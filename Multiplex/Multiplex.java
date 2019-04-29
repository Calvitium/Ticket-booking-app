package Multiplex;

import BookingDetails.Movie;
import BookingDetails.ScreeningRoom;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import static BookingDetails.RoomSpecifications.A;
import static BookingDetails.RoomSpecifications.C;

public final class Multiplex implements TicketsPrices {
    private ScreeningRoom[] rooms;
    private ArrayList<Movie> repertoire;
    private HashMap<Double, Reservation> reservationHashMap;

    public static final Multiplex MULTIPLEX = new Multiplex();

    private Multiplex() {

        this.rooms = new ScreeningRoom[3];
        for(int name = A; name <= C; name++)
            rooms[name] = new ScreeningRoom(name);

        this.repertoire = new ArrayList<>();
        this.reservationHashMap = new HashMap<>();
    }

    public void addMovie(String title, int hours, int minutes){
        repertoire.add(new Movie(title, hours, minutes));
        if(repertoire.size()>1)
            sortMoviesAlphabetically();
    }

    public void addScreening(String title, int room, LocalDateTime date){
        for(Movie iter : repertoire){
            if(iter.getTitle().equals(title)) {
                iter.addScreening(room, date);
                System.out.println("Screening added: \"" + title + "\", room: " + room + ", date: " + date.toString());
                return;
            }
        }
        System.out.println("Adding screening impossible - no such movie: " + title);

    }

    private void sortMoviesAlphabetically() {
        repertoire.sort(Comparator.comparing(Movie::getTitle));
    }
}
