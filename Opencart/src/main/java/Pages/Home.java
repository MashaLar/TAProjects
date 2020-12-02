package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Home {

    protected static WebDriver driver;

    private By search = By.name("search");
    private By searchBtn = By.className("input-group-btn");
    private By product = By.className("product-thumb");
    private By button = By.tagName("button");
    private By alertAboutAddInCart = By.cssSelector(".alert-dismissible");

    public Home(WebDriver driver){
        this.driver = driver;
        driver.get("https://demo.opencart.com/");
    }

    public void Search(String text)
    {

            driver.findElement(search).sendKeys(text);
            driver.findElement(searchBtn).click();

    }

    public void AddInCartFeatured(String nameProduct){
        try {
            List<WebElement> featured = driver.findElements(product);
            checkFeatured(featured,nameProduct);
        }catch (Exception e){
            System.out.println("Something get wrong!");
        }

    }

    public boolean AddInCartAlertArrive(){
        System.out.println(driver.findElement(alertAboutAddInCart).getText());
        return driver.findElement(alertAboutAddInCart).isDisplayed();
    }

    public void exit(){
        driver.close();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public WebDriver getDriver(){
        return driver;
    }

    private void checkFeatured(List<WebElement> featured, String nameProduct){
        for (WebElement webElement : featured) {
            if(webElement.findElement(By.tagName("h4")).getText().contains(nameProduct)){
               List<WebElement> buttons = webElement.findElements(button);
               FindAddCartButton(buttons);
            }
        }
    }

    private void FindAddCartButton(List<WebElement> buttons){
        for (WebElement webElement : buttons) {
            if(webElement.getText().contains("ADD TO CART")){
                webElement.click();
            }
        }
    }



}
