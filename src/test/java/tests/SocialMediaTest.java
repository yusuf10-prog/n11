package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class SocialMediaTest extends BaseTest {
    
    @Test(description = "Test clicking on Facebook icon")
    public void testFacebookIcon() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFacebookIcon();
        // Switch to new window and verify URL contains facebook.com
        switchToNewWindow();
        assertURLContains("facebook.com");
    }
    
    @Test(description = "Test clicking on Twitter icon")
    public void testTwitterIcon() {
        HomePage homePage = new HomePage(driver);
        homePage.clickTwitterIcon();
        // Switch to new window and verify URL contains x.com or twitter.com
        switchToNewWindow();
        String currentUrl = driver.getCurrentUrl().toLowerCase();
        assert (currentUrl.contains("x.com") || currentUrl.contains("twitter.com")) : 
            "Expected URL to contain 'x.com' or 'twitter.com' but was '" + currentUrl + "'";
    }
    
    @Test(description = "Test clicking on Instagram icon")
    public void testInstagramIcon() {
        HomePage homePage = new HomePage(driver);
        homePage.clickInstagramIcon();
        // Switch to new window and verify URL contains instagram.com
        switchToNewWindow();
        assertURLContains("instagram.com");
    }
    
    @Test(description = "Test clicking on Youtube icon")
    public void testYoutubeIcon() {
        HomePage homePage = new HomePage(driver);
        homePage.clickYoutubeIcon();
        // Switch to new window and verify URL contains youtube.com
        switchToNewWindow();
        assertURLContains("youtube.com");
    }
    
    @Test(description = "Test clicking on Pinterest icon")
    public void testPinterestIcon() {
        HomePage homePage = new HomePage(driver);
        homePage.clickPinterestIcon();
        // Switch to new window and verify URL contains pinterest.com
        switchToNewWindow();
        assertURLContains("pinterest.com");
    }
    
    private void switchToNewWindow() {
        // Store the current window handle
        String mainWindow = driver.getWindowHandle();
        // Switch to new window
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
    
    private void assertURLContains(String expectedText) {
        String currentUrl = driver.getCurrentUrl().toLowerCase();
        assert currentUrl.contains(expectedText) : 
            "Expected URL to contain '" + expectedText + "' but was '" + currentUrl + "'";
    }
}
