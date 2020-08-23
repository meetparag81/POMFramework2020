package com.POMfamework.helper.browserConfiguration.config;

import uiframework.uiframework.Paragcom.freecrm.helper.BrowserConfiguration.BrowserType;

public interface ConfigReader 
{
	
	public int getImplicitWait();
	public int getexplicitWait();
	public int getPageLoadTimeout();
	public  void getBrowserType();

}
