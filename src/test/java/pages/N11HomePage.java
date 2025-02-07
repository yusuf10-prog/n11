package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class N11HomePage extends BasePage {
    // Menu Locators
    private final By modaMenuLink = By.xpath("//span[text()='Moda']/ancestor::a");
    private final By elektronikMenuLink = By.xpath("//span[text()='Elektronik']/ancestor::a");
    private final By evYasamMenuLink = By.xpath("//span[text()='Ev & Yaşam']/ancestor::a");
    private final By anneBebekMenuLink = By.xpath("//span[text()='Anne & Bebek']/ancestor::a");
    private final By kozmetikMenuLink = By.xpath("//span[text()='Kozmetik & Kişisel Bakım']/ancestor::a");
    private final By mucevherSaatMenuLink = By.xpath("//span[text()='Mücevher & Saat']/ancestor::a");
    private final By sporOutdoorMenuLink = By.xpath("//span[text()='Spor & Outdoor']/ancestor::a");
    private final By kitapMuzikMenuLink = By.xpath("//span[text()='Kitap, Müzik, Film, Oyun']/ancestor::a");
    private final By otomotivMotosikletMenuLink = By.xpath("//span[text()='Otomotiv & Motosiklet']/ancestor::a");

    // Cookie consent locator
    private final By cookieAcceptButton = By.id("onetrust-accept-btn-handler");

    public N11HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToN11() {
        driver.get("https://www.n11.com");
        handleCookieConsent();
    }

    public void handleCookieConsent() {
        if (isElementVisible(cookieAcceptButton)) {
            click(cookieAcceptButton);
        }
    }

    public void clickAllMenuItems() {
        // Wait for the page to load completely
        try {
            Thread.sleep(2000); // Wait for page load
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        click(modaMenuLink);
        shortWait();
        driver.navigate().back();
        shortWait();
        
        click(elektronikMenuLink);
        shortWait();
        driver.navigate().back();
        shortWait();
        
        click(evYasamMenuLink);
        shortWait();
        driver.navigate().back();
        shortWait();
        
        click(anneBebekMenuLink);
        shortWait();
        driver.navigate().back();
        shortWait();
        
        click(kozmetikMenuLink);
        shortWait();
        driver.navigate().back();
        shortWait();
        
        click(mucevherSaatMenuLink);
        shortWait();
        driver.navigate().back();
        shortWait();
        
        click(sporOutdoorMenuLink);
        shortWait();
        driver.navigate().back();
        shortWait();
        
        click(kitapMuzikMenuLink);
        shortWait();
        driver.navigate().back();
        shortWait();
        
        click(otomotivMotosikletMenuLink);
        shortWait();
        driver.navigate().back();
        shortWait();
    }

    private void shortWait() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void scrollToBottomOfPage() {
        scrollToBottom();
    }
}
