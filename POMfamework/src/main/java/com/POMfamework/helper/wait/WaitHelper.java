package com.POMfamework.helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.POMfamework.helper.logger.LoggerHelper;

public class WaitHelper 
{
	private Logger log = LoggerHelper.GetLogger(WaitHelper.class);
	private WebDriver driver;

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This is Implicit wait
	 * 
	 * @param timeout
	 * @param unit
	 */
	public void SetImplicitWait(long timeout, TimeUnit unit)
	{
		log.info("SetImplicitWait has benn set to:" + timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);

	}

	/**
	 * This method will help to get webdriverwait object.
	 * 
	 * @param timeout
	 * @param unit
	 */
	private WebDriverWait GetExplicitWait(int timout, int pollingeveryMilliseconds) {
		WebDriverWait wait = new WebDriverWait(driver, timout);
		wait.pollingEvery(Duration.ofMillis(pollingeveryMilliseconds));
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;

	}

	/**
	 * This method will wait till element to be visible
	 * 
	 * @param timeout
	 * @param unit
	 */

	public void WaitForElementTobeVisiblewitPollingTime(WebElement element, int timeoutinseconds,
			int pollingeverymillisecond) {
		log.info("Waiting for" + element.toString() + "for" + timeoutinseconds);

		WebDriverWait wait = GetExplicitWait(timeoutinseconds, pollingeverymillisecond);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info(element.toString() + "is visible not");
	}

	/**
	 * This method will check till element to be clickable
	 * 
	 * @param timeout
	 * @param unit
	 */

	public void WaitForElementTobeClickable(WebElement element, int timeoutinseconds, int pollingeverymillisecond) {
		log.info("Waiting for" + element.toString() + "for" + timeoutinseconds);

		WebDriverWait wait = new WebDriverWait(driver, timeoutinseconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info(element.toString() + "is cliked not");
	}

	/**
	 * This method will check invisibilityOf element * @param timeout
	 * 
	 * @param unit
	 */

	public boolean WaitForElementNotPresent(WebElement element, int timeoutinseconds, int pollingeverymillisecond) {
		log.info("Waiting for" + element.toString() + "for" + timeoutinseconds);

		WebDriverWait wait = new WebDriverWait(driver, timeoutinseconds);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info(element.toString() + "is not visible now");
		return status;
	}

	/**
	 * This method will check frameToBeAvailableAndSwitchToIt Of element
	 * * @param timeout
	 * 
	 * @param unit
	 */

	public void WaitForframeToBeAvailableAndSwitchToIt(WebElement element, int timeoutinseconds,
			int pollingeverymillisecond) {
		log.info("Waiting for" + element.toString() + "for" + timeoutinseconds);

		WebDriverWait wait = new WebDriverWait(driver, timeoutinseconds);
		WebDriver status = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("Frame is available and switched to");

	}

	/**
	 * This method will give usFlentWait * @param timeout
	 * 
	 * @param unit
	 */

	public Wait<WebDriver> GetFluentWait(int timout, int pollingeveryMilliseconds) 
	{
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timout))
				.pollingEvery(Duration.ofMillis(pollingeveryMilliseconds)).ignoring(NoSuchElementException.class);
		return fwait;

	}
	public WebElement WaitforElementUsingFluentWait(WebElement element, int timout, int pollingeveryMilliseconds)
	{
		 Wait<WebDriver> fwait = GetFluentWait(timout, pollingeveryMilliseconds);
		  WebElement element1 = fwait.until(ExpectedConditions.visibilityOf(element));
		return element1;
	}
	
	public void PageLoad(long timeout, TimeUnit unit)
	{
		log.info("waiting for Page to Load"+unit+"seconds");
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("page is loaded");
	}
	
}