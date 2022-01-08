package com.gittigidiyor.step_definitions;

import com.gittigidiyor.pages.*;
import com.gittigidiyor.utilities.BrowserUtils;
import com.gittigidiyor.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class MyStepDefs {
    HomePage homePage = new HomePage();
    AramaSonuclariSayfasi aramaSonuclariSayfasi = new AramaSonuclariSayfasi();
    IkinciSayfa ikinciSayfa = new IkinciSayfa();
    SecilenUrunSayfasi secilenUrunSayfasi = new SecilenUrunSayfasi();
    SepetimSayfasi sepetimSayfasi = new SepetimSayfasi();
    String urunFiyati = "";
    String urunOzellikleri = "";

    @Given("{string} sitesi acilir")
    public void sitesiAcilir(String adres) {

        Driver.get().get(adres);
    }

    @And("arama kutucuguna {string} kelimesi girilir")
    public void aramaKutucugunaKelimesiGirilir(String aranacakKelime) {

        homePage.cookies.click();
        homePage.aramaKutusu.sendKeys(aranacakKelime + Keys.ENTER);
    }

    @And("arama sonuclari sayfasindan {int}.sayfa acilir")
    public void aramaSonuclariSayfasindanSayfaAcilir(int arg0) {

        BrowserUtils.scrollToElement(aramaSonuclariSayfasi.sayfa2);
        aramaSonuclariSayfasi.sayfa2.click();
    }

    @And("{int}. sayfanin acildigi kontrol edilir")
    public void sayfaninAcildigiKontrolEdilir(int arg0) {

        String expectedUrl = "https://www.gittigidiyor.com/arama?k=bilgisayar&sf=2";
        String currentUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,currentUrl);
    }

    @And("sonuca gore sergilenen urunlerden rastgele bir urun secilir")
    public void sonucaGoreSergilenenUrunlerdenRastgeleBirUrunSecilir() {

        BrowserUtils.waitFor(3);
        ikinciSayfa.secilecekUrun.click();
    }

    @And("secilen urunun urun bilgisi ve tutar bilgisi txt dosyasina yazilir")
    public void secilenUrununUrunBilgisiVeTutarBilgisiTxtDosyasinaYazilir() {

        urunOzellikleri = secilenUrunSayfasi.urunOzellikleri.getText();
        urunFiyati = secilenUrunSayfasi.urunFiyati.getText();

        secilenUrunSayfasi.writeTextFile(urunOzellikleri);
        secilenUrunSayfasi.writeTextFile(urunFiyati);
    }

    @And("secilen urun sepete eklenir")
    public void secilenUrunSepeteEklenir() {

        BrowserUtils.waitFor(3);
        BrowserUtils.scrollToElement(secilenUrunSayfasi.sepeteEkle);
        secilenUrunSayfasi.sepeteEkle.click();
        secilenUrunSayfasi.sepeteGit.click();
    }

    @And("urun sayfasindaki fiyat ile sepette yer alan urun fiyatinin dogrulugu karsilastirilir")
    public void urunSayfasindakiFiyatIleSepetteYerAlanUrunFiyatininDogruluguKarsilastirilir() {

        String sepettekiFiyat = sepetimSayfasi.sepettekiFiyat.getText();
        Assert.assertEquals(urunFiyati,sepettekiFiyat);
    }

    @And("adet arttirilarak urun adedinin {int} oldugu dogrulanir")
    public void adetArttirilarakUrunAdedininOlduguDogrulanir(int arg0) {

        Select urunSayisi = new Select(sepetimSayfasi.urunSayisiDropdown);
        urunSayisi.selectByVisibleText("2");
        BrowserUtils.waitFor(2);
        String adetKontrol = sepetimSayfasi.fiyatKontrol.getText();
        String sonAdet = adetKontrol.substring(14, 15);
        Assert.assertEquals(2,Integer.parseInt(sonAdet));
    }

    @Then("urun sepetten silinerek sepetin bos oldugu kontrol edilir")
    public void urunSepettenSilinerekSepetinBosOlduguKontrolEdilir() {

        sepetimSayfasi.silButonu.click();
        BrowserUtils.waitFor(2);
        String actualSepetBosMesaji = sepetimSayfasi.sepetBosMesaji.getText();
        String expectedMesaj = "Sepetinizde ürün bulunmamaktadır.";
        Assert.assertEquals(expectedMesaj,actualSepetBosMesaji);
    }
}
