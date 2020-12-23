package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductBlock {

    private final By block = By.className("product-thumb");

    private final By image = By.className("image");
    private final By caption = By.className("caption");
    private final By title = By.tagName("h4");

    private List<WebElement> productBlocks;

    private ProductButtons buttons;
    private Price price = new Price();

    public ProductBlock(WebDriver driver) {
        productBlocks = driver.findElements(block);
    }

    public void GetButtonsForProductBlock(WebElement element){
        buttons = new ProductButtons(element);
    }

    public WebElement GetProductBlock(String nameProduct){
        for (WebElement webElement :  productBlocks) {
            if(webElement.findElement(By.tagName("h4")).getText().contains(nameProduct)){
                return webElement;
            }
        }
        return null;
    }

    public void GetProduct(String nameProduct){
        GetButtonsForProductBlock(GetProductBlock(nameProduct));
    }
    public void AddInCartProduct(String nameProduct){
        GetProduct(nameProduct);
        buttons.GetAddCartBtn().click();
    }
    public void AddToWishProduct(String nameProduct){
        GetProduct(nameProduct);
        buttons.GetAddWishList().click();
    }
    public void AddToCompareProduct(String nameProduct){
        GetProduct(nameProduct);
        buttons.GetAddCompareList().click();
    }

    public WebElement GetProductImage(String nameProduct){
        return GetProductBlock(nameProduct).findElement(image);
    }
    public WebElement GetProductCaption(String nameProduct){
        return GetProductBlock(nameProduct).findElement(caption);
    }
    public WebElement GetProductTitle(String nameProduct){
        return GetProductBlock(nameProduct).findElement(title);
    }

    public String GetProducNewPrice(String nameProduct){
        return price.NewPriceString(GetProductBlock(nameProduct));
    }
    public String GetProducOldPrice(String nameProduct){
        return price.OldPriceString(GetProductBlock(nameProduct));
    }
    public String GetProducTaxPrice(String nameProduct){
        return price.TaxesString(GetProductBlock(nameProduct));
    }

    public List<WebElement> GetProductBlocks(){
        return productBlocks;
    }
}
