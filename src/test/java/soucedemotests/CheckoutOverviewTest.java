package soucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertEquals;

public class CheckoutOverviewTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private YourCardPage yourCardPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;
    private CheckoutOverview checkoutOverview;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucedemo.com/");

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        yourCardPage = new YourCardPage(driver);
        checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        checkoutOverview = new CheckoutOverview(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }
    @After
    public void closeDriver(){
        driver.close();
    }

    @Test
    public void checkoutOverviewItemsPrice(){
        productPage.clickAddToCardBikeLight();
        productPage.clickAddToCardBoltTShirt();
        productPage.clickYourCardIcon();
        yourCardPage.clickCheckoutButton();
        checkoutYourInformationPage.enterFirstName("Andrijana");
        checkoutYourInformationPage.enterLastName("Ilievska");
        checkoutYourInformationPage.enterZipCode("2222");
        checkoutYourInformationPage.clickContinueButton();

        String priceOfFleeceJacketWithout$ = checkoutOverview.getPriceOfFleeceJacker().substring(1);
        String priceOfBikeLightWithout$ = checkoutOverview.getPriceOfBikeLight().substring(1);
        String taxPriceWithout$ = checkoutOverview.getPriceOfTax().substring(6);

        double priceOfFleeceJacketParsed = Double.parseDouble(priceOfFleeceJacketWithout$);
        double priceOfBikeLightParsed = Double.parseDouble(priceOfBikeLightWithout$);
        double priceOfTaxParsed = Double.parseDouble(taxPriceWithout$);

        double finalValue = priceOfFleeceJacketParsed+priceOfBikeLightParsed+priceOfTaxParsed;

        double rounded = Math.round(finalValue * 1000) / 1000;
        double finalValueOverall = 28.0;

        assertEquals(finalValueOverall, rounded, 0.0);

    }


}
