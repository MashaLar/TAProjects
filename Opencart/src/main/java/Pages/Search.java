package Pages;

import SiteBase.BasePage;
import models.Header;
import models.ProductBlock;
import models.SearchForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Search extends BasePage {

    private Header header = new Header();
    private SearchForm searchForm = new SearchForm();
    private ProductBlock productBlock;

    public Search(){
        super();
        GetProductBlock();
    }
    public Search(String browser){
        super(browser,"https://demo.opencart.com/index.php?route=product/search");
    }

    public void SearchByName(String name)
    {
        searchForm.SearchByName(driver,name);
    }

    public void SearchByNameAndCategory(String name, String categoryName) {
        searchForm.SearchByNameAndCategory(driver,name,categoryName);
    }

    public boolean FoundProductNameCheck(String name){
        GetProductBlock();
        List<WebElement> products =productBlock.GetProductBlocks();
        return SearchContainProductName(products,name);
    }

    public void SearchTopField(String text){
        header.Search(driver,text);
    }


    private  boolean SearchContainProductName(List<WebElement> products, String name) {
        for (WebElement webElement : products) {
            System.out.println(webElement.findElement(By.tagName("h4")).getText());
            if(webElement.findElement(By.tagName("h4")).getText().contains(name)){
                return true;
            }
        }
        return false;
    }

    private boolean SearchContainProductDescription(List<WebElement> products, String descriptionText) {
        for (WebElement webElement : products) {
           // System.out.println(webElement.findElement(By.tagName("p")).getText());
            if(webElement.findElement(By.tagName("p")).getText().contains(descriptionText)){
                return true;
            }
        }
        return false;
    }

    public void GetProductBlock(){
        productBlock = new ProductBlock(driver);
    }

}
