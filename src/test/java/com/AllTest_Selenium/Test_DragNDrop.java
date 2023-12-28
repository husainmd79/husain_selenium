package com.AllTest_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_DragNDrop {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
	}
	@Test 
	public void dragAndDrop()
	{
		WebElement copen=driver.findElement(By.id("box4"));
		WebElement den=driver.findElement(By.id("box104"));
		Actions act=new Actions(driver);
		act.dragAndDrop(copen, den).build().perform();
		//act.clickAndHold(copen).moveToElement(den).release().build().perform();
		
		WebElement olse=driver.findElement(By.id("box3"));
		WebElement swe=driver.findElement(By.id("box103"));
		act.dragAndDrop(olse, swe).perform();
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

}
