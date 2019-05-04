package BookingAppDemo;

import Multiplex.Multiplex;

import java.io.IOException;
import java.time.LocalDateTime;
import static BookingDetails.RoomSpecifications.*;
import static Multiplex.Multiplex.MULTIPLEX;
import static Multiplex.Multiplex.getWeeklyRepertoireDay;

public class BookingApp {

    public static void main(String[] args) throws IOException {
       addMovies();
       addScreenings();
        clearConsole();
       MULTIPLEX.createNewReservation();
       System.out.print(MULTIPLEX.findReservation(1));
    }

    private static void addScreenings() {
        MULTIPLEX.addScreening("Avengers: Endgame", 1, LocalDateTime.of(2019, getWeeklyRepertoireDay(1).getMonth(), getWeeklyRepertoireDay(1).getDayOfMonth(), 19, 30));
        MULTIPLEX.addScreening("Avengers: Endgame", 1, LocalDateTime.of(2019, getWeeklyRepertoireDay(2).getMonth(), getWeeklyRepertoireDay(2).getDayOfMonth(), 19, 30));
        MULTIPLEX.addScreening("Avengers: Endgame", 1, LocalDateTime.of(2019, getWeeklyRepertoireDay(3).getMonth(), getWeeklyRepertoireDay(3).getDayOfMonth(), 19, 30));
        MULTIPLEX.addScreening("Avengers: Endgame", 1, LocalDateTime.of(2019, getWeeklyRepertoireDay(4).getMonth(), getWeeklyRepertoireDay(4).getDayOfMonth(), 19, 30));
        MULTIPLEX.addScreening("Avengers: Endgame", 1, LocalDateTime.of(2019, getWeeklyRepertoireDay(5).getMonth(), getWeeklyRepertoireDay(5).getDayOfMonth(), 19, 15));
        MULTIPLEX.addScreening("Avengers: Endgame", 1, LocalDateTime.of(2019, getWeeklyRepertoireDay(6).getMonth(), getWeeklyRepertoireDay(6).getDayOfMonth(), 19, 15));
        MULTIPLEX.addScreening("Avengers: Endgame", 1, LocalDateTime.of(2019, getWeeklyRepertoireDay(7).getMonth(), getWeeklyRepertoireDay(7).getDayOfMonth(), 19, 15));

        MULTIPLEX.addScreening("Avengers: Endgame", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(1).getMonth(), getWeeklyRepertoireDay(1).getDayOfMonth(), 16, 15));
        MULTIPLEX.addScreening("Avengers: Endgame", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(2).getMonth(), getWeeklyRepertoireDay(2).getDayOfMonth(), 16, 15));
        MULTIPLEX.addScreening("Avengers: Endgame", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(3).getMonth(), getWeeklyRepertoireDay(3).getDayOfMonth(), 16, 15));
        MULTIPLEX.addScreening("Avengers: Endgame", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(4).getMonth(), getWeeklyRepertoireDay(4).getDayOfMonth(), 16, 15));
        MULTIPLEX.addScreening("Avengers: Endgame", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(5).getMonth(), getWeeklyRepertoireDay(5).getDayOfMonth(), 15, 45));
        MULTIPLEX.addScreening("Avengers: Endgame", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(6).getMonth(), getWeeklyRepertoireDay(6).getDayOfMonth(), 15, 45));
        MULTIPLEX.addScreening("Avengers: Endgame", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(7).getMonth(), getWeeklyRepertoireDay(7).getDayOfMonth(), 15, 45));

        MULTIPLEX.addScreening("Avengers: Endgame", 3, LocalDateTime.of(2019, getWeeklyRepertoireDay(1).getMonth(), getWeeklyRepertoireDay(1).getDayOfMonth(), 12, 30));
        MULTIPLEX.addScreening("Avengers: Endgame", 3, LocalDateTime.of(2019, getWeeklyRepertoireDay(2).getMonth(), getWeeklyRepertoireDay(2).getDayOfMonth(), 12, 30));
        MULTIPLEX.addScreening("Avengers: Endgame", 3, LocalDateTime.of(2019, getWeeklyRepertoireDay(3).getMonth(), getWeeklyRepertoireDay(3).getDayOfMonth(), 12, 30));
        MULTIPLEX.addScreening("Avengers: Endgame", 3, LocalDateTime.of(2019, getWeeklyRepertoireDay(4).getMonth(), getWeeklyRepertoireDay(4).getDayOfMonth(), 12, 30));
        MULTIPLEX.addScreening("Avengers: Endgame", 3, LocalDateTime.of(2019, getWeeklyRepertoireDay(5).getMonth(), getWeeklyRepertoireDay(5).getDayOfMonth(), 12, 30));
        MULTIPLEX.addScreening("Avengers: Endgame", 3, LocalDateTime.of(2019, getWeeklyRepertoireDay(6).getMonth(), getWeeklyRepertoireDay(6).getDayOfMonth(), 12, 15));
        MULTIPLEX.addScreening("Avengers: Endgame", 3, LocalDateTime.of(2019, getWeeklyRepertoireDay(7).getMonth(), getWeeklyRepertoireDay(7).getDayOfMonth(), 12, 15));

        MULTIPLEX.addScreening("Vox Lux", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(1).getMonth(), getWeeklyRepertoireDay(1).getDayOfMonth(), 20, 30));
        MULTIPLEX.addScreening("Vox Lux", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(2).getMonth(), getWeeklyRepertoireDay(2).getDayOfMonth(), 20, 20));
        MULTIPLEX.addScreening("Vox Lux", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(3).getMonth(), getWeeklyRepertoireDay(3).getDayOfMonth(), 20, 20));
        MULTIPLEX.addScreening("Vox Lux", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(4).getMonth(), getWeeklyRepertoireDay(4).getDayOfMonth(), 20, 20));
        MULTIPLEX.addScreening("Vox Lux", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(5).getMonth(), getWeeklyRepertoireDay(5).getDayOfMonth(), 20, 30));
        MULTIPLEX.addScreening("Vox Lux", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(6).getMonth(), getWeeklyRepertoireDay(6).getDayOfMonth(), 20, 30));
        MULTIPLEX.addScreening("Vox Lux", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(7).getMonth(), getWeeklyRepertoireDay(7).getDayOfMonth(), 20, 20));

        MULTIPLEX.addScreening("Missing Link", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(1).getMonth(), getWeeklyRepertoireDay(1).getDayOfMonth(), 16, 20));
        MULTIPLEX.addScreening("Missing Link", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(2).getMonth(), getWeeklyRepertoireDay(2).getDayOfMonth(), 16, 20));
        MULTIPLEX.addScreening("Missing Link", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(3).getMonth(), getWeeklyRepertoireDay(3).getDayOfMonth(), 16, 20));
        MULTIPLEX.addScreening("Missing Link", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(4).getMonth(), getWeeklyRepertoireDay(4).getDayOfMonth(), 16, 20));
        MULTIPLEX.addScreening("Missing Link", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(5).getMonth(), getWeeklyRepertoireDay(5).getDayOfMonth(), 16, 10));
        MULTIPLEX.addScreening("Missing Link", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(6).getMonth(), getWeeklyRepertoireDay(6).getDayOfMonth(), 16, 10));
        MULTIPLEX.addScreening("Missing Link", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(7).getMonth(), getWeeklyRepertoireDay(7).getDayOfMonth(), 16, 10));

        MULTIPLEX.addScreening("Green Book", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(1).getMonth(), getWeeklyRepertoireDay(1).getDayOfMonth(), 16, 10));
        MULTIPLEX.addScreening("Green Book", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(2).getMonth(), getWeeklyRepertoireDay(2).getDayOfMonth(), 16, 10));
        MULTIPLEX.addScreening("Green Book", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(3).getMonth(), getWeeklyRepertoireDay(3).getDayOfMonth(), 16, 10));
        MULTIPLEX.addScreening("Green Book", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(4).getMonth(), getWeeklyRepertoireDay(4).getDayOfMonth(), 16, 15));
        MULTIPLEX.addScreening("Green Book", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(5).getMonth(), getWeeklyRepertoireDay(5).getDayOfMonth(), 16, 20));
        MULTIPLEX.addScreening("Green Book", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(6).getMonth(), getWeeklyRepertoireDay(6).getDayOfMonth(), 16, 30));
        MULTIPLEX.addScreening("Green Book", 2, LocalDateTime.of(2019, getWeeklyRepertoireDay(7).getMonth(), getWeeklyRepertoireDay(7).getDayOfMonth(), 16, 10));

    }

    private static void addMovies() {
        MULTIPLEX.addMovie("Vox Lux", 1, 50);
        MULTIPLEX.addMovie("Avengers: Endgame", 3, 10);
        MULTIPLEX.addMovie("Missing Link", 1, 35);
        MULTIPLEX.addMovie("Green Book", 2, 10);
    }

    public static void clearConsole() {
        for(int i = 0; i < 100; i++)
            System.out.println("");
    }
}
