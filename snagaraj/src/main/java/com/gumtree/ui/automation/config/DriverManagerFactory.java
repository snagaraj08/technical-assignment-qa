package com.gumtree.ui.automation.config;


import org.openqa.selenium.WebDriver;

public class DriverManagerFactory {

    public static WebDriver getDriver(Browsers type) {

        WebDriver driver = null;

        switch (type) {
            case CHROME:
                driver = new ChromeDriverManager().createDriver();
                break;
            case FIREFOX:
               // driverManager = new FirefoxDriverManager();
                break;
            default:
                break;
        }
        return driver;

    }

}
