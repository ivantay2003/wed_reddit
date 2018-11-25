/*
 * 	Copyright (c) 2018 Ivan Tay 
 *  Driver Manager to select type of webdriver . Now there is only Chrome / Firefox Driver. 
 *  
 */
package BrowserDriver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private String driverPath= "";
	private BaseWebDriver driverManager;
     
	public DriverManager (String driverInputPath){
		
		driverPath = driverInputPath;
	}
	
	public  BaseWebDriver getManager(BrowserType type) {
		/*
		 * Select the type of browser driver. Default is chrome
		 * 
		 */

        
        
        
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                //driver = driverManager.getDriver(driverPath);
                
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                //driver = driverManager.getDriver(driverPath);
                break;
            default:
                driverManager = new ChromeDriverManager();
                //driver = driverManager.getDriver(driverPath);
                break;
        }
        return driverManager;

    }
	
	public WebDriver getDriver (){
		/*
		 * Get Web Driver
		 * 
		 */
		return driverManager.getDriver(driverPath);
	}
	
	public void quitDriver (){
		/*
		 * Stop driver instance
		 * 
		 */
		driverManager.stopService();
	}
	
	public void maximizeWindow (){
		/*
		 * Maximize window size
		 * 
		 */
		driverManager.getDriver(driverPath).manage().window().maximize();
	}
		
}
