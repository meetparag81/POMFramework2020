package com.POMfamework.helper.window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.POMfamework.helper.Frame.SwitchHelper;
import com.POMfamework.helper.logger.LoggerHelper;

public class WindowHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.GetLogger(SwitchHelper.class);

	public WindowHelper(WebDriver driver)
	{
		this.driver = driver;
	}
	/**
	 * This method will SwitchToParent window
	 * 
	 * @param unit
	 */

	public void SeichToParntWindow() 
	{
		log.info("Switching to Parent window");
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will SwitchTo child window based on index
	 * 
	 * @param unit
	 */

	public void SeichToWindow(int index)
	{
		log.info("Switching to Parent window");
		Set<String> windows = driver.getWindowHandles();
		int i = 1;
		for (String window : windows) 
		{
			if (i == index) 
			{
				log.info("switched to window:"+index);
				driver.switchTo().window(window);
			} else 
			{
				i++;
			}

		}
	}
	/**
	 * This method will SwitchTo main window and close all child windows
	 * 
	 * @param unit
	 */

	public void CloseAllWindowAndSwitchToMainWindow(int index) 
	{
		log.info("close all windows");
		
		Set<String> windows = driver.getWindowHandles();
		String parentwindow = driver.getWindowHandle();
		int i = 1;
		for (String window : windows) 
		{
			if (!window.equalsIgnoreCase(parentwindow)) 
			{
				driver.close();
			} 
			log.info("switched to main window");
			driver.switchTo().window(parentwindow);

		}

	}
	
	/**
	 * This method will do browser back navigation
	 * 
	 * @param unit
	 */

	
	public void NavigateBack()
	{
		log.info("navigating back");
		driver.navigate().back();
	}
	
	/**
	 * This method will do browser forward navigation
	 * 
	 * @param unit
	 */

	public void NavigateForward()
	{
		log.info("navigating forward");
		driver.navigate().forward();
	}

}
