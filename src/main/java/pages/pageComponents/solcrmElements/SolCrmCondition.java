package pages.pageComponents.solcrmElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.impl.Html;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.WebDriverRunner.isIE;

public abstract class SolCrmCondition extends Condition {

    public static final Condition required = new Condition("required") {
        @Override
        public boolean apply(WebElement element) {
            return element.getAttribute("class").contains("required");
        }
    };

    public SolCrmCondition(String name) {
        super(name);
    }

    /**
     * <p>Sample: <code>$("h1").shouldHave(exactText("Hello"))</code></p>
     * <p>
     * <p>Case insensitive</p>
     * <p>NB! Ignores multiple whitespaces between words</p>
     *
     * @param text expected text of HTML element
     */
    public static Condition innerText(final String text) {
        return new Condition("innerText") {
            @Override
            public boolean apply(WebElement element) {
                String innerText;
                if (isIE())
                    innerText = element.getAttribute("innerText");
                else
                    innerText = element.getAttribute("textContent");

                return Html.text.equals(innerText, text);
            }

            @Override
            public String toString() {
                return name + " '" + text + '\'';
            }
        };
    }

}
