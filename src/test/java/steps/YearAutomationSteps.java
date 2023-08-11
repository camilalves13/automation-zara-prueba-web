package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.YearAutomationPage;
import runner.RunCucumberTest;

public class YearAutomationSteps extends RunCucumberTest {

    private YearAutomationPage automationPage = new YearAutomationPage();

    @Given("^the user is on the Google homepage$")
    public void the_user_is_on_the_Google_homepage() {
        automationPage.getGooglePage();
    }

    @When("^the user searches for the word \"([^\"]*)\"$")
    public void the_user_searches_for_the_word(String word) {
        automationPage.searchByText(word);
    }

    @Then("^the user clicks on the link related to Wikipedia$")
    public void the_user_clicks_on_the_link_related_to_Wikipedia() {
        automationPage.clickWikipediaLink();
    }

    @And("^the user checks the information about the year of the first automatic process year \"([^\"]*)\"$")
    public void the_user_checks_the_information_about_the_year_of_the_first_automatic_process(String year) {
        boolean isYearExists = automationPage.yearAutomation(year);
        Assert.assertTrue(isYearExists);
    }

    @And("^the user checks the information about the year of the first automatic process year do not exists \"([^\"]*)\"$")
    public void the_user_checks_the_information_about_the_year_of_the_first_automatic_process_year_invalid(String year) {
        boolean isYearExists = automationPage.yearAutomation(year);
        Assert.assertFalse(isYearExists);
    }

    @And("^the user takes a screenshot of the Wikipedia page$")
    public void the_user_takes_a_screenshot_of_the_Wikipedia_page() {
        automationPage.takeScreenshotWikipediaPage("wikipedia_page");
    }
}
