package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Dados para reserva:");
		System.out.print("Room number:");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = spf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy):");
		Date checkOut = spf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
			return;
		}
		Reservation reservation = new Reservation(roomNumber,checkIn,checkOut);
		System.out.println(reservation.toString());
		
		System.out.println();
		System.out.println("Enter data to update the reservation:");
		System.out.print("Check-in date (dd/MM/yyyy): ");
		checkIn = spf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy):");
		checkOut = spf.parse(sc.next());
		
		String error = reservation.updateDates(checkIn, checkOut);
		if (error != null)
			System.out.println("Reservation: " + error);
		else
			System.out.println(reservation.toString());
			
		

	}

}
