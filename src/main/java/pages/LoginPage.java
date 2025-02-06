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
    private By errorMessageContainer = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");
    private By borderPassword = By.xpath("//*[@id=\"password\"]");
    private By borderUsername = By.xpath("//*[@id=\"user-name\"]");
    private By usernameFieldFontType = By.id("user-name");
    private By usernameFieldFontSize = By.id("user-name");
    private By passwordFieldFontType = By.id("password");
    private By passwordFieldFontSize = By.id("password");
    private By loginButtonFontType = By.id("login-button");
    private By loginButtonFontSize = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }
    public String getUsernameFieldFontType(){
      return driver.findElement(usernameFieldFontType).getCssValue("font-family");
  }
  public String getUsernameFieldFontSize(){
      return driver.findElement(usernameFieldFontSize).getCssValue("font-size");
 }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public String getPasswordFieldFontType(){
        return driver.findElement(passwordFieldFontType).getCssValue("font-family");
    }
    public String getPasswordFieldFontSize(){
        return driver.findElement(passwordFieldFontSize).getCssValue("font-size");
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    public String getLoginButtonFontType(){
        return driver.findElement(loginButtonFontType).getCssValue("font-family");
    }
    public String getLoginButtonFontSize(){
        return driver.findElement(loginButtonFontSize).getCssValue("font-size");
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
   public String errorMessageContainerColor(){
       Color errorMessageBackgroundColor = Color.fromString(driver.findElement(errorMessageContainer).getCssValue("background-color"));return errorMessageBackgroundColor.asHex();
   }
   public String borderUsernameColor(){
       Color borderUsernameColor = Color.fromString(driver.findElement(borderUsername).getCssValue("border-bottom-color"));return borderUsernameColor.asHex();
   }
    public String borderPasswordColor(){
        Color borderPasswordColor = Color.fromString(driver.findElement(borderPassword).getCssValue("border-bottom-color"));return borderPasswordColor.asHex();
    }
}