package com.wilfaskins.studentdata.students;

import java.util.Collections;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import com.wilfaskins.studentdata.Module;
import com.wilfaskins.studentdata.Supervisor;
import com.wilfaskins.studentdata.students.id.StudentName;

/**
 * This class represents a postgraduate research student, with no modules and a supervisor allocated.
 *
 * @author Wilfrid Askins
 */
public final class PostgraduateResearchStudent extends AbstractStudent{

	/** The supervisor allocated to this student. */
	private final Supervisor supervisor;
	
	/**
	 * Instantiates a new postgraduate research student.
	 *
	 * @param studentName the student's name
	 * @param dateOfBirth the date of birth
	 * @param supervisor the supervisor allocated
	 */
	public PostgraduateResearchStudent(StudentName studentName, Date dateOfBirth, Supervisor supervisor) {
		super(studentName, dateOfBirth);
		
		Objects.requireNonNull(supervisor, "A supervisor cannot be null");
		
		this.supervisor = supervisor;
	}

	/* (non-Javadoc)
	 * @see com.wilfaskins.studentdata.students.Student#getModules()
	 */
	@Override
	public Set<Module> getModules() {
		return Collections.emptySet(); // This student type has no modules
	}
	
	/* (non-Javadoc)
	 * @see com.wilfaskins.studentdata.students.Student#addModule()
	 */
	@Override
	public void addModule(Module m) {
		throw new UnsupportedOperationException("This student cannot take modules!"); // You can't give a research student a module, therefore this throws an exception
	}

	/* (non-Javadoc)
	 * @see com.wilfaskins.studentdata.students.Student#isRegisteredCorrectly()
	 */
	@Override
	public boolean isRegisteredCorrectly() {
		return supervisor != null && !supervisor.getFullName().isEmpty(); // Return true if a supervisor has been allocated.
	}

	/* (non-Javadoc)
	 * @see com.wilfaskins.studentdata.students.Student#getStudentType()
	 */
	@Override
	public StudentType getStudentType() {
		return StudentType.POSTGRADUATE_RESEARCH; // Return the correct student type
	}

	/**
	 * Gets the supervisor allocated to this student.
	 *
	 * @return the supervisor
	 */
	public Supervisor getSupervisor() {
		return supervisor;
	}

}
