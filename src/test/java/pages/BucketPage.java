package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class BucketPage extends PageObject {

    @FindBy(xpath = "//ul[contains(@class, 'main_basketlist')]/li[1]")
    WebElementFacade firstItemInBucket;


    public String getPrice() {
        String priceWithCurrency = firstItemInBucket
                .findElement(By.xpath("//span[@class='basket-list__item-price']")).getText();
        return priceWithCurrency.replaceAll("\\D+", "");
    }


}
