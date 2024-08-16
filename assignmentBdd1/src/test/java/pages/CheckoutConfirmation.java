package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutConfirmation {
    public WebDriver driver = null;

    public CheckoutConfirmation(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement confirmOrder() {
        return driver.findElement(By.xpath("//*[@id=\"checkout_btn\"]"));
    }

}
