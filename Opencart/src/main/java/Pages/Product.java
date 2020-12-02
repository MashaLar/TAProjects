package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Product {

    protected static WebDriver driver;

    private By description = By.id("tab-description");


    public Product(WebDriver driver){
        this.driver = driver;
    }

    public boolean CheckDescription(String text){
        return driver.findElement(description).getText().contains(text);
    }


}
