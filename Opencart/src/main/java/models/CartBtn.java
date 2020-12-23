package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartBtn {

    private final By cartBtn = By.id("cart");

    public void ClickOnBtnCart(WebDriver driver){
        FoundCartBtn(driver).click();
    }

    private WebElement FoundCartBtn(WebDriver driver){
        return driver.findElement(cartBtn);
    }
}
