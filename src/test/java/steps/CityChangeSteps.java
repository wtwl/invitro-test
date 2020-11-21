package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.Menu;

public class CityChangeSteps {
    Menu menu;

    @Given("^Нахожусь на главной странице$")
    public void нахожусь_на_главной_странице() throws Exception {
        menu.open();
    }


    @When("^Нажать на Ваш город$")
    public void нажать_на_Ваш_город() throws Exception {
        menu.clickChangeCity();
    }

    @When("^Нажать Выбрать другой$")
    public void нажать_Выбрать_другой() throws Exception {
        menu.clickChangeCityConfirm();
    }

    @When("^Ввеcти в поиск \"([^\"]*)\"$")
    public void ввеcти_в_поиск(String arg1) throws Exception {
        menu.enterCity(arg1);
    }

    @When("^Выбрать город из списка$")
    public void выбрать_город_из_списка() throws Exception {
        menu.selectCity();
    }

    @Then("^Отображается Ваш город: Омск$")
    public void отображается_Ваш_город_Омск() throws Exception {
        Assert.assertEquals(menu.getSelectedCity(), "Омск");
    }
}
