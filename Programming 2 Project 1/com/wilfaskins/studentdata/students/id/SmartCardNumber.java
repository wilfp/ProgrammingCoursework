package com.wilfaskins.studentdata.students.id;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * This class represents a SmartCard's number, including the letter and digits.
 *
 * @author Wilfrid Askins
 */
public final class SmartCardNumber {

	/** The string which seperates the letter and digits. */
	private static final String SEPERATOR = "-";

	/** Used to issue an incremental serial number. */
	private static final Map<String,Integer> letterNumberMap = new HashMap<>();

	/** The first initial of the student. */
	private final String firstInitial;
	
	/** The last initial of the student. */
	private final String lastInitial;
	
	/** The year the card was issued. */
	private final String year;
	
	/** The serial number of the card. */
	private final int serialNumber;

	/**
	 * Instantiates a new smart card number.
	 *
	 * @param firstInitial the first initial of the student
	 * @param lastInitial the last initial of the student
	 * @param year the year the card was issued
	 * @param serialNumber the serial number of the card
	 */
	private SmartCardNumber(String firstInitial, String lastInitial, String year, int serialNumber) {
		super();
		this.firstInitial = firstInitial;
		this.lastInitial = lastInitial;
		this.year = year;
		this.serialNumber = serialNumber;
	}

	/**
	 * Gets the next unique SmartCardNumber.
	 *
	 * @param name the name of the student
	 * @param year the year the card was issued
	 * @return the unique number
	 */
	public static SmartCardNumber getNext(StudentName name, String year){
		
		Objects.requireNonNull(name, "A student's name cannot be null");
		Objects.requireNonNull(year, "A student's year cannot be null");
		
		String firstInitial = name.getFirstName().substring(0, 1); // Get the student's first initial
		String lastInitial = name.getLastName().substring(0, 1); // Get the student's last initial
		
		String letters = firstInitial + lastInitial + SEPERATOR + year; // All of the SmartCardNumber except for the serial number
		
		int numberUsed = letterNumberMap.getOrDefault(letters, -1); // Get the required serial number
		letterNumberMap.put(letters, ++numberUsed); // Update the serial number in the map
		
		return new SmartCardNumber(firstInitial, lastInitial, year, numberUsed); // Return a new SmartCardNumber instance
	}

	/**
	 * Gets the first initial of the student.
	 *
	 * @return the first initial of the student
	 */
	public String getFirstInitial() {
		return firstInitial;
	}

	/**
	 * Gets the last initial of the student.
	 *
	 * @return the last initial of the student
	 */
	public String getLastInitial() {
		return lastInitial;
	}

	/**
	 * Gets the year the card was issued.
	 *
	 * @return the year the card was issued
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Gets the serial number of the card.
	 *
	 * @return the serial number of the card
	 */
	public int getSerialNumber() {
		return serialNumber;
	}

	/**
	 * Gets the full number of the card.
	 *
	 * @return the full number of the card
	 */
	public String getFullNumber(){
		return firstInitial + lastInitial + SEPERATOR + year + SEPERATOR + serialNumber; // Concatenates the parts of the card number
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SmartCardNumber [fullNumber=" + getFullNumber() + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + serialNumber;
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SmartCardNumber other = (SmartCardNumber) obj;
		if (serialNumber != other.serialNumber)
			return false;
		return true;
	}

}
