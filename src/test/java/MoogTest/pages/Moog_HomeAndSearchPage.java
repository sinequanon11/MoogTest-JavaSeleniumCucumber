package MoogTest.pages;

import MoogTest.stepdefinitions.MoogParent;
import MoogTest.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Moog_HomeAndSearchPage extends MoogParent {

    public Moog_HomeAndSearchPage() {
        PageFactory.initElements( Driver.getDriver(), this );
    }

    @FindBy(xpath = "//button[text()='Accept']")
    public WebElement acceptAllCookies;

    @FindBy(css = ".Search-link")
    public WebElement searchButton;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement inputSearchBar;

    @FindBy( css= ".Search_Input-button")
    public WebElement searchItemButton;

    @FindBy( css= ".Advanced_Search--noresults")
    public WebElement noSearchResult;

    @FindBy( css= "div#web-page-results>div")
    public WebElement availableSearchResult;

    @FindBy( xpath= "//ul[@class='List List--all-results']/li")
    public List<WebElement> searchResults;


}
