package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropdownMenu {

    private final By dropdownItem = By.className("dropdown");
    private final By dropdownMenu = By.tagName("li");

    public void ClickOnDropdownItem(WebDriver driver, String name){
        FoundDropdownItemByName(driver,name).click();
    }
    public void ClickOnDropdownItemList(WebDriver driver, String nameDropdown, String nameItem){
        FoundDropdownItemListByName(FoundDropdownItemByName(driver,nameDropdown),nameItem).click();
    }

    private List<WebElement> FoundDropdownItems(WebDriver driver){
        return driver.findElements(dropdownItem);
    }

    private List<WebElement> FoundDropdownItemList(WebElement elements){
        return elements.findElements(dropdownMenu);
    }

    private WebElement FoundDropdownItemByName(WebDriver driver, String name){
        for (WebElement foundDropdownItem : FoundDropdownItems(driver)) {
            if(foundDropdownItem.getText().contains(name)){
                return foundDropdownItem;
            }
        }
        return null;
    }

    private WebElement FoundDropdownItemListByName(WebElement element, String name){
        for (WebElement foundDropdownItem : FoundDropdownItemList(element)) {
            if(foundDropdownItem.getText().contains(name)){
                return foundDropdownItem;
            }
        }
        return null;
    }



}
