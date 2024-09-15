package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    private WebDriver driver;
    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }
    private By Complete = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");
    public String getConfirmation(){
        return  driver.findElement(Complete).getText();
    }
}
