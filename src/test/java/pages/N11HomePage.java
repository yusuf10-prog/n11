package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

public class N11HomePage extends BasePage {
    @FindBy(xpath = "//span[text()='Moda']/ancestor::a")
    private WebElement modaMenuLink;

    @FindBy(xpath = "//span[text()='Elektronik']/ancestor::a")
    private WebElement elektronikMenuLink;

    @FindBy(xpath = "//span[text()='Ev & Yaşam']/ancestor::a")
    private WebElement evYasamMenuLink;

    @FindBy(xpath = "//span[text()='Anne & Bebek']/ancestor::a")
    private WebElement anneBebekMenuLink;

    @FindBy(xpath = "//span[text()='Kozmetik & Kişisel Bakım']/ancestor::a")
    private WebElement kozmetikMenuLink;

    @FindBy(xpath = "//span[text()='Mücevher & Saat']/ancestor::a")
    private WebElement mucevherSaatMenuLink;

    @FindBy(xpath = "//span[text()='Spor & Outdoor']/ancestor::a")
    private WebElement sporOutdoorMenuLink;

    @FindBy(xpath = "//span[text()='Kitap, Müzik, Film, Oyun']/ancestor::a")
    private WebElement kitapMuzikMenuLink;

    @FindBy(xpath = "//span[text()='Otomotiv & Motosiklet']/ancestor::a")
    private WebElement otomotivMotosikletMenuLink;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookieAcceptButton;

    public void navigateToN11() {
        Driver.getDriver().get("https://www.n11.com");
        handleCookieConsent();
    }

    public void handleCookieConsent() {
        try {
            if (cookieAcceptButton.isDisplayed()) {
                cookieAcceptButton.click();
            }
        } catch (Exception ignored) {
            // Cookie banner might not appear
        }
    }

    public void clickAllMenuItems() {
        shortWait(); // Initial wait for page load

        clickAndGoBack(modaMenuLink);
        clickAndGoBack(elektronikMenuLink);
        clickAndGoBack(evYasamMenuLink);
        clickAndGoBack(anneBebekMenuLink);
        clickAndGoBack(kozmetikMenuLink);
        clickAndGoBack(mucevherSaatMenuLink);
        clickAndGoBack(sporOutdoorMenuLink);
        clickAndGoBack(kitapMuzikMenuLink);
        clickAndGoBack(otomotivMotosikletMenuLink);
    }

    private void clickAndGoBack(WebElement element) {
        element.click();
        shortWait();
        Driver.getDriver().navigate().back();
        shortWait();
    }

    public void scrollToBottomOfPage() {
        scrollToBottom();
    }
}
