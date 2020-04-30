package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;
import model.exception.renatoException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Dados para reserva:");
			System.out.print("Room number:");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = spf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):");
			Date checkOut = spf.parse(sc.next());
			
			Reservation reservation = new Reservation(roomNumber,checkIn,checkOut);
			System.out.println(reservation.toString());
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = spf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):");
			checkOut = spf.parse(sc.next());
			reservation.updateDates(checkIn, checkOut);
			System.out.println(reservation.toString());
		}
		catch(ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		catch(IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
			//e.printStackTrace();
		}
		catch (renatoException e) {
			System.out.println("Error: " + e.getMessage());
			//e.printStackTrace();
		}
		catch (InputMismatchException e) {
			System.out.println("Erro na entrada de dados.");
		}
		
		sc.close();
	}

}
