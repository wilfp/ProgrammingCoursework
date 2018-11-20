
/**
 * Generates a short report about a Hotel object and prints the report to the command line.
 * 
 * @author Wilfrid Askins
 */
public class HotelReport {

	/**
	 * Prints a report about a specified hotel.
	 * 
	 * @param hotel the hotel object to be reported on
	 */
	public static void produceReport(Hotel hotel){

		// Prints a separator to make the output look more clean
		print("");
		// Prints the hotel's name
		print("Hotel name: " + hotel.getName());
		// Prints whether the hotel has vacancies
		print("Has vacancies: "+hotel.hasVacancies());
		// Prints the number of rooms in this hotel
		print("Number of rooms: " + hotel.getRoomNumber());

		// The number of the room in the current iteration
		int roomNumber = 1;

		// Loop through all the rooms in the hotel
		for(Room room : hotel.getRooms()){

			// Prints a new line to separate this room's information
			print("");
			// Prints the room's number as a header
			print("== Room " + roomNumber + " ==");
			// Prints whether the room is vacant
			print("Vacant: "+room.isVacant());

			// Prints the number of beds in the room
			print("Number of beds: " + room.getBedNumber());
			// Prints the number of single beds
			print("Number of single beds: " + room.getBedsOfSize(Bed.Size.SINGLE).length);
			// Prints the number of double beds
			print("Number of double beds: " + room.getBedsOfSize(Bed.Size.DOUBLE).length);

			// Increments the room number for the next iteration
			roomNumber++;
		}
	}

	/**
	 * Prints text to the system output.
	 * 
	 * @param text the text to be printed
	 */
	private static void print(Object text){
		// Prints the text to the command line
		System.out.println(text);
	}
}
