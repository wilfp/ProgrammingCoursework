/**
 *  Tests the Hotel class by creating a new Hotel object and printing it's maximum occupancy.
 *  
 *  This class uses constants rather than a random generator, as random parameters will be more inconsistent than known data.
 *  If the Hotel, Room and Bed classes are implemented correctly, then the maximum occupancy of the Hotel should be 200.
 *  
 * @author Wilfrid Askins
 */
public class HotelTest {

	/** The name of the hotel to be created */
	private static final String HOTEL_NAME = "Premier Inn";

	/** The number of rooms in the hotel to be generated */
	private static final int ROOM_NUM = 25;

	/** The number of beds in each room in the hotel */
	private static final int BEDS_PER_ROOM = 4;

	/** The size of the beds in the rooms */
	private static final Bed.Size BED_SIZE = Bed.Size.DOUBLE;

	/** Whether the rooms are vacant */
	private static final boolean ROOMS_VACANT = true;

	/**
	 * The main method, to be used to run the hotel test.
	 * 
	 * @param args the arguments used to run the main method, which are not used in this program
	 */
	public static void main(String[] args){

		// Creates a new Hotel object using the constants specified above
		Hotel hotel = new Hotel(HOTEL_NAME, ROOM_NUM, roomNum -> new Room(ROOMS_VACANT, BEDS_PER_ROOM), bedNum -> new Bed(BED_SIZE));

		// Prints the hotel's max occupancy
		System.out.println("Max occupancy: "+hotel.getMaximumOccupancy());
	}

}
