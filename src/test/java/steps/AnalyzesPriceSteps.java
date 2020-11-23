package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.AnalyzesPage;
import pages.BucketPage;
import pages.MainPage;

public class AnalyzesPriceSteps {

    AnalyzesPage analyzesPage;
    MainPage mainPage;
    BucketPage bucketPage;

    @Given("^На странице с анализами$")
    public void на_странице_с_анализами()  {
        analyzesPage.open();
    }


    @When("^Запомнить цену$")
    public void запомнить_цену()  {
        analyzesPage.savePrice(1);
    }

    @When("^Добавить анализ в корзину$")
    public void добавить_анализ_в_корзину()  {
        analyzesPage.addAnalyzeProductToBucket();
    }



    @When("^Перейти в корзину$")
    public void перейти_в_корзину()  {
        mainPage.closeAttentionPopup();
        mainPage.clickBucketButton();
    }

    @Then("^Сумма анализа совпадает с сохранённой ценой$")
    public void сумма_анализа_совпадает_с_сохранённой_ценой()  {
        Assert.assertEquals(analyzesPage.getCurrentPrice(), bucketPage.getPrice());
    }
    
}
