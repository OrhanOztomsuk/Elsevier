package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class SummerDressesPage extends BasePage{

    public SummerDressesPage(){
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "ul.product_list.grid.row>li")
    private List<WebElement> summerDressesProducts;

    @FindBy(xpath = "//ul[@class='product_list grid row']/li//span[text()='Add to cart']")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//i[@class='icon-ok']/..")
    private WebElement successMessage;

    @FindBy(xpath = "//span[normalize-space(text())='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "ul.product_list.grid.row>li h5")
    private List<WebElement> summerDressesProductNames;

    public void hoverOverSummerDress(int index){
        hoverOverElement(summerDressesProducts.get(index));
    }


    public void clickOnAddToCartButton(int index){
        clickElement(addToCartButtons.get(index));
    }

    public String getSuccessMessageText(){
        return getTextOf(successMessage);
    }

    public void clickProceedToCheckoutButton(){
        clickElement(proceedToCheckoutButton);
    }

    public boolean isSuccessMessageDisplayed(){
       return isElementDisplayed(successMessage);
    }

    public String getSummerDressProductName(int index){
        return getTextOf(summerDressesProductNames.get(index));
    }

    public List<WebElement> getSummerDressesProducts(){
        return getWebElementList(summerDressesProducts);
    }


}
