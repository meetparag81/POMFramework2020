package com.POMfamework.helper.assertion;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.POMfamework.helper.logger.LoggerHelper;

public class AssertHelper 
{
	
	private Logger log = LoggerHelper.GetLogger(AssertHelper.class);

	
	public static void VerifyText(String s1, String s2)
	{
		Assert.assertEquals(s1, s2);
	}
	public static void VerifyTrue()
	{
		Assert.assertTrue(true);
	}
	public static void VerifyTrue(String message)
	{
		Assert.assertTrue(true,message);
	}
	public static void VerifyFalse()
	{
		Assert.assertFalse(false);
	}
	public static void VerifyFalse(String message)
	{
		Assert.assertTrue(false,message);
	}
}
