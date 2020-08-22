package com.POMfamework.helper.javascript;


import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.POMfamework.helper.logger.LoggerHelper;



public class JavaScriptHelper 
{
	private WebDriver driver;
	private Logger log= LoggerHelper.GetLogger(JavaScriptHelper.class)	;
public JavaScriptHelper(WebDriver driver)
{
	this.driver= driver;
	log.info("JavaScriptHelper has been initalized");
}

public Object executeScript(String script)
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	return js.executeScript(script);
}

public Object executeScript(String script,Object...args)
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	return js.executeScript(script, args);
}

public void scrollToElement(WebElement element)
{
	log.info("Scroll to WebElement" );
	executeScript("window.scrollTo(argument[0],argument[1]",element.getLocation().x,element.getLocation().y );
}
public void scrollToElementAndClick(WebElement element)
{
	
	scrollToElement(element);
	element.click();
	log.info("Scroll to WebElement and"+ element.toString()+ "isclick" );
}
public void scrollInToView(WebElement element)
{
	log.info("Scroll to WebElement" );
	executeScript("window.scrollTo(argument[0],argument[1]",element);
}

public void scrollInToViewAndClick(WebElement element)
{
	log.info("Scroll to WebElement");
	scrollInToView(element);
	element.click();
	log.info("Scroll into view and"+ element.toString()+ "isclick" );
}

public void scrollDownvertically(WebElement element)
{
	log.info("Scrolling verticallydown");
	executeScript("window.scrollTo(o,document.body.scroolHeight)");
	log.info("Scrolling verticallydown");log.info("Scrolling verticallydown");
}

public void scrollUpvertically(WebElement element)
{
	log.info("Scrolling verticallyup");
	executeScript("window.scrollT(o,-document.body.scroolHeight)");
	
}

public void scrollDownByPixcel(int pixcel)
{
	log.info("Scrolling down");
	executeScript("window.scrollBy(0,"+ pixcel+")");
	
}

public void scrollUpByPixcel(int pixcel)
{
	log.info("Scrolling up");
	executeScript("window.scrollBy(0,-"+ pixcel+")");
	
}
public void clickTheElement(WebElement element)
{
	log.info("Scrolling verticallyup");
	executeScript("arguments[0].click();",element);
	
}
	
	


}
