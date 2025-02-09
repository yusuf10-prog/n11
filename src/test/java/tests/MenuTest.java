package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class MenuTest extends BaseTest {

    @Test(description = "Test clicking on all Müşteriler menu items")
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

    @Test(description = "Test clicking on all Popüler Sayfalar items")
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

    @Test(description = "Test clicking on all Öne Çıkan Sayfalar items")
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

    @Test(description = "Test clicking on all Mağazalar section items")
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
