package com.crm.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.gmail.base.TestBase;

public class TestUtil extends TestBase{
	
	public static int implicit =20;
	static Workbook book;
	static Sheet sh1;
	static String path = "C:\\Users\\PRABHU\\Desktop";
	public static void implicitwait()
	{
		
	}
	public void clickon(WebDriver driver,int Time,WebElement el1)
	{
		new WebDriverWait(driver,Time).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(el1));
		el1.click();
	}
	public void Mousemovement(WebElement Ele1)
	{
		Actions ac1= new Actions(driver);
		ac1.moveToElement(Ele1).build().perform();
	}
	public void VerifyTitle(String Title)
	{
		String page_title = driver.getTitle();
		Assert.assertEquals(page_title,Title); 
	}
	public void Actionenter(WebElement Ele1)
	{
		Actions ac1 = new Actions(driver);
		ac1.sendKeys(Ele1,Keys.ENTER);
	}
	public static Object[][] getdata(String Sheetname)
	{
		FileInputStream f1 =null;
		
		try {
			f1=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(f1);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sh1 =book.getSheet(Sheetname);
		Object[][] data = new Object[sh1.getLastRowNum()][sh1.getRow(0).getLastCellNum()];
		for(int i=0;i<sh1.getLastRowNum();i++)
			for(int j=0;j<sh1.getRow(0).getLastCellNum();i++)
			{
				data[i][j]=sh1.getRow(i+1).getCell(j);
			}
		return data;
	}
}
