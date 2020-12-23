package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ColumnLinks {

    private final By column = By.className("col-sm-3");
    private final By nameColumn = By.tagName("h5");
    private final By links = By.tagName("li");

    public void ClickLink(WebElement element, String nameColumn, String nameLink){
        FoundLinkByName(element,nameColumn,nameColumn).click();
    }

    private List<WebElement> FoundColumns(WebElement element){
        return element.findElements(column);
    }

    private WebElement FoundByNameColumn(WebElement element, String name){
        for (WebElement foundColumn : FoundColumns(element)) {
            if(GetNameColumn(foundColumn).contains(name))
            {
                return foundColumn;
            }
        }
        return null;
    }

    private List<WebElement> FoundLinks(WebElement element, String name){
        return FoundByNameColumn(element,name).findElements(links);
    }

    private WebElement FoundLinkByName(WebElement element, String nameColumn, String nameLink){
        for (WebElement foundLink : FoundLinks(element, nameColumn)) {
            if(foundLink.getText().contains(nameLink)){
                return foundLink;
            }
        }
        return null;
    }

    private String GetNameColumn(WebElement element){
        return element.findElement(nameColumn).getText();
    }


}
