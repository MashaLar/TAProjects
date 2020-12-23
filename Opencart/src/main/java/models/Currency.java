package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Currency {

    private final By currency = By.id("form-currency");

    private final By euro = By.name("EUR");
    private final By sterling = By.name("GBP");
    private final By dollar = By.name("USD");

    public void ChangeCurrencyEuro(WebDriver driver){
        FoundEuro(driver).click();
    }
    public void ChangeCurrencySterling(WebDriver driver){
        FoundSterling(driver).click();
    }
    public void ChangeCurrencyDollar(WebDriver driver){
        FoundDollar(driver).click();
    }

    private WebElement FoundFormCurrency(WebDriver driver){
        return driver.findElement(currency);
    }

    private WebElement FoundEuro(WebDriver driver){
        return FoundFormCurrency(driver).findElement(euro);
    }

    private WebElement FoundSterling(WebDriver driver){
        return FoundFormCurrency(driver).findElement(sterling);
    }

    private WebElement FoundDollar(WebDriver driver){
        return FoundFormCurrency(driver).findElement(dollar);
    }


}
