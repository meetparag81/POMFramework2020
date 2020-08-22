package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class B
{
	int i=1;
	@Test
	public void TestB()
	{
		if(i==3)
		{
			Assert.assertTrue(true);
			
		}
		else
		{
			i++;
			Assert.assertTrue(false);	
		}
		
		}

}


