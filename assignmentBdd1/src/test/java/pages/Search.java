package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search {
    public WebDriver driver = null;

    public Search(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement searchMessage(){
        return driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]"));
    }

    public WebElement outOfStockButton(){
        return driver.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[4]/ul/li/span"));
    }


}
