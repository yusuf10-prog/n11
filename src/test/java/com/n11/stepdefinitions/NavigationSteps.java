package com.n11.stepdefinitions;

import com.n11.pages.HomePage;
import com.n11.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class NavigationSteps {
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        homePage = new HomePage(driver);
    }

    @Given("user is on the N11 homepage")
    public void userIsOnTheN11Homepage() {
        driver.get("https://www.n11.com");
        homePage.handleAllPopups();
    }

    @When("user clicks on {string} category")
    public void userClicksOnCategory(String category) {
        homePage.navigateToCategory(category);
    }

    @Then("verify user is on {string} category page")
    public void verifyUserIsOnCategoryPage(String category) {
        Assert.assertTrue("User is not on " + category + " page", 
            homePage.isCategoryPageDisplayed(category));
    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }
}
