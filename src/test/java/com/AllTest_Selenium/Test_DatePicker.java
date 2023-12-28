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

public class Test_DatePicker {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://www.Expedia.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
	}
	@Test
	public void testDate()
	{
		String monthYear="June 2024";
		String day="25";
		driver.findElement(By.name("EGDSDateRange-date-selector-trigger")).click();
		while(true)
		{
			String MY=driver.findElement(By.xpath("//span[@class='uitk-align-center uitk-month-label']")).getText();
			if(MY.equals(monthYear))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("(//button[@class='uitk-button uitk-button-medium uitk-button-only-icon uitk-button-paging'])[2]"))
				.click();
			}
				
			
		}
		List<WebElement>allDate=driver.findElements(By.xpath("(//table)[1][@class='uitk-month-table']/tbody/tr/td/div"));
		for(WebElement date:allDate)
		{
			if(date.getText().equals(day))
			{
				date.click();
			}
		}
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}


}







