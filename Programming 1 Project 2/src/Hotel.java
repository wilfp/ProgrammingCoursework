import java.util.Arrays;
import java.util.function.Function;

/**
 * The class which stores data about a hotel and it's rooms.
 *  
 * @author Wilfrid Askins
 */
public class Hotel {

	/** The name of the hotel */
	private String name;
	/** An array of all the rooms in the hotel */
	private Room[] rooms;

	/**
	 * Creates a new Hotel object by using the details set by the user. 
	 * This constructor handles the populating of the room and bed arrays so that it doesn't need to be done from HotelTest or HotelConfigure.
	 * 
	 * @param name the name of the new hotel
	 * @param roomNumber the number of rooms in this hotel
	 * @param genRoom a functional interface supplied by the user which returns a new room
	 * @param genBed a functional interface supplied by the user which returns a new bed
	 */
	public Hotel(String name, int roomNumber, Function<Integer,Room> genRoom, Function<Integer,Bed> genBed) {
		super();

		// Sets the name of the hotel to the one specified
		this.name = name;

		// Initialises the room array
		initRoomArray(roomNumber, genRoom, genBed);
	}

	/**
	 * Used to initialise the rooms in this hotel using the functional interfaces supplied.
	 * 
	 * @param roomNumber the number of rooms in the array
	 * @param genRoom a functional interface which returns a new room
	 * @param genBed a functional interface which returns a new bed
	 */
	private void initRoomArray(int roomNumber, Function<Integer,Room> genRoom, Function<Integer,Bed> genBed){

		// Creates a new array to store the rooms of this hotel
		this.rooms = new Room[roomNumber];

		// Populates the room array
		for(int roomIndex = 0; roomIndex < roomNumber; roomIndex++){

			// Gets a new room object
			Room curRoom = genRoom.apply(roomIndex);

			// Adds the beds to the current room
			curRoom.setBeds(genBed);

			// Puts the room in the room array
			this.rooms[roomIndex] = curRoom;
		}
	}

	/**
	 * Gets the name of this hotel
	 * 
	 * @return the name of the hotel as a string
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of this hotel
	 * 
	 * @param name the string to set the name to
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets all the rooms in this hotel
	 * 
	 * @return an array of all the rooms in this hotel
	 */
	public Room[] getRooms() {
		return rooms;
	}

	/**
	 * Sets the hotel's rooms to the specified values
	 * 
	 * @param rooms an array of the new rooms
	 */
	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}

	/**
	 * Returns the number of rooms in this hotel
	 * 
	 * @return the number of rooms as an integer
	 */
	public int getRoomNumber(){
		// Returns the length of the rooms array
		return rooms.length;
	}

	/**
	 * Gets whether the hotel has vacancies
	 * 
	 * @return true if there is one or more vacancies
	 */
	public boolean hasVacancies(){
		// Return true if any of the rooms are vacant
		return Arrays.stream(rooms).anyMatch(Room::isVacant);
	}

	/**
	 * Gets the max number of people this hotel can accommodate
	 * 
	 * @return the maximum occupancy as an integer
	 */
	public int getMaximumOccupancy(){
		// Loops through all the rooms and adds together their capacities, returning this sum
		return Arrays.stream(rooms).mapToInt(Room::getMaxCapacity).sum();
	}
}
