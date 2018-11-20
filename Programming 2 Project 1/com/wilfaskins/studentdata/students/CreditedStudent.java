package com.wilfaskins.studentdata.students;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.wilfaskins.studentdata.Module;
import com.wilfaskins.studentdata.students.id.StudentName;

/**
 * 
 * This class represents a student who takes modules and has credits.
 * 
 * @author Wilfrid Askins
 */
public abstract class CreditedStudent extends AbstractStudent{

	/** The modules taken by the student. */
	private Set<Module> modules;
	
	/**
	 * Instantiates a new credited student.
	 *
	 * @param studentName the student's name
	 * @param dateOfBirth the date of birth
	 */
	public CreditedStudent(StudentName studentName, Date dateOfBirth) {
		super(studentName, dateOfBirth);
		modules = new HashSet<Module>();
	}

	/* (non-Javadoc)
	 * @see com.wilfaskins.studentdata.students.Student#getModules()
	 */
	@Override
	public Set<Module> getModules() {
		return modules;
	}

	/* (non-Javadoc)
	 * @see com.wilfaskins.studentdata.students.Student#addModule()
	 */
	@Override
	public void addModule(Module m){
		modules.add(m);
	}
	
	/**
	 * Gets the number of credits the student is registered for.
	 *
	 * @return the registered credits
	 */
	public int getRegisteredCredits(){
		return modules.stream().mapToInt(Module::getCredits).sum(); // Add all the modules together and return a total
	}
	
	/**
	 * Gets the expected credits the student should be registered for.
	 *
	 * @return the expected credits
	 */
	public abstract int getExpectedCredits();
	
	/**
	 * Gets the pass percentage the student neeeds to achieve.
	 *
	 * @return the pass percentage
	 */
	public abstract int getPassPercentage();
	
	/* (non-Javadoc)
	 * @see com.wilfaskins.studentdata.students.Student#isRegisteredCorrectly()
	 */
	@Override
	public boolean isRegisteredCorrectly(){
		return getRegisteredCredits() == getExpectedCredits(); // If the credits of this student are what was expected
	}
}
