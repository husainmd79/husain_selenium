package com.AllTest_Selenium;

import java.io.File;
import java.io.IOException;

import javax.swing.text.AbstractDocument;
import javax.swing.text.Document;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_JavascriptExecutor {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://www.twoplugs.com");
		driver.manage().window().maximize();
		
	}
	@Test
	public void DrawBorderByJs() throws IOException
	{
		WebElement about=driver.findElement(By.xpath("//a[normalize-space()='About']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='5px solid red';", about);
		
		File src=about.getScreenshotAs(OutputType.FILE);
		File f=new File(".\\screenShot\\about.png");
		FileUtils.copyFile(src, f);
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	@Test
	public void clickElementByJs()
	{
		WebElement loginButton=driver.findElement(By.xpath("//a[normalize-space()='Contact']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",loginButton);
	}
	@Test
	public void getTitleByJs()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String v=(String)js.executeScript("return document.title;".toString());
		System.out.println("this is title of the Page:  "+v);
	}
	@Test
	public void scrollPageDown() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		//Thread.sleep(3000);
	}
	@Test
	public void scrollDownPage()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHieght);");
	}
	@Test
	public void refreshByJs()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	

}




























