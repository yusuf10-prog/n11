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
    private final By footerMenuBy = By.cssSelector(".footer-menu");
    private final By n11SectionBy = By.cssSelector(".footer-menu .footer-block:nth-child(1)");
    private final By musterilerSectionBy = By.cssSelector(".footer-menu .footer-block:nth-child(2)");
    private final By populerSayfalarSectionBy = By.cssSelector(".footer-menu .footer-block:nth-child(3)");
    private final By oneCikanSayfalarSectionBy = By.cssSelector(".footer-menu .footer-block:nth-child(4)");
    private final By magazalarSectionBy = By.cssSelector(".footer-menu .footer-block:nth-child(5)");
    
    // Quick access icons
    private final By quickAccessMenuBy = By.cssSelector(".quick-access-menu");
    private final By kuponFirsatlariBy = By.cssSelector(".quick-access-menu .item:nth-child(1)");
    private final By yeniUrunlerBy = By.cssSelector(".quick-access-menu .item:nth-child(2)");
    private final By odemeYontemleriBy = By.cssSelector(".quick-access-menu .item:nth-child(3)");
    private final By iadeBy = By.cssSelector(".quick-access-menu .item:nth-child(4)");
    
    // Sosyal Medya İkonları locators
    private final By socialMediaContainerBy = By.cssSelector(".social-media");
    private final By facebookIconBy = By.cssSelector(".social-media a[title*='Facebook'], .social-media a[href*='facebook.com']");
    private final By twitterIconBy = By.cssSelector(".social-media a[title*='Twitter'], .social-media a[title*='X'], .social-media a[href*='twitter.com'], .social-media a[href*='x.com']");
    private final By instagramIconBy = By.cssSelector(".social-media a[title*='Instagram'], .social-media a[href*='instagram.com']");
    private final By youtubeIconBy = By.cssSelector(".social-media a[title*='YouTube'], .social-media a[href*='youtube.com']");
    private final By pinterestIconBy = By.cssSelector(".social-media a[title*='Pinterest'], .social-media a[href*='pinterest.com']");
    private final By socialMediaLinksBy = By.cssSelector(".social-media a");
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public void clickAllQuickAccessIcons() {
        try {
            // Wait for quick access menu to be present
            wait.until(ExpectedConditions.presenceOfElementLocated(quickAccessMenuBy));

            // Try to click each icon
            By[] quickAccessIcons = {
                kuponFirsatlariBy,
                yeniUrunlerBy,
                odemeYontemleriBy,
                iadeBy
            };

            for (By iconBy : quickAccessIcons) {
                try {
                    WebElement icon = wait.until(ExpectedConditions.presenceOfElementLocated(iconBy));
                    scrollToElement(icon);
                    click(icon);
                    driver.navigate().back();
                } catch (Exception e) {
                    System.out.println("Could not click quick access icon: " + iconBy);
                }
            }
        } catch (Exception e) {
            System.out.println("Error accessing quick access menu: " + e.getMessage());
        }
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

    // Menu click methods
    public void clickMarkaKorumaMerkezi() {
        click(By.linkText("Marka Koruma Merkezi"));
    }

    public void clickMarkalar() {
        click(By.linkText("Markalar"));
    }

    public void clickIletisim() {
        click(By.linkText("İletişim"));
    }

    public void clickUyeOl() {
        click(By.linkText("Üye Ol"));
    }

    public void clickYeniUyeRehberi() {
        click(By.linkText("Yeni Üye Rehberi"));
    }

    public void clickYardim() {
        click(By.linkText("Yardım"));
    }

    public void clickOdemeSecenekleri() {
        click(By.linkText("Ödeme Seçenekleri"));
    }

    public void clickIptalIade() {
        click(By.linkText("İptal & İade"));
    }

    public void clickIslemRehberi() {
        click(By.linkText("İşlem Rehberi"));
    }

    public void clickKullaniciGuvenligi() {
        click(By.linkText("Kullanıcı Güvenliği"));
    }

    public void clickSiteHaritasi() {
        click(By.linkText("Site Haritası"));
    }

    public void clickKuponKullanimRehberi() {
        click(By.linkText("Kupon Kullanım Rehberi"));
    }

    public void clickN11InfluencerProgrami() {
        click(By.linkText("n11 Influencer Programı"));
    }

    // Product click methods
    public void clickPlaystation5() {
        click(By.linkText("PlayStation 5"));
    }

    public void clickKurutmaMakinesi() {
        click(By.linkText("Kurutma Makinesi"));
    }

    public void clickCepTelefonu() {
        click(By.linkText("Cep Telefonu"));
    }

    public void clickAirpodsKulaklik() {
        click(By.linkText("AirPods Kulaklık"));
    }

    public void clickRobotSupurge() {
        click(By.linkText("Robot Süpürge"));
    }

    public void clickIphone14() {
        click(By.linkText("iPhone 14"));
    }

    public void clickBluetoothKulaklik() {
        click(By.linkText("Bluetooth Kulaklık"));
    }

    public void clickAkilliSaat() {
        click(By.linkText("Akıllı Saat"));
    }

    public void clickAirfryerFritoz() {
        click(By.linkText("Airfryer Fritöz"));
    }

    public void clickAppleWatch() {
        click(By.linkText("Apple Watch"));
    }

    public void clickAltin() {
        click(By.linkText("Altın"));
    }

    public void clickSacDuzlestirici() {
        click(By.linkText("Saç Düzleştirici"));
    }

    public void clickAvize() {
        click(By.linkText("Avize"));
    }

    public void clickSuAritmaCihazi() {
        click(By.linkText("Su Arıtma Cihazı"));
    }

    public void clickSevgililerGunu() {
        click(By.linkText("Sevgililer Günü"));
    }

    public void clickLaptop() {
        click(By.linkText("Laptop"));
    }

    public void clickIphone15() {
        click(By.linkText("iPhone 15"));
    }

    public void clickIphone16() {
        click(By.linkText("iPhone 16"));
    }

    public void clickAppleWatch9() {
        click(By.linkText("Apple Watch 9"));
    }

    public void clickDysonHavaTemizleyici() {
        click(By.linkText("Dyson Hava Temizleyici"));
    }

    public void clickIsitici() {
        click(By.linkText("Isıtıcı"));
    }

    public void clickKahveMakinesi() {
        click(By.linkText("Kahve Makinesi"));
    }

    // Magaza click methods
    public void clickMagazaGirisi() {
        click(By.linkText("Mağaza Girişi"));
    }

    public void clickUcretsizMagazaAc() {
        click(By.linkText("Ücretsiz Mağaza Aç"));
    }

    public void clickMagazaPuanHesaplamasi() {
        click(By.linkText("Mağaza Puan Hesaplaması"));
    }

    public void clickMagazaYardimMerkezi() {
        click(By.linkText("Mağaza Yardım Merkezi"));
    }

    public void clickYeniMagazaRehberi() {
        click(By.linkText("Yeni Mağaza Rehberi"));
    }

    public void clickKargoRehberi() {
        click(By.linkText("Kargo Rehberi"));
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
