package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccount {
    public WebDriver driver=null;

    public MyAccount(WebDriver driver){
        this.driver=driver;
    }

    public WebElement homeButon(){
        return driver.findElement(By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[1]/a"));
    }

}
