package com.AllTest_Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_WebTable {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test
	public void handle_WebTable() throws InterruptedException
	{
		WebElement frame1=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.id("datepicker")).click();
		//Thread.sleep(5000);
		int numOfRow=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr")).size();
		System.out.println("number of row:  "+numOfRow);
		 
		int numOfColumn=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/thead/tr/th")).size();
		System.out.println("number of column:  "+numOfColumn);
		
		List<WebElement>allData=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for(WebElement data:allData)
		{
			String d=data.getText();
			System.out.println(d);
		}
		
		
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

}
