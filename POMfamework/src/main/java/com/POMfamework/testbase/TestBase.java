package com.POMfamework.testbase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.POMfamework.helper.Utils.ExtentManager;
import com.POMfamework.helper.browserConfiguration.BrowserType;
import com.POMfamework.helper.browserConfiguration.ChromeBrowser;
import com.POMfamework.helper.browserConfiguration.FirefoxBrowser;
import com.POMfamework.helper.browserConfiguration.IEBrowser;
import com.POMfamework.helper.browserConfiguration.config.PropertyReader;
import com.POMfamework.helper.browserConfiguration.config.objectreader;
import com.POMfamework.helper.logger.LoggerHelper;
import com.POMfamework.helper.wait.WaitHelper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;




public class TestBase 
{
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	private  Logger log = LoggerHelper.GetLogger(TestBase.class);
	public static File  reportDirectery;
			
			
			
			
			
	
	@ BeforeSuite
	public void Beforesuite()
	{
		 extent = ExtentManager.getInstance();
	}
	@BeforeTest
	public void Beforetest() throws Exception
	{
		objectreader.reader = new PropertyReader();
		 reportDirectery = new File("G:\\Javaprogramming\\uiframework\\Screenshots");
		 SetUpTheDriver(objectreader.reader.getBrowserType());
		
	}
	
	@ BeforeTest
	public void BeforeAnyClass()
	{
		System.out.println(extent.toString());
	String temp="testLogin";
			ExtentTest check = extent.createTest(temp);
	test = check;
	
		
		
		
	}
	@BeforeMethod
	public void beforeMethod(Method method)
	{
		test.log(Status.INFO, method.getName()+ "test started");
		
	}
	
	@AfterMethod
	public void AfterMethod(ITestResult result)throws IOException
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getThrowable());
			test.log(Status.FAIL,result.getThrowable());
			
		}
		else if (result.getStatus()== ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getTestName() +"is passed");
			
		}
		else if (result.getStatus()== ITestResult.SKIP)
		{
			test.log(Status.SKIP, result.getThrowable());
			
		}
		extent.flush();
		log.info("**************"+result.getName()+"Finished***************");
		}
	
	public WebDriver BrowserObject(BrowserType btype)
	
	{
		
		try
		{
			switch(btype)
			{
			case Chrome:
				// get object of ChromeBrowser class
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				ChromeOptions optionc = chrome.getChromeOptions();
				return chrome.getChromeDriver(optionc);
			case Firefox:
				FirefoxBrowser firefox =  FirefoxBrowser.class.newInstance();
				FirefoxOptions optionf = firefox.FirefoxOptions();
				return firefox.getFirefoxDriver(optionf);
			case IEexplorer:
				IEBrowser InternetExplorer = IEBrowser.class.newInstance();
				InternetExplorerOptions optionie = InternetExplorer.getIExplorerCapabilities();
				InternetExplorer.getIExplorerDriver(optionie);
				default:
					throw new Exception("Driver not found"+ btype.name());
				
			
			}
			
				
				
			
		}
		catch(Exception e)
		{
			log.info(e.getMessage());
			
			
		}
		return driver;
	}
	
	public void SetUpTheDriver(BrowserType btype) throws Exception
	{
		driver = BrowserObject(btype);
		log.info("initalized webdriver" + driver.hashCode());
		WaitHelper wait = new WaitHelper(driver);
		wait.PageLoad(objectreader.reader.getPageLoadTimeout(), TimeUnit.SECONDS);
		wait.SetImplicitWait(objectreader.reader.getImplicitWait(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	public String Capturescreen(String filename)
	{
		if(driver== null)
		{
			log.info("diver is null");
			return null;
			
		}
		if(filename=="")
		{
			filename = "blank";	
		}
		String desfile = null;
		String path = "\\src\\main\\resources"+"/screenshots/";
		
		 Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat(("dd_mm_yyyy_hh_mm_ss"));
		
		 File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try
		{
			 desfile = ResourceHelper.getResourcePath(path)+ filename + "_" + formater.format(calendar.getTime()) + ".png";
			 File finalDestination = new File(desfile);
			 try 
				{
				FileUtils.copyFile(source,finalDestination );
				}
				catch (IOException e) 
				{
					System.out.println("Exception are" + e.getMessage());
					e.printStackTrace();
				}
			log.info("screenshot copied");
			// This will help us to link the screen shot in testNG report the Reporter class will be used
			Reporter.log("<a href='"+finalDestination.getAbsolutePath()+"'><img src='"+finalDestination.getAbsolutePath()+"'height='100' width='100'/></a>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return desfile.toString();
		
		
				
	}
	
	public  String getScreenshot(WebDriver driver, String screenshotName) throws Exception 
	{
        //below line is just to append the date format with the screenshot name to avoid duplicate names 
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    formatter = new SimpleDateFormat("dd,MM,yyyy"); 
    String dateName = new SimpleDateFormat("dd,MM,yyyy").format(new Date());
   //     String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
TakesScreenshot ts = (TakesScreenshot) driver;
File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
Calendar calendar = Calendar.getInstance();
SimpleDateFormat formater = new SimpleDateFormat(("dd_mm_yyyy_hh_mm_ss"));
String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName + "_" + formater.format(calendar.getTime()) + ".png";
File finalDestination = new File(destination);
FileUtils.copyFile(source, finalDestination);
try
{
	// This will help us to link the screen shot in testNG report the Reporter class will be used
				Reporter.log("<a href='"+finalDestination.getAbsolutePath()+"'><img src='"+finalDestination.getAbsolutePath()+"'height='100' width='100'/></a>");
			}
catch(Exception e)
{
	log.info(e.getMessage());
}
        //Returns the captured file path
return destination;
		
		
		
		
	}
	public  void navigatetoscreen(WebDriver driver) 
	{
		log.info("capturing ui navigation screen...");
		
		
		
		 
		
	}
}
	


