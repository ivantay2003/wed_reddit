/*
 * 	Copyright (c) 2018 Ivan Tay 
 *  Base Driver  . All future webdriver implementation inherit here
 *  
 */

package BrowserDriver;

import org.openqa.selenium.WebDriver;

public abstract class BaseWebDriver {

    protected WebDriver driver;
    protected abstract void startService(String driverPath);
    protected abstract void stopService();
    protected abstract WebDriver createDriver();
    public void quitDriver() {
    	/*
    	 * Quit instance of web driver
    	 */
    	
        if (null != driver) {
            driver.quit();
            driver = null;
        }

    }

    public WebDriver getDriver(String driverPath) {
    	/*
    	 * Get instance of web driver
    	 * 
    	 */
        if (null == driver) {
            startService(driverPath);
            createDriver();
        }
        return driver;
    }
}