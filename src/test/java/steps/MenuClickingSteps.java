package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.RadiologyPage;

public class MenuClickingSteps {
    RadiologyPage radiologyPage;
    
    @Given("^Нахожусь на странице Медицинские услуни$")
    public void нахожусь_на_странице_Медицинские_услуни() {
        radiologyPage.open();
    }


    @When("^Перейти по каждому пункту меню$")
    public void перейти_по_каждому_пункту_меню() {
        radiologyPage.clickOnMenu();
    }

    @Then("^Открывается страница соответствующего меню$")
    public void открывается_страница_соответствующего_меню() {
    }
    
    
}
