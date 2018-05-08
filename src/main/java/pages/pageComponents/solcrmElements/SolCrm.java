package pages.pageComponents.solcrmElements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.ElementFinder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.visible;

/**
 * Yazan: Ilyas Bayraktar
 * Tarih: 28.12.2017
 * Açıklama:
 */
public class SolCrm extends Selenide {

    /**
     * Locates the first element matching given CSS selector
     * ATTENTION! This method doesn't start any search yet!
     *
     * @param cssSelector any CSS selector like "input[name='first_name']" or "#messages .new_message"
     * @return SelenideElement
     */
    public static SolCrmElement $(String cssSelector) {
        return getElement(By.cssSelector(cssSelector));
    }

    /**
     * Locates the first element matching given XPATH expression
     * ATTENTION! This method doesn't start any search yet!
     *
     * @param xpathExpression any XPATH expression //*[@id='value'] //E[contains(@A, 'value')]
     * @return SelenideElement which locates elements via XPath
     */
    public static SolCrmElement $x(String xpathExpression) {
        return getElement(By.xpath(xpathExpression));
    }

    /**
     * Locates the first element matching given CSS selector
     * ATTENTION! This method doesn't start any search yet!
     *
     * @param seleniumSelector any Selenium selector like By.id(), By.name() etc.
     * @return SelenideElement
     */
    public static SolCrmElement $(By seleniumSelector) {
        return getElement(seleniumSelector);
    }

    /**
     * @see #getElement(By, int)
     */
    public static SolCrmElement $(By seleniumSelector, int index) {
        return getElement(seleniumSelector, index);
    }

    /**
     * Locates the Nth element matching given criteria
     * ATTENTION! This method doesn't start any search yet!
     *
     * @param cssSelector any CSS selector like "input[name='first_name']" or "#messages .new_message"
     * @param index       0..N
     * @return SelenideElement
     */
    public static SolCrmElement $(String cssSelector, int index) {
        return getElement(By.cssSelector(cssSelector), index);
    }

    /**
     * Locates the first element matching given criteria
     * ATTENTION! This method doesn't start any search yet!
     *
     * @param criteria instance of By: By.id(), By.className() etc.
     * @return SelenideElement
     */
    public static SolCrmElement getElement(By criteria) {
        return ElementFinder.wrap(SolCrmElement.class, null, criteria, 0);
    }

    /**
     * Locates the Nth element matching given criteria
     * ATTENTION! This method doesn't start any search yet!
     *
     * @param criteria instance of By: By.id(), By.className() etc.
     * @param index    0..N
     * @return SelenideElement
     */
    public static SolCrmElement getElement(By criteria, int index) {
        return ElementFinder.wrap(SolCrmElement.class, null, criteria, index);
    }


    /**
     * Replacement for standard Selenide `$` method.
     *
     * @return SolCrmElement - an "advanced" version of `SelenideElement` with more custom methods
     */
    public static SolCrmElement comboLov(WebElement parentElement, String cssLocator) {
        return ElementFinder.wrap(SolCrmElement.class, parentElement, By.cssSelector(cssLocator), 0);
    }

    /**
     * Replacement for standard Selenide `$` method.
     *
     * @return SolCrmElement - an "advanced" version of `SelenideElement` with more custom methods
     */
    public static SolCrmElement comboLov(WebElement parentElement, By locator) {
        return ElementFinder.wrap(SolCrmElement.class, parentElement, locator, 0);
    }

    public static SolCrmElement comboLov(String selector) {
        return ElementFinder.wrap(SolCrmElement.class, null, By.cssSelector(selector), 0);
    }

    public static SolCrmElement comboLov(By locator) {
        return ElementFinder.wrap(SolCrmElement.class, null, locator, 0);
    }


    public static SolCrmElement comboBox(WebElement parentElement, String selector) {
        return ElementFinder.wrap(SolCrmElement.class, parentElement, By.cssSelector(selector), 0);
    }

    /**
     * Replacement for standard Selenide `$` method.
     *
     * @return SolCrmElement - an "advanced" version of `SelenideElement` with more custom methods
     */
    public static SolCrmElement comboBox(WebElement parentElement, By locator) {
        return ElementFinder.wrap(SolCrmElement.class, parentElement, locator, 0);
    }


    public static SolCrmElement comboBox(String selector) {
        return ElementFinder.wrap(SolCrmElement.class, null, By.cssSelector(selector), 0);
    }

    public static SolCrmElement comboBox(By locator) {
        return ElementFinder.wrap(SolCrmElement.class, null, locator, 0);
    }


    /**
     * First search in main iframe, then first level child iframes(optiona iframe locator).
     * Stay in founded iframe, to return to main iframe use switchTo().defaultContent().
     *
     * @param locator
     * @param iframeLocator
     * @return
     */
    public static SelenideElement $inFrame(By locator, By... iframeLocator) {

        switchToFrameOfElement(locator, iframeLocator);

        return ElementFinder.wrap(SolCrmElement.class, null, locator, 0);
    }

    /**
     * First search in main iframe, then first level child iframes(optiona iframe locator).
     * Stay in founded iframe, to return to main iframe use switchTo().defaultContent().
     *
     * @param cssSelector
     * @param iframeLocator
     * @return
     */
    public static SelenideElement $inFrame(String cssSelector, By... iframeLocator) {

        switchToFrameOfElement(By.cssSelector(cssSelector), iframeLocator);

        return ElementFinder.wrap(SolCrmElement.class, null, By.cssSelector(cssSelector), 0);
    }

    private static void switchToFrameOfElement(By elementLocator, By... iframeLocator) {

       /* switchTo().defaultContent();
        if ($(elementLocator).exists())
            return;// $(elementLocator);*/

        By f = iframeLocator.length > 0 ? iframeLocator[0] : By.tagName("iframe");
        $(f).shouldBe(visible);
        ElementsCollection iframes = $$(f);

        for (SelenideElement iframe : iframes) {
            switchTo().frame(iframe);
            if ($(elementLocator).exists())// && $(locator).is(visible))
                return;

            switchTo().defaultContent();
        }

//        return;// $(elementLocator);
    }


}

