package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage {
    private WebDriver driver;

    public CheckoutYourInformationPage (WebDriver driver) {
        this.driver = driver;
    }


    private By checkoutYourInformationPage = By.className("title");
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By errorMessage = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3");
    private By cancelButton = By.id("cancel");

    public boolean isCheckoutYourInformationPageDisplayed(){
        return driver.findElement(checkoutYourInformationPage).getText().equals("Checkout: Your information");
    }
    public void enterFirstName(String value) {
        driver.findElement(firstNameField).sendKeys(value);
    }
    public void enterLastName(String value){
    driver.findElement(lastNameField).sendKeys(value);
    }
    public void enterZipCode(String value){
        driver.findElement(zipCodeField).sendKeys(value);
    }
    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }
    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
    public void clickCancelButton(){
        driver.findElement(cancelButton).click();
    }

}
