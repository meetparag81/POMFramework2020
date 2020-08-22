import org.codehaus.jackson.map.deser.impl.ExternalTypeHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {
	
	public static  ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		if(extent==null){
			createInstance("test-output/extent.html");
			
		}
		else
		{
			return extent;
		}
		return extent;
	}
	
	public static ExtentReports createInstance(String filename){
		ExtentHtmlReporter Htmlreporter = new ExtentHtmlReporter(filename);
		Htmlreporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		Htmlreporter.config().setChartVisibilityOnOpen(true);
		Htmlreporter.config().setTheme(Theme.STANDARD);
		Htmlreporter.config().setDocumentTitle(filename);
		Htmlreporter.config().setEncoding("utf-8");
		Htmlreporter.config().setReportName("AutomationReport");
		extent = new ExtentReports();
		extent.attachReporter(Htmlreporter);
		
		
		return extent;
		
	}

}
