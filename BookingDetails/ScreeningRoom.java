package BookingDetails;

import java.util.ArrayList;

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
    }
}
