package com.gmail.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.util.TestUtil;

public class SigninPage extends TestUtil{
	
	//---------Using Page Factory-----------//
	
	@FindBy(xpath="//input[@class='_2zrpKA _1dBPDZ']")
	WebElement username;
	@FindBy(xpath="//button[@type='submit' and @class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement Login_btn;
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	//------- Initializing the elements using Page factory------//
	public SigninPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//--------Page Library-----------//
	public HomePage login() throws InterruptedException
	{
		username.sendKeys(prop.getProperty("Username"));
		password.sendKeys(prop.getProperty("Password"));
		clickon(driver,10, Login_btn);
		Thread.sleep(5000);
		return new HomePage();
		
	}
	
}
