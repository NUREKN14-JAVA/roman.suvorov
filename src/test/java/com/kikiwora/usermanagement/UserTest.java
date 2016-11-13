package com.kikiwora.usermanagement;

import java.util.Date;
import java.util.Calendar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	private User testUser;				// Test User Object
	private Long testID;				// Test User ID
	private String testFirstName;		// Test User First Name
	private String testLastName;		// Test User Last Name
	private Date testDateOfBirthday;	// Test User Date of Birthday
	
	@Before
	public void setUp() throws Exception {
		testUser = new User();
		testID = 13245920L;
		testFirstName = "John";
		testLastName = "Smith";
		Calendar calendar = Calendar.getInstance();
		calendar.set(1996, Calendar.DECEMBER, 10);
		testDateOfBirthday = calendar.getTime();
	}
	
	@Test
	public void testGetID() {
		testUser.setID(testID);
		assertEquals(testID, testUser.getID());
	}

	@Test
	public void testGetFirstName() {
		testUser.setFirstName(testFirstName);
		assertEquals(testFirstName, testUser.getFirstName());
	}
	
	@Test
	public void testGetLastName() {
		testUser.setLastName(testLastName);
		assertEquals(testLastName, testUser.getLastName());
	}
	
	@Test
	public void testGetFullName() {
		testUser.setFirstName(testFirstName);
		testUser.setLastName(testLastName);
		assertEquals(testFirstName + " " + testLastName, testUser.getFullName());
	}
	
	@Test
	public void testSetFullName() {
		testUser.setFullName(testFirstName + " " + testLastName);
		assertEquals(testFirstName + " " + testLastName, testUser.getFullName());
	}
	
	@Test
	public void testGetDateOfBirthday() {
		testUser.setDateOfBirthday(testDateOfBirthday);
		assertEquals(testDateOfBirthday, testUser.getDateOfBirthday());
	}
	
	@Test
	public void testGetAge() {
		testUser.setDateOfBirthday(testDateOfBirthday);
		
		Date currentDate = new Date();					// Current Date
		Calendar calendar = Calendar.getInstance();		// Calendar for date difference calculating
		calendar.setTimeInMillis(currentDate.getTime() - this.testDateOfBirthday.getTime());	// ѕолучаем разницу дат
		int testAge = (calendar.get(Calendar.YEAR) - 1970);		// –азница дат, хран¤ща¤с¤ в переменной, записана в формате от 1 январ¤ 1970 года, получаем нужное значение вычита¤ начальное значение года
		assertEquals(testAge, testUser.getAge());
	}
}