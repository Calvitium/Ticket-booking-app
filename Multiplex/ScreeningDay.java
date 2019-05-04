package Multiplex;

import BookingDetails.Screening;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static BookingAppDemo.BookingApp.clearConsole;

class ScreeningDay {
    private LocalDate localDate;
    private List<Screening> screenings;

    ScreeningDay(LocalDate localDate){
        this.localDate = localDate;
        screenings = new ArrayList<>();
    }

    Screening choosePreferredScreening() {
        int number;
        boolean selectionPossible = false;
        clearConsole();
        System.out.println("\n\nNow, choose your preferred screening.");
        System.out.println("Numbers in brackets represent your choice.");
        do{
            showAvailableScreenings();
            System.out.print("\nEnter your screening number: ");
            try {
                number = new Scanner(System.in).nextInt();
                if(number < 1 || number > screenings.size())
                    System.out.println("Invalid input! No such number. ");
                else if(LocalDateTime.now().plusMinutes(15).isAfter(screenings.get(number).getDate()))
                    System.out.println("You cant make a reservation 15 or less minutes before the movie.");
                else
                    selectionPossible = true;
            }catch (InputMismatchException exception){
                System.out.println("Invalid input! Please enter an INTEGER value. ");
                number = -1;
            }
        }while (number < 1 || number > screenings.size() || !selectionPossible);
        return screenings.get(number-1);
    }

    private void showAvailableScreenings() {
        System.out.print("Available screenings on " + localDate.getDayOfWeek() + ",  " + localDate + ":");
        String movieTitle = "empty";
        int number = 1;
        for(Screening screening : screenings){
            if(!movieTitle.equals(screening.getMovieTitle()))
            {
                System.out.print("\n\n" + screening.getMovieTitle() + ":  ");
                movieTitle = screening.getMovieTitle();
            }
            if(!LocalDateTime.now().plusMinutes(15).isAfter(screening.getDate()))
                System.out.print(screening.getDate().getHour() + ":" + screening.getDate().getMinute() + "(" + number + ")  |  ");
            number++;
        }
    }

    void addScreening(String title, int room, LocalDateTime date) {
        screenings.add(new Screening(title, room, date));
            if(screenings.size()>1)
                sortByTitleThenDate();
    }

    LocalDate getDate() { return localDate;
    }

    private void sortByTitleThenDate() {
        Comparator<Screening> comparator = Comparator.comparing(Screening::getMovieTitle);
        comparator = comparator.thenComparing(Screening::getDate);
        Stream<Screening> screeningStream = screenings.stream().sorted(comparator);
        screenings = screeningStream.collect(Collectors.toList());
    }

}

