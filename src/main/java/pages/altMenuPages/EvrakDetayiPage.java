package pages.altMenuPages;

import com.codeborne.selenide.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.MainPage;
import pages.pageComponents.TextEditor;
import pages.pageComponents.belgenetElements.BelgenetElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static pages.pageComponents.belgenetElements.Belgenet.comboLov;

public class EvrakDetayiPage extends MainPage {

    SelenideElement pageTitle = $(By.xpath("//span[. = 'Evrak Detayı' and @class = 'ui-dialog-title']"));
    ElementsCollection txtkonuKodu = $$("[id^='inboxItemInfoForm:evrakBilgileriList'][id$='konuKoduLov:lovContainer']");
    SelenideElement txtkonu = $("[id$='konuTextArea']");
    ElementsCollection secilenKaldirilicakKlasor = $$("[id$='eklenecekKlasorlerLov:LovSecilenTable_data']");
    SelenideElement cmbEvrakTuru = $("[id$='evrakTuruCombo']");
    SelenideElement cmbGizlilik = $("[id$='guvenlikKodu']");
    ElementsCollection cmbGeregiSecilen = $$("[id$='geregiLov:LovSecilenTable_data']");
    SelenideElement btnTebellugEt = $("button .tebellugEt");
    SelenideElement btnPanelHayir = $(By.id("mainInboxForm:tebellugEtHayirButton"));
    SelenideElement dialogTabMenuRight = $(By.id("inboxItemInfoForm:dialogTabMenuRight:dialogTabMenuRight"));
    SelenideElement btnTeslimAl = $(By.id("inboxItemInfoForm:dialogTabMenuRight:uiRepeat:4:cmdbutton"));
    SelenideElement btnEvrakGoster = $(By.id("inboxItemInfoForm:dialogTabMenuRight:uiRepeat:3:cmdbutton"));
    SelenideElement btnHavaleYap = $("[id^='inboxItemInfoForm:dialogTabMenuRight:uiRepeat'] [class$='havaleEt']");
    SelenideElement btnTebligEt = $("[id^='inboxItemInfoForm:dialogTabMenuRight:uiRepeat'] [class$='tebligEt']");
    SelenideElement btnIadeEt = $("[id^='inboxItemInfoForm:dialogTabMenuRight:uiRepeat'] [class$='iadeEt']");
    SelenideElement btnCevapYaz = $("[id^='inboxItemInfoForm:dialogTabMenuRight:uiRepeat'] [class$='cevapYaz']");
    SelenideElement btnEvrakKapat = $("[id^='inboxItemInfoForm:dialogTabMenuRight:uiRepeat'] [class$='evrakKapat']");
    SelenideElement btnSil = $("[id^='inboxItemInfoForm:dialogTabMenuRight:uiRepeat'] [class$='evrakSil']");
    SelenideElement divContainer = $("#evrakBilgileriContainerDiv");
    SelenideElement spanBilgileri = $x("//span[. = 'Bilgileri']");
    SelenideElement tabEditor = $("button .editor");
    ElementsCollection tblHareketGecmisi = $$("tbody[id$='hareketGecmisiDataTable_data'] > tr[role='row']");
    SelenideElement btnKaydet = $("span[class='ui-button-icon-left ui-icon kaydet']");
    SelenideElement btnKaydetEvet = $(By.id("kaydetConfirmForm:kaydetEvetButton"));
    SelenideElement btnKaydetHayir = $(By.id("kaydetConfirmForm:kaydetHayirButton"));

    SelenideElement evrakDetayi = $(By.xpath("//div[@id='windowItemInfoDialog']//span[.='Evrak Detayı']"));

    SelenideElement txtAciklama = $(By.id("inboxItemInfoForm:onayIslemiAciklama"));
    SelenideElement btnGonder = $(By.id("inboxItemInfoForm:gonderButton"));
    SelenideElement btnHavaleOnayinaGonder = $(By.xpath("//span[text()='Havale Onayına Gönder']//..//..//button[2]"));
    SelenideElement btnGonder2 = $(By.xpath("//span[text()='Gönder']//..//..//button"));

    SelenideElement txtSilmeNotu = $("[id^='inboxItemInfoForm:j_idt'] [class*=' ui-inputtextarea']");
    SelenideElement btnEvrakNotSil = $("[class='form-buttons'] [id^='inboxItemInfoForm:j_idt']");

    BelgenetElement txtKullaniciListesi = comboLov(By.id("inboxItemInfoForm:dagitimBilgileriKisiListesiLov:LovText"));
    BelgenetElement txtOnaylayacakKisi = comboLov(By.id("inboxItemInfoForm:onaylayacakKisiLov:LovText"));
    BelgenetElement txtTebligEtKullniciListesi = comboLov(By.id("inboxItemInfoForm:kullaniciGrubuLov_id:LovText"));
    SelenideElement btnEvrakDetayiClose = $("div[id='windowItemInfoDialog'] span[class='ui-icon ui-icon-closethick']");
    SelenideElement btnIadeEt2 = $(By.id("inboxItemInfoForm:iadeEtButton_id"));
    SelenideElement btnTeslimAlPopup = $(By.id("teslimAlEvetButton"));

    BelgenetElement txtHavaleYapBirim = comboLov(By.id("inboxItemInfoForm:dagitimBilgileriBirimLov:LovText"));
    SelenideElement btnDetay = $("[id$='inboxItemInfoForm:dagitimBilgileriKisiListesiLov:LovSecilenTable:0:']");
    ElementsCollection tblKullaniciGrupDetay = $$("[id='inboxItemInfoForm:kullaniciGrubuDetay_data'] tr[data-ri]");
    SelenideElement btnKullaniciGrupDetayKullan = $(By.id("inboxItemInfoForm:kullaniciGrubuDetayKullanViewDialog"));
    SelenideElement btnKullaniciGrupDetayEkraniKapat = $("div[id$='kullaniciGrubuDetayViewDialog'] span[class='ui-icon ui-icon-closethick']");

    //otomatik havale  kontrol içerikten
    SelenideElement txtIcerikBirimKontrol = $(By.id("inboxItemInfoForm:dagitimBilgileriBirimLov:LovText"));
    SelenideElement txtIcerikKisiKontrol = $(By.id("inboxItemInfoForm:dagitimBilgileriKullaniciLov:LovText"));
    SelenideElement txtIcerikKullanıcıListeKontrol = $(By.id("inboxItemInfoForm:dagitimBilgileriKisiListesiLov:LovText"));
    SelenideElement txtIcerikAciklamaKontrol = $(By.id("inboxItemInfoForm:havaleAciklama"));
    SelenideElement txtTeslimAlinmayiIcerikAciklamaKontrol = $(By.id("inboxItemInfoForm:aciklamaInputText"));
    SelenideElement btnIcerikDosyaEkleKontrol = $(By.id("inboxItemInfoForm:fileUploadHavaleEk"));
    SelenideElement btnTeslimAlinmayiIcerikDosyaEkleKontrol = $(By.id("inboxItemInfoForm:fileUploadTeslimAlHavaleEk"));
    SelenideElement txtIcerikIslemSureKontrol = $(By.id("inboxItemInfoForm:islemSuresiTarih_input"));
    SelenideElement txtTeslimAlinmayiIcerikIslemSureKontrol = $(By.id("inboxItemInfoForm:islemSuresiTarihTeslimAlHavaleEt_input"));
    SelenideElement btnIcerikHavaleOnayinaGonder = $(By.xpath("//*[contains(text(),'Havale Onayına Gönder')]"));
    SelenideElement btnIcerikHavaleGonder = $("[class$='havaleGonderButonClass']");
    SelenideElement btnIcerikTeslimAlGonder = $(By.xpath("//*[contains(text(),'Teslim Al Gönder')]"));
    SelenideElement btnIcerikVazgec = $(By.id("inboxItemInfoForm:teslimAlHavaleEtVazgecButton"));

    BelgenetElement txtIcerikHavaleYapKisi = comboLov(By.id("inboxItemInfoForm:dagitimBilgileriKullaniciLov:LovText"));


    private HareketGecmisiTab hareketGecmisiTab = new HareketGecmisiTab();
    private EditorTab editorTab = new EditorTab();
    private BilgileriTab bilgileriTab = new BilgileriTab();
    private EkleriTab ekleriTab = new EkleriTab();
    private IlgileriTab ilgileriTab = new IlgileriTab();

    @Step("Sayfa geldiği kontrol edilir.")
    public EvrakDetayiPage sayfaAcilmali() {
        Assert.assertEquals(pageTitle.is(visible), true);
        return this;
    }


    @Step("Editör tab aç")
    public EditorTab editorTaAc() {
        return editorTab.open();
    }

    @Step("Bilgiler tab aç")
    public BilgileriTab bilgileriTabAc() {
        return bilgileriTab.open();
    }

    @Step("Ekleri tab aç")
    public EkleriTab ekleriTabAc() {
        return ekleriTab.open();
    }

    @Step("İlgileri tab aç")
    public IlgileriTab ilgileriTabAc() {
        return ilgileriTab.open();
    }

    @Step("Hareket Geçmisi tab aç")
    public HareketGecmisiTab hareketGecmisiTabAc() {
        return hareketGecmisiTab.open();
    }

    @Step("Tebliğ geçmişi tab aç")
    public TebligGecmisiTab tebligGecmisiTabAc() {
        return new TebligGecmisiTab().open();
    }

    @Step("Tebellüğ Et butonuna tıkla.")
    public EvrakDetayiPage tebellugEt(boolean onay) {
        Selenide.sleep(5000);
        btnTebellugEt.waitUntil(visible, 5000);
        btnTebellugEt.click();

        if (onay == true)
            $$(By.id("mainInboxForm:tebellugEtEvetButton")).last().click();
        else
            btnPanelHayir.click();


        return this;
    }

    @Step("\"{text}\" butonu tıklanır.")
    public EvrakDetayiPage btnTikla(String text) {
        SelenideElement btn = $(By.xpath("descendant::*[text()='" + text + "']/ancestor::tbody[1]//button"));
        btn.click();
        return this;
    }

    @Step("Evrak Önizleme buton kontrolü. Buton Name : \"{btnText}\", Ekranda bulunuyor mu : {shoulBeDisplay} ")
    public EvrakDetayiPage havaleYapKisiAlanindaButonKontrolu(String btnText, boolean shoulBeDisplay) {
        SelenideElement btnEvrakOnizleme = $(By.xpath("//table[@id='inboxItemInfoForm:kisiLovContainer']//span[text()='" + btnText + "']"));
        if (shoulBeDisplay)
            Assert.assertEquals(btnEvrakOnizleme.isDisplayed(), true);
        else
            Assert.assertEquals(btnEvrakOnizleme.isDisplayed(), false);
        return this;
    }

    @Step("Evrak Önizleme buton kontrolü. Buton Name : \"{btnText}\", Ekranda bulunuyor mu : {shoulBeDisplay} ")
    public EvrakDetayiPage havaleYapKisiAlanindaButonTikla(String btnText) {
        SelenideElement btnEvrakOnizleme = $(By.xpath("//table[@id='inboxItemInfoForm:kisiLovContainer']//span[text()='" + btnText + "']"));
        btnEvrakOnizleme.click();
        return this;
    }

    @Step("Evrak Önizleme buton kontrolü. Buton Name : \"{btnText}\", Ekranda bulunuyor mu : {shoulBeDisplay} ")
    public EvrakDetayiPage havaleYapBirimAlanindaButonKontrolu(String btnText, boolean shoulBeDisplay) {
        SelenideElement btnEvrakOnizleme = $(By.xpath("//table[@id='inboxItemInfoForm:birimLovContainer']//span[text()='" + btnText + "']"));
        if (shoulBeDisplay)
            Assert.assertEquals(btnEvrakOnizleme.isDisplayed(), true);
        else
            Assert.assertEquals(btnEvrakOnizleme.isDisplayed(), false);
        return this;
    }

    @Step("Evrak Önizleme buton tıklanır. Buton Name : \"{btnText}\" ")
    public EvrakDetayiPage havaleYapBirimAlanindaButonTikla(String btnText) {
        SelenideElement btnEvrakOnizleme = $(By.xpath("//table[@id='inboxItemInfoForm:birimLovContainer']//span[text()='" + btnText + "']"));
        btnEvrakOnizleme.click();
        return this;
    }

    @Step("\"{text}\" butonu kontrolu. Ekranda görünüyor mu : {shoulBeExist} ")
    public EvrakDetayiPage butonKontrolu(String text, boolean shoulBeExist) {
        SelenideElement btn = $(By.xpath("descendant::*[text()='" + text + "']/ancestor::tbody[1]//button"));
        if (shoulBeExist)
            Assert.assertEquals(btn.isDisplayed(), true);
        else
            Assert.assertEquals(btn.isDisplayed(), false);
        return this;
    }

    @Step("Kullanici Listesinde detay butonuna tıklanır.")
    public EvrakDetayiPage kullaniciListesiDetay() {
        ElementsCollection tblKullaniciListesi = $$("[id='inboxItemInfoForm:dagitimBilgileriKisiListesiLov:LovSecilenTable_data'] tr[data-ri]");
        tblKullaniciListesi
                .first()
                .$("tr:nth-child(2) button").click();
//        btnDetay.click();
        return this;
    }

    @Step("Kullanici Listesinde detay butonuna tıklanır.")
    public EvrakDetayiPage tebligEtKullaniciListesiDetay() {
//        ElementsCollection tblKullaniciListesi = $$("[id='inboxItemInfoForm:kullaniciGrubuLov_id:LovSecilenTable_data'] tr[data-ri]");
//        tblKullaniciListesi
//                .first()
//                .$("tr:nth-child(2) button").click();
        $("[id='inboxItemInfoForm:kullaniciGrubuLov_id:LovSecilenTable_data'] tbody tbody tr:nth-child(2) button").click();
        return this;
    }


    @Step("Kullanici Grup Detay tablosunda \"{kullanici}\" kontrolü yapılır.")
    public EvrakDetayiPage kullaniciGrupDetayKontrol(String kullanici) {
        tblKullaniciGrupDetay
                .filterBy(text(kullanici))
                .shouldHaveSize(1);
        return this;
    }

    @Step("Kullanici Grup Detay ekranı kapatılır.")
    public EvrakDetayiPage kullaniciGrupDetayEkraniKapat() {
        btnKullaniciGrupDetayEkraniKapat.click();
        return this;
    }

    @Step("Kullanici Grup Detay ekran kontrolü yapılır.")
    public EvrakDetayiPage tebligEtKullaniciGrupDetayKontrol() {
        SelenideElement popUpKullaniciGrupDetay = $(By.id("inboxItemInfoForm:tebligKullaniciGrubuDetayViewDialog"));
        Assert.assertEquals(popUpKullaniciGrupDetay.isDisplayed(), true, "Kullanıcı Grup Detay popupı gelir.");
        return this;
    }

    @Step("Kullanici Grup Detay ekranı kapatılır.")
    public EvrakDetayiPage tebligEtKullaniciGrupDetayEkraniKapat() {
        $(By.id("inboxItemInfoForm:kullaniciGrubuDetayKapatViewDialog")).click();
        return this;
    }

    @Step("Kullanici Grup Detay tablosunda checkbox kontrolü yapılır.")
    public EvrakDetayiPage kullaniciGrupDetayCheckBoxKontrolu(boolean shoulBeSelected) {
        tblKullaniciGrupDetay.size();
        for (int i = 0; i < tblKullaniciGrupDetay.size(); i++) {
            if (shoulBeSelected) {
                Assert.assertEquals(tblKullaniciGrupDetay
                        .get(i)
                        .$("div[class$='ui-state-active']").isDisplayed(), true);
                Allure.addAttachment("checkbox kontrol", "Seçili.");
            } else
                Allure.addAttachment("checkbox kontrol", "Seçili değil.");
        }
        takeScreenshot();

        return this;
    }

    @Step("Kullanici Grup Detay tablosunda checkbox seçimi. \"{shouldBeSelect}\" ")
    public EvrakDetayiPage kullaniciGrupDetayCheckBoxSecimi(String kullanici, boolean shouldBeSelect) {
        tblKullaniciGrupDetay.size();
        if (shouldBeSelect) {
            if (tblKullaniciGrupDetay.filterBy(text(kullanici)).first().$("div[class$='ui-state-active']").isDisplayed())
                Allure.addAttachment("checkbox", "Seçili");
            else {
                tblKullaniciGrupDetay
                        .filterBy(text(kullanici)).first()
                        .$("div[class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']").click();
            }
        } else {
            if (tblKullaniciGrupDetay.filterBy(text(kullanici)).first().$("div[class$='ui-state-active']").isDisplayed()) {
                tblKullaniciGrupDetay
                        .filterBy(text(kullanici)).first()
                        .$("div[class$='ui-state-active']").click();
            } else {
                Allure.addAttachment("checkbox", "Seçili değil");
            }
        }
        return this;
    }


    @Step("Kullanici Grup Detay ekranında Kullan butonu tıklanır.")
    public EvrakDetayiPage kullaniciGrupDetayKullan() {
        clickJs(btnKullaniciGrupDetayKullan);
        return this;
    }

    @Step("Kaydet")
    public EvrakDetayiPage kaydet() {
        btnKaydet.click();
        return this;
    }

    @Step("Evet tıklanır")
    public EvrakDetayiPage kaydetEvet() {
        btnKaydetEvet.click();
        return this;
    }

    @Step("Kaydet")
    public EvrakDetayiPage kaydet(boolean save) {
        btnKaydet.click();
        if (save)
            btnKaydetEvet.click();
        else
            btnKaydetHayir.click();
        return this;
    }

    @Step("Evrak Teslim Al popupı kapatılır. ")
    public EvrakDetayiPage evrakTeslimAlPopUpEvet() {
        btnTeslimAlPopup.click();
        return this;
    }

    @Step("Açıklama girilir.")
    public EvrakDetayiPage kaydetVeOnayaSunAciklama(String aciklama) {
        txtAciklama.sendKeys(aciklama);
        return this;
    }

    @Step("Gönder butonu tıklanır.")
    public EvrakDetayiPage iadeEt() {
        btnIadeEt2.click();
        return this;
    }


    @Step("Gönder butonu tıklanır.")
    public EvrakDetayiPage gonder() {
        btnGonder.click();
        return this;
    }

    @Step("Havale Yap ekranında Gönder butonu tıklanır.")
    public EvrakDetayiPage havaleYapGonder() {
        btnGonder2.click();
        return this;
    }

    @Step("Havale Yap ekranında Havele Onayına Gönder butonu tıklanır.")
    public EvrakDetayiPage havaleYapHavaleOnayınaGonder() {
        btnHavaleOnayinaGonder.click();
        return this;
    }

    @Step("Havale Yap ekranında Havele Onayına Gönder butonu tıklanır.")
    public EvrakDetayiPage havaleYapButon(String buttonName) {
        SelenideElement button = $(By.xpath("//button//span[text()='" + buttonName + "']//.."));
        button.click();
        return this;
    }

    @Step("Kullanici Lisesi alanında \"{kullaniciListesi}\" seçilir. ")
    public EvrakDetayiPage kullaniciListesiSec(String kullaniciListesi) {
        txtKullaniciListesi.selectLov(kullaniciListesi);
        return this;
    }

    @Step("Kullanici Lisesi alanında kullaniciListesi kontrolü. \"{kullaniciListesi}\" , {shouldBeExist}")
    public EvrakDetayiPage kullaniciListesiKontrolu(String kullaniciListesi, boolean shouldBeExist) {
        if (shouldBeExist)
            txtKullaniciListesi.openTreePanel().getSelectableItems().filterBy(text(kullaniciListesi)).shouldHaveSize(1);
        else
            txtKullaniciListesi.openTreePanel().getSelectableItems().filterBy(text(kullaniciListesi)).shouldHaveSize(0);

        return this;
    }

    @Step("Onaylayacak Kişi alanında \"{kisi}\" seçilir. ")
    public EvrakDetayiPage onaylayacakKisiSec(String kisi) {
        txtOnaylayacakKisi.openTreePanel().getSelectableItems().filterBy(text(kisi)).first().click();
        return this;
    }

    @Step("Havale Yap alanında Birim \"{birim}\" seçilir. ")
    public EvrakDetayiPage havaleYapAlanindaBirimSec(String birim) {
        txtHavaleYapBirim.selectLov(birim);
        return this;
    }

    @Step("Evrak Detayi ekranında Havale Yap alanında Kisi \"{kisi}\" seçilir. ")
    public EvrakDetayiPage havaleYapAlanindaKisiSec(String kisi) {
        txtIcerikHavaleYapKisi.selectLov(kisi);
        return this;
    }


    @Step("Kullanici Lisesi alanında \"{kullaniciListesi}\" seçilir. ")
    public EvrakDetayiPage tebligEtKullaniciListesiSec(String kullaniciListesi) {
        txtTebligEtKullniciListesi.selectLov(kullaniciListesi);
        return this;
    }

    @Step("Kullanici Lisesi alanında kullaniciListesi kontrolü. \"{kullaniciListesi}\" , {shouldBeExist}")
    public EvrakDetayiPage tebligEtKullaniciListesiKontrolu(String kullaniciListesi, boolean shouldBeExist) {
        if (shouldBeExist)
            txtTebligEtKullniciListesi.openTreePanel().getSelectableItems().filterBy(text(kullaniciListesi)).shouldHaveSize(1);
        else
            txtTebligEtKullniciListesi.openTreePanel().getSelectableItems().filterBy(text(kullaniciListesi)).shouldHaveSize(0);

        return this;
    }

    @Step("Havale yap ekran geldigi gorulur")
    public EvrakDetayiPage havaleYapEkranGeldigiGorme() {
        boolean durum = $(By.id("inboxItemInfoForm:havaleDagitimLovPanel")).isDisplayed();
        Assert.assertEquals(durum, true);
        takeScreenshot();
        return this;
    }

    @Step("İçerik alanın {icerik} bilgisi ile doğru geldiği görülür")
    public EvrakDetayiPage editorIcerigiGeldigiGorme(String icerik) {
        $$(By.id("cke_96_contents")).filterBy(Condition.text(icerik)).first().isDisplayed();
        return this;
    }

    @Step("Alan bilgileri kontrolü")
    public EvrakDetayiPage bilgilerAlanlarDogruGeldigiGorme(String konukodu, String konu, String kaldirilicakKlasor, String evrakTuru, String gizlilik, String geregi, String onayAkisiKull1, String onayAkisi2) {
        Allure.addAttachment("Konu kodu alanı doğru bilgiler geldiği görülür", "");
        Assert.assertEquals(txtkonuKodu.filterBy(Condition.text(konukodu)).first().isDisplayed(), true, "Konu Kodu Alanı Görüntülendi");

        Allure.addAttachment("Konu alanı doğru bilgiler geldiği görülür", "");
        Assert.assertEquals(txtkonu.getText(), konu, "Konu Alanı Görüntülendi");

        Allure.addAttachment("Kaldırılacak Klasörler alanı doğru bilgiler geldiği görülür", "");
        Assert.assertEquals(secilenKaldirilicakKlasor.filterBy(Condition.text(kaldirilicakKlasor)).first().isDisplayed(), true, "Kaldırılacak Klasörler Alanı Görüntülendi");

        Allure.addAttachment("Evrak Türü alanı doğru bilgiler geldiği görülür", "");
        Assert.assertEquals(cmbEvrakTuru.getSelectedText(), evrakTuru, "Evrak Türü Alanı Görüntülendi");

        Allure.addAttachment("Gizlilik Derecesi alanı doğru bilgiler geldiği görülür", "");
        Assert.assertEquals(cmbGizlilik.getSelectedText(), gizlilik, "Gizlilik Derecesi Alanı Görüntülendi");

        Allure.addAttachment("Gereği alanı doğru bilgiler geldiği görülür", "");
        Assert.assertEquals(cmbGeregiSecilen.filterBy(Condition.text(geregi)).first().isDisplayed(), true, "Gereği Alanı Görüntülendi");

        Allure.addAttachment("Onay Akışı alanı doğru bilgiler geldiği görülür", "");
        Assert.assertEquals($$("[id$='akisLov:LovSecilen']").filterBy(Condition.text(onayAkisiKull1)).filterBy(Condition.text(onayAkisi2)).first().isDisplayed(), true, "Onay Akışı Alanı Görüntülendi");

        takeScreenshot();
        return this;
    }

    @Step("Havale bilgilerinin girileceği alanların geldiği görülür.")
    public EvrakDetayiPage icerikGosterHavaleBilgilerininGirilecegiAlanlarınGeldigiGorme() {
        Assert.assertEquals(txtIcerikBirimKontrol.isDisplayed(), true, "Birim Alanı Görüntülendi");
        Allure.addAttachment("Birim Kontrol Alanı Görüntülendi : ", "");

        Assert.assertEquals(txtIcerikKisiKontrol.isDisplayed(), true, "Kisi Alanı Görüntülendi");
        Allure.addAttachment("Kisi Alanı Görüntülendi : ", "");

        Assert.assertEquals(txtIcerikKullanıcıListeKontrol.isDisplayed(), true, "Kullanıcı Liste Alanı Görüntülendi");
        Allure.addAttachment("Kullanıcı Liste Alanı Görüntülendi : ", "");

        Assert.assertEquals(txtIcerikAciklamaKontrol.isDisplayed(), true, "Aciklama Alanı Görüntülendi");
        Allure.addAttachment("Aciklama Alanı Görüntülendi : ", "");

        Assert.assertEquals(btnIcerikDosyaEkleKontrol.isDisplayed(), true, "Dosya Ekle Alanı Görüntülendi");
        Allure.addAttachment("Dosya Ekle Alanı Görüntülendi : ", "");

        Assert.assertEquals(txtIcerikIslemSureKontrol.isDisplayed(), true, "İşlem Süre Alanı Görüntülendi");
        Allure.addAttachment("İslem Sure Alanı Görüntülendi : ", "");

        boolean durum8 = btnIcerikHavaleGonder.isDisplayed();
        Assert.assertEquals(durum8, true);
        Allure.addAttachment("Gonder buttonun geldiği görülür", "Gonder");

        boolean durum9 = btnIcerikHavaleOnayinaGonder.isDisplayed();
        Assert.assertEquals(durum9, true);
        Allure.addAttachment("Havale Onayına Gönder buttonun geldiği görülür", "Havale Onayına Gönder");
        return this;
    }

    @Step("Havale bilgilerinin girileceği alanların geldiği görülür.")
    public EvrakDetayiPage icerikGosterTeslimAlVeHavaleBilgilerininGirilecegiAlanlarınGeldigiGorme() {
        Assert.assertEquals(txtIcerikBirimKontrol.isDisplayed(), true, "Birim Alanı Görüntülendi");
        Allure.addAttachment("Birim Kontrol Alanı Görüntülendi : ", "");

        Assert.assertEquals(txtIcerikKisiKontrol.isDisplayed(), true, "Kisi Alanı Görüntülendi");
        Allure.addAttachment("Kisi Alanı Görüntülendi : ", "");

        Assert.assertEquals(txtIcerikKullanıcıListeKontrol.isDisplayed(), true, "Kullanıcı Liste Alanı Görüntülendi");
        Allure.addAttachment("Kullanıcı Liste Alanı Görüntülendi : ", "");

        Assert.assertEquals(txtTeslimAlinmayiIcerikAciklamaKontrol.isDisplayed(), true, "Aciklama Alanı Görüntülendi");
        Allure.addAttachment("Aciklama Alanı Görüntülendi : ", "");

        Assert.assertEquals(btnTeslimAlinmayiIcerikDosyaEkleKontrol.isDisplayed(), true, "Dosya Ekle Alanı Görüntülendi");
        Allure.addAttachment("Dosya Ekle Alanı Görüntülendi : ", "");

        Assert.assertEquals(txtTeslimAlinmayiIcerikIslemSureKontrol.isDisplayed(), true, "İşlem Süre Alanı Görüntülendi");
        Allure.addAttachment("İslem Sure Alanı Görüntülendi : ", "");

        boolean durum9 = btnIcerikHavaleOnayinaGonder.isDisplayed();
        Assert.assertEquals(durum9, true);
        Allure.addAttachment("Havale Onayına Gönder buttonun geldiği görülür", "Havale Onayına Gönder");

        boolean durum8 = btnIcerikTeslimAlGonder.isDisplayed();
        Assert.assertEquals(durum8, true);
        Allure.addAttachment("Teslim Al Gonder buttonun geldiği görülür", "Teslim Al Gönder");

        boolean durum10 = btnIcerikVazgec.isDisplayed();
        Assert.assertEquals(durum10, true);
        Allure.addAttachment("Vazgeç buttonun geldiği görülür", "Vazgeç");

        return this;
    }

    @Step("Evrak Detay sayfası kapatılır.")
    public EvrakDetayiPage evrakDetayiSayfasiKapat() {
        btnEvrakDetayiClose.click();
        return this;
    }

    @Step("Kaydet Ve Onaya Sun Uyari PopUp kapatılır.")
    public EvrakDetayiPage kaydetVeOnayaSunUyariPopUpEvet() {
        SelenideElement btnEvet = $(By.id("kaydetEvetButton"));
        btnEvet.click();
        return this;
    }

    @Step("Evrak göster, Havale yap, tebliğ et, iade et, cevap yaz, evrak kapat Ikon kontrolleri")
    public EvrakDetayiPage ikonKontrolleri() {

        dialogTabMenuRight.shouldBe(visible);

        Assert.assertEquals(btnEvrakGoster.isDisplayed(), true);
        Assert.assertEquals(btnHavaleYap.isDisplayed(), true);
        Assert.assertEquals(btnTebligEt.isDisplayed(), true);
        Assert.assertEquals(btnIadeEt.isDisplayed(), true);
        Assert.assertEquals(btnCevapYaz.isDisplayed(), true);
        Assert.assertEquals(btnEvrakKapat.isDisplayed(), true);

        return this;
    }

    @Step("Cevap Yaz")
    public EvrakDetayiPage cevapYaz() {
        btnCevapYaz.shouldBe(visible);
        btnCevapYaz.click();
        return this;
    }

    @Step("Tebellüğ Butonu kontrolü")
    public EvrakDetayiPage tebellugButonuKontrolEt() {
        btnTebellugEt.shouldBe(visible);
        return this;
    }

    @Step("Evrak Bilgileri tabı açıldı.")
    public EvrakDetayiPage evrakBilgileriTabAktifKontrolEt() {
        spanBilgileri.shouldHave(attribute("class", "tabMenuTextSelected")).shouldBe(visible);
        return this;
    }

    @Step("Evrak Detay ekranı \"{text}\" tabı açık.")
    public EvrakDetayiPage evrakDetayEkraniTabSeçimKontrolu(String text) {
        $x("//span[. = '" + text + "']").shouldHave(attribute("class", "tabMenuTextSelected")).shouldBe(visible);
        return this;
    }


    @Step("Silme Onayı: Kaydı silmek istediğinize emin misiniz?: {secim}")
    public EvrakDetayiPage evrakSilPopup(String secim) {

        SelenideElement btnEvet = $(By.id("inboxItemInfoForm:evrakSilEvetButton"));
        SelenideElement btnHayir = $(By.id("inboxItemInfoForm:evrakSilHayirButton"));

        switch (secim) {
            case "Evet":
                btnEvet.click();
                break;
            case "Hayır":
                btnHayir.click();
                break;
        }
        return this;
    }

    @Step("Sil butonunun gelmediği kontrolu")
    public EvrakDetayiPage silButonunGelmedigiKontrolu() {

        Assert.assertEquals(btnSil.isDisplayed(), false);

        return this;
    }

    @Step("Sil butonunun geldiği kontrolu")
    public EvrakDetayiPage silButonununGeldigiKontrolu() {

        Assert.assertEquals(btnSil.isDisplayed(), true);

        return this;
    }

    @Step("Evrak Sil")
    public EvrakDetayiPage evrakSil() {

        btnSil.click();

        return this;
    }

    @Step("Evrak Silme Notu Gir")
    public EvrakDetayiPage evrakSilmeNotuDoldur(String not) {

        txtSilmeNotu.setValue(not);

        return this;
    }

    @Step("Evrak Notu Sonrası Sil")
    public EvrakDetayiPage evrakSilmeNotuSonrasiSil() {

        btnEvrakNotSil.click();

        return this;
    }

    @Step("Editör tabı ekranında açıldığı kontrolu")
    public EvrakDetayiPage editorTabKontrolu() {

        Assert.assertEquals(tabEditor.isDisplayed(), true);

        return this;
    }

    @Step("\"Evrak Detayı\" ekranının görüntülendiği görülür")
    public EvrakDetayiPage sayfaAcilmasiKontrolu() {
        pageTitle.shouldBe(visible);
        return this;
    }

    @Step("Evrak Göster")
    public EvrakDetayiPage evrakGoster() {

        btnEvrakGoster.click();

        return this;
    }

    //@Step("Frame Değiştirme")
    public EvrakDetayiPage frameDegistirme() {

        Selenide.sleep(2000);
        switchTo().frame($("iframe[class='onizlemeFrame']"));
        Selenide.sleep(1000);
        return this;
    }

    @Step("Pdf Dağıtımda eklerin gitmeyeceği yerler kontrolu: {dagitim}")
    public EvrakDetayiPage eklerinDagitimdaGitmeyecegiYerlerKontroluDagitim1(String dagitim, String ekler) {
        String pdfDagitim = $(By.xpath("//*[@id='viewer']/div/div[2]/div[30]")).getText();
        //String pdfDagitim = $(By.xpath("//*[contains(text(),'"+ekler+"')]")).getText();
        Assert.assertEquals(pdfDagitim.contains(ekler), true);

        return this;
    }

    @Step("Pdf Dağıtımda eklerin gitmeyeceği yerler kontrolu: {dagitim}")
    public EvrakDetayiPage eklerinDagitimdaGitmeyecegiYerlerKontroluDagitim2(String dagitim, String ekler) {
        String pdfDagitim = $(By.xpath("//*[@id='viewer']/div/div[2]/div[31]")).getText();
        Assert.assertEquals(pdfDagitim.contains(ekler), true);
        return this;
    }

    @Step("Pdf Dağıtımda eklerin gitmeyeceği yerler kontrolu: {dagitim}")
    public EvrakDetayiPage eklerinDagitimdaGitmeyecegiYerlerKontroluDagitim3(String dagitim, String ekler) {
        String pdfDagitim3 = $(By.xpath("//*[@id='viewer']/div/div[2]/div[32]")).getText();
        String pdfDagitimDevami = $(By.xpath("//*[@id='viewer']/div/div[2]/div[33]")).getText();

        String pdfDagitim = pdfDagitim3 + " " + pdfDagitimDevami;
        Assert.assertEquals(pdfDagitim.contains(ekler), true);

        return this;
    }

    public class EditorTab extends MainPage {

        SelenideElement tabEditor = $(By.xpath("//span[. = 'Editör']/../../..//button"));

        private EditorTab open() {
            tabEditor.click();
            return this;
        }


        @Step("Editör İçerik Doldur")
        public EditorTab editorIcerikDoldur(String icerik) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            TextEditor editor = new TextEditor();
            editor.clear();
            editor.type(icerik);

            //divEditor.find(By.tagName("iframe")).click();
            //divEditor.find(By.tagName("iframe")).getWrappedElement().sendKeys(icerik);
            return this;
        }
    }


    public class TebligGecmisiTab extends MainPage {

        SelenideElement tabTebligGecmisi = $(By.xpath("//span[. = 'Tebliğ Geçmişi']/../../..//button"));
        ElementsCollection tableTebligGecmisi = $$("tbody[id='inboxItemInfoForm:tebligDataTable_data'] > tr[role='row']");

        private TebligGecmisiTab open() {
            tabTebligGecmisi.click();
            return this;
        }

        @Step("Teblig geçmişi kontrol et")
        public TebligGecmisiTab tebligGecmisiKontrol(String tebligEdenveTarih, String[] kullanicilar) {

            $x("//span[contains(text(), '" + tebligEdenveTarih + "')]").waitUntil(visible, 5000);

            SelenideElement currentRow = tableTebligGecmisi
                    .filterBy(Condition.text(tebligEdenveTarih))
                    .last()
                    .waitUntil(visible, 5000);

            if (currentRow.$(By.xpath(".//span[. = '" + tebligEdenveTarih + "']/..//span[contains(@class, 'ui-icon-plusthick')]")).isDisplayed()) {
                currentRow.$(By.xpath(".//span[. = '" + tebligEdenveTarih + "']/..//span[contains(@class, 'ui-icon-plusthick')]")).click();
            }

            ElementsCollection tableTebligEdilen = $$(By.xpath("//span[. = '" + tebligEdenveTarih + "']/../..//tbody/tr[@role='row']"));

            for (int i = 0; i < kullanicilar.length; i++) {

                tableTebligEdilen
                        .filterBy(Condition.text(kullanicilar[i]))
                        .first()
                        .shouldBe(visible);
            }


            return this;
        }

        @Step("Teblig geçmişinde tebellüğ olanları kontrol et")
        public TebligGecmisiTab tebligGecmisiKontrol(String tebligEdenveTarih, String[] kullanicilar, String[] tebellugTarih) {

            Selenide.sleep(5000);
            SelenideElement currentRow = tableTebligGecmisi
                    .filterBy(Condition.text(tebligEdenveTarih))
                    .last();

            if (currentRow.$(By.xpath(".//span[. = '" + tebligEdenveTarih + "']/..//span[contains(@class, 'ui-icon-plusthick')]")).isDisplayed()) {
                currentRow.$(By.xpath(".//span[. = '" + tebligEdenveTarih + "']/..//span[contains(@class, 'ui-icon-plusthick')]")).click();
            }

            ElementsCollection tableTebligEdilen = $$(By.xpath("//span[. = '" + tebligEdenveTarih + "']/../..//tbody/tr[@role='row']"));

            for (int i = 0; i < kullanicilar.length; i++) {

                tableTebligEdilen
                        .filterBy(Condition.text(kullanicilar[i]))
                        .filterBy(Condition.text(tebellugTarih[i]))
                        .first()
                        .shouldBe(visible);
            }


            return this;
        }

    }


    public class BilgileriTab extends MainPage {

        SelenideElement tabBilgileri = $(By.xpath("//span[. = 'Bilgileri']/../../..//button"));
        BelgenetElement txtOnayAkisi = comboLov("[id^='inboxItemInfoForm:evrakBilgileriList:'][id$=':akisLov:LovText']");
        SelenideElement txtKonu = $(By.id("inboxItemInfoForm:evrakBilgileriList:3:konuTextArea"));

        private BilgileriTab open() {
            tabBilgileri.click();
            return this;
        }

        @Step("Seçili Onay Akışı güncellendi.")
        public BilgileriTab onayAkişGuncelle(String onayAkisi) {
            txtOnayAkisi.clearAllSelectedItems();
            txtOnayAkisi.selectLov(onayAkisi);
            return this;
        }

        @Step("Kopyası oluşturulan evrak bilgilerinin aynısının geldiği ve değiştirilebildiği görülür")
        public BilgileriTab kopyasiOlusturulanEvrakBilgilerininDegitirilebilgiGorme() {
            boolean durum = txtKonu.shouldBe(visible).exists();
            Assert.assertEquals(durum, true);
            return this;
        }

        @Step("Kaldırılacak klasör, Gereği, Onay akışı, bilgilerinin girildiği şekilde geldiği görülür.")
        public BilgileriTab bilgileriTabKaldirilacakKlasorOnayAkisiGeregiGeldigiGorme(String kaldirilacakKlasor, String geregi, String onayAkisi) {
            boolean durum = $$("[id$='eklenecekKlasorlerLov:LovSecilenTable_data']").filterBy(Condition.text(kaldirilacakKlasor)).size() == 1;
            boolean durum1 = $$("[id$='geregiLov:LovSecilenTable']").filterBy(Condition.text(geregi)).size() == 1;
            boolean durum2 = $$("[id$='akisLov:LovSecilen']").filterBy(Condition.text(onayAkisi)).size() == 1;
            Assert.assertEquals(durum, durum1);
            Assert.assertEquals(durum2, durum1);
            return this;
        }
    }

    public class EkleriTab extends MainPage {

        SelenideElement tabEkleri = $(By.xpath("//span[. = 'Ekleri']/../../..//button"));

        private EkleriTab open() {
            tabEkleri.click();
            return this;
        }


        @Step("Eklenen dosyanın geldiği görülür.")
        public EkleriTab eklenenDosyaninGeldigiGorulur(String dosya) {
            boolean durum = $$(By.id("inboxItemInfoForm:ekListesiDataTable_data")).filterBy(Condition.text(dosya)).size() == 1;
            Assert.assertEquals(durum, true);
            return this;
        }

        @Step("Kopyası oluşturulan evrak eklerinin aynısının geldiği ve değiştirilebildiği görülür")
        public EkleriTab eklenenDosyaninKopyalananDosyaAyniGeldigiGorulur() {
            boolean durum = $$(By.id("inboxItemInfoForm:ekListesiDataTable_data")).filterBy(Condition.text("Listelenecek Veri Bulunamamıştır.")).size() == 1;
            Assert.assertEquals(durum, true);
            return this;
        }

        @Step("Kopyası oluşturulan evrak eklerinin aynısının geldiği ve değiştirilebildiği görülür")
        public EkleriTab eklenenDosyaninKopyalananDosyaAyniGeldigiGorulurDegistirelbildigiGorme() {
            boolean durum = $$(By.id("inboxItemInfoForm:ekListesiDataTable_data")).filterBy(Condition.text("Listelenecek Veri Bulunamamıştır.")).size() == 1;
            Assert.assertEquals(durum, true);
            return this;
        }

    }

    public class IlgileriTab extends MainPage {

        SelenideElement tabIlgileri = $(By.xpath("//span[. = 'İlgileri']/../../..//button"));

        private IlgileriTab open() {
            tabIlgileri.click();
            return this;
        }


        @Step("Cevap yazılan evrak bilgisinin geldiği görülür.")
        public IlgileriTab cevapYazilanEvrakBilgisiGeldigiGorme() {
            boolean durum = $$("[id='inboxItemInfoForm:ilgiListesiDataTable_data'] > tr").size() == 1;
            Assert.assertEquals(durum, true);
            return this;
        }

        @Step("Kopyası oluşturulan evrak ilgilerinin aynısının geldiği ve değiştirilebildiği görülür")
        public IlgileriTab cevapYazilanEvrakBilgisiKopyalananBosEvrakAyniGeldigiGorme() {
            boolean durum = $$("[id='inboxItemInfoForm:ilgiListesiDataTable_data'] > tr").filterBy(Condition.text("Listelenecek Veri Bulunamamıştır.")).size() == 1;
            Assert.assertEquals(durum, true);
            return this;
        }

    }

    public class HareketGecmisiTab extends MainPage {

        SelenideElement tabHareketGecmisi = $("button .kullaniciGecmisi");
        ElementsCollection tblHareketGecmisi = $$("tbody[id='inboxItemInfoForm:hareketGecmisiDataTable_data'] > tr[role='row']");
        SelenideElement btnRaporAlExcel = $(By.id("inboxItemInfoForm:hareketGecmisiDataTable:evrakGecmisiExport"));
        SelenideElement txtBaslangicTarihi = $(By.id("inboxItemInfoForm:hareketGecmisiDataTable:hareketGecmisiBegin_input"));
        SelenideElement txtBitisTarihi = $(By.id("inboxItemInfoForm:hareketGecmisiDataTable:hareketGecmisiEnd_input"));
        SelenideElement tblKolonGonderen = $(By.xpath("//span[text()='Gönderen']"));
        SelenideElement tblKolonTeslimAlan = $(By.xpath("//span[text()='Teslim Alan']"));
        SelenideElement tblKolonIslemSureci = $(By.xpath("//span[text()='İşlem Süreci']"));
        SelenideElement tblKolonIslemTarihi = $(By.xpath("//span[normalize-space(text())='İşlem Tarihi']"));
        SelenideElement tblKolonAciklama = $(By.xpath("//span[text()='Açıklama']"));

        private HareketGecmisiTab open() {
            tabHareketGecmisi.click();
            return this;
        }

        @Step("Hareket Geçmişi açıklama kontrolü :\n \"{text}\" ")
        public HareketGecmisiTab tabloKontol(String text) {
            tblHareketGecmisi
                    .filterBy(Condition.text(text))
                    .shouldHaveSize(1);

            Assert.assertEquals(tblKolonGonderen.isDisplayed(), true);
            Assert.assertEquals(tblKolonTeslimAlan.isDisplayed(), true);
            Assert.assertEquals(tblKolonIslemSureci.isDisplayed(), true);
            Assert.assertEquals(tblKolonIslemTarihi.isDisplayed(), true);
            Assert.assertEquals(tblKolonAciklama.isDisplayed(), true);

            Allure.addAttachment("Tablo kontolü", "Aşağıdaki kolonların listelendiği görülür. \n Gönderen\n" +
                    "Teslim Alan\n" +
                    "İşlem Süreci\n" +
                    "İşlem Tarihi\n" +
                    "Açıklama");
            return this;
        }

        @Step("Rapor al Excel")
        public HareketGecmisiTab raporAl(String remoteDownloadPath) {
            deleteSpecificFile("Rapor_");

            sleep(3000);

            btnRaporAlExcel.click();
            islemMesaji().basariliOlmali();
            waitForLoadingJS(WebDriverRunner.getWebDriver(), 180);
            sleep(3000);
            searchDownloadedFileWithName(remoteDownloadPath, "Rapor_.xls");

            return this;
        }

        @Step("Evrak Arama ekranı kapat")
        public HareketGecmisiTab evrakDetayiKapat() {
            $(By.xpath("//div[@id='windowItemInfoDialog']//span[@class='ui-icon ui-icon-closethick']")).click();
            islemPenceresiKapatmaOnayiPopup("Kapat");
            return this;
        }


        @Step("Hareket Geçmişi tablo kolon isimleri kontrolü.")
        public HareketGecmisiTab tabloKolonIsımleriKontol(String text) {
            Assert.assertEquals($(By.xpath("//span[text()='Gönderen']")).isDisplayed(), true);
            Assert.assertEquals($(By.xpath("//span[text()='Teslim Alan']")).isDisplayed(), true);
            Assert.assertEquals($(By.xpath("//span[text()='İşlem Süreci']")).isDisplayed(), true);
            Assert.assertEquals($(By.xpath("//span[normalize-space(text())='İşlem Tarihi'] ")).isDisplayed(), true);
            Assert.assertEquals($(By.xpath("//span[text()='Açıklama']")).isDisplayed(), true);
            return this;
        }


    }

}