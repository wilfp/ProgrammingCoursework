import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * A class which stores information about a room, including whether it is vacant and an array of the beds.
 *  
 * @author Wilfrid Askins
 */
public class Room {

	/** Whether the room is vacant */
	private boolean vacant;
	/** The array of all the beds in this room */
	private Bed[] beds;
	/** The number of beds which should be put into this room */
	private int bedNumber;

	/**
	 * Creates a new room object.
	 * 
	 * @param vacant true if the room is vacant
	 * @param bedNumber the number of beds in this room
	 */
	public Room(boolean vacant, int bedNumber){
		super();
		// Sets whether the room is vacant
		this.vacant = vacant;
		// Sets the number of beds in this rooms
		this.bedNumber = bedNumber;
	}

	/**
	 * Returns true if the room is vacant.
	 * 
	 * @return true if the room is vacant
	 */
	public boolean isVacant() {
		return vacant;
	}

	/**
	 * Used to set whether a room is vacant.
	 * 
	 * @param vacant true if the room is vacant
	 */
	public void setVacant(boolean vacant) {
		this.vacant = vacant;
	}

	/**
	 * Used to get the beds in this room.
	 * 
	 * @return an array of the room's beds
	 */
	public Bed[] getBeds() {
		return beds;
	}

	/**
	 * Used to set the beds of this room, by supplying a function which populates the bed array.
	 * 
	 * @param genBed the functional interface which creates a new bed
	 */
	public void setBeds(Function<Integer, Bed> genBed) {
		// Loop through the numbers 0 to bedNumber, creating a Bed object for each
		this.beds = IntStream.range(0, this.bedNumber).mapToObj(genBed::apply).toArray(Bed[]::new);
	}

	/**
	 * Returns the number of beds in the room.
	 * 
	 * @return an integer of the number of beds
	 */
	public int getBedNumber(){
		return bedNumber;
	}

	/**
	 * Used to set the number of beds in this room.
	 * 
	 * @param bedNumber the number of beds to be set
	 */
	public void setBedNumber(int bedNumber){
		this.bedNumber = bedNumber;
	}

	/**
	 * Returns the beds with the specified size.
	 * 
	 * @param size the size to filter by
	 * @return an array of the beds of this size
	 */
	public Bed[] getBedsOfSize(Bed.Size size){
		// Loops through the beds array, filtering by beds with the specified size, then returns those beds
		return Arrays.stream(beds).filter(b -> b.getSize().equals(size)).toArray(Bed[]::new);
	}

	/**
	 * Returns the maximum number of people this room can accommodate.
	 * 
	 * @return an integer of the max number of people for this room
	 */
	public int getMaxCapacity(){
		// Loops through all the beds, adding up their capacities and returning that sum
		return Arrays.stream(beds).mapToInt(b -> b.getSize().getCapacity()).sum();
	}

}
