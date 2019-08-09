package com.mercury.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mercury.qa.base.TestBase;

public class FlightFinderPage extends TestBase {

	@FindBy(xpath="//b/font/input[2]")
	WebElement onewaytrip;
	
	
	@FindBy(xpath="//select[@name='passCount']")
	WebElement passengers;
	
	@FindBy(xpath="//tr[4]/td[2]/select")
	WebElement Departing;
	
	@FindBy(xpath="//input[@name='findFlights']")
	WebElement continuebutton;
	
	public void FlightFindrerPage(){
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	public void typeoftrip(){
		onewaytrip.click();
	}
	
	public void NumofPassengers(){
		Select passcount= new Select(passengers);
		passcount.selectByVisibleText("2");
	}
	
	public void DepartingFrom(){
		Select departure= new Select(Departing);
		departure.selectByValue("London");
	}
	
	
	public void continuefromFlightFinder(){
		continuebutton.click();
		
	}
	
	
	
	
	
	
	
}
