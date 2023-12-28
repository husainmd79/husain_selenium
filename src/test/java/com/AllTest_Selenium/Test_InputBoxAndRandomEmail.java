package com.AllTest_Selenium;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_InputBoxAndRandomEmail {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test(priority=2)
	public void testRandomEmail()
	{
		driver.findElement(By.xpath("//a[normalize-space()='REGISTER']")).click();
		driver.findElement(By.name("firstName")).sendKeys("sabrina");
		
		WebElement email=driver.findElement(By.id("userName"));
		RandomStringUtils ram=new RandomStringUtils();
		String randomEmail=ram.randomAlphabetic(8)+"@gmil.com";
		email.sendKeys(randomEmail);
	}
	@Test(priority=1)
	public void randomNumber() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[normalize-space()='REGISTER']")).click();
		WebElement number=driver.findElement(By.name("phone"));
		RandomStringUtils random=new 	RandomStringUtils();
		String numaric=random.randomAlphanumeric(10);
		number.sendKeys(numaric);
		Thread.sleep(5000);
	}
	@Test(priority=3)
	public void randomCity()
	{
		driver.findElement(By.xpath("//a[normalize-space()='REGISTER']")).click();
		WebElement mycity=driver.findElement(By.name("city"));
		String city=generatRandomEmil()+"mycity";
		mycity.sendKeys(city);
		
	}
	public static String generatRandomEmil()
	{
		RandomStringUtils randomString=new RandomStringUtils();
		String random_emil=randomString.randomAlphabetic(10);
		return random_emil;
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

}














