package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.MainPage;

public class CityChangeSteps {
    MainPage mainPage;

    @Given("^Нахожусь на главной странице$")
    public void нахожусь_на_главной_странице()  {
        mainPage.open();
    }

    @When("^Нажать на Ваш город$")
    public void нажать_на_Ваш_город()  {
        mainPage.clickChangeCity();
    }

    @When("^Нажать Выбрать другой$")
    public void нажать_Выбрать_другой()  {
        mainPage.clickChangeCityConfirm();
    }

    @When("^Ввеcти в поиск \"([^\"]*)\"$")
    public void ввеcти_в_поиск(String arg1)  {
        mainPage.enterCity(arg1);
    }

    @When("^Выбрать город из списка$")
    public void выбрать_город_из_списка()  {
        mainPage.selectCity();
    }

    @Then("^Отображается Ваш город: Омск$")
    public void отображается_Ваш_город_Омск()  {
        Assert.assertEquals(mainPage.getSelectedCity(), "Омск");
    }
}
