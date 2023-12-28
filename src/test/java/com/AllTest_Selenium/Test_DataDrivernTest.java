package com.AllTest_Selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utilityFile.XLData;

public class Test_DataDrivernTest {               
	WebDriver driver;                          
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				
	}
	@Test(dataProvider="n")
	
	public void Register_Test(String First_name,String Last_name, String city)
	{
		WebElement reg=driver.findElement(By.xpath("//a[normalize-space()='REGISTER']"));
		reg.click();
		WebElement name=driver.findElement(By.name("firstName"));
		name.sendKeys(First_name);
		WebElement lname=driver.findElement(By.name("lastName"));
		lname.sendKeys(Last_name);
		WebElement ci=driver.findElement(By.name("city"));
		ci.sendKeys(city);
		 
	}
	@DataProvider(name="n")
	public Object [][] getData() throws IOException
	{
		String path=".\\ExcelFile\\newTourData.xlsx";
		XLData d=new XLData(path);
		int totalRow=d.getRowCount("Sheet1");
		int totalCell=d.getCellCount("Sheet1", totalRow);
		Object data[][]=new Object[totalRow][totalCell];
		for(int i=1;i<=totalRow; i++)
		{
			for(int j=0; j<totalCell; j++)
			{
				data[i-1][j]=d.getCellData("Sheet1", i, j);
			}
		}
		return data;
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	

}






















