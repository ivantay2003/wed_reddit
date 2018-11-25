/*
 * Copyright Ivan Tay 2018
 */

package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import BrowserDriver.BrowserType;
import Control.Configuration;
import Control.Credential;
import Control.LOCELEMENT;
import PageObject.PageObjectManager;
import Report.ExtentTestManager;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;

public class Steps extends PageObjectManager {



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
	  
	

	  @Given("^I want to launch reddit$") 
	  public void launchURL() { 
		  setup();
		
		homePage.homePageURL(); //launching page
		ExtentTestManager.createSection("Launch Landing Page");  
		  

	  } 
	  
	  @And("^I log into my account$") 
	  public void registration() { 
		  
		  homePage.signIn(Credential.user,Credential.password); //login
		  
		  

	  }
	  
	  @When("^I go to my subreddits$") 
	  public void launchSubscription() { 
		  
		  ExtentTestManager.createSection("Launch subcribe page");
		  subscribePage.launchSubscribePage(); //launch subscribe page
		  
		  

	  }
	  
	  @And("^I check that the thread \"([^\"]*)\"$")
	  public void validateThreadsExist(String message) { 

		  subscribePage.validateThreadPostExist(message); // check that the post in subscribe exist



	  }
	  
	  
	  @And("^I add comment on the post \"([^\"]*)\" with my name \"([^\"]*)\"$")
	  public void addCommentOnThreadPost(String message, String name) { 
		  
		  ExtentTestManager.createSection("Add comment on thread post");
		  subscribePage.addCommentOnThreadPost(message,name);//Write a comment with current date time


	  }
	
	  @And("^I click down vote in latest comment$")
	  public void downVoteLatestComment() { 
		  
		  ExtentTestManager.createSection("Click down vote on latest comments");
		  subscribePage.downVoteLatestComment(LOCELEMENT.LATEST_COMMENT_ARROW);//Down vote on the latest comment


	  }
	  
	  @And("^I click up vote in latest comment$")
	  public void upVoteLatestComment() { 
		  
		  ExtentTestManager.createSection("Click up vote on latest comments");
		  subscribePage.upVoteLatestComment(LOCELEMENT.LATEST_COMMENT_ARROW);//Up vote on the latest comment 


	  }
	
	  @Then("^I check page title is \"([^\"]*)\"$")
	  public void checkPageTitle(String expectedPageTitle) { 
		  
		  subscribePage.checkPageTitle (expectedPageTitle); //verify that the page is correct
		  

	  } 
	  
	  @And("^I want print the report$")
	  public void printReport() { 
		  
		  ExtentTestManager.endReport(); //Flush report
		  closeTest();

	  }
	
}
