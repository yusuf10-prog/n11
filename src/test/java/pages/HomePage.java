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
    
    // Müşteriler menu locators
    private final By markaKorumaMerkeziBy = By.linkText("Marka Koruma Merkezi");
    private final By markalarBy = By.linkText("Markalar");
    private final By iletisimBy = By.linkText("İletişim");
    private final By uyeOlBy = By.linkText("Üye Ol");
    private final By yeniUyeRehberiBy = By.linkText("Yeni Üye Rehberi");
    private final By yardimBy = By.linkText("Yardım");
    private final By odemeSecenekleriBy = By.linkText("Ödeme Seçenekleri");
    private final By iptalIadeBy = By.linkText("İptal & İade");
    private final By islemRehberiBy = By.linkText("İşlem Rehberi");
    private final By kullaniciGuvenligiBy = By.linkText("Kullanıcı Güvenliği");
    private final By siteHaritasiBy = By.linkText("Site Haritası");
    private final By kuponKullanimRehberiBy = By.linkText("Kupon Kullanım Rehberi");
    private final By n11InfluencerProgramiBy = By.linkText("n11 Influencer Programı");
    
    // Popüler Sayfalar locators
    private final By playstation5By = By.linkText("Playstation 5");
    private final By kurutmaMakinesiBy = By.linkText("Kurutma Makinesi");
    private final By cepTelefonuBy = By.linkText("Cep Telefonu");
    private final By airpodsKulaklikBy = By.linkText("Airpods Kulaklık");
    private final By robotSupurgeBy = By.linkText("Robot Süpürge");
    private final By iphone14By = By.linkText("iPhone 14");
    private final By bluetoothKulaklikBy = By.linkText("Bluetooth Kulaklık");
    private final By akilliSaatBy = By.linkText("Akıllı Saat");
    private final By airfryerFritozBy = By.linkText("Airfryer/Fritöz");
    private final By appleWatchBy = By.linkText("Apple Watch");
    private final By altinBy = By.linkText("Altın");
    
    // Öne Çıkan Sayfalar locators
    private final By sacDuzlestiriciBy = By.linkText("Saç Düzleştirici");
    private final By avizeBy = By.linkText("Avize");
    private final By suAritmaCihaziBy = By.linkText("Su Arıtma Cihazı");
    
    // Sosyal Medya İkonları locators
    private final By facebookIconBy = By.cssSelector("a[href*='facebook.com']");
    private final By twitterIconBy = By.cssSelector("a[href*='twitter.com']");
    private final By instagramIconBy = By.cssSelector("a[href*='instagram.com']");
    private final By youtubeIconBy = By.cssSelector("a[href*='youtube.com']");
    private final By pinterestIconBy = By.cssSelector("a[href*='pinterest.com']");
    
    private final By sevgililerGunuBy = By.linkText("Sevgililer Günü");
    private final By laptopBy = By.linkText("Laptop");
    private final By iphone15By = By.linkText("iPhone 15");
    private final By iphone16By = By.linkText("iPhone 16");
    private final By appleWatch9By = By.linkText("Apple Watch 9");
    private final By dysonHavaTemizleyiciBy = By.linkText("Dyson Hava Temizleyici");
    private final By isiticiBy = By.linkText("Isıtıcı");
    private final By kahveMakinesiBy = By.linkText("Kahve Makinesi");
    
    // Mağazalar section locators
    private final By magazaGirisiBy = By.linkText("Mağaza Girişi");
    private final By ucretsizMagazaAcBy = By.linkText("Ücretsiz Mağaza Aç");
    private final By magazaPuanHesaplamasiBy = By.linkText("Mağaza Puan Hesaplaması");
    private final By magazaYardimMerkeziBy = By.linkText("Mağaza Yardım Merkezi");
    private final By yeniMagazaRehberiBy = By.linkText("Yeni Mağaza Rehberi");
    private final By kargoRehberiBy = By.linkText("Kargo Rehberi");
    
    // Footer locators
    private final By footerMenuBy = By.cssSelector(".footer__middle");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public void clickFacebookIcon() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(facebookIconBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    
    public void clickTwitterIcon() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(twitterIconBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    
    public void clickInstagramIcon() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(instagramIconBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    
    public void clickYoutubeIcon() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(youtubeIconBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    
    public void clickPinterestIcon() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(pinterestIconBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // Müşteriler menu methods
    public void clickMarkaKorumaMerkezi() { click(markaKorumaMerkeziBy); }
    public void clickMarkalar() { click(markalarBy); }
    public void clickIletisim() { click(iletisimBy); }
    public void clickUyeOl() { click(uyeOlBy); }
    public void clickYeniUyeRehberi() { click(yeniUyeRehberiBy); }
    public void clickYardim() { click(yardimBy); }
    public void clickOdemeSecenekleri() { click(odemeSecenekleriBy); }
    public void clickIptalIade() { click(iptalIadeBy); }
    public void clickIslemRehberi() { click(islemRehberiBy); }
    public void clickKullaniciGuvenligi() { click(kullaniciGuvenligiBy); }
    public void clickSiteHaritasi() { click(siteHaritasiBy); }
    public void clickKuponKullanimRehberi() { click(kuponKullanimRehberiBy); }
    public void clickN11InfluencerProgrami() { click(n11InfluencerProgramiBy); }

    // Popüler Sayfalar methods
    public void clickPlaystation5() { click(playstation5By); }
    public void clickKurutmaMakinesi() { click(kurutmaMakinesiBy); }
    public void clickCepTelefonu() { click(cepTelefonuBy); }
    public void clickAirpodsKulaklik() { click(airpodsKulaklikBy); }
    public void clickRobotSupurge() { click(robotSupurgeBy); }
    public void clickIphone14() { click(iphone14By); }
    public void clickBluetoothKulaklik() { click(bluetoothKulaklikBy); }
    public void clickAkilliSaat() { click(akilliSaatBy); }
    public void clickAirfryerFritoz() { click(airfryerFritozBy); }
    public void clickAppleWatch() { click(appleWatchBy); }
    public void clickAltin() { click(altinBy); }

    // Öne Çıkan Sayfalar methods
    public void clickSacDuzlestirici() { click(sacDuzlestiriciBy); }
    public void clickAvize() { click(avizeBy); }
    public void clickSuAritmaCihazi() { click(suAritmaCihaziBy); }
    public void clickSevgililerGunu() { click(sevgililerGunuBy); }
    public void clickLaptop() { click(laptopBy); }
    public void clickIphone15() { click(iphone15By); }
    public void clickIphone16() { click(iphone16By); }
    public void clickAppleWatch9() { click(appleWatch9By); }
    public void clickDysonHavaTemizleyici() { click(dysonHavaTemizleyiciBy); }
    public void clickIsitici() { click(isiticiBy); }
    public void clickKahveMakinesi() { click(kahveMakinesiBy); }

    // Mağazalar section methods
    public void clickMagazaGirisi() { click(magazaGirisiBy); }
    public void clickUcretsizMagazaAc() { click(ucretsizMagazaAcBy); }
    public void clickMagazaPuanHesaplamasi() { click(magazaPuanHesaplamasiBy); }
    public void clickMagazaYardimMerkezi() { click(magazaYardimMerkeziBy); }
    public void clickYeniMagazaRehberi() { click(yeniMagazaRehberiBy); }
    public void clickKargoRehberi() { click(kargoRehberiBy); }
    private final By socialMediaLinksBy = By.cssSelector(".footer__social a");

    public void searchProduct(String keyword) {
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(searchBoxBy));
        searchBox.clear();
        searchBox.sendKeys(keyword);
        wait.until(ExpectedConditions.elementToBeClickable(searchButtonBy)).click();
    }

    public void clickCartIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIconBy)).click();
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
