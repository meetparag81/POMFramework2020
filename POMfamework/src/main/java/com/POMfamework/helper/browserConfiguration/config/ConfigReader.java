package com.POMfamework.helper.browserConfiguration.config;

import com.POMfamework.helper.browserConfiguration.BrowserType;

public interface ConfigReader 
{
	
	public int getImplicitWait();
	public int getexplicitWait();
	public int getPageLoadTimeout();
	public  BrowserType getBrowserType();

}
