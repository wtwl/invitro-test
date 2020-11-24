package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.AnalyzesPopup;
import pages.MainPage;

public class AnalyzesPopupSteps {

    MainPage mainPage;
    AnalyzesPopup analyzesPopup;


    @Given("^Нажать Получить результаты анализов$")
    public void нажать_Получить_результаты_анализов()  {
        mainPage.closeAttentionPopup();
        analyzesPopup.clickOnGetAnalyzesResult();
    }

    @Given("^Поп-ап открылся$")
    public void поп_ап_открылся() {
        Assert.assertTrue(analyzesPopup.isPopUpOpened());
    }

    @When("^Нажать Найти результаты$")
    public void нажать_Найти_результаты(){
        analyzesPopup.clickOnFindAnalyzesBtn();
    }

    @Then("^Поля выделены красным$")
    public void поля_выделены_красным(){
        Assert.assertTrue(analyzesPopup.isFieldRed());
    }

    @Then("^Появилось Предупреждение \"([^\"]*)\"$")
    public void появилось_Предупреждение(String arg1) {
        Assert.assertTrue(analyzesPopup.attentionIsPresent(arg1));
    }


    @When("^Заполнить поле Код ИНЗ: \"([^\"]*)\"$")
    public void заполнить_поле_Код_ИНЗ(String arg1){
        analyzesPopup.fillInzCodeInput(arg1); 
    }


    @When("^Заполнить поле Дата рождения: \"([^\"]*)\"$")
    public void заполнить_поле_Дата_рождения(String arg1){
        analyzesPopup.fillBornDateInput(arg1);
    }

    @When("^Заполнить поле Фамилия: \"([^\"]*)\"$")
    public void заполнить_поле_Фамилия(String arg1){
        analyzesPopup.fillSurnameInput(arg1);
    }

    @Then("^Появилось предупреждение$")
    public void появилось_предупреждение(String arg1){
        analyzesPopup.attentionIsPresent(arg1);
    }

}
