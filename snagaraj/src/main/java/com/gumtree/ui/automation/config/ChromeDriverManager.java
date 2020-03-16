package com.gumtree.ui.automation.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeDriverManager {

    private static final String DRIVERPATH = System.getProperty("user.dir") + "/src/test/resources/driver/";

    protected WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", DRIVERPATH + "chromedriver");
        return new ChromeDriver();
    }
}