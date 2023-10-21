package MoogTest.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ReusableMethods {

    public static void clickJSElementWithJavaScript(String javascriptPath) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebElement webElement = (WebElement) jse.executeScript( "return " + javascriptPath + "" );
        jse.executeScript( "arguments[0].click();", webElement );
    }

    /**
     * This method retrieves the text content of an element in the DOM using its XPath.
     *
     * @param xpath The XPath of the element from which to get the text value, provided as a string.
     * @return The text content of the specified element.
     */
    public static String getTextWithJavaScriptXpath(String xpath) {
        WebElement element = Driver.getDriver().findElement( By.xpath( xpath ));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        String text = (String) jsExecutor.executeScript( "return arguments[0].textContent;", element );
        return text;
    }


    public static void hoverOverElement(WebElement element) {
        Actions actions = new Actions( Driver.getDriver() );
        actions.moveToElement( element ).perform();
    }

}
