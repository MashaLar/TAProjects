package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchField {

    private final By search = By.name("search");
    private final By searchBtn = By.className("input-group-btn");

    public void Search(WebDriver driver, String text) {
        GetField(driver).sendKeys(text);
        GetButton(driver).click();
    }

    public WebElement GetField(WebDriver driver) {
        return driver.findElement(search);
    }

    public WebElement GetButton(WebDriver driver) {
        return driver.findElement(searchBtn);
    }
}
