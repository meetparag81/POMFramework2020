package com.POMfamework.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.DesiredCapabilities;

import uiframework.uiframework.Paragcom.freecrm.helper.resource.ResourceHelper;

public class IEBrowser 
{
public InternetExplorerOptions getIExplorerCapabilities() 
{
		
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		
		cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR,ElementScrollBehavior.BOTTOM);
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		cap.setJavascriptEnabled(true);
		
		InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions(cap);
		
		return internetExplorerOptions;
	}
	
	public WebDriver getIExplorerDriver(InternetExplorerOptions cap) 
	{
		System.setProperty("webdriver.ie.driver", ResourceHelper.getResourcePath("\\src\\main\\resources\\IEDriverServer.exe"));
		return new InternetExplorerDriver(cap);
	}
	
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.ie.driver", ResourceHelper.getResourcePath("\\src\\main\\resources\\IEDriverServer.exe"));
		WebDriver driver  = new InternetExplorerDriver();
		
		driver.get("https://www.zomato.com/bangalore/punjabi-nawabi-hsr/order/LoqDdXx");
		
	}
	

}
