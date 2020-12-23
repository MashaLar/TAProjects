package SiteBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseDriverOption {

    protected static WebDriver driver;
    private static Logger log = Logger.getLogger(BaseDriverOption.class.getName());

    public BaseDriverOption(String browser) {
        browser = browser.toLowerCase();
        if (browser.equals("chrome")) {
            SetChromeBrowser(browser);
        }
        else if (browser.equals("firefox")) {
            browser = "gecko";
            SetFirefoxBrowser(browser);
        }
        else if (browser.equals("opera")) {
            SetOperaBrowser(browser);
        }
        else {
            log.log( Level.SEVERE,"Wrong Browser Name!");
        }
    }

    public BaseDriverOption() {

    }

    public WebDriver getDriver() {
        return driver;
    }

    private void SetChromeBrowser(String browser) {
        SetPropertiesBrowser(browser);
        driver = new ChromeDriver();
        SetDriverSettings();
    }

    private void SetFirefoxBrowser(String browser) {
        SetPropertiesBrowser(browser);
        driver = new FirefoxDriver();
        SetDriverSettings();
    }

    private void SetOperaBrowser(String browser) {
        SetPropertiesBrowser(browser);
        driver = new OperaDriver();
        SetDriverSettings();
    }

    private void SetPropertiesBrowser(String browser) {

        try (InputStream fis = getClass().getClassLoader().getResourceAsStream("config.properties");) {
            Properties prop = new Properties();
            prop.load(fis);
            System.setProperty("webdriver."+browser+".driver", prop.getProperty(browser));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void SetDriverSettings() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

}
