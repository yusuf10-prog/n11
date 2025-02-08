package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.HomePage;

public class HomePageTest extends BaseTest {
    
    private HomePage homePage;

    @Before
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
    }

    @Test
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
            
            // Category interaction
            homePage.scrollToElement(By.cssSelector(".catMenuItem a"));
            Thread.sleep(1000);
            homePage.clickFirstCategory();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            
            // Campaign interaction
            homePage.scrollToElement(By.cssSelector(".banner-container"));
            Thread.sleep(1000);
            homePage.clickFirstCampaign();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            
            // Featured product interaction
            homePage.scrollToElement(By.cssSelector(".plink"));
            Thread.sleep(1000);
            homePage.clickFirstFeaturedProduct();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            
            // Footer interactions
            homePage.scrollToElement(By.cssSelector(".footer__middle"));
            Thread.sleep(1000);
            homePage.clickFooterMenu();
            Thread.sleep(2000);
            driver.navigate().back();
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
