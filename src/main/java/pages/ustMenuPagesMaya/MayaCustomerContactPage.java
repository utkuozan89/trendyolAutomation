package pages.ustMenuPagesMaya;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.MainPageMaya;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class MayaCustomerContactPage extends MainPageMaya {
    ElementsCollection TBL_CONTACTS_CSS = $$(GetObject("MAYA","TBL_CONTACTS_CSS","CSS_SELECTOR","MayaCustomerContact","PRP"));
    private SelenideElement TXT_CONTACTPHONE_XPATH = $(By.xpath(GetObject("MAYA","TXT_CONTACTPHONE_XPATH","XPATH","MayaCustomerContact","PRP")));
    private SelenideElement BTN_CONTACTKAYDET_ID = $(By.id(GetObject("MAYA","BTN_CONTACTKAYDET_ID","ID","MayaCustomerContact","PRP")));
    private SelenideElement MSG_KONTAK = $(By.xpath(GetObject("MAYA","MSG_KONTAK","XPATH","MayaCustomerContact","PRP")));
    @Step("kontak tablosundan kontak seçilir.")
    public MayaCustomerContactPage tablodanIlkKontakSec() {
        TBL_CONTACTS_CSS
                .first()
                .$("button")
                .click();
        return this;
    }
    @Step("Cep telefonu alanına \"{phoneNumber}\" yazılır.")
    public MayaCustomerContactPage telefonNumarasıDoldur(String phoneNumber) {
        TXT_CONTACTPHONE_XPATH.setValue(phoneNumber);
        return this;
    }
    @Step("Kaydet butonu tıklanır.")
    public MayaCustomerContactPage kaydet() {
        BTN_CONTACTKAYDET_ID.click();
        return this;
    }
    @Step("Mesaj Kontrol Edilir")
    public MayaCustomerContactPage mesajKontrol(String mesaj) {
        MSG_KONTAK.shouldHave(Condition.visible);
        Assert.assertEquals(MSG_KONTAK.getText().equals(mesaj),true);
        return this;
    }

}