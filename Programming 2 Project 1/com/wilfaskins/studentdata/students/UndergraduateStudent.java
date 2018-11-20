package com.wilfaskins.studentdata.students;

import java.util.Date;

import com.wilfaskins.studentdata.students.id.StudentName;

/**
 * This class represents an undergraduate student
 *
 * @author Wilfrid Askins
 */
public class UndergraduateStudent extends CreditedStudent{

	/**
	 * Instantiates a new undergraduate student.
	 *
	 * @param studentName the student's name
	 * @param dateOfBirth the date of birth of the student
	 */
	public UndergraduateStudent(StudentName studentName, Date dateOfBirth) {
		super(studentName, dateOfBirth);
	}

	/* (non-Javadoc)
	 * @see com.wilfaskins.studentdata.students.ModuleStudent#getExpectedCredits()
	 */
	@Override
	public int getExpectedCredits() {
		return 120;
	}

	/* (non-Javadoc)
	 * @see com.wilfaskins.studentdata.students.ModuleStudent#getPassPercentage()
	 */
	@Override
	public int getPassPercentage() {
		return 40;
	}
	
	/* (non-Javadoc)
	 * @see com.wilfaskins.studentdata.students.Student#getStudentType()
	 */
	@Override
	public StudentType getStudentType() {
		return StudentType.UNDERGRADUATE;
	}

}
