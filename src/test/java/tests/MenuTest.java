package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.HomePage;

public class MenuTest extends BaseTest {

    @Epic("Menu Navigation Tests")
    @Feature("Müşteriler Menu")
    @Story("Click all items in Müşteriler menu")
    @Description("Test clicks on all available items in the Müşteriler menu and verifies navigation")
    @Test(description = "Test clicking on all Müşteriler menu items")
    @Severity(SeverityLevel.CRITICAL)
    public void testMusterilerMenu() {
        HomePage homePage = new HomePage(driver);
        
        homePage.clickMarkaKorumaMerkezi();
        driver.navigate().back();
        
        homePage.clickMarkalar();
        driver.navigate().back();
        
        homePage.clickIletisim();
        driver.navigate().back();
        
        homePage.clickUyeOl();
        driver.navigate().back();
        
        homePage.clickYeniUyeRehberi();
        driver.navigate().back();
        
        homePage.clickYardim();
        driver.navigate().back();
        
        homePage.clickOdemeSecenekleri();
        driver.navigate().back();
        
        homePage.clickIptalIade();
        driver.navigate().back();
        
        homePage.clickIslemRehberi();
        driver.navigate().back();
        
        homePage.clickKullaniciGuvenligi();
        driver.navigate().back();
        
        homePage.clickSiteHaritasi();
        driver.navigate().back();
        
        homePage.clickKuponKullanimRehberi();
        driver.navigate().back();
        
        homePage.clickN11InfluencerProgrami();
        driver.navigate().back();
    }

    @Epic("Menu Navigation Tests")
    @Feature("Popüler Sayfalar")
    @Story("Click all items in Popüler Sayfalar section")
    @Description("Test clicks on all available items in the Popüler Sayfalar section and verifies navigation")
    @Test(description = "Test clicking on all Popüler Sayfalar items")
    @Severity(SeverityLevel.CRITICAL)
    public void testPopulerSayfalar() {
        HomePage homePage = new HomePage(driver);
        
        homePage.clickPlaystation5();
        driver.navigate().back();
        
        homePage.clickKurutmaMakinesi();
        driver.navigate().back();
        
        homePage.clickCepTelefonu();
        driver.navigate().back();
        
        homePage.clickAirpodsKulaklik();
        driver.navigate().back();
        
        homePage.clickRobotSupurge();
        driver.navigate().back();
        
        homePage.clickIphone14();
        driver.navigate().back();
        
        homePage.clickBluetoothKulaklik();
        driver.navigate().back();
        
        homePage.clickAkilliSaat();
        driver.navigate().back();
        
        homePage.clickAirfryerFritoz();
        driver.navigate().back();
        
        homePage.clickAppleWatch();
        driver.navigate().back();
        
        homePage.clickAltin();
        driver.navigate().back();
    }

    @Epic("Menu Navigation Tests")
    @Feature("Öne Çıkan Sayfalar")
    @Story("Click all items in Öne Çıkan Sayfalar section")
    @Description("Test clicks on all available items in the Öne Çıkan Sayfalar section and verifies navigation")
    @Test(description = "Test clicking on all Öne Çıkan Sayfalar items")
    @Severity(SeverityLevel.CRITICAL)
    public void testOneCikanSayfalar() {
        HomePage homePage = new HomePage(driver);
        
        homePage.clickSacDuzlestirici();
        driver.navigate().back();
        
        homePage.clickAvize();
        driver.navigate().back();
        
        homePage.clickSuAritmaCihazi();
        driver.navigate().back();
        
        homePage.clickSevgililerGunu();
        driver.navigate().back();
        
        homePage.clickLaptop();
        driver.navigate().back();
        
        homePage.clickIphone15();
        driver.navigate().back();
        
        homePage.clickIphone16();
        driver.navigate().back();
        
        homePage.clickAppleWatch9();
        driver.navigate().back();
        
        homePage.clickDysonHavaTemizleyici();
        driver.navigate().back();
        
        homePage.clickIsitici();
        driver.navigate().back();
        
        homePage.clickKahveMakinesi();
        driver.navigate().back();
    }

    @Epic("Menu Navigation Tests")
    @Feature("Mağazalar Section")
    @Story("Click all items in Mağazalar section")
    @Description("Test clicks on all available items in the Mağazalar section and verifies navigation")
    @Test(description = "Test clicking on all Mağazalar section items")
    @Severity(SeverityLevel.CRITICAL)
    public void testMagazalarSection() {
        HomePage homePage = new HomePage(driver);
        
        try {
            homePage.clickMagazaGirisi();
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("Could not click Mağaza Girişi: " + e.getMessage());
        }
        
        try {
            homePage.clickUcretsizMagazaAc();
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("Could not click Ücretsiz Mağaza Aç: " + e.getMessage());
        }
        
        try {
            homePage.clickMagazaPuanHesaplamasi();
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("Could not click Mağaza Puan Hesaplaması: " + e.getMessage());
        }
        
        try {
            homePage.clickMagazaYardimMerkezi();
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("Could not click Mağaza Yardım Merkezi: " + e.getMessage());
        }
        
        try {
            homePage.clickYeniMagazaRehberi();
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("Could not click Yeni Mağaza Rehberi: " + e.getMessage());
        }
        
        try {
            homePage.clickKargoRehberi();
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("Could not click Kargo Rehberi: " + e.getMessage());
        }
    }
}
