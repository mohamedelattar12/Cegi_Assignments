package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public WebDriver driver = null;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement loginOrRegister() {
        return driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a"));
    }

    public WebElement SkinsheenBronzerStickProduct() {
        return driver.findElement(By.xpath("//*[@id=\"block_frame_featured_1769\"]/div/div[1]/div[1]/div/a"));
    }

    public WebElement checkOut() {
        return driver.findElement(By.xpath("//*[@id=\"main_menu_top\"]/li[4]/a/span"));
    }

    public WebElement beneFitGirlMeetsPearlProduct() {
        return driver.findElement(By.xpath("//*[@id=\"block_frame_featured_1769\"]/div/div[2]/div[1]/div/a"));
    }

    public WebElement searchField() {
        return driver.findElement(By.xpath("//*[@id=\"filter_keyword\"]"));
    }
}
