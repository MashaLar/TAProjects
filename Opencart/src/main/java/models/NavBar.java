package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NavBar {

    private final By menu = By.id("menu");
    private final By items = By.tagName("li");

    private DropdownMenu dropdownMenu = new DropdownMenu();

    public void ClickItemByName(WebDriver driver, String name){
        FoundItemByName(driver,name).click();
    }

    public void ClickDropdownItemByName(WebDriver driver, String nameDropdown, String nameItem){
        dropdownMenu.ClickOnDropdownItem(driver,nameDropdown);
        dropdownMenu.ClickOnDropdownItemList(driver, nameDropdown, nameItem);
    }

    private WebElement FoundMenu(WebDriver driver){
        return driver.findElement(menu);
    }

    private List<WebElement> FoundMenuItems(WebDriver driver){
        return FoundMenu(driver).findElements(items);
    }

    private WebElement FoundItemByName(WebDriver driver, String name){
        for (WebElement foundMenuItem : FoundMenuItems(driver)) {
            if(foundMenuItem.getText().contains(name)){
                return foundMenuItem;
            }
        }
        return null;
    }


}
