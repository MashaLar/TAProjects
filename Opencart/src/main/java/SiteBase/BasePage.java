package SiteBase;

import org.openqa.selenium.WebDriver;

public abstract class BasePage extends BaseDriverOption {

    public BasePage(String browser){
        super(browser);
    }
    public BasePage(String browser, String URL){
        super(browser);
        super.driver.get(URL);
    }
    public BasePage( ){
        super();
    }

    public String getTitle(){
        return driver.getTitle();
    }
    public void exit(){
        driver.close();
    }

}
