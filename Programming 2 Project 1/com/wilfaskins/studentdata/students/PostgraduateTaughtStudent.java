package com.wilfaskins.studentdata.students;

import java.util.Date;

import com.wilfaskins.studentdata.students.id.StudentName;

/**
 * This class represents a postgraduate taught student.
 * 
 * @author Wilfrid Askins
 */
public class PostgraduateTaughtStudent extends CreditedStudent{

	/**
	 * Instantiates a new postgraduate taught student.
	 *
	 * @param studentName the student's name
	 * @param dateOfBirth the date of birth
	 */
	public PostgraduateTaughtStudent(StudentName studentName, Date dateOfBirth) {
		super(studentName, dateOfBirth);
	}

	/* (non-Javadoc)
	 * @see com.wilfaskins.studentdata.students.ModuleStudent#getExpectedCredits()
	 */
	@Override
	public int getExpectedCredits() {
		return 180; // The correct number of credits
	}

	/* (non-Javadoc)
	 * @see com.wilfaskins.studentdata.students.ModuleStudent#getPassPercentage()
	 */
	@Override
	public int getPassPercentage() {
		return 50; // The pass percentage for this student type
	}
	
	/* (non-Javadoc)
	 * @see com.wilfaskins.studentdata.students.Student#getStudentType()
	 */
	@Override
	public StudentType getStudentType() {
		return StudentType.POSTGRADUATE_TAUGHT; // Returns the student type
	}

}
