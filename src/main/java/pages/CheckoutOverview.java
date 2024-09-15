package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverview {
    private WebDriver driver;
    public CheckoutOverview(WebDriver driver){
        this.driver = driver;
    }
    private By priceOfBikeLight = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
    private By priceOfFleeceJacket = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]/div");
    private By priceOfTax = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]");

    public String getPriceOfBikeLight(){
        return  driver.findElement(priceOfBikeLight).getText();
    }
    public String getPriceOfFleeceJacker(){
        return driver.findElement(priceOfFleeceJacket).getText();
    }
    public String getPriceOfTax(){
        return driver.findElement(priceOfTax).getText();
    }

}
