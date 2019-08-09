package com.mercury.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.FFPage;
import com.mercury.qa.pages.FlightFinderPage;
import com.mercury.qa.pages.Loginpage;

public class LoginTest extends TestBase {

	Loginpage loginpg;
	FFPage ffpg;
	public LoginTest(){
		super();
	}
	
	
	
	@BeforeMethod
	public void setup(){
		intialization();
		 loginpg = new Loginpage();
	}
	
	
	@Test(priority=1)
	public void loginpagetitle(){
	String title = loginpg.validatetitle();
	Assert.assertEquals(title, "Sign-on: Mercury Tours");
	
	
	}
	
	@Test(priority=2)
	public void Logoimgtest(){
	boolean flag =	loginpg.validateimg();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void logintest(){
		ffpg=loginpg.login(prop.getProperty("username"),prop.getProperty("password"));
		
		
	}
	
	
	@AfterMethod
	public void closing(){
		driver.close();
	}
	
}
