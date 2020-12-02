package chrome;

import Pages.Registration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationPage {

    private Registration registration;

    @Before
    public void init() {
        try {

            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
            registration = new Registration(driver);
        }
        catch (Exception e){
            System.out.println("Wrong path!");
        }

    }

    @Test
    public void RegistrationNoneValidPolicy() {

        //given
        String firstName = "Canon";
        String lastName = "Canon";
        String email = "Canon@can.can";
        String phone = "Canon";
        String password = "Canon";
        String confirm = "Canon";
        boolean sub = true;
        boolean policy = false;

        registration.loginUser(firstName,lastName,email,phone,password,confirm,sub,policy);
        boolean actual = registration.getAlertAboutPolicy();

        //then
        Assert.assertTrue(actual);

    }

    @Test
    public void RegistrationNoneValidFirstName() {

        //given
        String firstName = "";
        String lastName = "Larykova";
        String email = "mashalar01@gmail.om";
        String phone = "0504216666";
        String password = "1234567";
        String confirm = "1234567";
        boolean sub = true;
        boolean policy = true;

        registration.loginUser(firstName,lastName,email,phone,password,confirm,sub,policy);
        boolean actual = registration.getAlertAboutFN();

        //then
        Assert.assertTrue(actual);

    }

    @Test
    public void RegistrationNoneValidLastName() {

        //given
        String firstName = "Maria";
        String lastName = "";
        String email = "mashalar01@gmail.om";
        String phone = "0504216666";
        String password = "1234567";
        String confirm = "1234567";
        boolean sub = true;
        boolean policy = true;

        registration.loginUser(firstName,lastName,email,phone,password,confirm,sub,policy);
        boolean actual = registration.getAlertAboutLN();

        //then
        Assert.assertTrue(actual);

    }

    @Test
    public void RegistrationNoneValidEmail() {

        //given
        String firstName = "Maria";
        String lastName = "Larykova";
        String email = "";
        String phone = "0504216666";
        String password = "1234567";
        String confirm = "1234567";
        boolean sub = true;
        boolean policy = true;

        registration.loginUser(firstName,lastName,email,phone,password,confirm,sub,policy);
        boolean actual = registration.getAlertAboutEmail();

        //then
        Assert.assertTrue(actual);

    }

    @Test
    public void RegistrationNoneValidPhone() {

        //given
        String firstName = "Maria";
        String lastName = "Larykova";
        String email = "mashalar01@gmail.om";
        String phone = "";
        String password = "1234567";
        String confirm = "1234567";
        boolean sub = true;
        boolean policy = true;

        registration.loginUser(firstName,lastName,email,phone,password,confirm,sub,policy);
        boolean actual = registration.getAlertAboutPhone();

        //then
        Assert.assertTrue(actual);

    }

    @Test
    public void RegistrationNoneValidPassword() {

        //given
        String firstName = "Maria";
        String lastName = "Larykova";
        String email = "mashalar01@gmail.om";
        String phone = "0504216666";
        String password = "";
        String confirm = "";
        boolean sub = true;
        boolean policy = true;

        registration.loginUser(firstName,lastName,email,phone,password,confirm,sub,policy);
        boolean actual = registration.getAlertAboutPassword();

        //then
        Assert.assertTrue(actual);

    }

    @Test
    public void RegistrationNoneValidConfirm() {

        //given
        String firstName = "Maria";
        String lastName = "Larykova";
        String email = "mashalar01@gmail.om";
        String phone = "0504216666";
        String password = "1234567";
        String confirm = "1345678";
        boolean sub = true;
        boolean policy = true;

        registration.loginUser(firstName,lastName,email,phone,password,confirm,sub,policy);
        boolean actual = registration.getAlertAboutConfirm();

        //then
        Assert.assertTrue(actual);

    }

    @Test //One Time Test
    public void RegistrationValid() {

        //given
        String firstName = "Canon";
        String lastName = "Canon";
        String email = "Canon@can.can"; //should be changed for work!!!
        String phone = "Canon";
        String password = "Canon";
        String confirm = "Canon";
        boolean sub = true;
        boolean policy = false; //should be changed for work!!!

        //
        registration.loginUser(firstName,lastName,email,phone,password,confirm,sub,policy);
        String actual = registration.getTitle();
        String expected = "Your Account Has Been Created"; //https://demo.opencart.com/index.php?route=account/success

        //then
        Assert.assertEquals(expected,actual);

    }


    @After
    public void close() {
        registration.exit();
    }

}
