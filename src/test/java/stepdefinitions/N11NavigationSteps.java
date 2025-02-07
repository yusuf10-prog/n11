package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.N11HomePage;

public class N11NavigationSteps {
    private static WebDriver driver;
    private N11HomePage n11HomePage;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        n11HomePage = new N11HomePage(driver);
    }

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
    @Step("Scrolling to bottom of page")
    public void iScrollToTheBottomOfThePage() {
        n11HomePage.scrollToBottomOfPage();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            saveScreenshot();
        }
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
