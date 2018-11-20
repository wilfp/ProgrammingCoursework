package com.wilfaskins.studentdata.students.id;

import java.util.Objects;

/**
 * Represents a student's name.
 * 
 * @author Wilfrid Askins
 */
public final class StudentName {
	
	/** The first name of the student. */
	private final String firstName;
	
	/** The last name of the student. */
	private final String lastName;
	
	/** The middle names of the student. */
	private final String middleNames;
	
	/**
	 * Instantiates a new student name.
	 *
	 * @param firstName the first name of the student
	 * @param lastName the last name of the student
	 */
	public StudentName(String firstName, String lastName) {
		this(firstName, lastName, ""); // Create with no middle names
	}
	
	/**
	 * Instantiates a new student name.
	 *
	 * @param firstName the first name of the student
	 * @param lastName the last name of the student
	 * @param middleNames the middle names of the student
	 */
	public StudentName(String firstName, String lastName, String middleNames) {
		super();
		
		Objects.requireNonNull(firstName, "A student's name cannot contain a null value");
		Objects.requireNonNull(lastName, "A student's name cannot contain a null value");
		Objects.requireNonNull(middleNames, "A student's name cannot contain a null value");
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleNames = middleNames;
	}

	/**
	 * Gets the first name of the student.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the last name of the student.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Gets the middle names of the student.
	 *
	 * @return the middle names
	 */
	public String getMiddleNames() {
		return middleNames;
	}

	/**
	 * Checks for middle names.
	 *
	 * @return true, if successful
	 */
	public boolean hasMiddleNames(){
		return middleNames != null;
	}
	
	/**
	 * Gets the full name of the student.
	 *
	 * @return the full name string
	 */
	public String getFullName(){
		
		String full = firstName; // Add the first name
		
		if(hasMiddleNames()){ // If there are middle names
			full += " " + middleNames; // Add the middle names
		}
		
		full += lastName; // Add the last name
		
		return full; // Return the full name
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentName [fullName=" + getFullName() + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleNames == null) ? 0 : middleNames.hashCode());
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
		StudentName other = (StudentName) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleNames == null) {
			if (other.middleNames != null)
				return false;
		} else if (!middleNames.equals(other.middleNames))
			return false;
		return true;
	}
	
	
}
