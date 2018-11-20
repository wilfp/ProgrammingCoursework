package com.wilfaskins.studentdata.students.id;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import com.wilfaskins.studentdata.students.StudentType;

/**
 * Represents a student's SmartCard
 * 
 * @author Wilfrid Askins
 */
public final class SmartCard {
	
	/** The card owner's name. */
	private final StudentName studentName;
	
	/** The card owner's ID. */
	private final StudentID studentID;
	
	/** The card owner's date of birth. */
	private final Date dateOfBirth;
	
	/** The smart card's number. */
	private final SmartCardNumber smartCardNumber;
	
	/** The date this card was issued. */
	private final Date dateOfIssue;
	
	/**
	 * Instantiates a new smart card.
	 *
	 * @param studentName the student's name
	 * @param studentID the student's ID
	 * @param dateOfBirth the student's date of birth
	 * @param smartCardNumber the smart card number
	 * @param dateOfIssue the date of issue
	 */
	private SmartCard(StudentName studentName, StudentID studentID, Date dateOfBirth, SmartCardNumber smartCardNumber, Date dateOfIssue) {
		super();		
		this.studentName = studentName;
		this.studentID = studentID;
		this.dateOfBirth = new Date(dateOfBirth.getTime()); // Copy the date so it can't be changed later
		this.smartCardNumber = smartCardNumber;
		this.dateOfIssue = new Date(dateOfIssue.getTime());
	}

	/**
	 * Checks whether a student can have a smartcard, then issues a new smartcard if they are allowed.
	 * Help gotten from https://stackoverflow.com/questions/7906301/how-can-i-find-the-number-of-years-between-two-dates
	 * 
	 * @param studentName the student's name
	 * @param studentID the student's ID
	 * @param type the type of the student
	 * @param dateOfBirth the date of birth of the student
	 * @return the smart card which was created
	 */
	public static SmartCard createSmartCard(StudentName studentName, StudentID studentID, StudentType type, Date dateOfBirth){
		
		Objects.requireNonNull(studentName, "A student's name cannot be null");
		Objects.requireNonNull(studentID, "A student's id cannot be null");
		Objects.requireNonNull(type, "A student's type cannot be null");
		Objects.requireNonNull(dateOfBirth, "A student's date of birth cannot be null");
		
		Date dateOfIssue = new Date(); // Create a new date with the current time
		
		Calendar birth = Calendar.getInstance();
		birth.setTime(dateOfBirth); // Convert the birth date to a calendar to process
		
		Calendar issue = Calendar.getInstance();
		issue.setTime(dateOfIssue); // Convert the issue date to a calendar to process
		
		int YEAR = Calendar.YEAR; // Constants used by the calendar class, put here for readability
		int MONTH = Calendar.MONTH;
		int DATE = Calendar.DATE;
		
		int age = issue.get(YEAR)-birth.get(YEAR); // Calculate the student's age in years
		
		if(birth.get(MONTH) > issue.get(MONTH) || (birth.get(MONTH) == issue.get(MONTH) && birth.get(DATE) > issue.get(DATE))){ // If the year was rounded up
			age--; // Subtract one from the student's age
		}
		
		boolean flag1 = (type == StudentType.UNDERGRADUATE && age < 17); // If the student is too young for undergraduate
		boolean flag2 = (type.isPostgraduate() && age < 20); // If the student is too young for postgraduate
		
		if(flag1 || flag2){ // If the student is too young
			throw new IllegalArgumentException("This student is not old enough to be this type of student."); // Refuse to issue a card
		}
		
		// Return a new SmartCard instance
		return new SmartCard(studentName, studentID, dateOfBirth, SmartCardNumber.getNext(studentName, Integer.toString(issue.get(YEAR))), dateOfIssue);
	}
		
	/**
	 * Gets the student's name.
	 *
	 * @return the student's name
	 */
	public StudentName getStudentName() {
		return studentName;
	}
	
	/**
	 * Gets the student's ID.
	 *
	 * @return the student's ID
	 */
	public StudentID getStudentID(){
		return studentID;
	}

	/**
	 * Gets the student's date of birth.
	 *
	 * @return the student's date of birth
	 */
	public Date getDateOfBirth() {
		return new Date(dateOfBirth.getTime()); // Make a new Date instance to avoid changes
	}
	
	/**
	 * Gets the smart card number.
	 *
	 * @return the smart card number
	 */
	public SmartCardNumber getSmartCardNumber(){
		return smartCardNumber;
	}
	
	/**
	 * Gets the date of issue of the SmartCard.
	 *
	 * @return the date of issue
	 */
	public Date getDateOfIssue() {
		return new Date(dateOfIssue.getTime()); // Make a new Date instance to avoid changes
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SmartCard [studentName=" + studentName + ", dateOfBirth=" + dateOfBirth + ", smartCardNumber="
				+ smartCardNumber + ", dateOfIssue=" + dateOfIssue + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((smartCardNumber == null) ? 0 : smartCardNumber.hashCode());
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
		SmartCard other = (SmartCard) obj;
		if (smartCardNumber == null) {
			if (other.smartCardNumber != null)
				return false;
		} else if (!smartCardNumber.equals(other.smartCardNumber))
			return false;
		return true;
	}

	
}
