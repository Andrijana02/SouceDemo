package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

import java.awt.*;

public class LoginPage {

    private WebDriver driver;

    //locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
//    private By errorMessageContainer = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }
//    public String getUsernameFieldFontType(){
//        return driver.findElement(usernameField).getCssValue("font-family");
//    }
//    public String usernameFieldFontSize(){
//        return driver.findElement(usernameField).getCssValue("font-size");
//    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();

    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
//    public String errorMessageContainerColor(){
//        Color errorMessageBackgroundColor = Color.fromString(driver.findElement(errorMessageContainer).getCssValue("background-color"));
//        return errorMessageBackgroundColor.asHex();
//    }
}