package chrome;

import Pages.Search;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class SearchPage {


    private Search search;

    @Before
    public void init() {
        search = new Search("chrome");
    }

    @Test
    public void ProductSearchIncorrectName_NegativeTC(){
        String product = "Canon   EOS erw";

        search.SearchByName(product);
        boolean actual = search.FoundProductNameCheck(product);

        Assert.assertFalse(actual);
    }

    @Test
    public void ProductSearchCorrectName_PositiveTC() throws InterruptedException {

        String product = "Canon EOS 5D";

        search.SearchByName(product);
        boolean actual = search.FoundProductNameCheck(product);


        assertTrue(actual);
    }

    @Test
    public void ProductSearchPartlyCorrectName_PositiveTC(){

        String product = "Can";

        search.SearchByName(product);
        boolean actual = search.FoundProductNameCheck(product);

        assertTrue(actual);
    }

    @Test
    public void ProductSearchWithWhitespacesBetweenWords_PositiveTC(){

        String inputProduct = "Canon   EOS 5D";
        String actualProduct = "Canon EOS 5D";

        search.SearchByName(inputProduct);
        boolean actual = search.FoundProductNameCheck(actualProduct);


        assertTrue(actual);
    }


/*
    //Not work
    @Test
    public void FindByDescription(){
        //given
        String addProduct = "Book";

        //
        search.SearchByDescription(addProduct);
        Product product = new Product(search.getDriver());
        boolean actual = product.CheckDescription(addProduct);

        //then
        Assert.assertTrue(actual);
    }

    //Not work
    @Test
    public void FindByNameAndCategory(){
        //given
        String product = "Book";
        String category = "Desktops";

        //
        search.SearchByNameAndCategory(product,category);
        boolean actual = search.FoundProductNameCheck(product);

        //then
        Assert.assertTrue(actual);
    }
*/

    @After
    public void close() {
        search.exit();
    }


}
