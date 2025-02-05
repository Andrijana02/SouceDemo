package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    private WebDriver driver;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }
    private By Complete = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");
    private By CompleteTitle = By.className("title");
    private By ButtonHome = By.id("back-to-products");

    public String getConfirmation(){
        return  driver.findElement(Complete).getText();
    }
    public String getTextFromCompleteTitle(){
        return driver.findElement(CompleteTitle).getText();
    }
    public void clickBackHome(){
        driver.findElement(ButtonHome).click();
    }
}
