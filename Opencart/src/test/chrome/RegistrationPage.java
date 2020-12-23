package chrome;

import Pages.Registration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class RegistrationPage {

    private Registration registration;

    @Before
    public void init() {
        registration = new Registration("chrome");
    }

    @Test
    public void RegistrationNoneValidPolicy() {

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

        assertTrue(actual);

    }

    @Test
    public void RegistrationNoneValidFirstName() {

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

        assertTrue(actual);

    }

    @Test
    public void RegistrationNoneValidLastName() {

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

        assertTrue(actual);

    }

    @Test
    public void RegistrationNoneValidEmail() {

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

        assertTrue(actual);

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
        assertTrue(actual);

    }

    @Test
    public void RegistrationNoneValidPassword() {

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

        assertTrue(actual);

    }

    @Test
    public void RegistrationNoneValidConfirm() {

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

        assertTrue(actual);

    }

    @Test //One Time Test
    public void RegistrationValid() {

        String firstName = "Canon";
        String lastName = "Canon";
        String email = "Canon@can.can"; //should be changed for work!!!
        String phone = "Canon";
        String password = "Canon";
        String confirm = "Canon";
        boolean sub = true;
        boolean policy = false; //should be changed for work!!!

        registration.loginUser(firstName,lastName,email,phone,password,confirm,sub,policy);
        String actual = registration.getTitle();
        String expected = "Your Account Has Been Created!"; //https://demo.opencart.com/index.php?route=account/success

        Assert.assertEquals(expected,actual);

    }


    @After
    public void close() {
        registration.exit();
    }

}
