package MoogTest.stepdefinitions;

import MoogTest.utilities.ExcelUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import MoogTest.pages.Moog_HomeAndSearchPage;
import MoogTest.utilities.Driver;

public class Moog_Search extends MoogParent {

    Moog_HomeAndSearchPage moog_page = new Moog_HomeAndSearchPage();

    @When("Clicking the Search button")
    public void clickingTheSearchButton() {
        clickFunction( moog_page.searchButton );
    }

    @And("Entering <{string}> in the Search bar")
    public void enteringInTheSearchBar(String string) {
        sendKeysFunction( moog_page.inputSearchBar, "artilleries" );
    }

    @And("Clicking the Search item button")
    public void clickingTheSearchItemButton() {
        clickFunction( moog_page.searchItemButton );
    }

    @Then("Asserting that this item is not available on the web page")
    public void assertingThatThisItemIsNotAvailableOnTheWebPage() {
        Assert.assertTrue( moog_page.noSearchResult.getText().contains( "we couldn’t find" ) );
    }

    @And("Entering the <{string}> in the Search bar")
    public void enteringTheInTheSearchBar(String string) {
        sendKeysFunction( moog_page.inputSearchBar, "artillery" );
    }

    @Then("Asserting that this item is available on the web page")
    public void assertingThatThisItemIsAvailableOnTheWebPage() {
        Assert.assertTrue( moog_page.availableSearchResult.getText().contains( "Showing results" ) );

    }

    @And("Entering the item from the {string} sheet in the Excel file into the Search bar")
    public void enteringTheItemFromTheSheetInTheExcelFileIntoTheSearchBar(String sheetName) {
        ExcelUtils excelUtils = new ExcelUtils( "src/test/resources/MoogSearch.xlsx", sheetName );
        String searchItem = excelUtils.getCellData( 0, 0 );
        sendKeysFunction( moog_page.inputSearchBar, searchItem );
    }

    @Then("Asserting that the search result is greater than <{string}>")
    public void assertingThatTheSearchResultIsGreaterThan(String expectedValue) {
        for (int i = 0; i < moog_page.searchResults.size(); i++) {
            int numberOfElements = moog_page.searchResults.size();
            int intExpectedValue = Integer.parseInt( expectedValue );
            Assert.assertTrue( numberOfElements > intExpectedValue );
        }
    }

    @And("Entering the item <{string}> in the Search bar")
    public void enteringTheItemInTheSearchBar(String string) {
        sendKeysFunction( moog_page.inputSearchBar, "cloud" );
    }

    @Then("Asserting that the number of search results of <{string}> is the same of the actual search results")
    public void assertingThatTheNumberOfSearchResultsOfIsTheSameOfTheActualSearchResults(String string) {
        for (int i = 0; i < moog_page.searchResults.size(); i++) {
            String expectedNumberInString = String.valueOf( moog_page.searchResults.size() );
            String actualNumberInString = "152";
            Assert.assertEquals(expectedNumberInString, actualNumberInString);
        }
    }
}


