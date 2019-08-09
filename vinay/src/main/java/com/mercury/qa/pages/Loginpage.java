package com.mercury.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercury.qa.base.TestBase;


public class Loginpage extends TestBase {

	//Pafe Foctory
	
		@FindBy(name="userName")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(name="login")
		WebElement submit;
		
		@FindBy(xpath="/html/body/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/p[1]/img")
		WebElement img;
		//intializing page elements
		public Loginpage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		public String validatetitle(){
			return driver.getTitle();
		}
		
		public boolean validateimg(){
		return img.isDisplayed();
		}
		
		public FFPage login(String un,String pd){
			username.sendKeys(un);
			password.sendKeys(pd);
			submit.click();
			return new FFPage();
		}

	
	
}
