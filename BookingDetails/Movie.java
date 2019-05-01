package BookingDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public class Movie {
    private String movieTitle; // primary key
    private int hours;
    private int minutes;
    private ArrayList<Screening> screenings;

    public Movie(String title, int hours, int minutes) {
        this.movieTitle = title;
        this.hours = hours;
        this.minutes = minutes;
        screenings = new ArrayList<>();
    }

    public void addScreening(int room, LocalDateTime date){
        screenings.add(new Screening(movieTitle, room, date));
        if(screenings.size()>1)
            sortScreeningsChronologically();
    }

    public String getTitle() { return movieTitle;
    }

    private void sortScreeningsChronologically() { screenings.sort(Comparator.comparing(Screening::getDate));
    }

}
