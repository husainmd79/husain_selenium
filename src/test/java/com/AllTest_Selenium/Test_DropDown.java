package com.AllTest_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_DropDown {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://www.twoplugs.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	@Test
	public void dropDown_test()
	{
		String value="Automobile";
				
		driver.findElement(By.xpath("//a[normalize-space()='Live Posting']")).click();
		WebElement drp=driver.findElement(By.name("category_id"));
		Select se=new Select(drp);
		se.selectByVisibleText(value);
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

}
