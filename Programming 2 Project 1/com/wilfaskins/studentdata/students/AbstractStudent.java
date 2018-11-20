package com.wilfaskins.studentdata.students;

import java.util.Date;
import java.util.Objects;

import com.wilfaskins.studentdata.students.id.StudentID;
import com.wilfaskins.studentdata.students.id.StudentName;

/**
 * This class represents an abstract student. This class is the super class of other student classes.
 *
 * @author Wilfrid Askins
 */
public abstract class AbstractStudent implements Student{

	/** The student's name. */
	private final StudentName studentName;
	
	/** The student's date of birth. */
	private final Date dateOfBirth;
	
	/** The student's ID. */
	private StudentID studentID;
	
	/**
	 * Instantiates a new abstract student.
	 *
	 * @param studentName the student's name
	 * @param dateOfBirth the date of birth
	 */
	public AbstractStudent(StudentName studentName, Date dateOfBirth){
		
		Objects.requireNonNull(studentName, "A student's name cannot be null");
		Objects.requireNonNull(dateOfBirth, "A student's date of birth cannot be null");
		
		this.studentName = studentName;
		this.dateOfBirth = dateOfBirth;
	}
	
	/* (non-Javadoc)
	 * @see com.wilfaskins.studentdata.students.Student#setStudentID(com.wilfaskins.studentdata.students.id.StudentID)
	 */
	@Override
	public void setStudentID(StudentID studentID) {
		this.studentID = studentID;
	}
	
	/* (non-Javadoc)
	 * @see com.wilfaskins.studentdata.students.Student#getStudentID()
	 */
	@Override
	public StudentID getStudentID() {
		return studentID;
	}

	/* (non-Javadoc)
	 * @see com.wilfaskins.studentdata.students.Student#getName()
	 */
	@Override
	public StudentName getName() {
		return studentName;
	}

	/* (non-Javadoc)
	 * @see com.wilfaskins.studentdata.students.Student#getDateOfBirth()
	 */
	@Override
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AbstractStudent [studentName=" + studentName + ", dateOfBirth=" + dateOfBirth + ", studentID="
				+ studentID + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((studentID == null) ? 0 : studentID.hashCode());
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
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
		AbstractStudent other = (AbstractStudent) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (studentID == null) {
			if (other.studentID != null)
				return false;
		} else if (!studentID.equals(other.studentID))
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		return true;
	}	
	
}
