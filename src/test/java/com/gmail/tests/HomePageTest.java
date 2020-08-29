package com.gmail.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.util.TestUtil;
import com.gmail.pages.AcademicsPage;
import com.gmail.pages.HomePage;
import com.gmail.pages.SigninPage;

public class HomePageTest extends TestUtil{
	
	SigninPage signin;
	AcademicsPage aca1;
	Logger log1 = Logger.getLogger(HomePageTest.class);
	//---- call he superclass constructor--------//
	public HomePageTest()
	{
		super();
	}
	//---Setup for the test---//
	@BeforeMethod
	public void setup()
	{
		OpenURL();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		signin = new SigninPage();
	}
	//--- test case-----//
	@Test
	public void NavigateAcademics() throws InterruptedException
	{
		HomePage home1=signin.login();
		home1.Search();
	}
	//-------Close session--------------//
	@AfterMethod
	public void closebrowser()
	{
		driver.close();
	}
	//----------------Other TESTNG Annotations--------------------------//
	/*-------Prioritize and Grouping-------//

	@Test(priority=1,groups="Books")
	@Test(priority=1,groups="Sprots")
	
	//-----Dependency on other Testcases---//
	
	@Test(dependsOnMethods="Logintoapp") ----When the Parent Test Fails,the dependent method will be skipped
	
	//------Test case to be executed Multiple times-----//
	 @Test(invocationCount=10) ----Executes the Test case 10 times
	 
	 @Test(invocationTimeOut=3000) ----------- Waits for 3 seconds ,if the testcase is not invoked in 3 secs, it fails te Testcase)
	 
	 // If an exception is expected on a page but we have to continue the execution //
	  
	  @Test(ExpectedExceptions=NumberformatException.class)
	 //----Data Provider --------// 
	  @DataProvider
	  public string dataprovidermethod()
	  {
	  }
	  @Test(DataProvider="dataprovidermethod")
	  public void methodname(datatype returned by dataprovider method)
	  {
	  }
	  //---------Ignore atest case------------//
	   
	   @Test(enabled=false)
	  
	  or inside tesng.xml 
	  
	  <classes>  
  	<class name="classname">  
  	<methods>  
  	<exclude name = "methodname"/>  
  	</methods>  
  	</class>  
  	</classes>  >
	  
	  
	 */
}
