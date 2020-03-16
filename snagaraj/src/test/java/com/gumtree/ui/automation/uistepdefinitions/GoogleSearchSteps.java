package com.gumtree.ui.automation.uistepdefinitions;

import com.gumtree.ui.automation.config.Browsers;
import com.gumtree.ui.automation.config.DriverManagerFactory;
import com.gumtree.ui.automation.pages.GoogleSearchPage;
import com.gumtree.ui.automation.pages.GumtreePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class GoogleSearchSteps {

    private WebDriver driver;
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    GumtreePage gumtreePage = new GumtreePage();

    @Before
    public void beforeTest() {
        driver = DriverManagerFactory.getDriver(Browsers.CHROME);
    }

    @After
    public void embedScreenshot() {
        driver.close();
    }


    @Given("^I search Google for \"([^\"]*)\"$")
    public void i_search_Google_for(String searchTerm) {
        googleSearchPage.gotoURL(driver);
        googleSearchPage.enterSearch(searchTerm,driver);
    }

    @Given("^count the number of Gumtree links displayed$")
    public void count_the_number_of_Gumtree_links_displayed() {
       googleSearchPage.getAllGumtreeLinks(driver);
    }

    @Then("^verify each link the title is displayed$")
    public void verify_each_link_the_title_is_displayed() {
        List<WebElement> gumtreeLinks = googleSearchPage.getAllGumtreeLinks(driver);
        for(WebElement link : gumtreeLinks ) {
            link.click();
            assertTrue("Gumtree Page is displayed", gumtreePage.getTitle(driver).isDisplayed());
        }
    }

    @Then("^number of results is greater than zero$")
    public void number_of_results_is_greater_than_zero() {
        String[] strArray = gumtreePage.getCountText(driver).split(" ads");
        int adsCount = Integer.parseInt(strArray[0].replace(",",""));
        assertTrue("The ads count is displayed", adsCount > 0);
    }
}


