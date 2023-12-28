package com.AllTest_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_AlertWithOk {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	@Test
	public void alert_With_Ok()
	{
		driver.findElement(By.xpath("//a[normalize-space()='SwitchTo']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Alerts']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']"))
		.click();
		Alert a=driver.switchTo().alert();
				a.sendKeys("Welcome to Alert Box");
				a.accept();
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

}
