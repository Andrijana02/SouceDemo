package soucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckoutYourInformationPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.YourCardPage;

import static org.junit.Assert.*;

public class CheckoutYourInformationPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private YourCardPage yourCardPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucedemo.com/");

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        yourCardPage = new YourCardPage(driver);
        checkoutYourInformationPage = new CheckoutYourInformationPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }


    @Before
    public void setUpForCheckout(){
        productPage.clickYourCartIcon();
        yourCardPage.clickCheckoutButton();
    }
    @After
    public void closeDriver(){
        driver.close();
    }

    @Test
    public void cancelButtonTest(){
        checkoutYourInformationPage.clickCancelButton();
        assertFalse(checkoutYourInformationPage.isCheckoutYourInformationPageDisplayed());

    }
    @Test
    public void successfulCheckoutTest(){
        checkoutYourInformationPage.enterFirstName("Andrijana");
        checkoutYourInformationPage.enterLastName("Ilievska");
        checkoutYourInformationPage.enterZipCode("2222");
        checkoutYourInformationPage.clickContinueButton();

    }
    @Test
    public void emptyFieldError(){
        checkoutYourInformationPage.clickContinueButton();
        assertEquals("Error: First Name is required",checkoutYourInformationPage.getErrorMessage());
    }
    @Test
    public void emptyZipCode(){
        checkoutYourInformationPage.enterFirstName("Andrijana");
        checkoutYourInformationPage.enterLastName("Ilievska");
        checkoutYourInformationPage.clickContinueButton();
        assertEquals("Error: Postal Code is required",checkoutYourInformationPage.getErrorMessage());
    }
    @Test
    public void emptyLastName(){
        checkoutYourInformationPage.enterFirstName("Andrijana");
        checkoutYourInformationPage.enterZipCode("2222");
        checkoutYourInformationPage.clickContinueButton();
        assertEquals("Error: Last Name is required",checkoutYourInformationPage.getErrorMessage());
    }
    @Test
    public void emptyFirstName(){
        checkoutYourInformationPage.enterLastName("Ilievska");
        checkoutYourInformationPage.enterZipCode("2222");
        checkoutYourInformationPage.clickContinueButton();
        assertEquals("Error: First Name is required",checkoutYourInformationPage.getErrorMessage());
    }
}
