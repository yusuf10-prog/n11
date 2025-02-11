package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class HomePage extends BasePage {
    
    // Header menu locators
    private final By searchBoxBy = By.id("searchData");
    private final By searchButtonBy = By.cssSelector(".searchBtn");
    private final By cartIconBy = By.cssSelector(".myBasket");
    
    // Footer menu sections
    private final By n11SectionBy = By.cssSelector(".footer__middle__left");
    private final By musterilerSectionBy = By.cssSelector(".footer__middle__center-left");
    private final By populerSayfalarSectionBy = By.cssSelector(".footer__middle__center");
    private final By oneCikanSayfalarSectionBy = By.cssSelector(".footer__middle__center-right");
    private final By magazalarSectionBy = By.cssSelector(".footer__middle__right");
    
    // Quick access icons
    private final By kuponFirsatlariBy = By.cssSelector(".iconsFirst");
    private final By yeniUrunlerBy = By.cssSelector(".iconsSecond");
    private final By odemeYontemleriBy = By.cssSelector(".iconsThird");
    private final By iadeBy = By.cssSelector(".iconsFourth");
    
    // Sosyal Medya İkonları locators
    private final By facebookIconBy = By.cssSelector("a[href*='facebook.com']");
    private final By twitterIconBy = By.cssSelector("a[href*='twitter.com']");
    private final By instagramIconBy = By.cssSelector("a[href*='instagram.com']");
    private final By youtubeIconBy = By.cssSelector("a[href*='youtube.com']");
    private final By pinterestIconBy = By.cssSelector("a[href*='pinterest.com']");
    private final By socialMediaLinksBy = By.cssSelector(".footer__social a");
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public void clickAllQuickAccessIcons() {
        click(kuponFirsatlariBy);
        click(yeniUrunlerBy);
        click(odemeYontemleriBy);
        click(iadeBy);
    }
    
    private void clickAllLinksInSection(By sectionLocator) {
        WebElement section = driver.findElement(sectionLocator);
        List<WebElement> links = section.findElements(By.tagName("a"));
        for (WebElement link : links) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
                click(link);
                driver.navigate().back();
            } catch (Exception e) {
                System.out.println("Could not click link: " + link.getText());
            }
        }
    }
    
    public void clickAllFooterLinks() {
        clickAllLinksInSection(n11SectionBy);
        clickAllLinksInSection(musterilerSectionBy);
        clickAllLinksInSection(populerSayfalarSectionBy);
        clickAllLinksInSection(oneCikanSayfalarSectionBy);
        clickAllLinksInSection(magazalarSectionBy);
    }
    
    public void clickFacebookIcon() {
        click(facebookIconBy);
    }
    
    public void clickTwitterIcon() {
        click(twitterIconBy);
    }
    
    public void clickInstagramIcon() {
        click(instagramIconBy);
    }
    
    public void clickYoutubeIcon() {
        click(youtubeIconBy);
    }
    
    public void clickPinterestIcon() {
        click(pinterestIconBy);
    }
    
    public void searchProduct(String keyword) {
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(searchBoxBy));
        searchBox.clear();
        searchBox.sendKeys(keyword);
        click(searchButtonBy);
    }

    public void clickCartIcon() {
        click(cartIconBy);
    }

    public void clickSocialMediaLinks() {
        click(socialMediaLinksBy);
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
