package MoogTest.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import MoogTest.pages.Moog_HomeAndSearchPage;
import MoogTest.utilities.ConfigurationReader;
import MoogTest.utilities.Driver;


public class Moog_Homepage extends MoogParent{

    Moog_HomeAndSearchPage moog_page = new Moog_HomeAndSearchPage();

    @When("Go to Moog home page")
    public void go_to_moog_home_page() {
        Driver.getDriver().get( ConfigurationReader.getProperty( "homepage" ) );
    }

    @And("accept all cookies")
    public void acceptAllCookies() {
        clickFunction( moog_page.acceptAllCookies );
    }
}
