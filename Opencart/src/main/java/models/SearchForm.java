package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchForm {

    private final By input = By.id("input-search");
    private final By searchbtn = By.id("button-search");
    private final By category = By.tagName("option");

    public void SearchByName(WebDriver driver,String name) {
        driver.findElement(input).sendKeys(name);
        driver.findElement(searchbtn).click();
    }
    public void SearchByNameAndCategory(WebDriver driver, String name, String categoryName) {
        driver.findElement(input).sendKeys(name);
        List<WebElement> categories = driver.findElements(category);
        SearchCategoryFirstContain(driver,categories,categoryName);
        driver.findElement(searchbtn).click();
    }
    private void SearchCategoryFirstContain(WebDriver driver, List<WebElement> categories, String categoryName) {
        for (WebElement webElement : categories) {
            if(webElement.getText().contains(categoryName)){
                webElement.click();
                driver.findElement(searchbtn).click();
            }
        }
    }
}
