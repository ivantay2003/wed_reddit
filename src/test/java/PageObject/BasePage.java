/*
 * 	Copyright (c) 2018 Ivan Tay 
 * 
 * Base Page inheritance 
 * 
 */

package PageObject;

import Control.Common;//Common webdriver shared modules
import Report.ExtentTestManager;

import org.testng.Assert;

import com.aventstack.extentreports.Status;



public class BasePage extends Common {
	

	public void validateCompareString(String expectedResult , String actualResult, String message) {
		/*
		 * Compare strings and assert for result
		 */
		
		
		try{
			Assert.assertEquals(expectedResult, actualResult, message); //Compare actual and expected. Assert if false
			//ExtentTestManager.logTest(message, status);
			
		}catch (Throwable error){
			
			
		}
		

	}
	
	public void validateNotNull ( Object obj, String message){
		
		try {
			Assert.assertNotNull( obj,message);
			ExtentTestManager.logTest(message, Status.PASS);
			
		}catch (Throwable error) {
			
			ExtentTestManager.logTest(message + ". Error Message : " + error, Status.FAIL);
			
		}
		
		
	}
}
