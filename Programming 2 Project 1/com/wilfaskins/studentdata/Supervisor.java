package com.wilfaskins.studentdata;

/**
 * 
 * This class represents a Supervisor.
 * 
 * @author Wilfrid Askins
 */
public final class Supervisor{
	
	/** The supervisor's first name. */
	private final String firstName;
	
	/** The supervisor's last name. */
	private final String lastName;
	
	/**
	 * Instantiates a new supervisor.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 */
	public Supervisor(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Gets the full name.
	 *
	 * @return the full name
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	/**
	 * Returns the Supervisor represented by a string
	 *
	 * @param text the text
	 * @return the supervisor
	 */
	public static Supervisor valueOf(String text){
		
		String[] parts = text.split(","); // Split the string by comma
		
		return new Supervisor(parts[0].trim(), parts[1].trim()); // Put each part of the array into the params for Supervisor
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Supervisor [firstName=" + firstName + ", lastName=" + lastName + "]";
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
		Supervisor other = (Supervisor) obj;
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
		return true;
	}
}
