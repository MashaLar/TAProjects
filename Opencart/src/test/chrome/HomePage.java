package chrome;

import Pages.Home;

import Pages.Search;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class HomePage {

    private Home home;

    @Before
    public void init() {
        home = new Home("chrome");
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
    public void Search() {

        String product = "Canon EOS 5D";
        home.Search(product);

        Search search = new Search();
        boolean actual = search.FoundProductNameCheck(product);

        assertTrue(actual);

    }

    @Test
    public void ProductAddedInCart(){
        String addProduct = "MacBook";

        home.AddInCart(addProduct);
        boolean actual = home.AddInCartAlertArrive();

        assertTrue(actual);
    }

    @Test
    public void ProductAddedInWishList(){
        String addProduct = "MacBook";

        home.AddToWish(addProduct);
        boolean actual = home.AddToWishListAlertArrive();

        assertTrue(actual);
    }

    @Test
    public void ProductAddedToCompare(){
        String addProduct = "MacBook";

        home.AddToCompare(addProduct);
        boolean actual = home.AddToCompareAlertArrive();

        assertTrue(actual);
    }


    @After
    public void close() {
        home.exit();
    }

}
