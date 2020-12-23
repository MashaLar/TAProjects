package Pages;

import SiteBase.BasePage;
import models.Alerts;
import models.RegistrationForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Registration extends BasePage {

    private RegistrationForm registrationForm;

    private By dangerText = By.className("text-danger");
    private Alerts alerts = new Alerts();

    public Registration(String browser){
        super(browser,"https://demo.opencart.com/index.php?route=account/register");
        registrationForm = new RegistrationForm();
    }

    public void loginUser(String firstname, String lastname, String email, String phone,
                          String password, String confirm,boolean subscribe,boolean policy)
    {
       registrationForm.loginFullUser(driver,firstname,lastname,email,phone,password,confirm,subscribe,policy);
    }

    public boolean getAlertAboutFN(){
        return FoundDangerText("First Name must be between 1 and 32 characters!");
    }
    public boolean getAlertAboutLN(){
        return FoundDangerText("Last Name must be between 1 and 32 characters!");
    }
    public boolean getAlertAboutEmail(){
        return FoundDangerText("E-Mail Address does not appear to be valid!");
    }
    public boolean getAlertAboutPhone(){
        return FoundDangerText("Telephone must be between 3 and 32 characters!");
    }
    public boolean getAlertAboutPassword(){
        return FoundDangerText("Password must be between 4 and 20 characters!");
    }
    public boolean getAlertAboutConfirm(){
        return FoundDangerText("Password confirmation does not match password!");
    }
    public boolean getAlertAboutPolicy(){
        return alerts.AlertAboutPolicy(driver);
    }
    public boolean getAlertAboutEmailRegistreted(){
        return alerts.AlertAboutEmailRegistreted(driver);
    }

    private boolean FoundDangerText(String text){
        List<WebElement> dangers = driver.findElements(dangerText);
        for (WebElement webElement : dangers) {
            if(webElement.getText().contains(text)){
                return true;
            }
         }
        return false;
    }

}
