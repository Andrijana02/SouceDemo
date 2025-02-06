package soucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductPage;

import static org.junit.Assert.assertEquals;


public class LoginPageTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;

    @Before
    public  void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucedemo.com/");

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);

    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void saucedemoLoginTests(){
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", loginPage.getLoginButtonFontType());
        assertEquals("16px", loginPage.getLoginButtonFontSize());
        loginPage.clickLogin();
        assertEquals("Products",productPage.getTextFromProductsTitle());
    }
    @Test
    public void unssacessfulsaucedemoLoginTests() {
        loginPage.enterUsername("standard_user");
        loginPage.clickLogin();
        assertEquals("#e2231a",loginPage.errorMessageContainerColor());
        assertEquals("Epic sadface: Password is required",loginPage.getErrorMessage());
    }

    @Test
    public void errorPasswordsaucedemoLoginTests() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("fgtd54");
        loginPage.clickLogin();
        assertEquals("#e2231a",loginPage.borderPasswordColor());
        assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getErrorMessage());
    }
    @Test
    public void emptyUsernamesaucedemoLoginTests() {
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        assertEquals("#e2231a",loginPage.borderUsernameColor());
        assertEquals("Epic sadface: Username is required",loginPage.getErrorMessage());

    }
    @Test
    public void emptyUsernameAndPasswordsaucedemoLoginTests() {
        loginPage.clickLogin();
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif",loginPage.getUsernameFieldFontType());
        assertEquals("14px",loginPage.getUsernameFieldFontSize());
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif",loginPage.getPasswordFieldFontType());
        assertEquals("14px",loginPage.getPasswordFieldFontSize());
        assertEquals("Epic sadface: Username is required",loginPage.getErrorMessage());
    }

}
