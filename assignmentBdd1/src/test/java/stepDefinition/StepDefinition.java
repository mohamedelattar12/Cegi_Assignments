package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.*;

import java.security.Key;
import java.time.Duration;


public class StepDefinition {
    WebDriver driver = new EdgeDriver();
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    MyAccount myAccount = new MyAccount(driver);
    SkinsheenBronzerStick skinsheenBronzerStick = new SkinsheenBronzerStick(driver);
    ShoppingCart shoppingCart = new ShoppingCart(driver);
    CheckoutConfirmation checkoutConfirmation = new CheckoutConfirmation(driver);
    Success success = new Success(driver);
    BeneFitGirlMeetsPearl beneFitGirlMeetsPearl=new BeneFitGirlMeetsPearl(driver);
    Search search=new Search(driver);


    @Given("the user opens the automationteststore website")
    public void openAutomationteststoreWebsite() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://automationteststore.com/");
    }

    @And("the user clicks on the \"Login or register\" button")
    public void clickOnLoginOrRegister() {
        homePage.loginOrRegister().click();
    }

    @And("the user logs in using username {string} and password {string}")
    public void enterUsername_Password(String userName, String password) {
        loginPage.loginName().sendKeys(userName);
        loginPage.password().sendKeys(password);
        loginPage.loginButton().click();
    }

    @And("the user clicks on the home button")
    public void clickHomeButton() {
        myAccount.homeButon().click();
    }

    @Given("the user clicks on a product name \"Skinsheen Bronzer Stick\" which is in stock")
    public void clickOnProductName() {
        homePage.SkinsheenBronzerStickProduct().click();
    }

    @And("the user clicks the \"add to cart\" button")
    public void clickAddToCart() {
        skinsheenBronzerStick.addToCart().click();
    }

    @And("the user clicks the \"Checkout\" button")
    public void clickCheckout() {
        shoppingCart.checkOutButton().click();
    }

    @When("the user clicks the \"Confirm order\" button")
    public void clickConfirm() {
        checkoutConfirmation.confirmOrder().click();
    }

    @Then("the message \"Your Order Has Been Processed!\" appears after the purchase")
    public void assertSuccesmessage() throws InterruptedException {
        Thread.sleep(1000);
        String expectedSuccessMessage = "Your Order Has Been Processed!";
        String actualSuccessMessage = success.message().getText();
        Assert.assertTrue("Assert success message appear", actualSuccessMessage.toLowerCase().contains(expectedSuccessMessage.toLowerCase()));
    }
    @When("the user clicks the \"Checkout\" button at homepage")
    public void clickCheckoutHomePage(){
        homePage.checkOut().click();
    }

    @And("the user increases the quantity to {string}")
    public void increaseQuantity(String quantity) {
        skinsheenBronzerStick.quantityField().clear();
        skinsheenBronzerStick.quantityField().sendKeys(quantity);
    }

    @Then("the error message \"Your shopping cart is empty!\" appears")
    public void asserShopCartIsEmpty(){
        String expectedMessage="Your shopping cart is empty!";
        String actualMessage=shoppingCart.emptyMessage().getText();
        Assert.assertTrue("assert shop cart is empty",actualMessage.contains(expectedMessage));
    }

    @When("the user clicks on a product name \"BeneFit Girl Meets Pearl\" which is out of stock")
    public void clickOnBeneFitGirlMeetsPearl(){
        homePage.beneFitGirlMeetsPearlProduct().click();
    }
    @Then("the \"add to cart\" button should be disabled")
    public void checkAddCartButtonDisabled(){
        Assert.assertTrue("assert product out of stock",beneFitGirlMeetsPearl.outOfStockButton().getText().contains("Out of Stock"));
    }

    @Given("the user inserts a product name {string}")
    public void clickOnSearchField(String name){
        homePage.searchField().sendKeys(name);
    }

    @When("the user press Enter")
    public void clickEnter(){
        homePage.searchField().sendKeys(Keys.ENTER);
    }

    @Then("the searched product {string} appears correctly")
    public void checkProductAppearInTheSearch(String product){
        switch (product){
            case "Skinsheen Bronzer Stick":
                String expectedProduct = "Skinsheen Bronzer Stick";
                String actualProduct = driver.findElement(By.xpath("//*[@id=\"product_details\"]/div/div[2]/div/div/h1/span")).getText();
                Assert.assertTrue("assert search result",actualProduct.contains(expectedProduct));
                break;
            case "BeneFit Girl Meets Pearl":
                String expectedProduct1 = "BeneFit Girl Meets Pearl";
                String actualProduct1 = driver.findElement(By.xpath("//*[@id=\"product_details\"]/div/div[2]/div/div/h1/span")).getText();
                Assert.assertTrue("assert search result",actualProduct1.contains(expectedProduct1));
                break;
            default:
                Assert.assertTrue("u put product name doesnt exist",false);
                break;
        }

    }

    @And("the product should have a notice that it is out of stock")
    public void checkOutOfStock(){
        String expectedText="Out of Stock";
        String actualText=search.outOfStockButton().getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }

    @Then("the message \"There is no product that matches the search criteria.\" is displayed")
    public void ceckSearchMessage(){
        String expectedMessage="There is no product that matches the search criteria.";
        String actualMessage=search.searchMessage().getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @AfterStep
    public void afterStep() throws Exception {
        Thread.sleep(200);
    }

    @After
    public void afterScenario() throws Exception {
        Thread.sleep(1000);
        driver.quit();
    }
}
