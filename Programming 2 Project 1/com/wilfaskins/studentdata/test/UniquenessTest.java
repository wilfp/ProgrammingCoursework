package com.wilfaskins.studentdata.test;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.wilfaskins.studentdata.students.StudentType;
import com.wilfaskins.studentdata.students.id.SmartCard;
import com.wilfaskins.studentdata.students.id.StudentID;
import com.wilfaskins.studentdata.students.id.StudentName;

/**
 * Tests whether SmartCards and StudentIDs are created uniquely.
 */
public class UniquenessTest {
	
	/**
	 * Smart card uniqueness test.
	 */
	@Test
	public void smartCardUniquenessTest() {
		
		final List<SmartCard> smartCards = new ArrayList<>();
		
		StudentName name = new StudentName("Wilfrid", "Askins");
		StudentID id = StudentID.createStudentID();
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 30);
		
		for(int i = 0; i < 100; i++){ // Loop 100 times
			SmartCard.createSmartCard(name, id, StudentType.UNDERGRADUATE, cal.getTime()); // Create smartcards and add them to the list
		}
		
		// Convert the smartcards to their serial numbers
		Stream<Integer> numbers = smartCards.stream().map(smartCard -> smartCard.getSmartCardNumber().getSerialNumber());
		
		// Check whether the smartcards are all unique
		assertEquals(smartCards.size(), numbers.distinct().count());
	}

	/**
	 * Student ID uniqueness test.
	 */
	@Test
	public void studentIDUniquenessTest() {
		
		final List<StudentID> studentIDs = new ArrayList<>();
		
		for(int i = 0; i < 100; i++){ // Loop 100 times
			studentIDs.add(StudentID.createStudentID()); // Create studentIDs and add them to the list
		}
		
		// Convert studentIDs to their full ID string
		Stream<String> fullIDs = studentIDs.stream().map(studentID -> studentID.getFullID());
		
		// Check the studentID strings are all unique
		assertEquals(studentIDs.size(), fullIDs.distinct().count());
	}

}
