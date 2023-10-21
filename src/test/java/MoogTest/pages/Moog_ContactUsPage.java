package MoogTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import MoogTest.utilities.Driver;

public class Moog_ContactUsPage {

    public Moog_ContactUsPage() {
        PageFactory.initElements( Driver.getDriver(), this );
    }

    @FindBy( xpath= "(//a[@data-id='mn-8']//span)[1]")
    public WebElement mainPageContactUs;

    @FindBy(xpath= "(//p[text()='CONTACT US'])[1]")
    public WebElement findAnInSolContactUs;

    @FindBy( xpath= "(//a[@class='tab-link']//img)[2]")
    public WebElement optionConstruction;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement iframeAcceptButton;

    @FindBy(xpath = "//input[@id='Field1']")
    public WebElement iframeYourName;

    @FindBy(xpath = "//input[@id='Field3']")
    public WebElement iframeYourEmail;

    @FindBy(xpath = "//*[@id='Field7']")
    public WebElement iframeSelectProduct;

    @FindBy(xpath = "//*[@name='Field5']")
    public WebElement iframeYourMessage;

    @FindBy(xpath = "//*[@name='Field11']")
    public WebElement iframeAcceptEmail;

    @FindBy(xpath = "//*[@name='Field111']")
    public WebElement iframeAcceptPhone;

    @FindBy(id = "saveForm")
    public WebElement iframeSubmit;

    @FindBy(xpath = "//h3[@id='errorMsgLbl']")
    public WebElement iframeErrorMessage;
}
