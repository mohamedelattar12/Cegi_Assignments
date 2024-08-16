package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart {
    public WebDriver driver = null;

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement checkOutButton() {
        return driver.findElement(By.xpath("//*[@id=\"cart_checkout1\"]"));
    }

    public WebElement emptyMessage() {
        return driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div"));
    }



}
