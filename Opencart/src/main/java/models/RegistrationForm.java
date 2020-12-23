package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationForm {

    private final By firstname = By.id("input-firstname");
    private final By lastname = By.id("input-lastname");
    private final By email = By.id("input-email");
    private final By phone = By.id("input-telephone");
    private final By password = By.id("input-password");
    private final By confirm = By.id("input-confirm");
    private final By subscribe = By.className("radio-inline");
    private final By privateP = By.name("agree");


    public void SetFirstName(String firstname, WebDriver driver) {
        driver.findElement(this.firstname).sendKeys(firstname);
    }
    public void SetLastName(String lastname, WebDriver driver)
    {
        driver.findElement(this.lastname).sendKeys(lastname);
    }
    public void SetEmail(String email, WebDriver driver)
    {
        driver.findElement(this.email).sendKeys(email);
    }
    public void SetPhone(String phone, WebDriver driver)
    {
        driver.findElement(this.phone).sendKeys(phone);
    }
    public void SetPassword(String password, WebDriver driver)
    {
        driver.findElement(this.password).sendKeys(password);
    }
    public void SetConfirm(String confirm, WebDriver driver)
    {
        driver.findElement(this.confirm).sendKeys(confirm);
    }
    public void SetSubscribe(boolean subscribe, WebDriver driver) {
        List<WebElement> sub = driver.findElements(this.subscribe);
        checkSubscribe(sub, subscribe);
    }
    public void SetPolicy(boolean policy, WebDriver driver) {
        WebElement privatePolicy = driver.findElement(privateP);
        if (policy == true && !privatePolicy.isSelected()) {
            privatePolicy.click();
        }
    }

    public void loginFullUser(WebDriver driver, String firstname, String lastname, String email, String phone,
                          String password, String confirm,boolean subscribe,boolean privateP)
    {
        SetFirstName(firstname,driver);
        SetLastName(lastname,driver);
        SetEmail(email,driver);
        SetPhone(phone,driver);
        SetPassword(password,driver);
        SetConfirm(confirm,driver);
        SetSubscribe(subscribe,driver);
        SetPolicy(privateP,driver);

        ContinueBtn.Click(driver);
    }

    private void checkSubscribe(List<WebElement> sub, boolean Usubscribe){
        for (WebElement webElement : sub) {
            if(Usubscribe == true){
                if(webElement.getText().contains("Yes")){
                    webElement.click();
                }
            }
            if(Usubscribe == false){
                if(webElement.getText().contains("No")){
                    webElement.click();
                }
            }
        }
    }

}
