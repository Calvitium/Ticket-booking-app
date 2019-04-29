package BookingAppDemo;

import java.time.LocalDateTime;

import static BookingDetails.RoomSpecifications.*;
import static Multiplex.Multiplex.MULTIPLEX;
import static java.time.Month.*;

public class BookingApp {

    public static void main(String[] args) {
       addMovies();
       addScreenings();
    }

    private static void addScreenings() {
        MULTIPLEX.addScreening("Avengers: Endgame", A, LocalDateTime.of(2019, MAY, 2, 19, 30));
        MULTIPLEX.addScreening("Avengers: Endgame", A, LocalDateTime.of(2019, MAY, 4, 19, 30));
        MULTIPLEX.addScreening("Avengers: Endgame", A, LocalDateTime.of(2019, MAY, 5, 19, 30));
        MULTIPLEX.addScreening("Avengers: Endgame", A, LocalDateTime.of(2019, MAY, 6, 19, 30));
        MULTIPLEX.addScreening("Avengers: Endgame", A, LocalDateTime.of(2019, MAY, 7, 19, 15));
        MULTIPLEX.addScreening("Avengers: Endgame", A, LocalDateTime.of(2019, MAY, 8, 19, 15));
        MULTIPLEX.addScreening("Avengers: Endgame", A, LocalDateTime.of(2019, MAY, 9, 19, 15));

        MULTIPLEX.addScreening("Avengers: Endgame", B, LocalDateTime.of(2019, MAY, 2, 16, 15));
        MULTIPLEX.addScreening("Avengers: Endgame", B, LocalDateTime.of(2019, MAY, 4, 16, 15));
        MULTIPLEX.addScreening("Avengers: Endgame", B, LocalDateTime.of(2019, MAY, 5, 16, 15));
        MULTIPLEX.addScreening("Avengers: Endgame", B, LocalDateTime.of(2019, MAY, 6, 16, 15));
        MULTIPLEX.addScreening("Avengers: Endgame", B, LocalDateTime.of(2019, MAY, 7, 15, 45));
        MULTIPLEX.addScreening("Avengers: Endgame", B, LocalDateTime.of(2019, MAY, 8, 15, 45));
        MULTIPLEX.addScreening("Avengers: Endgame", B, LocalDateTime.of(2019, MAY, 9, 15, 45));

        MULTIPLEX.addScreening("Avengers: Endgame", C, LocalDateTime.of(2019, MAY, 2, 12, 30));
        MULTIPLEX.addScreening("Avengers: Endgame", C, LocalDateTime.of(2019, MAY, 4, 12, 30));
        MULTIPLEX.addScreening("Avengers: Endgame", C, LocalDateTime.of(2019, MAY, 5, 12, 30));
        MULTIPLEX.addScreening("Avengers: Endgame", C, LocalDateTime.of(2019, MAY, 6, 12, 30));
        MULTIPLEX.addScreening("Avengers: Endgame", C, LocalDateTime.of(2019, MAY, 7, 12, 30));
        MULTIPLEX.addScreening("Avengers: Endgame", C, LocalDateTime.of(2019, MAY, 8, 12, 15));
        MULTIPLEX.addScreening("Avengers: Endgame", C, LocalDateTime.of(2019, MAY, 9, 12, 15));

        MULTIPLEX.addScreening("Vox Lux", B, LocalDateTime.of(2019, MAY, 2, 20, 30));
        MULTIPLEX.addScreening("Vox Lux", B, LocalDateTime.of(2019, MAY, 4, 20, 20));
        MULTIPLEX.addScreening("Vox Lux", B, LocalDateTime.of(2019, MAY, 5, 20, 20));
        MULTIPLEX.addScreening("Vox Lux", B, LocalDateTime.of(2019, MAY, 6, 20, 20));
        MULTIPLEX.addScreening("Vox Lux", B, LocalDateTime.of(2019, MAY, 7, 20, 30));
        MULTIPLEX.addScreening("Vox Lux", B, LocalDateTime.of(2019, MAY, 8, 20, 30));
        MULTIPLEX.addScreening("Vox Lux", B, LocalDateTime.of(2019, MAY, 9, 20, 20));

        MULTIPLEX.addScreening("Missing Link", C, LocalDateTime.of(2019, MAY, 2, 16, 20));
        MULTIPLEX.addScreening("Missing Link", C, LocalDateTime.of(2019, MAY, 4, 16, 20));
        MULTIPLEX.addScreening("Missing Link", C, LocalDateTime.of(2019, MAY, 5, 16, 20));
        MULTIPLEX.addScreening("Missing Link", C, LocalDateTime.of(2019, MAY, 6, 16, 20));
        MULTIPLEX.addScreening("Missing Link", C, LocalDateTime.of(2019, MAY, 7, 16, 10));
        MULTIPLEX.addScreening("Missing Link", C, LocalDateTime.of(2019, MAY, 8, 16, 10));
        MULTIPLEX.addScreening("Missing Link", C, LocalDateTime.of(2019, MAY, 9, 16, 10));

        MULTIPLEX.addScreening("Green Book", A, LocalDateTime.of(2019, MAY, 2, 16, 10));
        MULTIPLEX.addScreening("Green Book", A, LocalDateTime.of(2019, MAY, 4, 16, 10));
        MULTIPLEX.addScreening("Green Book", A, LocalDateTime.of(2019, MAY, 5, 16, 10));
        MULTIPLEX.addScreening("Green Book", A, LocalDateTime.of(2019, MAY, 6, 16, 15));
        MULTIPLEX.addScreening("Green Book", A, LocalDateTime.of(2019, MAY, 7, 16, 20));
        MULTIPLEX.addScreening("Green Book", A, LocalDateTime.of(2019, MAY, 8, 16, 30));
        MULTIPLEX.addScreening("Green Book", A, LocalDateTime.of(2019, MAY, 9, 16, 10));



    }

    private static void addMovies() {
        MULTIPLEX.addMovie("Vox Lux", 1, 50);
        MULTIPLEX.addMovie("Avengers: Endgame", 3, 10);
        MULTIPLEX.addMovie("Missing Link", 1, 35);
        MULTIPLEX.addMovie("Green Book", 2, 10);
    }
}
