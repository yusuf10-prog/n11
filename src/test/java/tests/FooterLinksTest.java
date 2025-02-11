package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class FooterLinksTest extends BaseTest {

    @Test(description = "Click all footer links and quick access icons")
    public void testClickAllLinks() {
        HomePage homePage = new HomePage(driver);
        
        // Click all quick access icons at the top
        homePage.clickAllQuickAccessIcons();
        
        // Click all footer links
        homePage.clickAllFooterLinks();
    }
}
