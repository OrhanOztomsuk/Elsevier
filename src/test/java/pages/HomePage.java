package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;


public class HomePage extends BasePage{

    public HomePage(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[@title='Dresses']/..)[2]")
    private WebElement dressesMenu;

    @FindBy(xpath = "(//a[@title='Summer Dresses']/..)[2]")
    private WebElement summerDressesMenu;


    public void hoverOverDressMenu(){
        hoverOverElement(dressesMenu);
    }
    public void clickSummerDressesMenu(){
        clickElement(summerDressesMenu);
    }

}


