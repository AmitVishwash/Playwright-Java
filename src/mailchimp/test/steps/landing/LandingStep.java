package steps.landing;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.base.BaseStep;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import pages.home.LandingPage;

public class LandingStep {

    Page page = BaseStep.page;
    LandingPage landingPage = new LandingPage(this.page);


    @Given("the user opens the mailchimp application")
    public void userOpensTheMailchimpApplication() {
     landingPage.openApplication();
    }

    @When("the user clicks on Log In")
    public void theUserClicksOnLogIn() {
        landingPage.clickLogInButton();
    }

    @Then("the user should land on the home page of the application")
    public void userShouldLandOnTheHomePageOfApplication(){
        assertThat(this.page).hasURL("https://mailchimp.com/?currency=EUR");
    }

    @Then("the user should land on Login page")
    public void userShouldLandOnLoginPage(){
        assertThat(this.page).hasTitle("Login | Mailchimp");
    }


}
