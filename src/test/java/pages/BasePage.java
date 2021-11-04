package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import java.util.List;


public class BasePage {

    WebDriver driver = Driver.getDriver();

    WebDriverWait wait = new WebDriverWait(driver, 10);

    protected void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected WebElement getElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected List<WebElement> getWebElementList(List<WebElement> list) {
        for (WebElement webElement : list) {
            wait.until(ExpectedConditions.visibilityOf(webElement));
        }
        return list;
    }

    protected void hoverOverElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions mouse = new Actions(driver);
        mouse.moveToElement(element).perform();
    }

    protected String getTextOf(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText().trim();
    }

    protected boolean isElementDisplayed(WebElement element){
       return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
}
