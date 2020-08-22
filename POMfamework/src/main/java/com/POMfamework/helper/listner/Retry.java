package com.POMfamework.helper.listner;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import com.POMfamework.helper.logger.LoggerHelper;

public class Retry implements IRetryAnalyzer
{
	private int retrycount=0;
	private int maxretrycount=3;
	private Logger log = LoggerHelper.GetLogger(Retry.class);
	public boolean retry(ITestResult result)
	{
		if(retrycount<maxretrycount)
		{
			log.info("Retryingtest"+result.getName() +"withstatus "+getResultStatsNname(result.getStatus()) + "for the"+(retrycount+1) +"times");
			retrycount++;
			return true;
		}
		return false;
		
	}
	public String getResultStatsNname(int status)
	{
		String resultName= null;
		if(status==1)
		{
			resultName="SUCCESS";
		}
		if(status==2)
		{
			resultName="FAILURE";
		}
		if(status==3)
		{
			resultName="SKIP";
		}
		
		return resultName;
		
		
		
	}
}
