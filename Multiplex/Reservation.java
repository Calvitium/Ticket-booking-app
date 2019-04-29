package Multiplex;

import BookingDetails.Seat;

import java.time.LocalDateTime;

public class Reservation {
    private static int current_ID = 1;

    private Integer reservation_ID;  // primary key
    private LocalDateTime date;      // foreign key
    private String clientName;
    private String clientSurname;
    private String movieTitle;       // foreign key
    private char room;
    private Seat seats;

    public Reservation(){
        reservation_ID = current_ID;
        current_ID++;
        System.out.println("New reservation ID assigned: " + reservation_ID);
    }
}
