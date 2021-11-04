package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage extends BasePage{

    public SignInPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h1.page-heading")
    private WebElement authentication;

    public String getAuthenticationText(){
        return getTextOf(authentication);
    }

    public boolean isAuthenticationDisplayed(){
        return isElementDisplayed(authentication);
    }

}
