package com.AllTest_Selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowHandel_Test {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
				
	}
	@Test
	public void window_Test() throws InterruptedException
	{
		WebElement userName=driver.findElement(By.name("username"));
		userName.clear();
		userName.sendKeys("admin");
		System.out.println("title of the Pagef:  "+driver.getWindowHandle());
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		Set<String>allWin=driver.getWindowHandles();
		for(String win:allWin)
		{
			String Title=driver.switchTo().window(win).getTitle();
			//System.out.println("all of Title: "+Title);
			if(Title.equals("OrangeHRM"))
			{
				driver.close();
			}
		}
		
		
		
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
