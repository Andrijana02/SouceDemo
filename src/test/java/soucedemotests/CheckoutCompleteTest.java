package soucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertEquals;
//comment
public class CheckoutCompleteTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private YourCardPage yourCardPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;
    private CheckoutOverview checkoutOverview;
    private CheckoutCompletePage checkoutCompletePage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/checkout-complete.html");

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        yourCardPage = new YourCardPage(driver);
        checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        checkoutOverview = new CheckoutOverview(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
//coment
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        driver.get("https://www.saucedemo.com/checkout-complete.html");
    }
    @Test
    public void CheckoutCompleteConfigurationTests(){
        assertEquals("Thank you for your order!",checkoutCompletePage.getConfirmation());
        assertEquals("Checkout: Complete!",checkoutCompletePage.getTextFromCompleteTitle());
       checkoutCompletePage.clickBackHome();
       assertEquals("Products",productPage.getTextFromProductsTitle());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
