/**
 * A class to store information about a bed in a room.
 *  
 * @author Wilfrid Askins
 */
public class Bed {

	/** The size of the bed */
	private Size size;

	/**
	 * Creates a new bed object.
	 * 
	 * @param size the size of the bed
	 */
	public Bed(Size size) {
		super();
		this.size = size;
	}

	/**
	 * Returns the size of this bed.
	 * 
	 * @return the size of the bed
	 */
	public Size getSize() {
		return size;
	}

	/**
	 * Sets the size of the bed.
	 * 
	 * @param size the size enum to set the bed to
	 */
	public void setSize(Size size){
		this.size = size;
	}

	/**
	 * An enum to represent the size of the beds.
	 * 
	 * @author Wilfrid Askins
	 */
	public enum Size{

		/** All the possible bed sizes */
		SINGLE(1), DOUBLE(2);

		/** The capacity of this bed size */
		private final int capacity;

		/**
		 * Creates a new Size object.
		 * 
		 * @param capacity the number of people this bed can hold
		 */
		private Size(int capacity){
			this.capacity = capacity;
		}

		/**
		 * Gets the capacity of this bed size.
		 * 
		 * @return the capacity of this bed size
		 */
		public int getCapacity() {
			return capacity;
		}
	}
}
