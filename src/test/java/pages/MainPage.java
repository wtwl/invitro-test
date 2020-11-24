package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.invitro.ru")
public class MainPage extends PageObject {

    @FindBy(xpath = "//div[@class='header-top']")
    WebElementFacade topBar;

    @FindBy(xpath = "//div[@class='attention--header--block--desktop']")
    WebElementFacade attentionPopup;

    @FindBy(xpath = "//div[@class='attention--header--block--desktop']//div[@class='close-block']")
    WebElementFacade attentionPopupClose;

    @FindBy(xpath = "//div[contains(@class, 'header-cart')]/a")
    WebElementFacade bucketBtn;

    @FindBy(xpath = "//input[@name='q']")
    WebElementFacade searchInput;

    @FindBy(xpath = "//div[@class='city__change']")
    WebElementFacade cityChangePopup;

    @FindBy(xpath = "//div[@class='city__label']")
    WebElementFacade changeCity;

    @FindBy(xpath = "//div[@class='city__change']//a[contains(@class, city__confirm-btn)]")
    WebElementFacade changeCityConfirm;

    @FindBy(xpath = "//div[@class='change-city-search']//input[@type='text']")
    WebElementFacade searchBox;

    @FindBy(xpath = "(//div[@id='eac-container-select-basket-city-input']//div[@class='eac-item'])[1]")
    WebElementFacade searchFirstResult;

    @FindBy(xpath = "//div[@class='city__label']//span[contains(@class, 'city__name')]")
    WebElementFacade cityName;

    public void closeAttentionPopup() {
        boolean isPopupOpened = attentionPopup.isCurrentlyVisible();
        if(isPopupOpened) {
            attentionPopupClose.waitUntilVisible()
                    .waitUntilClickable()
                    .click();
        }
    }

    public void clickBucketButton() {
        bucketBtn.waitUntilClickable().click();
    }

    public void typeIntoSearchInput(String text) {
        searchInput.waitUntilClickable();
        typeInto(searchInput, text);
    }

    public String getSearchInputValue() {
        return searchInput.getValue();
    }

    public void clickTopBarLinkByName(String name) {
        String xpath = "//li/a[text()='" + name + "']/ancestor::li" ;
        WebElementFacade link = topBar.findBy(By.xpath(xpath));
        link.waitUntilClickable().click();
    }

    public String getUrl() {
        return getDriver().getCurrentUrl();
    }

    public void clickChangeCity() {
        if(!isCityChangePopupOpened()) {
            changeCity.waitUntilClickable().click();
        }
    }
    public void clickChangeCityConfirm() {
        changeCityConfirm.waitUntilVisible().waitUntilClickable().click();
    }

    public void enterCity(String text) {
        searchBox.waitUntilClickable();
        typeInto(searchBox, text);

    }

    public void selectCity() {
        searchFirstResult.waitUntilClickable().click();
    }

    public String getSelectedCity() {
        return cityName.getText();
    }

    private boolean isCityChangePopupOpened() {
        return cityChangePopup.getCssValue("display").equals("block");
    }



}
