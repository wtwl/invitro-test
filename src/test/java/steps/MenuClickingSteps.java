package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.RadiologyPage;

public class MenuClickingSteps {
    RadiologyPage radiologyPage;


    @Given("^I am on Radiology page$")
    public void i_am_on_Radiology_page() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        radiologyPage.open();
    }


    @When("^I click on menu items$")
    public void i_click_on_menu_items() throws Exception {
        radiologyPage.clickOnMenu();
    }

    @Then("^corresponding page opens$")
    public void corresponding_page_opens() throws Exception {

    }
}
