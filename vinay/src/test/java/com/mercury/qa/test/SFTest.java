package com.mercury.qa.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.FFPage;
import com.mercury.qa.pages.Loginpage;
import com.mercury.qa.utill.Exceldata;
import com.mercury.qa.utill.ScreenShot;

import junit.framework.Assert;

public class SFTest extends TestBase{
	Loginpage loginpg;
	FFPage ffpg;
	SFTest(){
		super();
	}
	
	@BeforeClass
	public void setupinFFPg(){
		intialization();
		loginpg = new Loginpage();
		ffpg=loginpg.login(prop.getProperty("username"),prop.getProperty("password"));
//		ffpg.NumofPassengers();
//		ffpg.continuefromFlightFinder();
		//driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/p/input")).click();
	}
	@Test(priority=1)
	public void FFPageTesting(){
		ffpg.NumofPassengers();
		ffpg.continuefromFlightFinder();
		//ffpg.sigingoff();
	}
	@DataProvider
	public void getDatafromExcel() throws IOException{
		Exceldata.getDatafromExcel();
	}
		
	
	
	@Test(priority=2)
	public void continueonSFTPG(){
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/p/input")).click();
		
	//	Assert.assertTrue(false);
	}
	
//	@DataProvider
//	public void getDatafromExcel() throws IOException{
//		Exceldata.getDatafromExcel();
//		
//	}
	
	
	//dataProvider="getDatafromExcel", priority=3
	//String firstname,String secondname,String creditnum

	@Test()
	public void BookAFlightPage(){
	//driver.findElement(By.xpath("//input[@name='passFirst0']")).clear();
	//driver.findElement(By.name("passFirst0")).sendKeys("firstname");
//	
//	driver.findElement(By.xpath("//input[@name='passLast0']")).clear();
//	driver.findElement(By.xpath("//input[@name='passLast0']")).sendKeys(secondname);
//	
//	driver.findElement(By.xpath("//input[@name='creditnumber']")).clear();
//	driver.findElement(By.xpath("//input[@name='creditnumber']")).sendKeys(creditnum);
//	
	driver.findElement(By.xpath("//input[@name='buyFlights']")).click();

	}
	
	

	@AfterMethod
	public void RoTM(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus()){
			ScreenShot.captureScreenshot(driver, "continueonSFTPG");
		}
	}
	
	
	
	@AfterClass
	public void closing(){
		//driver.quit();
	}
	
}
