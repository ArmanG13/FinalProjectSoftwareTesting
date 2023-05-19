package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 10);
    }

    public void openUrl(String url){
        driver.get(url);
    }
    public void closeBrowser(){
        driver.quit();
    }
    public void maximizeWindow(){
        driver.manage().window().maximize();
    }
}

