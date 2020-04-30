package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
		private Integer roomNumber;
		private Date checkIn,checkOut;
		
		// foi declarado como static para criar uma unica vez - Nao em cada objeto instanciado.
		private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		/*****************************
		 * Construtores
		 *****************************/
		public Reservation() {
			
		}

		public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
			this.roomNumber = roomNumber;
			this.checkIn = checkIn;
			this.checkOut = checkOut;
		}

		/*****************************
		 * getters and setters
		 *****************************/
		public Integer getRoomNumber() {
			return roomNumber;
		}

		public void setRoomNumber(Integer roomNumber) {
			this.roomNumber = roomNumber;
		}

		public Date getCheckIn() {
			return checkIn;
		}

		public Date getCheckOut() {
			return checkOut;
		}
	
		/*****************************
		 * Metodos do projeto
		 *****************************/

		/*****************************
		 * @return o numero de dias da reserva
		 *****************************/
		public long duration() {
			// pegar a diferenca em milissegundos
			long diff = checkOut.getTime() - checkIn.getTime();
			// converter milissegundos para day
			return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		}
		
		/*****************************
		 * Atualiza as datas de entrada e saida da se
		 * @param checkIn
		 * @param checkOut
		 *****************************/
		public String updateDates (Date checkIn, Date checkOut) {
			Date dateNow = new Date(); // captura data atual.
			if(checkIn.before(dateNow) || checkOut.before(dateNow)) 
				 return "Reservation dates for update must be future dates.";
			if(checkOut.before(checkIn)) 
				return "Check-out date must be after check-in date";
			this.checkIn = checkIn;
			this.checkOut = checkOut;
			return null;
		}

		@Override
		public String toString() {
			return "Reservation [room " + roomNumber + ", checkIn=" + sdf.format(checkIn) + ", checkOut=" + sdf.format(checkOut) + ", " + duration() + " nights]";
		}
		

}
