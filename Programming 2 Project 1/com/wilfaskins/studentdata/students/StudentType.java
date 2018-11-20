package com.wilfaskins.studentdata.students;

/**
 * The Enum StudentType. This represents the different types of students stored in the system.
 *
 * @author Wilfrid Askins
 */
public enum StudentType {

	/** The undergraduate type. */
	UNDERGRADUATE("undergraduate", false), 
	
	/** The postgraduate research type. */
	POSTGRADUATE_RESEARCH("postgraduate_research", true), 
	
	/** The postgraduate taught type. */
	POSTGRADUATE_TAUGHT("postgraduate_taught", true);

	/** The name of the student type. */
	private final String name;
	
	/** Whether the student type is a postgraduate. */
	private final boolean postgraduate;
	
	/**
	 * Instantiates a new student type.
	 *
	 * @param name the name of the student type
	 * @param postgraduate whether the student type is a postgraduate
	 */
	private StudentType(String name, boolean postgraduate){
		this.name = name;
		this.postgraduate = postgraduate;
	}

	/**
	 * Gets the student type's name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Checks if the student type is postgraduate.
	 *
	 * @return true, if the student is postgraduate
	 */
	public boolean isPostgraduate(){
		return postgraduate;
	}
	
}
