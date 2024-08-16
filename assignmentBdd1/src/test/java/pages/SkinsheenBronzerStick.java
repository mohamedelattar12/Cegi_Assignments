package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SkinsheenBronzerStick {
    public WebDriver driver=null;

    public SkinsheenBronzerStick(WebDriver driver){
        this.driver=driver;
    }

    public WebElement addToCart(){
        return driver.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[4]/ul/li/a"));
    }

    public WebElement quantityField(){
        return driver.findElement(By.xpath("//*[@id=\"product_quantity\"]"));
    }


}
