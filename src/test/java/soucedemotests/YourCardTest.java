package soucedemotests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductPage;
import pages.YourCardPage;

import static org.junit.Assert.*;

public class YourCardTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private YourCardPage yourCardPage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucedemo.com/");

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        yourCardPage = new YourCardPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }
    @Test
    public void continueShoppingButtonTest(){
        productPage.clickYourCardIcon();
        yourCardPage.clickContinueButton();
        assertTrue(productPage.isProductsPageDisplayed());
    }
    @Test
    public void checkoutButtonTest(){
        productPage.clickYourCardIcon();
        yourCardPage.clickCheckoutButton();
       // assertTrue(productPage.isCheckoutYourInformationPageDisplayed());
    }
    @Test
    public void addOneItemToYourCardAndRemovedIt(){
        productPage.clickAddToCardBikeLight();
        assertEquals("1",productPage.itemCountOnCard());
        String bikeLightTitleProductsPage = productPage.getBikeLightTitle();
        String bikeLightDeskProductsPage = productPage.getBikeLightDesk();
        String bikeLightPriceProductsPage = productPage.getBikeLightPrice();
        productPage.clickYourCardIcon();
        assertEquals(bikeLightTitleProductsPage, yourCardPage.getBikeLightTitle());
        assertEquals(bikeLightDeskProductsPage, yourCardPage.getBikeLightDesk());
        assertEquals(bikeLightPriceProductsPage, yourCardPage.getBikeLightPrice());
        yourCardPage.clickRemoveButtonBikeLight();
        assertFalse(yourCardPage.isItemCardCountDisplayed());
    }

    @Test
    public void addTwoItemsToYourCardAndRemoveOneOfThem(){
        productPage.clickAddToCardBikeLight();
        productPage.clickAddToCardBoltTShirt();
        String boltTShirtTitle = productPage.getBoltTShirtTitle();
        String boltTShirtDesk = productPage.getBoltTShirtDesk();
        String boltTShirtPrice = productPage.getBoltTShirtPrice();

        assertEquals("2",productPage.itemCountOnCard());

        productPage.clickYourCardIcon();

        assertEquals(boltTShirtTitle, yourCardPage.getBoltTShirtTitle());
        assertEquals(boltTShirtDesk, yourCardPage.getBoltTShirtDesk());
        assertEquals(boltTShirtPrice, yourCardPage.getBoltTShirtPrice());

        yourCardPage.clickRemoveButtonBikeLight();
        assertEquals(yourCardPage.itemCountOnCard(),"1");
    }
}
