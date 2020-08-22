package com.POMfamework.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.POMfamework.helper.resource.ResourceHelper;

public class ChromeBrowser 
{
	
	public ChromeOptions getChromeOptions()
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--test-type");
		option.addArguments("--disable-popup-blocking");
		new DesiredCapabilities();
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		option.setCapability(ChromeOptions.CAPABILITY, chrome);
		if(System.getProperty("osname").contains("Linux"))
				{
				option.addArguments("--hedless","window-size=1024,768","--nosandbox" );
				}
		
 		return option;
 		
	}
	public WebDriver getChromeDriver(ChromeOptions cap)
		{
		if(System.getProperty("osname").contains("Mac"))
		{
			System.setProperty("webdriver.chrome.driver", ResourceHelper.GetResourcePath("\\src\\main\\resorces\\divers\\chromedriver"));
			return new ChromeDriver(cap);
		}
		else if (System.getProperty("osname").contains("window")) {
			
			System.setProperty("webdriver.chrome.driver", ResourceHelper.GetResourcePath("\\src\\main\\resorces\\divers\\chromedriver.exe"));
			return new ChromeDriver(cap);
		}
		else if (System.getProperty("osname").contains("Linux")) {
			System.setProperty("webdriver.chrome.driver", "/user/bin/chrome");
			return new ChromeDriver(cap);
		}
			
		return null;
			
		}

}
