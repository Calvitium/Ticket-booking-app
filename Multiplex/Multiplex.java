package Multiplex;

import BookingDetails.Movie;
import BookingDetails.ScreeningRoom;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

import static BookingAppDemo.BookingApp.clearConsole;

public final class Multiplex {
    private ScreeningRoom[] rooms;
    private ArrayList<Movie> repertoire;
    private HashMap<Integer, Reservation> reservationList;
    static ScreeningDay[] weeklyRepertoire;

    public static final Multiplex MULTIPLEX = new Multiplex();

    private Multiplex() {

        this.rooms = new ScreeningRoom[3];
        weeklyRepertoire = new ScreeningDay[7];
        this.repertoire = new ArrayList<>();
        this.reservationList = new HashMap<>();
        for (int name = 0; name <= 2; name++)
            rooms[name] = new ScreeningRoom(name + 1);
        clearConsole();
        int chosenWeek = choosePreferredWeek();

        LocalDate date = LocalDate.of(2018, Month.DECEMBER, 31);
        date = date.plusWeeks(chosenWeek - 1);
        for (int day = 0; day < weeklyRepertoire.length; day++)
            weeklyRepertoire[day] = new ScreeningDay(date.plusDays(day));
    }

    public static LocalDate getWeeklyRepertoireDay(int day) {
        return weeklyRepertoire[day - 1].getDate();
    }

    public Reservation findReservation(Integer reservation_ID) {
        return reservationList.get(reservation_ID);
    }

    public void createNewReservation() throws IOException {
        Reservation reservation = new Reservation();
        reservationList.put(reservation.getID(), reservation);
    }

    public void addMovie(String title, int hours, int minutes) {
        repertoire.add(new Movie(title, hours, minutes));
        if (repertoire.size() > 1)
            sortMoviesAlphabetically();
    }

    public void addScreening(String title, int room, LocalDateTime date) {
        for (Movie movie : repertoire) {
            if (movie.getTitle().equals(title)) {
                movie.addScreening(room, date);
                rooms[room - 1].addScreening(title, room, date);
                for (ScreeningDay day : weeklyRepertoire)
                    if (day.getDate().equals(date.toLocalDate()))
                        day.addScreening(title, room, date);
                return;
            }
        }
        System.out.println("Adding screening impossible - no such movie: " + title);
    }

    private int choosePreferredWeek() {
        int chosenWeek;
        System.out.println("Choose a week of 2019 to create a demo repertoire (choose between 1 and 52):");
        System.out.println("REMEBER! Repertoire of week before the current one won't show any possible screenings to book.");
        do {
            try {
                chosenWeek = new Scanner(System.in).nextInt();
                if (chosenWeek < 1 || chosenWeek > 52)
                    System.out.print("Error! Choose a proper number (1-52): ");
            } catch (InputMismatchException exception) {
                System.out.print("Invalid input! Please enter a NUMBER between 1 and 52: ");
                chosenWeek = 53;
            }
        } while (chosenWeek < 1 || chosenWeek > 52);
        return chosenWeek;
    }

    private void sortMoviesAlphabetically() {
        repertoire.sort(Comparator.comparing(Movie::getTitle));
    }

}
