package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ShoppingCartSummaryPage;
import pages.SignInPage;
import pages.SummerDressesPage;
import utilities.Driver;

import java.util.Random;

public class SummerDressesTest {

    HomePage homePage = new HomePage();
    SummerDressesPage summerDressesPage = new SummerDressesPage();
    ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage();
    SignInPage signInPage = new SignInPage();
    String firstSummerDressProductName;

    @BeforeClass
    public void setUp() {
        WebDriver driver = Driver.getDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void cleanUp() {
        Driver.closeDriver();
    }

    @Test
    public void summerDressesAddToCartTest(){

        homePage.hoverOverDressMenu();
        homePage.clickSummerDressesMenu();
        Random random = new Random();
        int randomIndex = random.nextInt(summerDressesPage.getSummerDressesProducts().size());
        firstSummerDressProductName = summerDressesPage.getSummerDressProductName(randomIndex);
        summerDressesPage.hoverOverSummerDress(randomIndex);
        summerDressesPage.clickOnAddToCartButton(randomIndex);
        Assert.assertTrue(summerDressesPage.isSuccessMessageDisplayed());
        String successMessageText = "Product successfully added to your shopping cart";
        Assert.assertEquals(summerDressesPage.getSuccessMessageText(),successMessageText);
    }

    @Test(dependsOnMethods = {"summerDressesAddToCartTest"})
    public void proceedToSignInTest(){

        summerDressesPage.clickProceedToCheckoutButton();
        Assert.assertTrue(shoppingCartSummaryPage.isShoppingCartSummaryPageTitleDisplayed());
        String shoppingCartSummaryPageTitle = "SHOPPING-CART SUMMARY";
        Assert.assertTrue(shoppingCartSummaryPage.getShoppingCartSummaryPageTitleText().contains(shoppingCartSummaryPageTitle));
        Assert.assertEquals(shoppingCartSummaryPage.getProductNameText(),firstSummerDressProductName);
        shoppingCartSummaryPage.clickProceedToCheckoutButton();
        Assert.assertTrue(signInPage.isAuthenticationDisplayed());
        Assert.assertEquals(signInPage.getAuthenticationText(),"AUTHENTICATION");
    }

}
