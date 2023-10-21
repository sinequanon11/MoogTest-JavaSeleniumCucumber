package MoogTest.stepdefinitions;

import MoogTest.pages.Moog_ContactUsPage;
import MoogTest.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import MoogTest.utilities.Driver;

public class Moog_ContactUs extends MoogParent {

    Moog_ContactUsPage contactUsPage = new Moog_ContactUsPage();
    Actions actions = new Actions( Driver.getDriver() );

    @When("Clicking Contact Us")
    public void clicking_contact_us() {
        clickFunction( contactUsPage.mainPageContactUs );

    }

    @And("Clicking Find an Industry Solution Contact Us and Construction")
    public void clicking_find_an_industry_solution_contact_us_and_construction() {

        actions.moveToElement( contactUsPage.findAnInSolContactUs ).click().perform();

        actions.moveToElement( contactUsPage.optionConstruction ).click().perform();

        Driver.getDriver().switchTo().frame( 0 );

        actions.moveToElement( contactUsPage.iframeAcceptButton ).click().perform();
    }

    @Then("Asserting that we are on the Construction page")
    public void assertingThatWeAreOnTheConstructionPage() {
        String expectedURL = "https://www.moog.com/contact-us/markets.construction.html";
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals( expectedURL, actualURL );
    }

    @And("Entering full name {string}")
    public void enteringFullName(String string) {

        sendKeysFunction( contactUsPage.iframeYourName, string );
    }

    @And("Entering invalid {string}")
    public void enteringInvalid(String string) {
        sendKeysFunction( contactUsPage.iframeYourEmail, string );
    }

    @And("Selecting a product")
    public void selectingAProduct() {
        Select selectObject = new Select( contactUsPage.iframeSelectProduct );
        selectObject.selectByIndex( 4 );
    }

    @Then("Entering Message")
    public void entering_message()  {
        sendKeysFunction( contactUsPage.iframeYourMessage, "I want to have more information" );

    }

    @Then("Clicking to Agree that Customer can be contacted by Email and Phone")
    public void clicking_to_agree_that_customer_can_be_contacted_by_email_and_phone() throws InterruptedException {

        ReusableMethods.clickJSElementWithJavaScript("document.querySelector(\"#Field11\")"  );
        ReusableMethods.clickJSElementWithJavaScript( "document.querySelector(\"#Field111\")" );

    }

    @And("Submitting the form")
    public void submittingTheForm() {

        ReusableMethods.clickJSElementWithJavaScript( "document.querySelector(\"#saveForm\")" );
    }

    @Then("Submission is not successful")
    public void submission_is_not_successful() {
        Assert.assertTrue( contactUsPage.iframeErrorMessage.getText().contains( "problem" ) );
        Driver.quitDriver();
    }


}


