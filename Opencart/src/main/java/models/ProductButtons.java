package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductButtons {

    private final By buttonGroup = By.className("button-group");
    private final By button = By.tagName("button");

    private List<WebElement> productButtons;

    public ProductButtons(WebElement element){
        productButtons = GetButtons(element);
    }

    public WebElement GetGroup(WebElement element){
        return element.findElement(buttonGroup);
    }
    public List<WebElement> GetButtons(WebElement element){
        return GetGroup(element).findElements(button);
    }
    public WebElement GetAddCartBtn(){
        return productButtons.get(0);
    }
    public WebElement GetAddWishList(){
            return productButtons.get(1);
    }
    public WebElement GetAddCompareList(){
        return productButtons.get(2);
    }

}
