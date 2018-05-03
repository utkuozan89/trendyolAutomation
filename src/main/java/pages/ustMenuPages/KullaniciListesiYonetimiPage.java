package pages.ustMenuPages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.MainPage;
import pages.pageComponents.belgenetElements.BelgenetElement;
import pages.pageData.UstMenuData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static pages.pageComponents.belgenetElements.Belgenet.comboLov;


/****************************************************
 * Tarih: 2017-12-22
 * Proje: Türksat Functional Test Automation
 * Class: "Evrak kontroller" konulu senaryoları içerir
 * Yazan: Emre Sencan
 ****************************************************/
public class KullaniciListesiYonetimiPage extends MainPage {

    SelenideElement tabSorgulamaVeFiltreleme = $x("//a[text()='Sorgulama ve Filtreleme']//..//..//h3");
    SelenideElement lblKullaniciListeleri = $x("//label[normalize-space(text())='Kullanıcı Listeleri']");
    SelenideElement btnYeniEkle = $(By.id("kullaniciGrubuListingForm:kullaniciGrubuDataTable:kullaniciGrubuYeniKayit_id"));
    SelenideElement lblKullaniciListesiEkleme = $x("//span[normalize-space(text())='Kullanıcı Listesi Ekleme']");
    SelenideElement txtAdi = $(By.id("kullaniciGrubuEditorForm:kullaniciGrubuAd_id"));
    SelenideElement txtAciklama = $(By.id("kullaniciGrubuEditorForm:kullaniciGrubuAciklama_id"));
    BelgenetElement txtAitOlduguBirim = comboLov(By.id("kullaniciGrubuEditorForm:kullaniciGrubuBirimLov_id:LovText"));
    BelgenetElement txtKullanicilar = comboLov(By.id("kullaniciGrubuEditorForm:kullaniciGrubuKullaniciLov_id:LovText"));
    SelenideElement btnKaydet = $(By.id("kullaniciGrubuEditorForm:kullaniciGrubuKaydet_id"));
    SelenideElement btnIptal = $(By.id("kullaniciGrubuEditorForm:kullaniciGrubuKaydetIptal_id"));
    SelenideElement cmbDurum = $(By.id("kullaniciGrubuListingForm:filterPanel:durumSelectBox"));
    SelenideElement btnAra = $(By.id("kullaniciGrubuListingForm:filterPanel:kullaniciGrubuArama_id"));
    ElementsCollection tblKullaniciListesi = $$("tbody[id='kullaniciGrubuListingForm:kullaniciGrubuDataTable_data'] tr[data-ri]");
    SelenideElement btnIslemOnayıEvet = $(By.id("baseConfirmationDialog:confirmButton"));
    SelenideElement txtSorgulamaVeFiltrelemeAd = $(By.id("kullaniciGrubuListingForm:filterPanel:kullaniciGrubufilterAd_id"));

    @Step("Kullanıcı Listesi Yönetimi sayfası açılır.")
    public KullaniciListesiYonetimiPage openPage() {
        ustMenu(UstMenuData.KullaniciIslemleri.KullaniciListesiYonetimi);
        return this;
    }

    @Step("Kullanıcı Listesi Yönetimi sayfası açıldığı görülür.")
    public KullaniciListesiYonetimiPage sayfaKontrolu() {
        SelenideElement sayfa = $(By.xpath("//div[@id='window1Dialog']//span[text()='Kullanıcı Listesi Yönetimi']"));
        Assert.assertEquals(sayfa.isDisplayed(), true, "Ekran açıldı.");
        return this;
    }

    @Step("Kullanıcı Listesi Yönetimi sayfası alan kontrolü yapılır.")
    public KullaniciListesiYonetimiPage ekranAlanKontrolu() {
        Assert.assertEquals(tabSorgulamaVeFiltreleme.isDisplayed(), true, "Sorgu ve Filtrele tabı gözüküyor.");
        Assert.assertEquals(lblKullaniciListeleri.isDisplayed(), true, "Kullanıcı Listeleri alanı gözüküyor.");

        Allure.addAttachment("Kullanıcı Listesi Yönetimi : ", "Kullanıcı Listesi Yönetimi ekranının açıldığı görülür.\n" +
                "Sorgulama ve Filtreleme\n" +
                "ve\n" +
                "Kullanıcı Listeleri alanları görüntülenir");
        takeScreenshot();
        return this;
    }

    @Step("Yeni Ekle (+) butonu tıklanır.")
    public KullaniciListesiYonetimiPage yeniEkle() {
        btnYeniEkle.click();
        return this;
    }

    @Step("Kullanıcı Listesi Ekleme alan kontrolleri yapılır.")
    public KullaniciListesiYonetimiPage kullaniciListesiEklemeAlanKontrolleri() {
        Assert.assertEquals(lblKullaniciListesiEkleme.isDisplayed(), true, "Kullanıcı Lİstesi Ekleme alanı görülür.");
        Assert.assertEquals(txtAdi.isDisplayed(), true, "Adı alanı görülür.");
        Assert.assertEquals(txtAciklama.isDisplayed(), true, "Açıklama alanı görülür.");
        Assert.assertEquals(txtAitOlduguBirim.isDisplayed(), true, "Ait Olduğu alanı görülür.");
        Assert.assertEquals(txtKullanicilar.isDisplayed(), true, "Kullanıclar alanı görülür.");

        Allure.addAttachment("Kullanıcı Listesi Ekeleme : ", "Kullanıcı Listesi Ekleme ekranının açıldığı görülür.\n" +
                "Adı\n" +
                "Açıklama\n" +
                "Ait Olduğu Birim\n" +
                "Kullanıcılar alanları gelir.");

        takeScreenshot();
        return this;
    }

    @Step("Adı alanına \"{ad}\" girilir.")
    public KullaniciListesiYonetimiPage adDoldur(String ad) {
        txtAdi.sendKeys(ad);
        return this;
    }

    @Step("Adı alanı temizlenir")
    public KullaniciListesiYonetimiPage adTemizle() {
        txtAdi.clear();
        return this;
    }

    @Step("Açıklama alanı temizlenir")
    public KullaniciListesiYonetimiPage aciklamaTemizle() {
        txtAciklama.clear();
        return this;
    }

    @Step("Açıklama alanına \"{aciklama}\" girilir.")
    public KullaniciListesiYonetimiPage aciklamaDoldur(String aciklama) {
        txtAciklama.sendKeys(aciklama);
        return this;
    }

    @Step("Ait Olduğu Birim alanında \"{birim}\" seçilir.")
    public KullaniciListesiYonetimiPage birimSec(String birim) {
        txtAitOlduguBirim.selectLov(birim);
        return this;
    }

    @Step("Kullanicilar alanında \"{kullanici}\" seçilir.")
    public KullaniciListesiYonetimiPage kullanicilarSec(String kullanici) {
        txtKullanicilar.selectLov(kullanici);
        return this;
    }

    @Step("Kaydet butonuna tıklanır.")
    public KullaniciListesiYonetimiPage kaydet() {
        btnKaydet.click();
        return this;
    }

    @Step("")
    public KullaniciListesiYonetimiPage kullaniciListesiListedenCikartButonKontrolu(){

        ElementsCollection kullaniciListesi= $$("tbody[id='kullaniciGrubuEditorForm:kullaniciGrubuKullaniciLov_id:LovSecilenTable_data'] tr[data-ri]");
        for(int i = 0 ; i<kullaniciListesi.size();i++) {
            boolean display = kullaniciListesi
                    .get(i)
                    .$("span[class='ui-button-icon-left ui-icon delete-icon']").isDisplayed();
            Assert.assertEquals(display, true, "Listeden çıkart butonu mevcut");
        }
        return this;
    }

    @Step("Durum alanında \"{durum}\" seçilir.")
    public KullaniciListesiYonetimiPage durumSec(String durum) {
        cmbDurum.selectOption(durum);
        return this;
    }

    @Step("Durum alanı Kontrolü yapılır.")
    public KullaniciListesiYonetimiPage durumKontrolu(String text) {
        String text1 = cmbDurum.getText();
        System.out.println(text1);
        Assert.assertEquals(text1, text, "Durumu Sadece Aktifler seçili olarak gelmeli");
        String[] cmbTexts = cmbDurum.innerText().split("\n");
        cmbTexts[0].contains("Tümü");
        cmbTexts[1].contains("Sadece Aktifler");
        cmbTexts[2].contains("Sadece Pasifler");

        Allure.addAttachment("Durum : ", "Durum Combosunda (Tümü, Sadece Aktifler, Sadece Pasifler) seçenekleri mevcuttur. \n" +
                "Default olarak Sadece Aktifler seçili gelir.");
        return this;
    }

    @Step("Ara butonuna tıklanır.")
    public KullaniciListesiYonetimiPage ara() {
        btnAra.click();
        return this;
    }

    @Step("Kullanici Listesi tablosu kontrolü.")
    public KullaniciListesiYonetimiPage kullaniciListesiTabloKontrolu() {

        String text = cmbDurum.getText();

        if (tblKullaniciListesi.size() > 0)
            Allure.addAttachment("Tablo Kontrolü : ", text + " Kayıtlar listelenmiştir.");

        else
            Allure.addAttachment("Tablo Kontrolü : ", "Kayıt bulunamamıştır.");
        return this;
    }

    @Step("Kullanıcı Listesi tablosunda her kaydın yanında Güncelle ve Aktif/Pasif yap seçenekleri yer alır.")
    public KullaniciListesiYonetimiPage tabloAktifPasifButonKontrolu(String durum) {

//        ElementsCollection kisiselPages = $$("th[id='kullaniciGrubuListingForm:kullaniciGrubuDataTable_paginator_top'] > span[class='ui-paginator-pages'] >  span");
//
//        for(int i = 0; i<kisiselPages.size();i++){
//            kisiselPages.get(i).click();
        for (int j = 0; j < tblKullaniciListesi.size(); j++) {
            if (durum.equals("Sadece Aktifler"))
                tblKullaniciListesi.get(j)
                        .$("button[id$='kullaniciGrubuAktif_id'] [class='ui-button-icon-left ui-icon to-passive-status-icon']").shouldBe(Condition.visible);
            else
                tblKullaniciListesi.get(j)
                        .$("button[id$='kullaniciGrubuAktif_id'] [class='ui-button-icon-left ui-icon to-active-status-icon']").shouldBe(Condition.visible);
        }
//        }
        return this;
    }


    @Step("Kullanici Listesi tablosu kontrolu : \"{kullaniciAdi}\", \"{shouldBeExist}\" ")
    public KullaniciListesiYonetimiPage kullaniciListesiTablosuKullaniciAdiKontrolu(String kullaniciAdi, boolean shouldBeExist) {
        if (shouldBeExist) {
//            searchTable().searchInAllPages(true).findRows(text(kullaniciAdi)).shouldHave(CollectionCondition.sizeGreaterThan(0));
            tblKullaniciListesi
                    .filterBy(Condition.text(kullaniciAdi))
                    .shouldHave(CollectionCondition.sizeGreaterThan(0));
        } else {
//            searchTable().searchInAllPages(true).findRows(text(kullaniciAdi)).shouldHaveSize(0);
            tblKullaniciListesi
                    .filterBy(Condition.text(kullaniciAdi))
                    .shouldHaveSize(0);
        }
        return this;
    }

    @Step("Pasif Yap butonu tıklanır.")
    public KullaniciListesiYonetimiPage pasifYap(String kullaniciAdi) {

        tblKullaniciListesi
                .filterBy(text(kullaniciAdi))
                .first()
                .$("[id$=':kullaniciGrubuAktif_id']").click();
        return this;
    }

    @Step("Güncelle butonu tıklanır.")
    public KullaniciListesiYonetimiPage guncelle(String kullaniciAdi) {

        tblKullaniciListesi
                .filterBy(text(kullaniciAdi))
                .first()
                .$("button[id$=':kullaniciGrubuGuncelle_id']").click();
        return this;
    }

    @Step("Kullanıcı Listesi tablosunda her kaydın yanında Güncelle ve Aktif/Pasif yap seçenekleri yer alır.")
    public KullaniciListesiYonetimiPage tumTabloButonKontrolu() {

        ElementsCollection kisiselPages = $$("th[id='kullaniciGrubuListingForm:kullaniciGrubuDataTable_paginator_top'] > span[class='ui-paginator-pages'] >  span");


        for (int i = 0; i < kisiselPages.size(); i++) {
            kisiselPages.get(i).click();
            for (int j = 0; j < tblKullaniciListesi.size(); j++) {
                tblKullaniciListesi.get(j)
                        .$("button[id$=':kullaniciGrubuGuncelle_id']").shouldBe(Condition.visible);
                tblKullaniciListesi.get(j)
                        .$("button[id$=':kullaniciGrubuAktif_id']").shouldBe(Condition.visible);
            }
        }
        return this;
    }


    @Step("Aktif Yap butonu kontrolu")
    public KullaniciListesiYonetimiPage aktifYapButonKontrolu(String kullaniciAdi) {

        tblKullaniciListesi
                .filterBy(text(kullaniciAdi))
                .first()
                .$("[id$=':kullaniciGrubuAktif_id']").shouldBe(Condition.appear);
        return this;
    }

    @Step("Pasif Yap butonu kontrolu")
    public KullaniciListesiYonetimiPage pasifYapButonKontrolu(String kullaniciAdi) {

        tblKullaniciListesi
                .filterBy(text(kullaniciAdi))
                .first()
                .$("[id$=':kullaniciGrubuAktif_id']").shouldBe(Condition.appear);
        return this;
    }

    @Step("Aktif Yap butonu tıklanır.")
    public KullaniciListesiYonetimiPage aktifYap(String kullaniciAdi) {

        tblKullaniciListesi
                .filterBy(text(kullaniciAdi))
                .first()
                .$("[id$=':kullaniciGrubuAktif_id']").click();
        return this;
    }

    @Step("İşlem Onayı popUpı \"{butonText}\" butonuna basılarak kapatılır.")
    public KullaniciListesiYonetimiPage islemOnayiPopUpEvetHayır(String butonText,String mesaj) {
        SelenideElement btnKapat = $(By.xpath("//div[@id='baseConfirmationDialog:dialog']//span[text()='" + butonText + "']//..//..//button"));
        SelenideElement popupMesaj = $(By.xpath("//div[@id='baseConfirmationDialog:dialog']//div[@class='content']"));
        Assert.assertEquals(popupMesaj.text().equals(mesaj),true,"iki mesajda eşit");

       btnKapat.click();
        return this;
    }

    @Step("Sorgula ve Filtrele Ad alanına \"{kullaniciAdi}\" girilir.")
    public KullaniciListesiYonetimiPage sorgulaVeFiltreleAdDoldur(String kullaniciAdi) {
        txtSorgulamaVeFiltrelemeAd.sendKeys(kullaniciAdi);
        return this;
    }

    @Step("Sorgula ve Filtrele Ad alanına temizlenir.")
    public KullaniciListesiYonetimiPage sorgulaVeFiltreleAdTemizle() {
        txtSorgulamaVeFiltrelemeAd.clear();
        return this;
    }

    @Step("Sorgula ve Filtrele tabı açılır.")
    public KullaniciListesiYonetimiPage sorgulaVeFiltreleTabAc() {
        tabSorgulamaVeFiltreleme.click();
        return this;
    }
}
