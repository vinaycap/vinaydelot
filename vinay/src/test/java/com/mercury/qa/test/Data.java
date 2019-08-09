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

public class Data {
	 public static HSSFWorkbook workbook;
	    public static HSSFSheet worksheet;
	    public static DataFormatter formatter= new DataFormatter();
	    public static String file_location = System.getProperty("D:\\example.xlsx");
	    static String SheetName= "Sheet1";
	
WebDriver driver;
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

@DataProvider
public Object[][] getExcelData() throws IOException {
	
	
		 FileInputStream fileInputStream= new FileInputStream(file_location); //Excel sheet file location get mentioned here
	        workbook = new HSSFWorkbook (fileInputStream); //get my workbook 
	        worksheet=workbook.getSheet(SheetName);// get my sheet from workbook
	        HSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0   
	     
	        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
	        int ColNum= Row.getLastCellNum(); // get last ColNum 
	         
	        Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
	         
	            for(int i=0; i<RowNum-1; i++) //Loop work for Rows
	            {  
	                HSSFRow row= worksheet.getRow(i+1);
	                 
	                for (int j=0; j<ColNum; j++) //Loop work for colNum
	                {
	                    if(row==null)
	                        Data[i][j]= "";
	                    else
	                    {
	                        HSSFCell cell= row.getCell(j);
	                        if(cell==null)
	                            Data[i][j]= ""; //if it get Null value it pass no data 
	                        else
	                        {
	                            String value=formatter.formatCellValue(cell);
	                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
	                        }
	                    }
	                }
	            }
	 
	        return Data;
	    }


	@Test(dataProvider="getExcelData")
	public void intiali(String firstname,String lastname){
		driver.findElement(By.name("first_name")).sendKeys(firstname);
		driver.findElement(By.name("last_name")).sendKeys(lastname);
	}
	
}
