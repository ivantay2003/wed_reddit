package PageObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Control.Configuration;
import Control.LOCELEMENT;
import Data.ExcelExtractionManager;

public class SubscribePage  extends BasePage {
	private Configuration config; // Config
	private ExcelExtractionManager userData;  //User data extraction manager
	
	public SubscribePage (Configuration configInput){
		
		config = configInput;
		setInstance(config.getWebDriver());
		userData = config.getUserData();// get user data
		
	}
	
	private String getDate () {
		  
		  String pattern = "dd MMMMM yyyy HH:mma";

		  SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		  
		  

		  String date = simpleDateFormat.format(new Date());
		  
		  return date;
	  }
	
	public void launchSubscribePage () {
		
		config.getWebDriver().get(LOCELEMENT.URL_SUBSCRIBED);
	}
	
	public void validateThreadPostExist(String text){
		//Check that the thread 'Online secure document collaboration' exist
		String xpath ="//*[contains(text(),'"+ text +"')]";
		WebElement elem = isPresenceElement (By.xpath(xpath));

		validateNotNull(elem,"Thead post '" + text + "' exist");
	}
	
	public void leaveCommentOnNewestThreadPost(String message){
		

		List <WebElement> elements = config.getWebDriver().findElements(By.xpath(LOCELEMENT.SUB_COMMENTS_XPATH));
		
		//System.out.println("Size of element : " + elements.size());
		
		
		for (WebElement elem : elements){
			
			//System.out.println("Element text : " + elem.getText());
			elem.click();
			break;
			
		}
		
		String inputString = getDate() + " " + message;
		
		isPresence (By.xpath(LOCELEMENT.SUB_COMMENT_INPUT_XPATH));
		sendKeys(By.xpath(LOCELEMENT.SUB_COMMENT_INPUT_XPATH), inputString);
		clickElement (By.xpath(LOCELEMENT.SUB_COMMENT_BUTTON_SUBMIT_XPATH));
		
		
	}
	
	public void clickThreadTitle (String postTitle){
		
		clickElement(By.xpath("//*[contains(@href,'" + postTitle.toLowerCase() + "') and contains(@href,'/comments/')]"));

		
	}
	
	public void addCommentOnThreadPost (String postTitle, String message){
		
		//*[contains(@href,'testing') and contains(@href,'/comments/') and (@data-click-id='comments')]
		String xpath = "//*[contains(@href,'" + postTitle.toLowerCase() + "') and contains(@href,'/comments/') and (@data-click-id='comments')]";
		clickElement (By.xpath(xpath));
		
		String inputString = getDate() + " " + message;
		
		isPresence (By.xpath(LOCELEMENT.SUB_COMMENT_INPUT_XPATH));
		sendKeys(By.xpath(LOCELEMENT.SUB_COMMENT_INPUT_XPATH), inputString);
		clickElement (By.xpath(LOCELEMENT.SUB_COMMENT_BUTTON_SUBMIT_XPATH));
		
	}
	
	public void upVoteLatestComment () {
		
		isPresence (By.xpath(LOCELEMENT.SUB_COMMENT_UPVOTE_XPATH));
		clickElement (By.xpath(LOCELEMENT.SUB_COMMENT_UPVOTE_XPATH));
		
	}

	public void upVoteLatestComment (int whichDown) {

		
		scrollDown();

		WebElement element=config.getWebDriver().findElement(By.xpath(LOCELEMENT.SUB_COMMENT_UPVOTE_XPATH + "[" + whichDown + "]" ));

		
		((JavascriptExecutor)config.getWebDriver()).executeScript("arguments[0].click();", element);


	}
	
	public void downVoteLatestComment (int whichDown) {

		
		scrollDown();

		WebElement element=config.getWebDriver().findElement(By.xpath(LOCELEMENT.SUB_COMMENT_DOWNVOTE_XPATH + "[" + whichDown + "]" ));

		
		((JavascriptExecutor)config.getWebDriver()).executeScript("arguments[0].click();", element);


	}
	
	public void checkPageTitle (String expectPageTitle) {
		
		//*[contains(text(),'TESTING') and @data-redditstyle='true']
		String xpath = "//*[contains(text(),'" + expectPageTitle + "') and @data-redditstyle='true']";
		
		WebElement elem = isPresenceElement (By.xpath(xpath));
		
		validateNotNull(elem," Verify page title '" + expectPageTitle + "' existence");
	}
}
