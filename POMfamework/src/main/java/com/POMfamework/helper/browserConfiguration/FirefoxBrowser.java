package com.POMfamework.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.POMfamework.helper.resource.ResourceHelper;



public class FirefoxBrowser {
	
	public FirefoxOptions FirefoxOptions(){
		 DesiredCapabilities firefox = DesiredCapabilities.firefox();
	
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		
		
		
		firefox.setJavascriptEnabled(true);
		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("MARIONETTE", true);
		FirefoxOptions FirefoxOptions = new FirefoxOptions(firefox);
		if(System.getProperty("osname").contains("Linux"))
				{
				FirefoxOptions.addArguments("--hedless","window-size=1024,768","--nosandbox" );
				}
		
 		return FirefoxOptions;
	}
	
	
	public WebDriver getFirefoxDriver(FirefoxOptions optionf)
	{
	if(System.getProperty("osname").contains("Mac"))
	{
		System.setProperty("webdriver.gecko.driver", ResourceHelper.GetResourcePath("\\src\\main\\resorces\\divers\\chromedriver"));
		return new ChromeDriver(optionf);
	}
	else if (System.getProperty("osname").contains("window")) {
		
		System.setProperty("webdriver.gecko.driver", ResourceHelper.GetResourcePath("\\src\\main\\resorces\\divers\\chromedriver.exe"));
		return new ChromeDriver(optionf);
	}
	else if (System.getProperty("osname").contains("Linux")) {
		System.setProperty("webdriver.gecko.driver", "/user/bin/firefox");
		return new ChromeDriver(optionf);
	}
		
	return null;
		
	}

}
