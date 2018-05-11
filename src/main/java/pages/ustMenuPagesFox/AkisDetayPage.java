package pages.ustMenuPagesFox;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPageFox;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class AkisDetayPage extends MainPageFox {

    private SelenideElement BTN_KURULUM_XPATH = $(By.xpath(GetObject("FOX","BTN_KURULUM_XPATH","XPATH","FoxAkisDetayPage","PRP")));

    @Step("Kurulum tıklanır.")
    public AkisDetayPage kurulumAdımınaTikla() {
        switchTo().frame(0);
        BTN_KURULUM_XPATH.click();
        return this;
    }
}
