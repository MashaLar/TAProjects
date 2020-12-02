package chrome;

import Pages.Home;
import Pages.Search;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HomePage {

    private Home home;

    @Before
    public void init() {
        try {
            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
            home = new Home(driver);
        }
        catch (Exception e){
            System.out.println("Wrong path!");
        }

    }

    @Test
    public void SearchTest() {

        //given
        String searchText = "Canon";

        //
        home.Search(searchText);
        Search search = new Search(home.getDriver());
        boolean actual = search.FoundProductNameCheck(searchText);

        //then
        Assert.assertTrue(actual);

    }

    @Test
    public void TitleTest() {

        //given
        String actual = home.getTitle();

        //expected
        String expected = "Your Store";

        //then
        Assert.assertEquals("'Your Store' - title", expected, actual );

    }

    @Test
    public void AddInCart(){
        //given
        String addProduct = "MacBook";

        //
        home.AddInCartFeatured(addProduct);
        boolean actual = home.AddInCartAlertArrive();

        //then
        Assert.assertTrue(actual);
    }


    @After
    public void close() {
        home.exit();
    }

}
