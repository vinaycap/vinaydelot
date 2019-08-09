package com.mercury.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mercury.qa.base.TestBase;

public class FFPage extends TestBase{

	@FindBy(xpath="//a[text()='SIGN-OFF']")
	WebElement Signoff;
	
	@FindBy(xpath="//input[@name='findFlights']")
	WebElement continuebutton;
	
	@FindBy(xpath="//select[@name='passCount']")
	WebElement passengers;
	
	public FFPage(){
		PageFactory.initElements(driver,this);
	}
	public void continuefromFlightFinder(){
		continuebutton.click();
		//return new SFPage();
		
	}
	
	public void sigingoff(){
		Signoff.click();
		
	}
	public void NumofPassengers(){
		Select passcount= new Select(passengers);
		passcount.selectByVisibleText("1");
	}
	
	
}
