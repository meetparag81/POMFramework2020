package com.POMfamework.helper.browserConfiguration.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.POIXMLProperties;

import com.POMfamework.helper.logger.LoggerHelper;
import com.POMfamework.helper.resource.ResourceHelper;
import com.POMfamework.helper.browserConfiguration.BrowserType;
import com.POMfamework.helper.browserConfiguration.config.ConfigReader;



public class PropertyReader implements ConfigReader 
{
	Logger log= LoggerHelper.GetLogger(PropertyReader.class);
	private static FileInputStream fis;
	public static Properties prop;
	
	public PropertyReader()  
	{
		String filepath = ResourceHelper.GetResourcePath("\\src\\main\\resources\\configfile\\config.properties");
			 try 
			 {
			 fis = new FileInputStream(new File(filepath));
			 prop = new Properties();
			prop.load(fis);
			} 
		 	catch(Exception e)
			 {
				 e.getMessage();
			 }
			 
		 
		
	}
	

	public int getImplicitWait() 
	{
		
		return	Integer.parseInt(prop.getProperty("implicitwait"));	
		
		
		
		
	}

	public int getexplicitWait() 
	{
		
		
		return Integer.parseInt(prop.getProperty("Explicitwait"));	
		
	}

	public int getPageLoadTimeout() 
	{
		
		
			return Integer.parseInt(prop.getProperty("pageloadtime"));	
	
	} 

	


	public BrowserType getBrowserType() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
