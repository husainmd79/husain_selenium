package com.AllTest_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_ActionClass {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	@Test
	public void mouseHoover()
	{
		
		
		WebElement desktop=driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		//admin.click();
		WebElement mac=driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		
		
		Actions act=new Actions(driver);
		//act.moveToElement(admin).click().build().perform();
		
		act.moveToElement(desktop).moveToElement(mac).click().perform();
		
	   String exp_value=driver.findElement(By.xpath("//span[normalize-space()='$122.00']")).getText();
	   String act_value="$122.00";
	   if(act_value.equals(exp_value))
	   {
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   Assert.assertTrue(false);
	   }
		
	}
	@AfterClass 
	public void tearDown()
	{
		driver.close();
	}

}
