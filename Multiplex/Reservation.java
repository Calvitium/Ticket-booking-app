package Multiplex;

import BookingDetails.Screening;
import BookingDetails.Seat;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static BookingAppDemo.BookingApp.clearConsole;
import static Multiplex.Multiplex.weeklyRepertoire;
import static Multiplex.TicketsPrices.*;
import static java.lang.Character.isLetter;
import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;

public class Reservation {
    private static int current_ID = 1;

    private Integer reservation_ID;  // primary key
    private String clientName;
    private String clientSurname;
    private Screening screening;
    private ArrayList<Seat> seats;
    private LocalDateTime expirationTime;
    private float totalCost;


    public Reservation() throws IOException {
        reservation_ID = current_ID;
        current_ID++;
        int day = choosePreferredDay();
        screening = weeklyRepertoire[day].choosePreferredScreening();
        expirationTime = screening.getDate().minusMinutes(15);
        seats = screening.choosePreferredSeats();
        chooseTickets();
        enterName();
        enterSurname();
        System.out.println("Your reservation was successfully created. Details below:");
        System.out.print(this);
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat();
        df.setMinimumIntegerDigits(6);
        clearConsole();
        System.out.print(screening);
        System.out.println("NAME: " + clientName);
        System.out.println("SURNAME: " + clientSurname);
        System.out.println("TOTAL COST: " + totalCost);
        System.out.println("EXPIRATION TIME: " + expirationTime);
        System.out.print("RESERVATION ID: " + df.format(reservation_ID));
        return "\n";
    }

    private void chooseTickets() {
        TicketsPrices[] tickets = {CHILD, STUDENT, ADULT};
        int ticketsLeft = seats.size();
        do
        {
            for (TicketsPrices ticket : tickets)
            {
                System.out.print("How many tickets in a " + ticket.getType().toUpperCase() + " price would you like to buy(" + ticketsLeft + " left)? ");
                int amount = selectTicketsAmount(ticketsLeft);
                ticketsLeft -= amount;
                totalCost += amount * ticket.getPrice();
                if (ticketsLeft == 0)
                    break;
            }
            if(ticketsLeft>0)
            {
                System.out.println("Too little amount of tickets was entered. Try again.");
                totalCost = 0;
                ticketsLeft = seats.size();
            }
        }while (ticketsLeft>0);
    }

    private int selectTicketsAmount(int ticketsLeft) {
        int amount;
        do {
            System.out.print("Enter the amount: ");
            try {
                amount =  new Scanner(System.in).nextInt();
                if (amount > ticketsLeft)
                    System.out.println("Invalid input! Too big amount of tickets entered. ");
                else if(amount < 0)
                    System.out.println("The tickets amount cannot be < 0. ");
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input! Please enter an INTEGER amount of tickets. ");
                amount = -1;
            }
        } while (amount > ticketsLeft || amount<0);
        return amount;
    }

    Integer getID() {
        return reservation_ID;
    }

    private void enterName() {
        System.out.print("Enter the name: ");
        do {
            clientName = new Scanner(System.in).next();
            if (clientName.length() < 3)
                System.out.println("Your name should contain at least 3 letters - try again. ");
            if (!containsLettersOnly())
                System.out.print("Your name should consist of letters only: ");
        } while (clientName.length() < 3 || !containsLettersOnly());

        clientName = clientName.substring(0, 1).toUpperCase() + clientName.substring(1).toLowerCase();
    }

    private void enterSurname() {
        System.out.println("Now enter your surname.");
        System.out.print("The surname could consist of two parts separated with a single dash: ");
        do {
            clientSurname = new Scanner(System.in).next();
        } while (!isSurnameCorrect());
    }

    private int choosePreferredDay() {
        int number = 1;
        int day;
        System.out.println("This is a weekly repertoire. Choose the day of your visit.");

        for (ScreeningDay screeningDay : weeklyRepertoire)
            System.out.println(number++ + " - " + screeningDay.getDate().getDayOfWeek() + "  " + screeningDay.getDate());

        do {
            try {
                System.out.print("Choose the day of your visit: ");
                day = new Scanner(System.in).nextInt();
                if (day < 1 || day > 7)
                    System.out.println("Error! Choose a number between 1 and 7");
            }catch (InputMismatchException exception){
                System.out.println("Invalid input! Please enter an INTEGER number.");
                day = -1;
            }
        } while (day < 1 || day > 7);

        return day - 1;
    }

    private boolean isSurnameCorrect() {
        char[] fullSurname = clientSurname.toCharArray();
        boolean dashAppeared = false;
        int firstSurnameLength = 0;

        if (fullSurname.length < 3)
        {
            System.out.print("Your surname should consist of at least 3 letters. Try again: ");
            return false;
        }
        for (int i = 0; i < fullSurname.length; i++) {
            if (!isLetter(fullSurname[i])) {
                if (sthWentWrong(fullSurname, firstSurnameLength, i, dashAppeared))
                {
                    System.out.print("Invalid input. Use letters only: ");
                    return false;
                }
                dashAppeared = true;
                fullSurname[i + 1] = toUpperCase(fullSurname[i + 1]);
                i++;
            } else {
                if (i == 0)
                    fullSurname[i] = toUpperCase(fullSurname[i]);
                else
                    fullSurname[i] = toLowerCase(fullSurname[i]);
                firstSurnameLength++;
            }
        }
        clientSurname = new String(fullSurname);
        return true;
    }

    private boolean sthWentWrong(char[] fullSurname, int firstSurname, int i, boolean dashAppeared) {
        return fullSurname[i] != '-' // character different from dash
                || (fullSurname[i] == '-' && dashAppeared)  // character is a dash, but appeared twice
                || firstSurname < 3  // first part of the fullSurname < 3
                || fullSurname.length - 1 - i < 3 // second part of the fullSurname < 3
                || !isLetter(fullSurname[i + 1]); //
    }

    private boolean containsLettersOnly() {
        char[] name = clientName.toCharArray();
        for (char letter : name)
            if (!isLetter(letter))
                return false;
        return true;
    }

}
