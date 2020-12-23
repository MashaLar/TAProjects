package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContinueBtn {

    public static void Click(WebDriver driver){
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }
}
