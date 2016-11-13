package com.kikiwora.usermanagement;

import java.util.Date;
import java.util.Calendar;

public class User {
	private Long 	iD;					// User ID
	private String 	firstName;			// User First Name
	private String 	lastName;			// User Last Name
	private Date 	dateOfBirthday;		// User Date of Birthday
	
	public void setID(Long iD) { this.iD = iD; }
	public Long getID() { return this.iD; }
	
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public String getFirstName() { return firstName; }
	
	public void setLastName(String lastName) { this.lastName = lastName; }
	public String getLastName() { return lastName; }
	
	public void setFullName(String fullName) {
		this.firstName = fullName.split(" ")[0];
		this.lastName = fullName.split(" ")[1];
	}
	public String getFullName() { return firstName + " " + lastName; }
	
	public void setDateOfBirthday(Date dateOfBirthday) { this.dateOfBirthday = dateOfBirthday; }
	public Date getDateOfBirthday() { return dateOfBirthday; }
	
	public int getAge() {
		Date currentDate = new Date();					// Current Date
		Calendar calendar = Calendar.getInstance();		// Calendar for date difference calculating
		calendar.setTimeInMillis(currentDate.getTime() - this.dateOfBirthday.getTime());	// Разница дат, хранящаяся в переменной, записана в формате от 1 Января 1970 года, получаем нужное значение вычитая начальное значение года
		return (calendar.get(Calendar.YEAR) - 1970);
	}
}	