package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.N11HomePage;
import utilities.Driver;

public class N11NavigationSteps {
    private final N11HomePage n11HomePage = new N11HomePage();

    @Given("I am on the N11 homepage")
    @Step("Opening N11 homepage")
    public void iAmOnTheN11Homepage() {
        n11HomePage.navigateToN11();
    }

    @When("I accept cookies if present")
    @Step("Accepting cookies if present")
    public void iAcceptCookiesIfPresent() {
        n11HomePage.handleCookieConsent();
    }

    @Then("I click on all menu items")
    @Step("Clicking all menu items")
    public void iClickOnAllMenuItems() {
        n11HomePage.clickAllMenuItems();
    }

    @Then("I scroll to the bottom of the page")
    @Step("Scrolling to the bottom of the page")
    public void iScrollToTheBottomOfThePage() {
        n11HomePage.scrollToBottomOfPage();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            takeScreenshot(scenario.getName());
        }
        Driver.closeDriver();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot(String scenarioName) {
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
