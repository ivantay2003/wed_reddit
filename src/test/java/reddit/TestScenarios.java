package reddit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BrowserDriver.BrowserType;
import Control.Configuration;
import Control.Credential;
import Control.LOCELEMENT;
import PageObject.PageObjectManager;
import Report.ExtentTestManager;

public class TestScenarios extends PageObjectManager{
	
	 //Configuration object
	private Configuration config;
	
	@BeforeTest 
	public void setup(){
		
		  config = new Configuration();
		  
		  /*
		   * Select browser type - Firefox or Chrome
		   */
		  //config.setBrowser(BrowserType.FIREFOX);//Use Firefox driver
		  config.setBrowser(BrowserType.CHROME);//Use Chrome driver
		  
		  setInitializePageObjects (config); //Initialize all Page Objects Models with project configurations / web driver / user data
		  ExtentTestManager.getInstance("TestReport");
		  
		
	}
	
	@AfterTest 
	public void closeTest (){
		
		//Uncomment this if you want it to close the browser
		config.getWebDriver().quit();
	}
	
  @Test
  public void f() {

	  //Login
	  homePage.homePageURL(); //launching page
	  homePage.signIn(Credential.user,Credential.password); //login
	  
	  //Subscribe Page
	  subscribePage.launchSubscribePage(); //launch subscribe page
	  subscribePage.validateThreadPostExist("Online secure document collaboration"); // check that the post in subscribe exist
	  subscribePage.addCommentOnThreadPost("TESTING","Peter Doe");//Write a comment with current date time
	  subscribePage.downVoteLatestComment(LOCELEMENT.LATEST_COMMENT_ARROW);//Down vote on the latest comment
	  subscribePage.upVoteLatestComment(LOCELEMENT.LATEST_COMMENT_ARROW);//Up vote on the latest comment    
	  subscribePage.checkPageTitle ("TESTING"); //verify that the page is correct


	  ExtentTestManager.endReport();
	  
  }
}
