package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Registration {


    protected static WebDriver driver;

    private By firstname = By.id("input-firstname");
    private By lastname = By.id("input-lastname");
    private By email = By.id("input-email");
    private By phone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By confirm = By.id("input-confirm");
    private By subscribe = By.className("radio-inline");
    private By privateP = By.name("agree");
    private By continueBtn = By.cssSelector(".btn-primary");

    private By dangerText = By.className("text-danger");
    private By alert = By.cssSelector(".alert-dismissible");

    public Registration(WebDriver driver){
        this.driver = driver;
        driver.get("https://demo.opencart.com/index.php?route=account/register");
    }

    public void loginUser(String Ufirstname, String Ulastname, String Uemail, String Uphone,
                          String Upassword, String Uconfirm,boolean Usubscribe,boolean UprivateP)
    {
        try {
            driver.findElement(firstname).sendKeys(Ufirstname);
            driver.findElement(lastname).sendKeys(Ulastname);
            driver.findElement(email).sendKeys(Uemail);
            driver.findElement(phone).sendKeys(Uphone);
            driver.findElement(password).sendKeys(Upassword);
            driver.findElement(confirm).sendKeys(Uconfirm);
            List<WebElement> sub = driver.findElements(subscribe);
            checkSubscribe(sub, Usubscribe);
            if (UprivateP == true) {
                driver.findElement(privateP).click();
            }

            driver.findElement(continueBtn).click();

        }catch (Exception e){
            System.out.println("Something get wrong!");
        }

    }

    public String getTitle(){
        return driver.getTitle();
    }

    public boolean getAlertAboutFN(){
        return FoundDanderText("First Name must be between 1 and 32 characters!");
    }
    public boolean getAlertAboutLN(){
        return FoundDanderText("Last Name must be between 1 and 32 characters!");
    }
    public boolean getAlertAboutEmail(){
        return FoundDanderText("E-Mail Address does not appear to be valid!");
    }
    public boolean getAlertAboutPhone(){
        return FoundDanderText("Telephone must be between 3 and 32 characters!");
    }
    public boolean getAlertAboutPassword(){
        return FoundDanderText("Password must be between 4 and 20 characters!");
    }
    public boolean getAlertAboutConfirm(){
        return FoundDanderText("Password confirmation does not match password!");
    }
    public boolean getAlertAboutPolicy(){
        return driver.findElement(alert).getText().contains("Warning: You must agree to the Privacy Policy!");
    }
    public boolean getAlertAboutEmailRegistreted(){
        return driver.findElement(alert).getText().contains("Warning: E-Mail Address is already registered!");
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

    private boolean FoundDanderText(String text){
        List<WebElement> dangers = driver.findElements(dangerText);
        for (WebElement webElement : dangers) {
            if(webElement.getText().contains(text)){
                return true;
            }
         }
        return false;
    }

    public void exit(){
        driver.close();
    }
}
