package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.MainPage;

public class SearchSteps {
    MainPage mainPage;

    @When("^Вввести код анализа в поле поиска \"([^\"]*)\"$")
    public void вввести_код_анализа_в_поле_поиска(String arg1) {
        mainPage.typeIntoSearchInput(arg1);
    }

    @Then("^Значение \"([^\"]*)\" указывается в строке поиска$")
    public void значение_указывается_в_строке_поиска(String arg1) {
        Assert.assertEquals(arg1, mainPage.getSearchInputValue());
    }

}
