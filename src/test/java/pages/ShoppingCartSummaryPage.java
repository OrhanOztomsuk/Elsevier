package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummaryPage extends BasePage{

    public ShoppingCartSummaryPage(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tbody/tr[1]/td[2]/p/a")
    private WebElement productName;

    @FindBy(xpath = "(//span[normalize-space(text())='Proceed to checkout'])[2]")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "h1#cart_title")
    private WebElement shoppingCartSummaryPageTitle;

    public String getProductNameText(){
        return getTextOf(productName);
    }

    public void clickProceedToCheckoutButton(){
        clickElement(proceedToCheckoutButton);
    }

    public boolean isShoppingCartSummaryPageTitleDisplayed(){
        return isElementDisplayed(shoppingCartSummaryPageTitle);
    }

    public String getShoppingCartSummaryPageTitleText(){
        return getTextOf(shoppingCartSummaryPageTitle);
    }
}
