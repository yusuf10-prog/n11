package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {
    
    private HomePage homePage;

    @BeforeMethod
    public void setUpTest() {
        homePage = new HomePage(driver);
    }

    @Test(description = "Test basic homepage interactions")
    @Epic("Homepage Tests")
    @Feature("Basic Interactions")
    @Story("Verify all basic homepage interactions work")
    @Description("Test basic interactions like search, cart, and navigation")
    @Severity(SeverityLevel.CRITICAL)
    public void testHomePageInteractions() throws InterruptedException {
        // Test all clickable elements
        try {
            Thread.sleep(3000); // Wait for page to load
            
            // Search functionality
            homePage.searchProduct("telefon");
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            
            // Cart interaction
            homePage.clickCartIcon();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            
            // Social media section
            homePage.scrollToElement(By.cssSelector(".footer__social"));
            Thread.sleep(2000);
            
            // Social media interactions
            homePage.scrollToElement(By.cssSelector(".footer__social a"));
            Thread.sleep(1000);
            homePage.clickSocialMediaLinks();
            Thread.sleep(2000);
            driver.navigate().back();
            
            System.out.println("All homepage interactions completed successfully");
            
        } catch (Exception e) {
            System.out.println("Error during home page interactions: " + e.getMessage());
            throw e;
        }
    }
}
