package POMfamework_Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.POMfamework.helper.assertion.AssertHelper;
import com.POMfamework.testbase.TestBase;


@Listeners()
public class Test1 extends  TestBase {
	
	@Test
	public void TestExtentReportPass()
	{
		AssertHelper.markPass();
	}
	
	@Test
	public void TestExtentReportFail()
	{
		AssertHelper.markFail("assertionfailed");
	}
	
	@Test
	public void TestExtentReportPass_1(){
		AssertHelper.markPass();
	}
		
	
	@Test
	public void TestExtentReportFail_1()
	{
		AssertHelper.markFail();
	}

}
