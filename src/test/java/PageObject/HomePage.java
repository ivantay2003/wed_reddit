package PageObject;

import org.testng.Assert;
//import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Control.Configuration;
import Control.LOCELEMENT;
import Data.ExcelExtractionManager;

public class HomePage  extends BasePage{
	private Configuration config; // Config
	private ExcelExtractionManager userData;  //User data extraction manager
	
	public HomePage (Configuration configInput){
		
		config = configInput;
		setInstance(config.getWebDriver());
		userData = config.getUserData();// get user data
		
	}
	

	public void homePageURL (){
		
		config.getWebDriver().get(LOCELEMENT.URL_MAIN);
		
	}
	
	

	public void signIn (String user, String password){
		/*
		 * SignIn method - accepts email address
		 * Input - email address
		 * Return - none. Brings to next page - Create account
		 */
		
		isPresence(By.xpath(LOCELEMENT.MAIN_LOGIN_BUTTON_XPATH)); //Is element presence in page ?
		clickElement (By.xpath(LOCELEMENT.MAIN_LOGIN_BUTTON_XPATH));
		config.getWebDriver().switchTo().frame(config.getWebDriver().findElement(By.xpath("//iframe[@class='s1h3r6h-2 guLBlv']")));
		sendKeys(By.xpath(LOCELEMENT.MAIN_LOGIN_INPUT_USER_XPATH), user);
		sendKeys(By.xpath(LOCELEMENT.MAIN_LOGIN_INPUT_PASSWORD_XPATH),password);
		clickElement (By.xpath(LOCELEMENT.MAIN_LOGIN_BUTTON_SUBMIT_XPATH));
		
		WebElement elem = isPresenceElement (By.xpath(LOCELEMENT.MAIN_BUTTON_WRITEPOST_XPATH));
		validateNotNull(elem,"Log into account");

		
	}
}
