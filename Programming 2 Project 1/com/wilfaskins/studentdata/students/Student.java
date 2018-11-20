package com.wilfaskins.studentdata.students;

import java.util.Date;
import java.util.Set;

import com.wilfaskins.studentdata.Module;
import com.wilfaskins.studentdata.students.id.StudentID;
import com.wilfaskins.studentdata.students.id.StudentName;

/**
 * 
 * This class represents a Student in the system.
 * This class is the superclass of all other Student classes.
 *
 * @author Wilfrid Askins
 */
public interface Student {
	
	/**
	 * Gets the name of the student.
	 *
	 * @return the name
	 */
	public StudentName getName();
	
	/**
	 * Gets the date of birth of the student.
	 *
	 * @return the date of birth
	 */
	public Date getDateOfBirth();
	
	/**
	 * Gets the student's type.
	 *
	 * @return the student type
	 */
	public StudentType getStudentType();
	
	/**
	 * Gets the student's ID.
	 *
	 * @return the student ID
	 */
	public StudentID getStudentID();
	
	/**
	 * Sets the student's ID.
	 *
	 * @param studentID the new student ID
	 */
	public void setStudentID(StudentID studentID);
	
	/**
	 * Gets the modules this student is taking.
	 *
	 * @return the modules
	 */
	public Set<Module> getModules();
	
	/**
	 * Adds a module to the list of what the student is taking.
	 * 
	 * @param m the module to add
	 */
	public void addModule(Module m);
	
	/**
	 * Checks if this student is registered correctly.
	 *
	 * @return true, if this student is registered correctly
	 */
	public boolean isRegisteredCorrectly();

}
