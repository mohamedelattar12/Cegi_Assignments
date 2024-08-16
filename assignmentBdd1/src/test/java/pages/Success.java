package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Success {
    public WebDriver driver = null;

    public Success(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement message(){
        return driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/h1/span[1]"));
    }

}
