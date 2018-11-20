
/**
 * The Class ModuleList. This handles the storing and initialising of the modules list.
 * 
 * Everything in this class can be static, as we only need one instance of the modules array
 * 
 * @author Wilfrid Askins
 */
public class ModuleList {
	
	/**
	 * The array of all possible modules.
	 */
	private static Module[] modules;;
	
	/**
	 * Initiates the list of modules.
	 */
	private static void initModules(){
		
		// This code is run when the modules array is first referenced
		// Initialises the module array, using a predefined list of modules
		modules = new Module[]{
				new Module("CSC1021", "Programming 1", 50, 20),
				new Module("CSC1022", "Programming 2", 40, 20, true),
				new Module("CSC1023", "The Software Engineering Professional", 100, 20),
				new Module("CSC1024", "Computer Architecture", 50, 20),
				new Module("CSC1025", "Mathematics for Computer Science", 20, 20),
				new Module("CSC1026", "Website Design and Construction", 80, 20)
		};
	}
	
	/**
	 * Gets the array of all modules.
	 *
	 * @return the modules
	 */
	public static Module[] getModules() {
		
		if(modules == null){
			// If the modules array doesn't exist yet
			// Initialise the modules array
			initModules();
		}
		
		// Returns the array of modules
		return modules;
	}
}
