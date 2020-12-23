package Pages;

import SiteBase.BasePage;
import models.Alerts;
import models.Header;
import models.ProductBlock;


public class Home extends BasePage {

    private Header header = new Header();
    private ProductBlock productBlock;
    private Alerts alerts = new Alerts();

    public Home( String browser){
        super(browser,"https://demo.opencart.com/");
        productBlock = new ProductBlock(driver);
    }

    public void Search(String text)
    {
        header.Search(driver,text);
    }

    public void AddInCart(String nameProduct){
       productBlock.AddInCartProduct(nameProduct);
    }
    public void AddToWish(String nameProduct){
        productBlock.AddToWishProduct(nameProduct);
    }
    public void AddToCompare(String nameProduct){
        productBlock.AddToCompareProduct(nameProduct);
    }

    public boolean AddInCartAlertArrive(){
        return alerts.AddInCartAlertArrive(driver);
    }
    public boolean AddToWishListAlertArrive(){
        return alerts.AddToWishListAlertArrive(driver);
    }
    public boolean AddToCompareAlertArrive(){
        return alerts.AddToCompareAlertArrive(driver);
    }

}
