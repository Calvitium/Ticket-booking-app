package BookingDetails;

public class Seat {
    private int row;
    private int number;
    private boolean occupied;

    Seat(int number, int row) {
        this.number = number;
        this.row = row;
        this.occupied = false;
    }

    boolean isOccupied() { return occupied;
    }

    void setOccupied() { occupied = true;
    }
}
