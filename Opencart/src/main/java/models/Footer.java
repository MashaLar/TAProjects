package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footer {

    private final By footer = By.tagName("footer");
    private final By officialInfo = By.tagName("p");

    private ColumnLinks columnLinks = new ColumnLinks();

    public void ClickLink(WebDriver driver, String nameColumn, String nameLink){
        columnLinks.ClickLink(FoundFooter(driver),nameColumn,nameLink);
    }

    public String GetTextOfficialInfo(WebDriver driver){
        return FoundOfficialInfo(driver).getText();
    }

    private WebElement FoundFooter(WebDriver driver){
        return driver.findElement(footer);
    }

    private WebElement FoundOfficialInfo(WebDriver driver){
        return FoundFooter(driver).findElement(officialInfo);
    }
}
