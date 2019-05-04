package BookingDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public class ScreeningRoom {

    private int name; // PK
    private ArrayList<Screening> screenings;

    public ScreeningRoom(int name) {
        this.name = name;
        this.screenings = new ArrayList<>();
    }

    public void addScreening(String title, int room, LocalDateTime date) {
        screenings.add(new Screening(title, room , date));
        if(screenings.size()>1)
            sortScreeningsChronologically();
    }

    private void sortScreeningsChronologically() {
        screenings.sort(Comparator.comparing(Screening::getDate));
    }
}
