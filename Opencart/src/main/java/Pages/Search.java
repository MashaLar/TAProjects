package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Search {

    protected static WebDriver driver;

    private By input = By.id("input-search");
    private By searchbtn = By.id("button-search");
    private By category = By.tagName("option");
    private By description = By.id("description");
    private By productBlock = By.className("product-thumb");

    public Search(WebDriver driver, String NameProduct){
        this.driver = driver;
        driver.get("https://demo.opencart.com/index.php?route=product/search&search="+NameProduct);
    }

    public Search(WebDriver driver){
        this.driver = driver;
    }

    public void SearchPageOpen(){
        driver.get("https://demo.opencart.com/index.php?route=product/search");
    }

    public void SearchByName(String name)
    {
        driver.findElement(input).sendKeys(name);
        driver.findElement(searchbtn).click();
    }

    public void SearchByNameAndCategory(String name, String categoryName)
    {
        driver.findElement(input).sendKeys(name);
        List<WebElement> categories = driver.findElements(category);
        SearchCategoryFirstContain(categories,categoryName);
        driver.findElement(searchbtn).click();
    }

    public void SearchByDescription(String descriptionText)
    {
        driver.findElement(input).sendKeys(descriptionText);
        driver.findElement(description).click();
        driver.findElement(searchbtn).click();
    }

    public boolean FoundProductNameCheck(String name){
        List<WebElement> products = driver.findElements(productBlock);
        return SearchContainProductName(products,name);
    }

    public boolean FoundProductDescriptionCheck(String descriptionText){
        List<WebElement> products = driver.findElements(productBlock);
        return SearchContainProductDescription(products,descriptionText);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void exit(){
        driver.close();
    }

    private void SearchCategoryFirstContain(List<WebElement> categories, String categoryName)
    {
        for (WebElement webElement : categories) {
            if(webElement.getText().contains(categoryName)){
                webElement.click();
                driver.findElement(searchbtn).click();
            }
        }
    }

    private boolean SearchContainProductName(List<WebElement> products, String name)
    {
        for (WebElement webElement : products) {
            System.out.println(webElement.findElement(By.tagName("h4")).getText());
            if(webElement.findElement(By.tagName("h4")).getText().contains(name)){
                return true;
            }
        }
        return false;
    }

    private boolean SearchContainProductDescription(List<WebElement> products, String descriptionText)
    {
        for (WebElement webElement : products) {
           // System.out.println(webElement.findElement(By.tagName("p")).getText());
            if(webElement.findElement(By.tagName("p")).getText().contains(descriptionText)){
                return true;
            }
        }
        return false;
    }


}
