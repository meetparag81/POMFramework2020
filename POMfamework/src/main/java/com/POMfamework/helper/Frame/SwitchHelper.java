package com.POMfamework.helper.Frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.POMfamework.helper.logger.LoggerHelper;

public class SwitchHelper 
{
	private WebDriver driver;
private Logger log = LoggerHelper.GetLogger(SwitchHelper.class)	;
	
public SwitchHelper(WebDriver driver)
{
	this.driver=driver;
	log.info("SwitchHelper has been initalized");
}

/**
 * This method will SwitchToFrame based on index
 * 
 * @param unit
 */
		
		

public void SwitchToFrame(int index)
{
	driver.switchTo().frame(index);
	log.info("Sitch to:"+ index+ "framme");
}

/**
 * This method will SwitchToFrame based on framename
 * 
 * @param unit
 */


public void SwitchToFrame(String  FrameName)
{
	driver.switchTo().frame(FrameName);
	log.info("Sitch to:"+ FrameName+ "framme");
}


/**
 * This method will SwitchToFrame based on webelement
 * 
 * @param unit
 */

public void SwitchToFrame(WebElement  frameelement)
{
	driver.switchTo().frame(frameelement);
	log.info("Sitch to:"+ frameelement+ "framme");
}



}
