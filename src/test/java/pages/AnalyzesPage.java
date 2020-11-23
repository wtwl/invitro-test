package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;



@DefaultUrl("https://www.invitro.ru/analizes/for-doctors/ryazan/")
public class AnalyzesPage extends PageObject {
    String analyzeXpath = "//div[@data-entity='items-row']//div[@class='show-block-wrap']";
    String titleXpath = "div[@class='result-item__title']";
    String priceXpath = "/.//span[@class='result-item__price']";
    String bucketBtnXpath = "/.//div[contains(@class, \'add_basket\')]";
    String currentAnalyzeProduct;
    String currentPrice;


    private String getAnalyzeXpath(int position) {
        return "(" + analyzeXpath + ")" + "[" + position + "]";
    }

    private String getChild(String parentXpath, String childXpath) {
        return parentXpath + childXpath;
    }

    public void selectAnalyzeItemByNumber(int i) {
        currentAnalyzeProduct = getAnalyzeXpath(i);
    }




    public void savePrice(int i) {
        selectAnalyzeItemByNumber(i + 1);
        String currentPriceXpath = getChild(currentAnalyzeProduct, priceXpath);
        currentPrice = findBy(currentPriceXpath).getText();
    }

    public void addAnalyzeProductToBucket() {
        String currentAddToBucketXpath = getChild(currentAnalyzeProduct, bucketBtnXpath);
        findBy(currentAddToBucketXpath).waitUntilClickable().click();
    }

    public String getCurrentPrice() {
        return currentPrice.replaceAll("\\D+", "");
    }



}
