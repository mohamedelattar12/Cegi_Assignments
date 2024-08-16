package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver=null;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement loginName(){
        return driver.findElement(By.id("loginFrm_loginname"));
    }
    public WebElement password(){
        return driver.findElement(By.id("loginFrm_password"));
    }
    public WebElement loginButton(){
        return driver.findElement(By.xpath("//*[@id=\"loginFrm\"]/fieldset/button"));
    }
}
