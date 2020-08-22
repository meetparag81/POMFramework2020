package com.POMfamework.helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.POMfamework.helper.logger.LoggerHelper;

public class AlertHelper {
	private WebDriver driver;
	private long timeOutInSeconds = 30;
	private static Logger log = LoggerHelper.GetLogger(AlertHelper.class);
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

	public AlertHelper(WebDriver driver1) {
		this.driver = driver1;
		log.info("AlertHelper object is created");

	}

	public Alert getAlert() {
		log.info("AlertTest:" + driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}

	public void AcceptAlert() {
		getAlert().accept();
		log.info("Alert is accepted");

	}

	public void DismissAlert() 
	{
		getAlert().dismiss();
		log.info("Alert is dismssed");

	}

	public void AlertPresent() 
	{

		log.info("Alert is dismssed");

	}

	public String getAlertText() 
	{
		String text = getAlert().getText();
		log.info("String on Alerttext:" + text);
		return text;
	}
	public boolean isAlertPresent() 
	{
		try
		{
			getAlert();	
			return true;
		}
		catch(NoAlertPresentException e) 
		{
			log.info(e.getCause());
			return false;
		}
		
		
	}
	public void AcceptAlertifPresent()
	{
		if(isAlertPresent())
		{
			AcceptAlert();
		}
		else
		{
			log.info("Alert is not present...");
		}
	}
	
	public void AcceptPromptandAddText(String text)
	{
		if(isAlertPresent())
		{
			getAlert().sendKeys(text);
			AcceptAlert();
		}
		else
		{
			log.info("Alert is not present...");
		}
	}

}
