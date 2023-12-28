package com.AllTest_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandleAlert {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	@Test 
	public void testAlert() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[normalize-space()='SwitchTo']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='Alerts']")).click();
		//driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
		driver.findElement(By.xpath("//div[@id='OKTab']")).click();
		
		String text=driver.switchTo().alert().getText();
		System.out.println("this is text of alert: "+text);
		
		driver.switchTo().alert().accept();
		
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	

}
