package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MainPage extends PageObject {

    @FindBy(xpath = "//div[@class='attention--header--block--desktop']")
    WebElementFacade attentionPopup;
    @FindBy(xpath = "//div[@class='attention--header--block--desktop']//div[@class='close-block']")
    WebElementFacade attentionPopupClose;
    @FindBy(xpath = "//div[contains(@class, 'header-cart')]/a")
    WebElementFacade bucketBtn;
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

}
