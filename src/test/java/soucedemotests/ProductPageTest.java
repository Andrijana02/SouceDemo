package soucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductPage;

import static org.junit.Assert.assertEquals;

public class ProductPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucedemo.com/");

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

    }

    @After
    public void closeDriver() {
        driver.close();
    }

    @Test
    public void orderingDropDownTest() {
        assertEquals("Name (A to Z)", productPage.getAllOptionsFromOrderingDropDown().get(0).getText());
        assertEquals("Name (Z to A)", productPage.getAllOptionsFromOrderingDropDown().get(1).getText());
        assertEquals("Price (low to high)", productPage.getAllOptionsFromOrderingDropDown().get(2).getText());
        assertEquals("Price (high to low)", productPage.getAllOptionsFromOrderingDropDown().get(3).getText());
    }

    @Test

    public void orderingProductFromDropDownPrice() {
        productPage.selectOrderingDropDownOption(3);
        assertEquals("Price (high to low)", productPage.getTextFromOrderingDropDown());
        assertEquals("$49.99", productPage.getMostExpensivePriceText());
    }

    @Test
    public void titleTest() {
        assertEquals("#000000", productPage.ColorTitle());
        assertEquals("20px", productPage.getSizeOfTitle());
        assertEquals("\"DM Mono\", sans-serif", productPage.getFontOfTitle());
        assertEquals("rgba(24, 88, 58, 1)", productPage.colorTitle());
    }
}
