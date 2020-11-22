package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;



@DefaultUrl("https://www.invitro.ru")
public class AnalyzesPopup extends PageObject {

    @FindBy(xpath = "//button[contains(@class, 'popupBtn')]//span[contains(text(), 'Получить результаты анализов')]")
    WebElementFacade analyzesBtn;

    @FindBy(xpath = "//div[@id='popupResult']")
    WebElementFacade analyzesPopUp;

    @FindBy(xpath = "//div[@id='getAnalysisFind']//button")
    WebElementFacade findAnalyzesBtn;

    @FindBy(xpath = "//form[@id='getAnalisis']//div[@class='form-row']")
    WebElementFacade form;

    @FindBy(xpath = "//input[@id='inz']")
    WebElementFacade INZCodeInput;

    @FindBy(xpath = "//input[@id='born']")
    WebElementFacade bornDateInput;

    @FindBy(xpath = "//input[@id='surname']")
    WebElementFacade surnameInput;

    @FindBy(xpath = "//div[@id='resultQuantError']")
    WebElementFacade attentionMessage;

    public void clickOnGetAnalyzesResult() {
        analyzesBtn.waitUntilClickable().click();
    }

    public void clickOnFindAnalyzesBtn() {
        findAnalyzesBtn.waitUntilClickable().click();
    }

    public void fillInputs(String INZCode, String bornDate, String surname) {
        typeInto(INZCodeInput, INZCode);
        typeInto(bornDateInput, bornDate);
        typeInto(surnameInput, surname);
    }

    public void fillInzCodeInput(String text) {
        typeInto(INZCodeInput, text);
    }

    public void fillBornDateInput(String text) {
        typeInto(bornDateInput, text);
    }

    public void fillSurnameInput(String text) {
        typeInto(surnameInput, text);
    }

    public boolean attentionIsPresent(String text) {
        return attentionMessage.isCurrentlyVisible()
                && attentionMessage.getText().equals(text);
    }

    public boolean isFieldRed() {
        String inz = getFieldColor(INZCodeInput);
        String born = getFieldColor(bornDateInput);
        String surname = getFieldColor(surnameInput);
        String red = "rgb(255, 0, 0)";

        return inz.equals(red)
                        && born.equals(red)
                        && surname.equals(red);
    }

    public boolean isPopUpOpened() {
        return analyzesPopUp.isCurrentlyVisible();
    }

    private String getFieldColor(WebElementFacade el) {
        return el.getCssValue("border-color");
    }



}
