package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.invitro.ru")
public class Menu extends PageObject {

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
    WebElementFacade cityName;;

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
