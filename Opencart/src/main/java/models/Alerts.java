package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Alerts {

    private final By alertSuccess = By.cssSelector(".alert-success");
    private final By alertDanger = By.cssSelector(".alert-danger");

    public boolean AddInCartAlertArrive(WebDriver driver){
        WebElement alert = FindAlertSuccess(driver);
        if(alert.isDisplayed() && alert.getText().contains("shopping cart")){
            return true;
        }
        return false;
    }
    public boolean AddToWishListAlertArrive(WebDriver driver){
        WebElement alert = FindAlertSuccess(driver);
        if(alert.isDisplayed() && alert.getText().contains("wish list")){
            return true;
        }
        return false;
    }
    public boolean AddToCompareAlertArrive(WebDriver driver){
        WebElement alert = FindAlertSuccess(driver);
        if(alert.isDisplayed() && alert.getText().contains("product comparison")){
            return true;
        }
        return false;
    }

    public boolean AlertAboutPolicy(WebDriver driver){
        WebElement alert = FindAlertDanger(driver);
        if(alert.isDisplayed() &&
                alert.getText().contains("Warning: You must agree to the Privacy Policy!")){
            return true;
        }
        return false;
    }
    public boolean AlertAboutEmailRegistreted(WebDriver driver){
        WebElement alert = FindAlertDanger(driver);
        if(alert.isDisplayed() &&
                alert.getText().contains("Warning: E-Mail Address is already registered!")){
            return true;
        }
        return false;
    }

    private WebElement FindAlertSuccess(WebDriver driver){
        return driver.findElement(alertSuccess);
    }
    private WebElement FindAlertDanger(WebDriver driver){
        return driver.findElement(alertDanger);
    }
}
