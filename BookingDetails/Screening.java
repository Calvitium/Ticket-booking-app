package BookingDetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static BookingAppDemo.BookingApp.clearConsole;

public class Screening {
    private final int ROWS_NUMBER = 15;
    private final int SEATS_PER_ROW = 25;
    private LocalDateTime date;
    private String movieTitle;
    private int room;
    private Seat[][] seats;

    public Screening(String title, int room, LocalDateTime date) {
        this.movieTitle = title;
        this.room = room;
        this.date = date;
        this.seats = new Seat[SEATS_PER_ROW][ROWS_NUMBER];
        for(int column = 0; column < SEATS_PER_ROW; column++)
            for(int row = 0; row < ROWS_NUMBER; row++)
                seats[column][row] = new Seat(column, row);
    }

    @Override
    public String toString(){
        return "\n\nSCREENING: " + (movieTitle) + ", ROOM: " + room + ", DATE: " + date + "\n";
    }

    public LocalDateTime getDate(){
        return date;
    }

    public String getMovieTitle(){
        return movieTitle;
    }

    public void showRoomSeats() {
        DecimalFormat twoDecimals = new DecimalFormat();
        twoDecimals.setMinimumIntegerDigits(2);
        System.out.print(this);
        System.out.println("\n\t\t\t\t\t\t\t\t\t==============================SCREEN==============================\n");
        for(int row = 0; row < ROWS_NUMBER; row++)
        {
            System.out.print("ROW " + twoDecimals.format(row+1) +": ");
            for(int column = 0; column < SEATS_PER_ROW; column++)
            {

                if(!seats[column][row].isOccupied()){
                    System.out.print("|" + twoDecimals.format(column + 1) + "| ");
                }
                else
                    System.out.print("|--| ");
            }
            System.out.println(" ");
        }
    }

    public ArrayList<Seat> choosePreferredSeats() throws IOException {
        ArrayList<Seat> chosenSeats = new ArrayList<>();
        int[] stream = new int[0];
        String quitChar;
        clearConsole();
        do{
            selectSeatsInRow(stream, chosenSeats);
            System.out.print("To continue reserving seats in other row, press anything. To finish, press 'q': ");
            quitChar = new Scanner(System.in).next();
            clearConsole();
        }while(!quitChar.equals("q"));
        return chosenSeats;
    }

    private void selectSeatsInRow(int[] stream, ArrayList<Seat> chosenSeats) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean selectionCorrect = false;
        showRoomSeats();
        System.out.print("Enter a stream of numbers, separated by a single whitespace.\n");
        System.out.print("First number is a ROW number - the others are seats: ");
        do{
            try{
                stream = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
                if(stream[0] < 1 || stream [0] > 15)
                    System.out.println("Invalid input! Row number should be in (1-15). ");
                else if(stream.length < 2)
                    System.out.println("Select at least one seat!");
                else if(isTakenSeatBeingReserved(stream))
                    System.out.println("You chose a seat that has been already taken! Try again.");
                else if(wereSingleSeatLeftOver(stream))
                    System.out.println("You cannot leave over a single seat! Try again.");
                else
                    selectionCorrect = true;
            }catch (NumberFormatException exception){
                System.out.println("Invalid input! Please enter INTEGER values only!");
            }catch (ArrayIndexOutOfBoundsException exception){
                System.out.println("Invalid input! Enter numbers between 1 and 25 ONLY!");
            }
        }while(!selectionCorrect);

        for(int i = 1; i<stream.length; i++){
            chosenSeats.add(seats[stream[i]-1][stream[0]-1]);
            seats[stream[i]-1][stream[0]-1].setOccupied();
        }
    }

    private boolean isTakenSeatBeingReserved(int[] stream) {
        for(int seat = 1; seat < stream.length; seat++)
            if(seats[stream[seat]-1][stream[0]-1].isOccupied())
                return true;
        return false;
    }

    private boolean wereSingleSeatLeftOver(int[] stream) {
        int freeSeatsCount = 0;
        boolean[] occupiedSeats = new boolean[SEATS_PER_ROW];

        for(int seat = 0; seat < SEATS_PER_ROW; seat++)
            occupiedSeats[seat] = seats[seat][stream[0]-1].isOccupied();
        for(int i = 1; i<stream.length; i++)
            occupiedSeats[stream[i]-1] = true;
        for(int seat = 0; seat < SEATS_PER_ROW; seat++){
            if(occupiedSeats[seat] && freeSeatsCount == 1)
                return true;
            else if(occupiedSeats[seat] && freeSeatsCount != 1)
                freeSeatsCount = 0;
            else if(!occupiedSeats[seat])
                ++freeSeatsCount;
        }
        return false;
    }
}
