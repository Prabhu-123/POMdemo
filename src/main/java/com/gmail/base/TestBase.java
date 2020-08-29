package com.gmail.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.crm.util.TestUtil;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;

	
	public TestBase()
	{
		
		try{
			prop =new Properties();
			FileInputStream f1=new FileInputStream("F:\\STUDY\\New_WorkSpace\\POMdemotest\\src\\main\\java\\com\\gmail\\config\\config.properties");
			prop.load(f1);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void OpenURL()
	{
		//-----Initalize the browser sequence------//
		
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","F:\\STUDY\\New_WorkSpace\\POMdemotest\\Driver\\chromedriver.exe");
			ChromeOptions cr1 = new ChromeOptions();
			cr1.addArguments("--incognito");
			cr1.setAcceptInsecureCerts(true);

			driver = new ChromeDriver(cr1);
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","F:\\STUDY\\New_WorkSpace\\POMdemotest\\Driver\\geckodriver.exe");
			FirefoxProfile f1 = new FirefoxProfile();
			f1.setAcceptUntrustedCertificates(true);
			f1.setAssumeUntrustedCertificateIssuer(false);
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit, TimeUnit.SECONDS);
		
		//--------------Naviagate to the URL------------//
		
		driver.get(prop.getProperty("URL"));
	}
	
}
