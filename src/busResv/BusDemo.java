package busResv;

	import java.util.Scanner;
	import java.util.ArrayList;

	public class BusDemo {
		public static void main(String[] args) {
			ArrayList<bus> buses = new ArrayList<bus>();
			ArrayList<Booking>bookings = new ArrayList<Booking>();
			
			buses.add(new bus(1,"ram",true,2));
			buses.add(new bus(2,"sam",false,50));
			buses.add(new bus(3,"tom",true,48));
			buses.add(new bus(4,"you",true,52));
			
			
			int userOpt = 1;
			Scanner scanner = new Scanner(System.in);
			
			for(bus b:buses) {
				b.displayBusInfo();
			}
			
			while ( true  ) {
				
				System.out.println("Enter 1 to book, 2 to cancel, 3 to EXIT");
				userOpt = scanner.nextInt();
				if(userOpt == 1) {
					Booking booking = new Booking();
				 	if(booking.isAvailable(bookings,buses)) {
				 		bookings.add(booking);
				 		System.out.println("Your booking is confirmed.");
				 		System.out.println("Booking number is :" +booking.BookingNumber);
				 	}
				 	else
				 		System.out.println("Sorry. bus is full. Try another bus or date.");
				}
				else if(userOpt==2) {
					Booking.cancelBooking(bookings);
				}
				
				else if(userOpt == 3) {
					System.out.println("Thankyou");
					break;
					
				}
				else {
					System.out.println("Invalid input!");
				}
			}
			
			
			
			
		}

	}
