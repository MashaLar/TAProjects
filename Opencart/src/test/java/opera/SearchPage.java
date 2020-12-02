package opera;

import Pages.Search;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SearchPage {


    private Search search;

    @Before
    public void init() {
        try {

            System.setProperty("webdriver.chrome.driver", "drivers\\operadriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
            search = new Search(driver);
            search.SearchPageOpen();
        }
        catch (Exception e){
            System.out.println("Wrong path!");
        }

    }

    @Test
    public void ProductSearchIncorrectName_NegativeTC(){
        //given
        String product = "Canon   EOS erw";

        //
        search.SearchByName(product);
        boolean actual = search.FoundProductNameCheck(product);

        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void ProductSearchCorrectName_PositiveTC(){
        //given
        String product = "Canon EOS 5D";

        //
        search.SearchByName(product);
        boolean actual = search.FoundProductNameCheck(product);

        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void ProductSearchPartlyCorrectName_PositiveTC(){
        //given
        String product = "Can";

        //
        search.SearchByName(product);
        boolean actual = search.FoundProductNameCheck(product);

        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void ProductSearchWithWhitespacesBetweenWords_PositiveTC(){
        //given
        String inputProduct = "Canon   EOS 5D";
        String actualProduct = "Canon EOS 5D";

        //
        search.SearchByName(inputProduct);
        boolean actual = search.FoundProductNameCheck(actualProduct);

        //then
        Assert.assertTrue(actual);
    }

/*
    //Not work
    @Test
    public void FindByDescription(){
        //given
        String addProduct = "book";

        //
        search.SearchByDescription(addProduct);
        boolean actual = search.FoundProductDescriptionCheck(addProduct);

        //then
        Assert.assertTrue(actual);
    }

    //Not work
    @Test
    public void FindByNameAndCategory(){
        //given
        String product = "Book";
        String category = "Desktop";

        //
        search.SearchByNameAndCategory(product,category);
        boolean actual = search.FoundProductNameCheck(product);

        //then
        Assert.assertTrue("Product founded", actual);
    }
*/

    @After
    public void close() {
        search.exit();
    }


}
