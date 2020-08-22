package com.POMfamework.helper.select;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.POMfamework.helper.logger.LoggerHelper;

public class dropDownHelper 
{
	private WebDriver driver;
	private static  Logger log = LoggerHelper.GetLogger(dropDownHelper.class);

	public dropDownHelper(WebDriver driver)
	{
		this.driver= driver;
		log.info("dropDownHelper object is created");
	}
	
	
	public void selectByUsigValue(WebElement ele, String value)
	{
		Select sel = new Select(ele);
		log.info("selectByUsigValue and value is:" + value);
		sel.selectByValue(value);
	}
	
	public void selectByUsigIndex(WebElement ele, int index)
	{
		Select sel = new Select(ele);
		log.info("selectByUsigIndex and index is:" + index);
		sel.selectByIndex(index);
	}
	
	public void selectByUsigVisibleText(WebElement ele,String text)
	{
		Select sel = new Select(ele);
		log.info("selectByUsigVisibleText and text is:" + text);
		sel.selectByVisibleText(text);
	}
	public void deselectByUsigVisibleText(WebElement ele,String text)
	{
		Select sel = new Select(ele);
		log.info("DeselectByUsigVisibleText and text is:" + text);
		sel.deselectByVisibleText(text);
	}
	public void deselectByUsigIndex(WebElement ele, int index)
	{
		Select sel = new Select(ele);
		log.info("DeselectByUsigIndex and index is:" + index);
		sel.deselectByIndex(index);
	}
	public void deselectByUsigValue(WebElement ele, String value)
	{
		Select sel = new Select(ele);
		log.info("DeselectByUsigValue and value is:" + value);
		sel.deselectByValue(value);
	}
	public List<String> getAllDropDownOptions(WebElement ele)
	{
		Select sel = new Select(ele);
		
		List<WebElement>elementlists= sel.getOptions();
		List<String> valuelist = new LinkedList<String>();
		for (WebElement ele1:elementlists)
		{
			log.info(ele1.getText());
			valuelist.add(ele1.getText());
		}
		return valuelist;
	}
}
