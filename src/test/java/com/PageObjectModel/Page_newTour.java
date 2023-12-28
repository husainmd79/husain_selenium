package com.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_newTour {
	WebDriver driver;
	public Page_newTour(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[normalize-space()='REGISTER']")
	WebElement reg;
	public void clickRegister()
	{
		reg.click();
	}
	@FindBy(name="firstName")
	WebElement first_name;
	public void setFirstName(String name)
	{
		first_name.sendKeys(name);
	}
	@FindBy(name="lastName")
	WebElement lastName;
	public void setLastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	@FindBy(name="city")
	WebElement myCity;
	public void setCity(String ct)
	{
		myCity.sendKeys(ct);
	}
	

}
