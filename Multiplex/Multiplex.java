package Multiplex;

import BookingDetails.Movie;
import BookingDetails.ScreeningRoom;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

import static BookingDetails.RoomSpecifications.A;
import static BookingDetails.RoomSpecifications.C;

public final class Multiplex implements TicketsPrices {
    private ScreeningRoom[] rooms;
    private ArrayList<Movie> repertoire;
    private static ScreeningDay[] weeklyRepertoire;
    private HashMap<Double, Reservation> reservationHashMap;

    public static final Multiplex MULTIPLEX = new Multiplex();

    private Multiplex() {

        this.rooms = new ScreeningRoom[3];
        weeklyRepertoire = new ScreeningDay[7];
        this.repertoire = new ArrayList<>();
        this.reservationHashMap = new HashMap<>();
        for(int name = A; name <= C; name++)
            rooms[name] = new ScreeningRoom(name);
        System.out.println("Choose a week of 2019 to create a demo repertoire (choose between 1 and 52):");
        int chosenWeek;
        do {
            chosenWeek = new Scanner(System.in).nextInt();
            if(chosenWeek < 1 || chosenWeek > 52)
                System.out.println("Error! Choose a proper number (1-52)");
        }while (chosenWeek < 1 || chosenWeek > 52);

        LocalDate date = LocalDate.of(2018, Month.DECEMBER, 31 );
        date = date.plusWeeks(chosenWeek - 1);
        for(int day = 0; day < weeklyRepertoire.length; day++)
            weeklyRepertoire[day] = new ScreeningDay(date.plusDays(day));
    }

    public void createNewReservation(){
        System.out.println("Welcome to the reservation creator!\n");
        System.out.println("Choose the day of your visit. The repertoire is updated each week:");
        int day = choosePreferedDay();
        weeklyRepertoire[day].showAvailableScreenings();
    }
    public void addMovie(String title, int hours, int minutes){
        repertoire.add(new Movie(title, hours, minutes));
        if(repertoire.size()>1)
            sortMoviesAlphabetically();
    }

    public void addScreening(String title, int room, LocalDateTime date){
        for(Movie movie : repertoire){
            if(movie.getTitle().equals(title)) {

                movie.addScreening(room, date);
                rooms[room].addScreening(title, room, date);
                for(ScreeningDay day : weeklyRepertoire)
                    if(day.getDate().equals(date.toLocalDate()))
                        day.addScreening(title, room, date);
                System.out.println("Screening added: \"" + title + "\", room: " + room + ", date: " + date.toString());
                return;
            }
        }
        System.out.println("Adding screening impossible - no such movie: " + title);
    }

    public static LocalDate getWeeklyRepertoireDay(int day){
        return weeklyRepertoire[day-1].getDate();
    }

    private int choosePreferedDay() {
        int number = 1;
        for(ScreeningDay day : weeklyRepertoire)
            System.out.println(number++ + " - " + day.getDate().getDayOfWeek() + "  " + day.getDate());
        int day;

        do{
            day = new Scanner(System.in).nextInt();
            if(day < 1 || day > 7)
                System.out.println("Error! Choose a number between 1 and 7");
        }while(day < 1 || day > 7);

        return day - 1;
    }

    private void sortMoviesAlphabetically(){
        repertoire.sort(Comparator.comparing(Movie::getTitle));
    }

}
