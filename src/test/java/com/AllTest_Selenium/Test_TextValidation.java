package com.AllTest_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_TextValidation {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	@Test
	public void textValidation()
	{
		String exp_logo=driver.findElement(By.xpath("//b[normalize-space()='Jul 6, 2017']")).getText();
		System.out.println("logo: "+exp_logo);
		String act_logo="Jul 6, 2017";

		//Assert.assertEquals(exp_logo, act_logo);
		if(exp_logo.equals(act_logo))
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
