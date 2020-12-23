package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Price {

    private final By prices = By.className("price");

    private final By newPrice = By.className("price-new");
    private final By oldPrice = By.className("price-new");
    private final By taxes = By.className("price-tax");

    public WebElement GetAllPrices(WebElement element){
        return element.findElement(prices);
    }
    public WebElement GetNewPrice(WebElement element){
        return element.findElement(newPrice);
    }
    public WebElement GetOldPrice(WebElement element){
        return element.findElement(oldPrice);
    }
    public WebElement GetTaxes(WebElement element){
        return element.findElement(taxes);
    }

    public String AllPricesString(WebElement element){
        return element.findElement(prices).getText();
    }
    public String NewPriceString(WebElement element){
        return element.findElement(newPrice).getText();
    }
    public String OldPriceString(WebElement element){
        return element.findElement(oldPrice).getText();
    }
    public String TaxesString(WebElement element){
        return element.findElement(taxes).getText();
    }
}
