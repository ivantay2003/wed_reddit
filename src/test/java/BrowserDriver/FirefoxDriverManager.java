/*
 * 	Copyright (c) 2018 Ivan Tay 
 *  Chrome Driver 	
 *  
 */

package BrowserDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends BaseWebDriver {

    

    @Override
    public void startService(String driverPath) {
    	/*
    	 * Start service . initialize properties
    	 */
    	System.setProperty("webdriver.gecko.driver",  driverPath);
    }

    @Override
    public void stopService() {
    	/*
		 * Quit web driver
		 */
    	driver.quit();
        
    }

    @Override
    public WebDriver createDriver() {
    	/*
    	 * return created web driver
    	 * 
    	 */
		  driver=new FirefoxDriver();
		  return driver;
		  
		  
    }
    
    


}