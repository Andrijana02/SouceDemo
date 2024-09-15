package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class YourCardPage {
    private WebDriver driver;

    public YourCardPage(WebDriver driver) {
        this.driver = driver;
    }
    private By boltTShirtTitle = By.id("item_1_title_link");
    private By boltTShibrtDesk = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[1]");
    private By boltTShirtPrice = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div");

    private By bikeLightTitle = By.id("item_0_title_link");
    private By bikeLightDesk = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[1]");
    private By bikeLightPrice = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div");
    private By removeButtonBikeLight = By.id("remove-sauce-labs-bike-light");
    private By cardItemNumber = By.className("shopping_cart_badge");
    private By continueShoppingButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");


    public String getBikeLightTitle(){
        return driver.findElement(bikeLightTitle).getText();
    }
    public String getBikeLightDesk(){
        return driver.findElement(bikeLightDesk).getText();
    }
    public String getBikeLightPrice(){
        return driver.findElement(bikeLightPrice).getText();
    }
    public String getBoltTShirtTitle(){
        return driver.findElement(boltTShirtTitle).getText();
    }
    public String getBoltTShirtDesk(){
        return driver.findElement(boltTShibrtDesk).getText();
    }
    public String getBoltTShirtPrice(){
        return driver.findElement(boltTShirtPrice).getText();
    }
    public void clickRemoveButtonBikeLight() {
        driver.findElement(removeButtonBikeLight).click();
    }
    public void clickContinueButton(){
        driver.findElement(continueShoppingButton).click();
    }
    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }
    public boolean isItemCardCountDisplayed(){
        try{
            driver.findElement(cardItemNumber).getText();
            return true;
        } catch (NoSuchElementException e){
        return false;
        }
    }
    public String itemCountOnCard(){
        return driver.findElement(cardItemNumber).getText();
    }
}

