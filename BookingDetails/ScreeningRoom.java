package BookingDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public class ScreeningRoom implements RoomSpecifications{

    private char name; // PK
    private ArrayList<Screening> screenings;

    public ScreeningRoom(int name) {
        switch (name){
            case A: this.name = 'A';
                    break;
            case B: this.name = 'B';
                    break;
            case C: this.name = 'C';
                    break;
        }
        screenings = new ArrayList<>();
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
