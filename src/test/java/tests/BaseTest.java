package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;

public class BaseTest {
    protected WebDriver driver;

    private static WebDriver staticDriver;

    @BeforeClass
    @Step("Setting up the test environment")
    public void setUp() {
        if (staticDriver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            staticDriver = new ChromeDriver(options);
        }
        driver = staticDriver;
    }

    @BeforeMethod
    @Step("Navigating to N11 homepage")
    public void navigateToHomePage() {
        driver.get("https://www.n11.com");
        try {
            // Try to find and click the cookie accept button
            driver.findElement(By.id("cookieAcceptButton")).click();
        } catch (Exception e) {
            // Cookie banner might not be present or already accepted
            System.out.println("Cookie banner not found or already accepted");
        }
    }

    @AfterMethod
    @Step("Taking screenshot if test fails")
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
    }

    @AfterClass
    @Step("Tearing down the test environment")
    public void tearDown() {
        // Do not quit the driver here as we want to reuse it
        // The driver will be quit when the test suite finishes
    }

    @AfterClass(alwaysRun = true)
    @Step("Final cleanup after all tests")
    public void finalCleanup() {
        if (staticDriver != null) {
            staticDriver.quit();
            staticDriver = null;
        }
    }
}
