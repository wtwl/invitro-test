package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.MainPage;

public class TopBarMenuSteps {
    MainPage mainPage;

    @When("^Нажать на (Пациентам|Врачам|Франчайзинг|Корпоративным клиентам|Прессе)$")
    public void нажать_на(String arg1)  {
        mainPage.clickTopBarLinkByName(arg1);
    }

    @Then("^Совершен переход на соответсвующую (.*)$")
    public void совершен_переход_на_соответсвующую_страницу(String arg1) {
        System.out.println(mainPage.getUrl());
        Assert.assertTrue(mainPage.getUrl().endsWith(arg1));
    }

}
