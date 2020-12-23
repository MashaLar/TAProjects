package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {

    private final By topMenu = By.id("top");
    private final By items = By.id("hidden-xs hidden-sm hidden-md");

    private SearchField searchField = new SearchField();
    private NavBar navBar = new NavBar();
    private Currency currency = new Currency();
    private CartBtn cartBtn = new CartBtn();

    public void Search(WebDriver driver, String text)
    {
        searchField.Search(driver,text);
    }

    public void GoToCart(WebDriver driver)
    {
        cartBtn.ClickOnBtnCart(driver);
    }

    public void ChangeToEuro(WebDriver driver)
    {
        currency.ChangeCurrencyEuro(driver);
    }
    public void ChangeToSterling(WebDriver driver)
    {
        currency.ChangeCurrencySterling(driver);
    }
    public void ChangeToDollar(WebDriver driver)
    {
        currency.ChangeCurrencyDollar(driver);
    }

    public void GoToNavBarItemByName(WebDriver driver, String nameItem)
    {
        navBar.ClickItemByName(driver,nameItem);
    }
    public void GoToNavBarItemByName(WebDriver driver, String nameDropdown, String nameItem) {
        navBar.ClickDropdownItemByName(driver,nameDropdown,nameItem);
    }

}
