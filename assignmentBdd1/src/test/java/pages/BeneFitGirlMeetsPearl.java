package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BeneFitGirlMeetsPearl {
    public WebDriver driver = null;

    public BeneFitGirlMeetsPearl(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement outOfStockButton() {
        return driver.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[4]/ul/li/span"));
    }


}
