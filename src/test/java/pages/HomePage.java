package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    
    // Header menu locators
    private final By searchBoxBy = By.id("searchData");
    private final By searchButtonBy = By.cssSelector(".searchBtn");
    private final By cartIconBy = By.cssSelector(".myBasket");
    
    // Category menu locators
    private final By firstCategoryBy = By.cssSelector(".catMenuItem a");
    
    // Main content locators
    private final By campaignsBy = By.cssSelector(".banner-container");
    private final By featuredProductsBy = By.cssSelector(".plink");
    
    // Footer locators
    private final By footerMenuBy = By.cssSelector(".footer__middle");
    private final By socialMediaLinksBy = By.cssSelector(".footer__social a");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String keyword) {
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(searchBoxBy));
        searchBox.clear();
        searchBox.sendKeys(keyword);
        wait.until(ExpectedConditions.elementToBeClickable(searchButtonBy)).click();
    }

    public void clickCartIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIconBy)).click();
    }

    public void clickFirstCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(firstCategoryBy)).click();
    }

    public void clickFirstCampaign() {
        wait.until(ExpectedConditions.elementToBeClickable(campaignsBy)).click();
    }

    public void clickFirstFeaturedProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(featuredProductsBy)).click();
    }

    public void clickFooterMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(footerMenuBy)).click();
    }

    public void clickSocialMediaLinks() {
        wait.until(ExpectedConditions.elementToBeClickable(socialMediaLinksBy)).click();
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
