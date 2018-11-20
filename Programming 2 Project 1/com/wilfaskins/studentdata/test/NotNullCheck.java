package com.wilfaskins.studentdata.test;

import java.util.Calendar;

import org.junit.Test;

import com.wilfaskins.studentdata.DataSystem;
import com.wilfaskins.studentdata.Module;
import com.wilfaskins.studentdata.students.Student;
import com.wilfaskins.studentdata.students.UndergraduateStudent;
import com.wilfaskins.studentdata.students.id.StudentName;

/**
 * 
 * Tests whether the parameters of different constructors can be null.
 * Every method in this class should throw a NullPointerException.
 * 
 * @author Wilfrid Askins
 *
 */
public class NotNullCheck {
	
	/**
	 * Tests whether a student's name can be null
	 */
	@Test(expected = NullPointerException.class)
	public void studentNameTest() {
		
		DataSystem ds = DataSystem.getDefaultInstance();
		
		//StudentName name = new StudentName("Wilfrid", "Askins");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 30);
		
		Student student = new UndergraduateStudent(null, cal.getTime());
		ds.registerStudent(student);
	}
	
	/**
	 * Tests whether a student's date of birth can be null
	 */
	@Test(expected = NullPointerException.class)
	public void studentDateTest() {
		
		DataSystem ds = DataSystem.getDefaultInstance();
		
		StudentName name = new StudentName("Wilfrid", "Askins");
		
		//Calendar cal = Calendar.getInstance();
		//cal.set(Calendar.YEAR, 1999);
		//cal.set(Calendar.MONTH, 3);
		//cal.set(Calendar.DATE, 30);
		
		Student student = new UndergraduateStudent(name, null);
		ds.registerStudent(student);
	}
	
	/**
	 * Tests whether a module's code can be null
	 */
	@SuppressWarnings("unused")
	@Test(expected = NullPointerException.class)
	public void moduleCodeTest() {
		
		Module module = new Module(null, "Computing Dance Theory", 20);
	}
	
	/**
	 * Tests whether a module's name can be null
	 */
	@SuppressWarnings("unused")
	@Test(expected = NullPointerException.class)
	public void moduleNameTest() {
		
		Module module = new Module("CSC1023", null, 20);
	}
	
	/**
	 * Tests whether a student's first name can be null
	 */
	@SuppressWarnings("unused")
	@Test(expected = NullPointerException.class)
	public void studentNameFirstTest() {
		
		StudentName name = new StudentName(null, "Peter", "Askins");
	}
	
	/**
	 * Tests whether a student's middle name can be null
	 */
	@SuppressWarnings("unused")
	@Test(expected = NullPointerException.class)
	public void studentNameMiddleTest() {
		
		StudentName name = new StudentName("Wilfrid", null, "Askins");
	}
	
	/**
	 * Tests whether a student's last name can be null
	 */
	@SuppressWarnings("unused")
	@Test(expected = NullPointerException.class)
	public void studentNameLastTest() {
		
		StudentName name = new StudentName("Wilfrid", "Peter", null);
	}
	
	@Test(expected = NullPointerException.class)
	public void registerStudentTest() {
		
		DataSystem ds = DataSystem.getDefaultInstance();
		ds.registerStudent(null); // Register the student
	}

	@Test(expected = NullPointerException.class)
	public void terminateStudentTest() {
		
		DataSystem ds = DataSystem.getDefaultInstance();
		ds.terminateStudent(null); // Terminate the student
	}

	@Test(expected = NullPointerException.class)
	public void amendStudentTest() {
		
		DataSystem ds = DataSystem.getDefaultInstance();
		ds.amendStudentData(null, null); // Amend the student
	}
	
}
