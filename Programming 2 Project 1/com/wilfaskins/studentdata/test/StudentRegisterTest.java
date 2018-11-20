package com.wilfaskins.studentdata.test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import com.wilfaskins.studentdata.DataSystem;
import com.wilfaskins.studentdata.Supervisor;
import com.wilfaskins.studentdata.students.PostgraduateResearchStudent;
import com.wilfaskins.studentdata.students.PostgraduateTaughtStudent;
import com.wilfaskins.studentdata.students.Student;
import com.wilfaskins.studentdata.students.UndergraduateStudent;
import com.wilfaskins.studentdata.students.id.StudentName;

/**
 * Tests whether DataSystem.registerStudent works properly.
 */
public class StudentRegisterTest {

	/** The DataSystem instance used in these tests. */
	private static final DataSystem ds = DataSystem.getDefaultInstance();
	
	/**
	 * Undergraduate success test.
	 */
	@Test
	public void undergraduateSuccessTest() {
		
		StudentName name = new StudentName("Wilfrid", "Askins");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 30);
		
		Student student = new UndergraduateStudent(name, cal.getTime());
		
		student.addModule(ds.getModule("CSC1021")); // Add modules to the student
		student.addModule(ds.getModule("CSC1022"));
		student.addModule(ds.getModule("CSC1023"));
		student.addModule(ds.getModule("CSC1024"));
		student.addModule(ds.getModule("CSC1025"));
		student.addModule(ds.getModule("CSC1026"));
		
		ds.registerStudent(student); // Register the student
		
		assertTrue(student.isRegisteredCorrectly()); // Check if the student was registered correctly
	}
	
	/**
	 * Undergraduate fail test.
	 */
	@Test
	public void undergraduateFailTest() {
		
		StudentName name = new StudentName("Wilfrid", "Askins");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 30);
		
		Student student = new UndergraduateStudent(name, cal.getTime());
		
		student.addModule(ds.getModule("CSC1021"));
		student.addModule(ds.getModule("CSC1022"));
		student.addModule(ds.getModule("CSC1023"));
		student.addModule(ds.getModule("CSC1024"));
		student.addModule(ds.getModule("CSC1025"));
		//student.addModule(sys.getModule("CSC1026")); // This module will not be added
		
		ds.registerStudent(student);
		
		assertFalse(student.isRegisteredCorrectly()); // Check the student was not registered correctly
	}

	/**
	 * Postgraduate taught success test.
	 */
	@Test
	public void postgraduateTaughtSuccessTest() {
		
		StudentName name = new StudentName("Wilfrid", "Askins");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1990);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 30);
		
		Student student = new PostgraduateTaughtStudent(name, cal.getTime());
		
		student.addModule(ds.getModule("CSC3095")); // Add the postgraduate modules
		student.addModule(ds.getModule("CSC3121"));
		student.addModule(ds.getModule("CSC3122"));
		student.addModule(ds.getModule("CSC3123"));
		student.addModule(ds.getModule("CSC3124"));
		student.addModule(ds.getModule("CSC3221"));
		student.addModule(ds.getModule("CSC3222"));
		student.addModule(ds.getModule("CSC3223"));
		student.addModule(ds.getModule("CSC3224"));
		student.addModule(ds.getModule("CSC3321"));
		student.addModule(ds.getModule("CSC3322"));
		student.addModule(ds.getModule("CSC3323"));
		student.addModule(ds.getModule("CSC3324"));
		student.addModule(ds.getModule("CSC3422"));
		student.addModule(ds.getModule("CSC3423"));
		
		ds.registerStudent(student); // Register the student
		
		assertTrue(student.isRegisteredCorrectly()); // Check the student was correctly registered
	}
	
	/**
	 * Postgraduate taught fail test.
	 */
	@Test
	public void postgraduateTaughtFailTest() {
		
		StudentName name = new StudentName("Wilfrid", "Askins");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1990);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 30);
		
		Student student = new PostgraduateTaughtStudent(name, cal.getTime());
		
		student.addModule(ds.getModule("CSC3095"));
		student.addModule(ds.getModule("CSC3121"));
		student.addModule(ds.getModule("CSC3122"));
		student.addModule(ds.getModule("CSC3123"));
		student.addModule(ds.getModule("CSC3124"));
		student.addModule(ds.getModule("CSC3221"));
		student.addModule(ds.getModule("CSC3222"));
		student.addModule(ds.getModule("CSC3223"));
		student.addModule(ds.getModule("CSC3224"));
		student.addModule(ds.getModule("CSC3321"));
		student.addModule(ds.getModule("CSC3322"));
		student.addModule(ds.getModule("CSC3323"));
		student.addModule(ds.getModule("CSC3324"));
		student.addModule(ds.getModule("CSC3422"));
		//student.addModule(ds.getModule("CSC3423")); // This module will not be added
		
		ds.registerStudent(student);
		
		assertFalse(student.isRegisteredCorrectly()); // Check the student was registered incorrectly
	}

	/**
	 * Postgraduate research success test.
	 */
	@Test
	public void postgraduateResearchSuccessTest() {
		
		StudentName name = new StudentName("Wilfrid", "Askins");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1990);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 30);
		
		Supervisor supervisor = new Supervisor("Neil", "Speirs"); // Make a supervisor for this student
		
		Student student = new PostgraduateResearchStudent(name, cal.getTime(), supervisor);
		
		ds.registerStudent(student);
		
		assertTrue(student.isRegisteredCorrectly()); // Check the student was registered correctly
	}

	/**
	 * Postgraduate research fail test.
	 */
	@Test(expected = NullPointerException.class)
	public void postgraduateResearchFailTest() {
		
		StudentName name = new StudentName("Wilfrid", "Askins");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1990);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 30);
		
		Student student = new PostgraduateResearchStudent(name, cal.getTime(), null); // This student will have no supervisor
		
		ds.registerStudent(student);
		
		assertFalse(student.isRegisteredCorrectly()); // Check the student was not registered correctly
	}
	
	/**
	 * Undergraduate age fail test.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void undergraduateAgeFailTest() {
		
		StudentName name = new StudentName("Wilfrid", "Askins");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2016); // This student will be too young
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 30);
		
		Student student = new UndergraduateStudent(name, cal.getTime()); // This will throw an exception
		
		student.addModule(ds.getModule("CSC1021"));
		student.addModule(ds.getModule("CSC1022"));
		student.addModule(ds.getModule("CSC1023"));
		student.addModule(ds.getModule("CSC1024"));
		student.addModule(ds.getModule("CSC1025"));
		student.addModule(ds.getModule("CSC1026"));
		
		ds.registerStudent(student);
	}

	/**
	 * Postgraduate age fail test.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void postgraduateAgeFailTest() {
		
		StudentName name = new StudentName("Wilfrid", "Askins");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1999); // This postgraduate student will be too young
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 30);
		
		Student student = new PostgraduateTaughtStudent(name, cal.getTime()); // This will throw an exception
		
		student.addModule(ds.getModule("CSC1021"));
		student.addModule(ds.getModule("CSC1022"));
		student.addModule(ds.getModule("CSC1023"));
		student.addModule(ds.getModule("CSC1024"));
		student.addModule(ds.getModule("CSC1025"));
		student.addModule(ds.getModule("CSC1026"));
		
		ds.registerStudent(student);
	}

	/**
	 * Test whether registering a student twice will cause an error
	 */
	@Test(expected = IllegalArgumentException.class)
	public void alreadyRegisteredFail() {
		
		StudentName name = new StudentName("Wilfrid", "Askins");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1999); // This postgraduate student will be too young
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 30);
		
		Student student = new PostgraduateTaughtStudent(name, cal.getTime()); // This will throw an exception
		
		student.addModule(ds.getModule("CSC1021"));
		student.addModule(ds.getModule("CSC1022"));
		student.addModule(ds.getModule("CSC1023"));
		student.addModule(ds.getModule("CSC1024"));
		student.addModule(ds.getModule("CSC1025"));
		student.addModule(ds.getModule("CSC1026"));
		
		ds.registerStudent(student);
		
		ds.registerStudent(student); // Register the student a second time
	}

}
