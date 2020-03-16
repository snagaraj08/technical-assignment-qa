package com.gumtree.ui.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchPage extends BasePage {

    private final String searchBoxCss = ".gLFyf";
    private final String searchLinksCss = "cite";

    public void gotoURL(WebDriver driver) {
        driver.get("https://www.google.com");
    }

    public void enterSearch(String searchTerm, WebDriver driver) {
        driver.findElement(By.cssSelector(searchBoxCss)).sendKeys(searchTerm);
        driver.findElement(By.cssSelector(searchBoxCss)).sendKeys(Keys.RETURN);
        getAllLinks(driver);
    }

    /**
     *
     * @param driver
     * returns the list of gumtreelinks as webelements
     * @return
     */
    public List<WebElement> getAllGumtreeLinks(WebDriver driver) {
        List<WebElement> allLinks = getAllLinks(driver);
        int count = 0;
        List<WebElement> gumtreeLinks = new ArrayList<>();

        for(WebElement e : allLinks) {
            if(e.getText().contains("gumtree")) {
                gumtreeLinks.add(e);
            }
            count++;
        }
        return gumtreeLinks;
    }

    /**
     *
     * @param driver
     * return the list of all the google search links
     * @return
     */
    public List<WebElement> getAllLinks(WebDriver driver) {
        return driver.findElements(By.tagName(searchLinksCss));
    }
}
