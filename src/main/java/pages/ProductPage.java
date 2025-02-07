package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage {

    private WebDriver driver;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    private By productsTitle = By.className("title");
    private By mostExpensivePriceText = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
    private By bikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private By bikeLightTitle = By.id("item_0_title_link");
    private By bikeLightDesk = By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[2]/div[1]/div/text()");
    private By bikeLightPrice = By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[2]/div[2]/div/text()[2]");
    private By boltTShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By boltTShirtTitle = By.id("item_1_title_link");
    private By boltTShibrtDesk = By.xpath("//*[@id=\"inventory_container\"]/div/div[3]/div[2]/div[1]/div");
    private By boltTShirtPrice = By.xpath("//*[@id=\"inventory_container\"]/div/div[3]/div[2]/div[2]/div");
    private By yourCartIcon = By.id("shopping_cart_container");
    private By cartItemNumber = By.className("shopping_cart_badge");
    private By colorTitle = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    private By sizeOfTitle = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    private By fontOfTitle = By.xpath("//*[@id=\"item_4_title_link\"]/div");

    public String getTextFromProductsTitle(){
        return driver.findElement(productsTitle).getText();
    }
    public List<WebElement> getAllOptionsFromOrderingDropDown(){
        Select orderingDropDown = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
                return orderingDropDown.getOptions();
    }
    public void selectOrderingDropDownOption(int optionNumber){
        Select orderingDropDown = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        orderingDropDown.selectByIndex(optionNumber);
    }
    public String getTextFromOrderingDropDown(){
        Select orderingDropDown = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        return orderingDropDown.getFirstSelectedOption().getText();
    }
    public String getMostExpensivePriceText(){
        return driver.findElement(mostExpensivePriceText).getText();
    }

    public String itemCountOnCard() {
        return driver.findElement(cartItemNumber).getText();
    }

    public boolean isProductsPageDisplayed() {
        return driver.findElement(productsTitle).getText().equals("Products");
    }
    public void clickAddToCardBikeLight(){
        driver.findElement(bikeLight).click();
    }
    public void clickAddToCardBoltTShirt(){
        driver.findElement(boltTShirt).click();
    }
    public void clickYourCartIcon(){
        driver.findElement(yourCartIcon).click();
    }
    public String getFontOfTitle(){
        return driver.findElement(fontOfTitle).getCssValue("font-family");
    }
    public String getSizeOfTitle(){
        return driver.findElement(sizeOfTitle).getCssValue("font-size");
    }
    public String ColorTitle(){
        Color colorOfTitle = Color.fromString(driver.findElement(colorTitle).getCssValue("background-color"));return colorOfTitle.asHex();
    }
    public String colorTitle(){
        return driver.findElement(colorTitle).getCssValue("color");
    }
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

}
