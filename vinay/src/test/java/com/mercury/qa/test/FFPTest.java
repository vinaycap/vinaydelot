package com.mercury.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.FFPage;
import com.mercury.qa.pages.Loginpage;

public class FFPTest extends TestBase{

	Loginpage loginpg;
	FFPage ffpg;
	FFPTest(){
		super();
	}
	
	@BeforeMethod
	public void setupinFFPg(){
		intialization();
		loginpg = new Loginpage();
		ffpg=loginpg.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void FFPageTesting(){
		ffpg.NumofPassengers();
		ffpg.continuefromFlightFinder();
		//ffpg.sigingoff();
	}
	
	
	@AfterMethod
	public void closing(){
		//driver.quit();
	}
}
