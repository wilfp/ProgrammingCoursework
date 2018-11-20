package com.wilfaskins.studentdata.students.id;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a student's ID
 * 
 * @author Wilfrid Askins
 */
public final class StudentID {
	
	/** All the IDs created. */
	private static final List<StudentID> createdIDs = new ArrayList<>();
	
	/** All the letters used in the student ID. */
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	
	/** The number at which the digits of the ID should rollover to zero. */
	private static final int ROLLOVER_VALUE = 10000;
	
	/** The number of the next student ID to be issued. */
	private static int currentNumber = 0;
	
	/** The letter used in this ID. */
	private final char letter;
	
	/** The number used in this ID. */
	private final String number;
	
	/**
	 * Instantiates a new student ID.
	 *
	 * @param letter the letter used in this ID
	 * @param number the number used in this ID
	 */
	private StudentID(char letter, String number) {
		super();
		this.letter = letter;
		this.number = number;
	}
	
	/**
	 * Creates a new student ID instance.
	 *
	 * @return the student ID instance
	 */
	public static StudentID createStudentID(){
		
		int number = ++currentNumber; // Post-increment the ID number
		
		char letter = ALPHABET.charAt(number / ROLLOVER_VALUE); // Find the letter to use in this ID
		String cardNumber = Integer.toString(number % ROLLOVER_VALUE); // Find the number to be used in this ID
		
		return getInstance(letter, pad(cardNumber)); // Return a new StudentID instance
	}
	
	/**
	 * Creates an instance of StudentID, checking for duplicates.
	 *
	 * @param letter the letter of the id
	 * @param number the number of the id
	 * @return an instance of StudentID
	 */
	private static final StudentID getInstance(char letter, String number){
		
		StudentID id = new StudentID(letter, number); // Create a new ID instance
		
		if(createdIDs.contains(id)){ // If this is a duplicate
			throw new IllegalArgumentException("This StudentID has already been created"); // Refuse to return the instance
		}
		
		return id; // Return a new StudentID instance
	}
	
	/**
	 * Pads a string with a maximum of four zeroes
	 * How to pad a string was learnt and modified from https://stackoverflow.com/questions/4051887/how-to-format-a-java-string-with-leading-zero
	 *
	 * @param original the original string
	 * @return the padded string
	 */
	private static String pad(String original){
		String expanded = "0000" + original; // Add the zeroes to the number
		return expanded.substring(expanded.length()-4, expanded.length()); // Cut the number to the correct length
	}
		
	/**
	 * Gets the letter of the ID.
	 *
	 * @return the letter
	 */
	public char getLetter() {
		return letter;
	}

	/**
	 * Gets the number of the ID.
	 *
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Gets the full ID string.
	 *
	 * @return the full ID
	 */
	public String getFullID(){
		return letter + number;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentID [letter=" + letter + ", number=" + number + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		
		if(arg0 instanceof StudentID){
			
			StudentID id = (StudentID)arg0;
			return id.getFullID().equals(this.getFullID());
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		
		int hc = 7;
		
		hc += 37 * letter;
		hc += number.hashCode();
		
		return hc;
	}
	
}
