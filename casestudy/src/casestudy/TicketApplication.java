package casestudy;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class TicketApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		Scanner sc = new Scanner(System.in);
		
		TrainDAO app = new TrainDAO();
		
		System.out.print("Enter the train Number: ");
		int trainNo = Integer.parseInt(sc.nextLine());
		Train train = app.findTrain(trainNo);
		
		if(train==null) {
			System.out.println("Train with no. " + trainNo + " does not exist.");
		}
		else {
			System.out.print("Enter Travel Date: ");
			String[] arr = sc.nextLine().split("/");
			LocalDate travelDate =  LocalDate.of(Integer.parseInt(arr[2]), Integer.parseInt(arr[1]), Integer.parseInt(arr[0]));
			
			System.out.print("Enter number of passengers: ");
			int noOfPassengers = Integer.parseInt(sc.nextLine());
			if(noOfPassengers <= 0) {
				System.out.println("Please Enter a number greater than 0.");
				System.exit(0);
			}
			
			Ticket ticket = new Ticket(travelDate, train);
			
			for(int i=0;i<noOfPassengers;i++) {
				System.out.print("\nEnter Passenger Name: ");
				String name = sc.nextLine();
				System.out.print("Enter Passenger Age: ");
				int age = Integer.parseInt( sc.nextLine());
				System.out.print("Enter Gender(M/F): ");
				char gender = sc.nextLine().charAt(0);
				if(gender != 'M' && gender != 'm' && gender != 'F' && gender != 'f') {
					System.out.println("Please enter M or F only.");
					System.exit(0);
				}
				
				ticket.addPassenger(name, age, gender);
			}

			ticket.writeTicket();
			System.out.println("Ticket booked with PNR: " + ticket.getPnr());
		}
		
		sc.close();
		
	}

}
