package com.n11.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage extends BasePage {
    private final By modaCategory = By.linkText("Moda");
    private final By elektronikCategory = By.linkText("Elektronik");
    private final By evYasamCategory = By.linkText("Ev & Yaşam");
    private final By anneBebekCategory = By.linkText("Anne & Bebek");
    private final By kozmetikCategory = By.linkText("Kozmetik & Kişisel Bakım");
    private final By mucevherCategory = By.linkText("Mücevher & Saat");
    private final By sporCategory = By.linkText("Spor & Outdoor");
    private final By kitapCategory = By.linkText("Kitap, Müzik, Film, Oyun");
    private final By otomotivCategory = By.linkText("Otomotiv & Motosiklet");
    
    // Popup and dialog locators
    private final By cookieContainer = By.id("cookieUsagePopIn");
    private final By acceptCookiesButton = By.cssSelector("span.cookieUsagePopIn__button");
    private final By locationPopup = By.className("locationModal");
    private final By closeLocationButton = By.className("closeBtn");
    private final By notificationDialog = By.id("notification-permission-dialog");
    private final By closeNotificationButton = By.className("btnDeny");
    private final By generalPopupClose = By.className("seg-popup-close");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToCategory(String category) {
        // Wait for page load before navigation
        waitForPageLoad();
        handleAllPopups();
        By categoryLocator;
        switch (category) {
            case "Moda":
                categoryLocator = modaCategory;
                break;
            case "Elektronik":
                categoryLocator = elektronikCategory;
                break;
            case "Ev & Yaşam":
                categoryLocator = evYasamCategory;
                break;
            case "Anne & Bebek":
                categoryLocator = anneBebekCategory;
                break;
            case "Kozmetik & Kişisel Bakım":
                categoryLocator = kozmetikCategory;
                break;
            case "Mücevher & Saat":
                categoryLocator = mucevherCategory;
                break;
            case "Spor & Outdoor":
                categoryLocator = sporCategory;
                break;
            case "Kitap, Müzik, Film, Oyun":
                categoryLocator = kitapCategory;
                break;
            case "Otomotiv & Motosiklet":
                categoryLocator = otomotivCategory;
                break;
            default:
                throw new IllegalArgumentException("Invalid category: " + category);
        }
        handleStaleElement(categoryLocator, () -> {
            WebElement element = waitForElementClickable(categoryLocator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            try {
                Thread.sleep(500); // Small wait for smooth scrolling
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            element.click();
        });
        
        // Wait for page load after click
        waitForPageLoad();
        handleAllPopups();
    }

    public boolean isCategoryPageDisplayed(String category) {
        waitForPageLoad();
        String currentUrl = driver.getCurrentUrl().toLowerCase();
        String expectedUrlPart;

        // Map categories to their URL parts
        switch (category) {
            case "Moda":
                expectedUrlPart = "giyim-ayakkabi";
                break;
            case "Elektronik":
                expectedUrlPart = "elektronik";
                break;
            case "Ev & Yaşam":
                expectedUrlPart = "ev-yasam";
                break;
            case "Anne & Bebek":
                expectedUrlPart = "anne-bebek";
                break;
            case "Kozmetik & Kişisel Bakım":
                expectedUrlPart = "kozmetik-kisisel-bakim";
                break;
            case "Mücevher & Saat":
                expectedUrlPart = "mucevher-saat";
                break;
            case "Spor & Outdoor":
                expectedUrlPart = "spor-outdoor";
                break;
            case "Kitap, Müzik, Film, Oyun":
                expectedUrlPart = "kitap-muzik-film-oyun";
                break;
            case "Otomotiv & Motosiklet":
                expectedUrlPart = "otomotiv-motosiklet";
                break;
            default:
                throw new IllegalArgumentException("Category URL mapping not found for: " + category);
        }
        
        System.out.println("Current URL: " + currentUrl);
        System.out.println("Expected URL part: " + expectedUrlPart);
        
        return currentUrl.contains(expectedUrlPart);
    }

    public void handleAllPopups() {
        // Handle cookies first
        acceptCookies();
        
        // Handle location popup
        closePopupIfPresent(closeLocationButton);
        
        // Handle notification dialog
        closePopupIfPresent(closeNotificationButton);
        
        // Handle any general popup
        closePopupIfPresent(generalPopupClose);
    }

    public void acceptCookies() {
        try {
            // Wait for cookie container to be visible
            if (isElementDisplayed(cookieContainer)) {
                // Wait specifically for the accept button and click it
                WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
                // Use JavaScript click for better reliability
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", acceptButton);
                // Wait for cookie container to disappear
                wait.until(ExpectedConditions.invisibilityOfElementLocated(cookieContainer));
                System.out.println("Cookies accepted successfully");
            }
        } catch (Exception e) {
            System.out.println("Cookie popup was not present or already accepted: " + e.getMessage());
        }
    }
}
