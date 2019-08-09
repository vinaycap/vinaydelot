package com.mercury.qa.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class newclass {
	WebDriver driver;
//	 public static HSSFWorkbook workbook;
//	    public static HSSFSheet worksheet;
//	    public static DataFormatter formatter= new DataFormatter();
//	    public static String file_location = System.getProperty("D:\\example.xlsx");
//	    static String SheetName= "Sheet1";

	@BeforeMethod
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "D:\\NEW DOWNLOA\\chromedriver.exe");
		driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
	
	}
	
//	@DataProvider
//public static Object[][] ReadVariant() throws IOException{
//	 FileInputStream fileInputStream= new FileInputStream(file_location); 
//     workbook = new HSSFWorkbook (fileInputStream); 
//     worksheet=workbook.getSheet(SheetName);
//     HSSFRow Row=worksheet.getRow(0);
//     int RowNum = worksheet.getPhysicalNumberOfRows();
//     int ColNum= Row.getLastCellNum();
//     Object Data[][]= new Object[RowNum-1][ColNum];
//     for(int i=0; i<RowNum-1; i++) 
//     {  
//         HSSFRow row= worksheet.getRow(i+1);
//         for (int j=0; j<ColNum; j++)
//         {
//        	 if(row==null)
//                 Data[i][j]= "";
//             else
//             {
//            	 HSSFCell cell= row.getCell(j);
//                 if(cell==null)
//                     Data[i][j]= ""; 
//                 else
//                 {
//                     String value=formatter.formatCellValue(cell);
//                     Data[i][j]=value; 
//                 }
//             }
//         }
//     }
//     return Data;
//}
	
	@Test 
//	(dataProvider="ReadVariant")
	public void intiali(){
		//System.out.println(firstname);
		driver.findElement(By.name("first_name")).sendKeys("firstname");
		driver.findElement(By.name("last_name")).sendKeys("lastname");
	}
}
