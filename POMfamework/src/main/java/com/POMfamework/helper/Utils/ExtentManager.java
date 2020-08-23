package com.POMfamework.helper.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import uiframework.uiframework.Paragcom.freecrm.helper.resource.ResourceHelper;


public class ExtentManager 
{
	public static ExtentReports extent;
	
	public static  ExtentReports getInstance()
	{
		if(extent==null)
		{			ExtentReports extentobj;
		String path = ResourceHelper.getResourcePath("\\test-output\\extent.html");
		return extentobj = createInstance(path);
			
		}
		else
		{
			return extent;
		}
		
		
	}
	
	public static ExtentReports createInstance(String fileName)
	{
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("AutomationReport");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
	}
		
		
	}


