import java.util.Scanner;
import java.util.function.Function;

/**
 *  Asks for input from the user to create a Hotel object. Then prints a hotel report about the hotel details which were entered.
 *  
 * @author Wilfrid Askins
 */
public class HotelConfigure {

	/**
	 * The main method of HotelConfigure. Used to ask for user input for a Hotel object, then print a hotel report.
	 * 
	 * @param args the arguments used to run the main method, which are not used in this program
	 */
	public static void main(String[] args){

		// Creates a new scanner to read from System.in
		Scanner sc = new Scanner(System.in);

		// Gets the hotel name from the user
		String hotelName = getHotelName(sc);
		// Gets the number of rooms in this hotel from the user
		int roomNumber = scanInt(sc, "number of rooms in "+hotelName, 1, Integer.MAX_VALUE);

		// The function to generate a new room for this hotel, by asking the user whether it is vacant and the number of beds it contains
		Function<Integer,Room> roomGen = roomNum -> new Room(roomVacant(sc, roomNum), scanInt(sc, "number of beds in room "+(roomNum+1), 1, Integer.MAX_VALUE));
		// The function to generate a bed for a room in this hotel, by asking the user for the bed's size
		Function<Integer,Bed> bedGen = bedNum -> new Bed(getBedSize(sc, bedNum));

		// Creates a new hotel object using this information
		Hotel hotel = new Hotel(hotelName, roomNumber, roomGen, bedGen);

		// Prints a report of this hotel to the command line
		HotelReport.produceReport(hotel);

		// Closes the scanner
		sc.close();
	}

	/**
	 * Used to scan an integer from the command line and check whether what was entered is a valid integer. 
	 * Other input methods also call this method, so that this validation is used for all integers entered.
	 * 
	 * @param sc the scanner to be used
	 * @param name the name of the field to be asked for
	 * @param min the minimum possible value
	 * @param max the maximum possible value
	 * @return the validated integer which was entered
	 */
	private static int scanInt(Scanner sc, String name, int min, int max){
		// Asks the user to input the field
		print("Please input " + name + ": ");
		// Gets what the user has entered
		String token = sc.next();

		// If an invalid integer was entered
		if(!isInt(token)){
			// Prints an error to the user
			print("Error! Invalid integer entered");
			// Asks the user to re-enter the integer
			return scanInt(sc, name, min, max);
		}

		// Gets the value of the token as an integer
		int tokenValue = Integer.parseInt(token);

		// If the value is out of range
		if(tokenValue < min || tokenValue > max){
			// Displays an error to the user
			print("Error! That integer is out of range!");
			// Asks the user to re-enter the integer
			return scanInt(sc, name, min, max);
		}

		// Returns the validated value
		return tokenValue;
	}

	/**
	 * Asks the user to enter a bed size (either 1 or 2) and scans what is entered.
	 * 
	 * @param sc the scanner to be used
	 * @param bedNum the number of this bed in the room
	 * @return the entered bed size
	 */
	private static Bed.Size getBedSize(Scanner sc, int bedNum){
		// Asks the user to input a bed size
		int bedSize = scanInt(sc, "the size of bed " + (bedNum+1) + " (either 1 or 2)", 1, 2);
		// Returns the bed size in that index
		return Bed.Size.values()[bedSize-1];
	}

	/**
	 * Asks the user to enter a hotel name.
	 * 
	 * @param sc the scanner to be used
	 * @return the hotel name entered
	 */
	private static String getHotelName(Scanner sc){
		// Asks the user for a hotel name
		print("Please input your hotel name: ");
		// Returns the next line which was entered
		return sc.nextLine();
	}

	/**
	 * Asks the user whether a room is vacant.
	 * 
	 * @param sc the scanner to be used
	 * @param roomNum the number which identifies the room
	 * @return true if the room is vacant
	 */
	private static boolean roomVacant(Scanner sc, int roomNum){
		// Asks whether the room is vacant
		print("Is room " + (roomNum+1) + " vacant? (y/n): ");
		
		// Gets what was entered by the user
		String token = sc.next();
		
		// Decides whether the user entered yes or no
		boolean enteredYes = token.startsWith("y");
		boolean enteredNo = token.startsWith("n");
		
		// If the user entered something other than y or n
		if(!enteredYes && !enteredNo){
			// Displays an error and asks again
			print("Error! You must enter either y or n!");
			return roomVacant(sc, roomNum);
		}
		
		// Returns true if what was entered starts with a "y"
		return enteredYes;
	}

	/**
	 * Checks whether a string is a valid integer.
	 * 
	 * @param token the string to be validated
	 * @return true if the string is a valid integer
	 */
	private static boolean isInt(String token){
		// RegEx learnt from https://www.regular-expressions.info/tutorial.html
		// Returns true if the token fits (optional plus) + (1 to 12 digits between 0 and 9)
		return token.matches("^(\\+)?[0-9]{1,12}$");
	}

	/**
	 * Prints text to the system output.
	 * 
	 * @param text the text to be printed
	 */
	private static void print(Object text){
		// Prints the text to the command line
		System.out.println(text);
		// Flushes the output stream so the text is immediately displayed
		System.out.flush();
	}
}
