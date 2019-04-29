package BookingDetails;

import java.time.LocalDateTime;

public class Screening {
    private LocalDateTime date;
    private String movieTitle;
    private int room;

    public Screening(String title, int room, LocalDateTime date) {
        this.movieTitle = title;
        this.room = room;
        this.date = date;
    }

    public LocalDateTime getDate(){
        return date;
    }
    // private Room room;
}
