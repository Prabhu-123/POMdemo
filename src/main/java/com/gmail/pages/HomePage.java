package com.gmail.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.util.TestUtil;

public class HomePage extends TestUtil{

	@FindBy(xpath="//ul[@class='_114Zhd']/li[7]")
	WebElement Others;
	
	@FindBy(xpath="//a[@title='Academics']")
	WebElement Academics;
	
	@FindBy(xpath="//a[@title='E-Learning']")
	WebElement E_Learning;
	
	@FindBy(xpath="//input[@type='text']")
	@CacheLookup
	WebElement Search_Box;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement search_icon;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public AcademicsPage gotoacademics()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		VerifyTitle("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Mousemovement(Others);
		clickon(driver, 10, Academics);
		return new AcademicsPage();
		
	}
	public ELearningPage gotoelearnig()
	{
		VerifyTitle("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		Mousemovement(Others);
		clickon(driver, 10, E_Learning);
		return new ELearningPage();
	}
	
	public AcademicsPage Search() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Search_Box.sendKeys("Academics");
		clickon(driver, 5, search_icon);
		return new AcademicsPage();
	}
	
}
