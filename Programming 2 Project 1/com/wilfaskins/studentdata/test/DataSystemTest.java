package com.wilfaskins.studentdata.test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import com.wilfaskins.studentdata.DataSystem;
import com.wilfaskins.studentdata.Supervisor;
import com.wilfaskins.studentdata.students.PostgraduateResearchStudent;
import com.wilfaskins.studentdata.students.PostgraduateTaughtStudent;
import com.wilfaskins.studentdata.students.Student;
import com.wilfaskins.studentdata.students.StudentType;
import com.wilfaskins.studentdata.students.UndergraduateStudent;
import com.wilfaskins.studentdata.students.id.StudentID;
import com.wilfaskins.studentdata.students.id.StudentName;

/**
 * Tests whether the methods of DataSystem work properly.
 */
public class DataSystemTest {

	/**
	 * No of students test.
	 */
	@Test
	public void noOfStudentsTest() {
		
		DataSystem ds = DataSystem.getDefaultInstance();
		
		assertEquals(ds.noOfStudents(StudentType.UNDERGRADUATE), 0);
		assertEquals(ds.noOfStudents(StudentType.POSTGRADUATE_TAUGHT), 0);
		assertEquals(ds.noOfStudents(StudentType.POSTGRADUATE_RESEARCH), 0);

		StudentName name = new StudentName("Wilfrid", "Askins"); // Create the student's details
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 30);
		
		for(int i = 0; i < 10; i++){
			Student student = new UndergraduateStudent(name, cal.getTime()); // Create several student instances
			ds.registerStudent(student); // Register students to the system
		}
		
		cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1990);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 30);
		
		for(int i = 0; i < 5; i++){
			Student student = new PostgraduateTaughtStudent(name, cal.getTime()); // Create postgraduate taught student instances
			ds.registerStudent(student);
		}
		
		Supervisor supervisor = new Supervisor("Neil", "Speirs"); // Create a new supervisor
		
		for(int i = 0; i < 5; i++){
			Student student = new PostgraduateResearchStudent(name, cal.getTime(), supervisor); // Create postgraduate research student instances
			ds.registerStudent(student);
		}
		
		assertEquals(ds.noOfStudents(StudentType.UNDERGRADUATE), 10); // Check if the students can be counted correctly
		assertEquals(ds.noOfStudents(StudentType.POSTGRADUATE_TAUGHT), 5);
		assertEquals(ds.noOfStudents(StudentType.POSTGRADUATE_RESEARCH), 5);
	}
	
	/**
	 * Tests counting the student with a null student type
	 */
	@Test(expected = NullPointerException.class)
	public void noOfStudentsFail() {
		
		DataSystem ds = DataSystem.getDefaultInstance();
		
		assertEquals(ds.noOfStudents(StudentType.UNDERGRADUATE), 0);
		assertEquals(ds.noOfStudents(StudentType.POSTGRADUATE_TAUGHT), 0);
		assertEquals(ds.noOfStudents(StudentType.POSTGRADUATE_RESEARCH), 0);

		StudentName name = new StudentName("Wilfrid", "Askins"); // Create the student's details
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 30);
		
		for(int i = 0; i < 10; i++){
			Student student = new UndergraduateStudent(name, cal.getTime()); // Create several student instances
			ds.registerStudent(student); // Register students to the system
		}
		
		cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1990);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 30);
		
		for(int i = 0; i < 5; i++){
			Student student = new PostgraduateTaughtStudent(name, cal.getTime()); // Create postgraduate taught student instances
			ds.registerStudent(student);
		}
		
		Supervisor supervisor = new Supervisor("Neil", "Speirs"); // Create a new supervisor
		
		for(int i = 0; i < 5; i++){
			Student student = new PostgraduateResearchStudent(name, cal.getTime(), supervisor); // Create postgraduate research student instances
			ds.registerStudent(student);
		}
		
		assertEquals(ds.noOfStudents(null), 10); // Check if an error was thrown
	}


	/**
	 * Amend student data test.
	 */
	@Test
	public void amendStudentDataTest() {
		
		DataSystem ds = DataSystem.getDefaultInstance();
		
		StudentName name = new StudentName("Wilfrid", "Askins");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 30);
		
		Student student = new UndergraduateStudent(name, cal.getTime());
		ds.registerStudent(student);
		
		assertTrue(ds.getStudents().contains(student)); // Check that the students list contains the student
		
		StudentName newName = new StudentName("Sam", "Wilson");
		Student newStudent = new UndergraduateStudent(newName, cal.getTime());
		
		ds.amendStudentData(student.getStudentID(), newStudent); // Remove the old student
		
		assertFalse(ds.getStudents().contains(student)); // Check the old student was removed
		assertTrue(ds.getStudents().contains(newStudent)); // Check the new student was added
	}

	/**
	 * Terminate student test.
	 */
	@Test
	public void terminateStudentTest() {
		
		DataSystem ds = DataSystem.getDefaultInstance();
		
		StudentName name = new StudentName("Wilfrid", "Askins");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 30);
		
		Student student = new UndergraduateStudent(name, cal.getTime());
		ds.registerStudent(student);
		
		assertTrue(ds.getStudents().contains(student)); // Check the student was previously in the student list
		
		ds.terminateStudent(student.getStudentID()); // Remove the student
		
		assertFalse(ds.getStudents().contains(student)); // Check the student was removed
	}

	/**
	 * Tests terminating a student which was never registered
	 */
	@Test(expected = IllegalArgumentException.class)
	public void terminateStudentFail() {
		
		DataSystem ds = DataSystem.getDefaultInstance();
		
		StudentName name = new StudentName("Wilfrid", "Askins");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 30);
		
		Student student = new UndergraduateStudent(name, cal.getTime());
		student.setStudentID(StudentID.createStudentID());
		//ds.registerStudent(student);
		
		ds.terminateStudent(student.getStudentID()); // Remove the student
	}

}
