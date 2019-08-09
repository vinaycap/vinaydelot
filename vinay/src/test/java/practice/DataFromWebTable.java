package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataFromWebTable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\NEW DOWNLOA\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://www.toolsqa.com/automation-practice-table/");
	 int rowcount= driver.findElements(By.xpath("//*[@id='content']/table/tbody/tr")).size();
	 int columncount=driver.findElements(By.xpath("//*[@id='content']/table/tbody/tr[1]/td")).size();
	for(int i=1;i<rowcount;i++){
		for(int j=1;j<columncount;j++){
			String value= driver.findElement(By.xpath("//*[@id='content']/table/tbody/tr["+i+"]/td["+j+"]")).getText();
			System.out.print(value+" ");
		}
		 System.out.println("");
		 
		 System.out.println("");
		
	}
	 
	
	

	}

}
