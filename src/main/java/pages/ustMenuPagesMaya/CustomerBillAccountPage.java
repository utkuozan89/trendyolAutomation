package pages.ustMenuPagesMaya;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.MainPageMaya;
import pages.pageData.MayaUstMenuData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class CustomerBillAccountPage extends MainPageMaya {

    //private SelenideElement CMB_DENEME = $(By.xpath("//div[@class='form-group']//select[@id='customerBillAccountForm:billShippingMethod']"));

    private SelenideElement BTN_SECILIKAYDIGUNCELLE_XPATH = $(By.xpath(GetObject("MAYA","BTN_SECILIKAYDIGUNCELLE_XPATH","XPATH","CustomerBillAccountPage","PRP")));
    private SelenideElement BTN_YENIKAYIT_XPATH = $(By.xpath(GetObject("MAYA","BTN_YENIKAYIT_XPATH","XPATH","CustomerBillAccountPage","PRP")));
    private SelenideElement BTN_SECILIKAYDISIL_XPATH = $(By.xpath(GetObject("MAYA","BTN_SECILIKAYDISIL_XPATH","XPATH","CustomerBillAccountPage","PRP")));
    private SelenideElement CMB_FATURAGONDERMESEKLI_XPATH = $(By.xpath(GetObject("MAYA","CMB_FATURAGONDERMESEKLI_XPATH","XPATH","CustomerBillAccountPage","PRP")));
    private SelenideElement CMB_FATURADETAYTURU_XPATH = $(By.xpath(GetObject("MAYA","CMB_FATURADETAYTURU_XPATH","XPATH","CustomerBillAccountPage","PRP")));
    private SelenideElement CMB_HESAPPARABIRIMI_XPATH = $(By.xpath(GetObject("MAYA","CMB_HESAPPARABIRIMI_XPATH","XPATH","CustomerBillAccountPage","PRP")));
    private SelenideElement TXT_FATURADAGORUNECEKACIKLAMA_XPATH = $(By.xpath(GetObject("MAYA","TXT_FATURADAGORUNECEKACIKLAMA_XPATH","XPATH","CustomerBillAccountPage","PRP")));
    private SelenideElement TXT_VARSAYILANEPOSTA_XPATH = $(By.xpath(GetObject("MAYA","TXT_VARSAYILANEPOSTA_XPATH","XPATH","CustomerBillAccountPage","PRP")));
    private SelenideElement BTN_GUNCELLE_XPATH = $(By.xpath(GetObject("MAYA","BTN_GUNCELLE_XPATH","XPATH","CustomerBillAccountPage","PRP")));
    private SelenideElement BTN_KAPAT_XPATH = $(By.xpath(GetObject("MAYA","BTN_KAPAT_XPATH","XPATH","CustomerBillAccountPage","PRP")));
    private SelenideElement TXT_ACIKLAMA_XPATH = $(By.xpath(GetObject("MAYA","TXT_ACIKLAMA_XPATH","XPATH","CustomerBillAccountPage","PRP")));
    private SelenideElement BTN_KAYDET_XPATH = $(By.xpath(GetObject("MAYA","BTN_KAYDET_XPATH","XPATH","CustomerBillAccountPage","PRP")));
    private SelenideElement LBL_FATURAHESABI = $(By.xpath(GetObject("MAYA","LBL_FATURAHESABI","XPATH","CustomerBillAccountPage","PRP")));


    @Step("Müsteri Fatura Hesabı Sayfası Açılır.")
    public CustomerBillAccountPage openPage()
    {
        ustMenu(MayaUstMenuData.Islemler.MusteriFaturaHesabi);
        return this;
    }
    @Step("Müşteri Fatura Hesabı sayfasının geldiği görülür.")
    public CustomerBillAccountPage musteriFaturaHesabiSayfaKontrolu() {
        Assert.assertEquals(LBL_FATURAHESABI.isDisplayed(),true,"Müşteri Fatura Hesabı Sayfası Açılmalı");
        takeScreenshot();
        return this;
    }
    @Step("Yeni Kayıt Butonuna Tıklanır.")
    public CustomerBillAccountPage yeniKayit()
    {
        BTN_YENIKAYIT_XPATH.click();
        return this;
    }

    @Step("Seçili Kaydı Güncelle Butonuna Tıklanır.")
    public CustomerBillAccountPage seciliKaydiGuncelle()
    {
        BTN_SECILIKAYDIGUNCELLE_XPATH.click();
        return this;
    }

    @Step("Seçili Kaydı Sil Butonuna Tıklanır.")
    public CustomerBillAccountPage seciliKaydiSil()
    {
        BTN_SECILIKAYDISIL_XPATH.click();
        return this;
    }

    @Step("Fatura Gönderme Şekli Seçilir. ")
    public CustomerBillAccountPage faturaGondermeSekli(String faturaGondermeSekli) {
        sleep(1000);
        CMB_FATURAGONDERMESEKLI_XPATH.selectOption(faturaGondermeSekli);

        return this;
    }

    @Step("Fatura Detay Türü Seçilir. ")
    public CustomerBillAccountPage faturaDetayTuru(String faturaDetayTuru) {
        sleep(1000);
        CMB_FATURADETAYTURU_XPATH.selectOption(faturaDetayTuru);

        return this;
    }

    @Step("Hesap Para Birimi Seçilir. ")
    public CustomerBillAccountPage hesapParaBirimi(String hesapParaBirimi) {
        sleep(1000);
        CMB_HESAPPARABIRIMI_XPATH.selectOption(hesapParaBirimi);

        return this;
    }

    @Step("Varsayılan E Posta Adresi Girilir. ")
    public CustomerBillAccountPage faturadaGorunecekAciklama(String faturadaGorunecekAciklama) {

        TXT_FATURADAGORUNECEKACIKLAMA_XPATH.sendKeys(faturadaGorunecekAciklama);

        return this;
    }

    @Step("Varsayılan E Posta Adresi Girilir. ")
    public CustomerBillAccountPage varsayilanEPosta(String varsayilanEPosta) {

        if ( TXT_VARSAYILANEPOSTA_XPATH.isEnabled()) {
            TXT_VARSAYILANEPOSTA_XPATH.sendKeys(varsayilanEPosta);
            return this;
        }
        else {
            return this;
        }
    }

    @Step("Güncelle Butonuna Tıklanır. ")
    public CustomerBillAccountPage guncelle() {

        BTN_GUNCELLE_XPATH.click();

        return this;
    }

    @Step("Kapat Butonuna Tıklanır. ")
    public CustomerBillAccountPage kapat() {

        BTN_KAPAT_XPATH.click();

        return this;
    }

    @Step("Açıklama Alanı Doldurulur. ")
    public CustomerBillAccountPage aciklamaAlaniDoldur(String aciklama) {

        TXT_ACIKLAMA_XPATH.sendKeys(aciklama);

        return this;
    }

    @Step("Kaydet Butonuna Tıklanır. ")
    public CustomerBillAccountPage kaydet() {

        BTN_KAYDET_XPATH.click();
        return this;
    }
}
