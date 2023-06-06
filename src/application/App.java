package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.println("Room number: ");
            int roomNumber = scanner.nextInt();
            System.out.println("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(scanner.next());
            System.out.println("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(scanner.next());

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        } catch (ParseException ex) {
            System.out.println("Invalid date format.");
        } catch (DomainException ex) {
            System.out.println("Booking error: " + ex.getMessage());
        } catch (RuntimeException ex) {
            System.out.println("Unexpected error.");
        }
        scanner.close();
    }
}
