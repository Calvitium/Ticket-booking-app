package Multiplex;

import BookingDetails.Screening;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScreeningDay {
    private LocalDate localDate;
    private List<Screening> screenings;

    public ScreeningDay(LocalDate localDate){
        this.localDate = localDate;
        screenings = new ArrayList<>();
    }

    public LocalDate getDate() { return localDate;
    }

    public void showAvailableScreenings() {
        System.out.println("Available screenings on " + localDate.getDayOfWeek() + ",  " + localDate + ":");

        String movieTitle = "empty";

        for(Screening screening : screenings){
            if(!movieTitle.equals(screening.getMovieTitle()))
            {
                System.out.print("\n\n" + screening.getMovieTitle() + ":  ");
                movieTitle = screening.getMovieTitle();
            }
            System.out.print(screening.getDate().getHour() + ":" + screening.getDate().getMinute() + "    ");
        }
    }

    public void addScreening(String title, int room, LocalDateTime date) {
        screenings.add(new Screening(title, room, date));
            if(screenings.size()>1)
                sortByTitleThenDate();
    }

    private void sortByTitleThenDate() {
        Comparator<Screening> comparator = Comparator.comparing(Screening::getMovieTitle);
        comparator = comparator.thenComparing(Screening::getDate);
        Stream<Screening> screeningStream = screenings.stream().sorted(comparator);
        screenings = screeningStream.collect(Collectors.toList());
    }

}

