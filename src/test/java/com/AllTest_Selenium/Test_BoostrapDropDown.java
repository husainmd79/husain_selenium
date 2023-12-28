package com.AllTest_Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_BoostrapDropDown {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://jqueryui.com/controlgroup/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	@Test
	public void dropDown_Test()
	{
		String value="Van";
		WebElement fm=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(fm);
		WebElement drp=driver.findElement(By.id("car-type-button"));
		drp.click();
		List<WebElement>Options=driver.findElements(By.xpath("//ul[@id='car-type-menu']/li"));
		for(WebElement option:Options)
		{
			if(option.getText().equals(value))
			{
				option.click();
				break;
			}
		}
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

}
