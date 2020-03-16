package com.gumtree.ui.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GumtreePage extends BasePage {

    public WebElement getTitle(WebDriver driver) {
        return driver.findElement(By.className("gumtree-logo-svg"));
    }

    public String getCountText(WebDriver driver) {
        return driver.findElement(By.className("h1-responsive")).getText();
    }

}
