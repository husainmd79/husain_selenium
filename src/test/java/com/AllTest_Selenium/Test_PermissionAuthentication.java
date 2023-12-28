package com.AllTest_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_PermissionAuthentication {
	WebDriver driver;
	ChromeOptions option;
	@BeforeClass
	public void setUp()
	{
		option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver=new ChromeDriver(option);
		driver.get("https://redbus.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		;
	}
	@Test
	public void handleAuthentication()
	{
		driver.findElement(By.xpath("//span[normalize-space()='Date']")).click();
	}
	@AfterClass
	public void teardown()
	{
		driver.close();
	}

}
