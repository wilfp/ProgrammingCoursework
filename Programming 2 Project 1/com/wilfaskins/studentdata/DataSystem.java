package com.wilfaskins.studentdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

import com.wilfaskins.studentdata.students.Student;
import com.wilfaskins.studentdata.students.StudentType;
import com.wilfaskins.studentdata.students.id.SmartCard;
import com.wilfaskins.studentdata.students.id.StudentID;

/**
 * 
 * This is the main class of the system.
 * This class will load modules and supervisors.
 * This class will handle students and smartcards.
 *
 * @author Wilfrid Askins
 */
public final class DataSystem {
	
	/** All the modules in the system. */
	private final Set<Module> modules;
	
	/** All the supervisors in the system. */
	private final Set<Supervisor> supervisors;
	
	/** The students which have been added. */
	private final Set<Student> students;
	
	/** The smart cards and the students who own them. */
	private final Map<StudentID,SmartCard> smartCards;
	
	/**
	 * Instantiates a new data system.
	 *
	 * @param moduleFile the file from which the modules are loaded
	 * @param supervisorFile the file from which the supervisors are loaded
	 */
	public DataSystem(File moduleFile, File supervisorFile){
		super();
		// Instantiate the needed lists and maps
		this.modules = new HashSet<>();
		this.supervisors = new HashSet<>();
		this.students = new HashSet<>();
		this.smartCards = new HashMap<StudentID,SmartCard>();
		
		// Read the files and load them into lists
		read(modules, moduleFile, Module::valueOf);
		read(supervisors, supervisorFile, Supervisor::valueOf);
	}
	
	/**
	 * Creates an instance of DataSystem using the default files.
	 * 
	 * The specification didn't say where the files would be loaded from, so I've given a default location, with the option of setting file locations yourself if you want.
	 * 
	 * @return the created instance
	 */
	public static DataSystem getDefaultInstance(){
		
		File modules = new File("modules.csv"); // Set the default modules file
		File supervisors = new File("supervisors.csv"); // Set the default supervisors file
		
		return new DataSystem(modules, supervisors); // Return a new instance of DataSystem
	}
	
	/**
	 * This method returns the number of students of the specified type that are currently
	 * enrolled.
	 *
	 * @param typeOfStudent the type of student to be counted
	 * @return the number of students
	 */
	public int noOfStudents(StudentType typeOfStudent){
		
		Objects.requireNonNull(typeOfStudent, "The type of student cannot be null");
		
		int counter = 0;
		
		for(Student student : students){ // Loop through all students
			if(student.getStudentType().equals(typeOfStudent)){ // If this student is the correct type
				counter++; // Increment the counter
			}
		}
		
		return counter; // Return the counter
	}
	
	/**
	 * 	This method registers a new student onto the system and allocates a student ID and SmartCard.
	 *
	 * @param student the student to be registered
	 */
	public void registerStudent (Student student){
		
		Objects.requireNonNull(student, "You can't register a null student");
		
		if(student.getStudentID() != null){
			throw new IllegalArgumentException("This student is already registered");
		}
		
		StudentID studentID = StudentID.createStudentID(); // Create a new student id
		student.setStudentID(studentID); // Give the student the id
		
		// Create a new smartcard
		SmartCard smartCard = SmartCard.createSmartCard(student.getName(), studentID, student.getStudentType(), student.getDateOfBirth());
		
		// Put the smartcard in the smartcard map
		smartCards.put(student.getStudentID(), smartCard);
		
		// Add the student to the students list
		students.add(student);
	}
	
	/**
	 * 	This method changes a student record.
	 *  I've made assumptions about the data type of StudentData and how the removal of the student instance from the student list, as this wasn't in the specification.
	 *  
	 *  Due to how StudentIDs and SmartCards are unique to an instance of Student, I've chosen to delete all old data on the student and re-register them.
	 *
	 * @param studentID the student ID to be changed
	 * @param studentData the student object to be added in
	 */
	public void amendStudentData(StudentID studentID, Student studentData){
		
		Objects.requireNonNull(studentID, "A studentID can't be null");
		Objects.requireNonNull(studentData, "A student can't be null");
		
		terminateStudent(studentID); // Terminate the old student instance
		registerStudent(studentData); // Register the new student instance
	}
	
	/**
	 * 	This method removes the student record associated with the given student number. In
	 * effect, the student is leaving the University.
	 *
	 * @param studentID the ID of the student to be removed
	 */
	public void terminateStudent (StudentID studentID){
		
		Objects.requireNonNull(studentID, "A studentID can't be null");
		
		Student terminated = null; // The student to be terminated
		
		for(Student student : students){ // Loop through all students
			if(student.getStudentID().equals(studentID)){ // If this is the correct student
				terminated = student; // Set to this student
				break; // End loop
			}
		}
		
		if(terminated == null){ // If the student was not found
			throw new IllegalArgumentException("This student is not registered");
		}
		
		students.remove(terminated); // Remove the student with that id
		smartCards.remove(studentID); // Remove the SmartCard which the student had
		terminated.setStudentID(null); // Remove the student's id
	}
	
	/**
	 * Reads a file line by line, converting each line to an object, then puts the objects into a list.
	 *
	 * @param <T> the generic type of the objects to be created
	 * @param set the set to be loaded into
	 * @param file the file to be loaded from
	 * @param readable the function to convert a line to an object
	 */
	private static <T> void read(Set<T> set, File file, Function<String,T> readable){
		
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){ // Open the file to read it
			
			reader.lines().forEach(line -> { // Go through each line in the file
				
				T result = readable.apply(line); // Apply the function to each
				set.add(result); // Put the returned value into the list
				
			});
			
		}catch (IOException e) { // If reading the file failed
			e.printStackTrace(); // Print an exception
		}
	}

	/**
	 * Gets all the modules in the system.
	 *
	 * @return the modules
	 */
	public List<Module> getModules() {
		return new ArrayList<>(modules); // Return a copy of the modules list
	}
	
	/**
	 * Gets a module object by code. Used in debugging and testing.
	 * 
	 * @param code the code of the module to find
	 * @return the module of that code
	 */
	public Module getModule(String code){
		
		for(Module m  : modules){ // Loop through all modules
			if(m.getCode().equalsIgnoreCase(code)){ // If it has the right code
				return m; // Return the module
			}
		}
		
		return null; // Return null if no code matched
	}
	
	/**
	 * Gets all the supervisors in the system.
	 *
	 * @return the supervisors
	 */
	public List<Supervisor> getSupervisors() {
		return new ArrayList<>(supervisors); // Return a copy of the supervisors list
	}

	/**
	 * Gets all the students in the system.
	 *
	 * @return the students
	 */
	public List<Student> getStudents() {
		return new ArrayList<>(students); // Return a copy of the students list
	}

	/**
	 * Gets the studentID->smartcard map.
	 *
	 * @return the smart cards
	 */
	public Map<StudentID, SmartCard> getSmartCards() {
		return new HashMap<>(smartCards); // Return a copy of the studentID->smartcard map
	}
	
}
