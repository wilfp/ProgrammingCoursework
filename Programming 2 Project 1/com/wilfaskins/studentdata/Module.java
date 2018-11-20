package com.wilfaskins.studentdata;

import java.util.Objects;

/**
 * This class represents a Module and it's details.
 *
 * @author Wilfrid Askins
 */
public final class Module{
	
	/** The module's code. */
	private final String code;
	
	/** The module's name. */
	private final String name;
	
	/** The module's credits. */
	private final int credits;
	
	/**
	 * Instantiates a new module.
	 *
	 * @param code the module's code
	 * @param name the module's name
	 * @param credits the module's credits
	 */
	public Module(String code, String name, int credits) {
		super();
		
		if(credits < 0){ // If the credits entered were negative
			// Throw an exception
			throw new IllegalArgumentException("A module can't have a negative number of credits");
		}
		
		Objects.requireNonNull(code, "A module's code cannot be null");
		Objects.requireNonNull(name, "A module's name cannot be null");
		
		this.code = code;
		this.name = name;
		this.credits = credits;
	}
	
	/**
	 * Gets the module's code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Gets the module's name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the module's credits.
	 *
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * Finds the Module value of a string.
	 *
	 * @param text the text to be converted
	 * @return the module the text represents
	 */
	public static Module valueOf(String text) {
		
		String[] parts = text.split(","); // Split the string by comma
		
		return new Module(parts[0].trim(), parts[1].trim(), Integer.parseInt(parts[2].trim())); // Put the array values into the params for Module
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Module [code=" + code + ", name=" + name + ", credits=" + credits + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + credits;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Module other = (Module) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (credits != other.credits)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
