package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class WebElements {
    WebDriver driver;
    Actions actions;
    SoftAssert softAssert;

    public WebElements(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        actions = new Actions(this.driver);
        softAssert = new SoftAssert();  // Initialize the soft assertion object
    }

    By Username = By.xpath("//input[@id='user-name']");
    By Password = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//input[@id='login-button']");
    By FirstProductAdd = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    By SecondProductAdd = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
    By CartIcon = By.xpath("//a[@class='shopping_cart_link']");
    By FirstProductName  = By.xpath("//div[normalize-space()='Sauce Labs Backpack']");
    By FirstProductPrice = By.xpath("//div[3]//div[2]//div[2]//div[1]");
    By SecondProductPrice = By.xpath("//div[4]//div[2]//div[2]//div[1]");
    By SecondProduct = By.xpath("//div[normalize-space()='Sauce Labs Bike Light']");
    By Checkout = By.xpath("//button[@id='checkout']");
    By Firstname = By.xpath("//input[@id='first-name']");
    By Lastname = By.xpath("//input[@id='last-name']");
    By Zipcodes = By.xpath("//input[@id='postal-code']");
    By Continue = By.xpath("//input[@id='continue']");
    By TotalPrice = By.xpath("//div[@class='summary_total_label']");
    By Finish = By.xpath("//button[@id='finish']");

    public void userInput(String username, String password) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(Username).click();
        driver.findElement(Username).sendKeys(username);
        driver.findElement(Password).click();
        driver.findElement(Password).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void ProductSelect() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(FirstProductAdd).click();
        driver.findElement(SecondProductAdd).click();
    }

    public void Cart() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(CartIcon).click();
    }

    public void FirstItemCheck(String name, String price) {
        WebElement nameElement = driver.findElement(FirstProductName);
        String actualName = nameElement.getText();
        WebElement priceElement = driver.findElement(FirstProductPrice);
        String actualPrice = priceElement.getText();

        softAssert.assertEquals(actualName, name, "Product name does not match");
        softAssert.assertEquals(actualPrice, price, "Product price does not match");

        System.out.println("Product name: " + actualName);
        System.out.println("Product price: " + actualPrice);
    }

    public void SecondItemCheck(String name, String price) {
        WebElement nameElement = driver.findElement(SecondProduct);
        String actualName = nameElement.getText();
        WebElement priceElement = driver.findElement(SecondProductPrice);
        String actualPrice = priceElement.getText();

        System.out.println("Second Product name: " + actualName);
        System.out.println("Second Product price: " + actualPrice);

        softAssert.assertEquals(actualName, name, "Product name does not match");
        softAssert.assertEquals(actualPrice, price, "Product price does not match");
    }

    public void Checkout() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(Checkout).click();
    }

    public void InputCredential(String name, String last, String Zipcode) throws InterruptedException {
        driver.findElement(Firstname).click();
        driver.findElement(Firstname).sendKeys(name);

        driver.findElement(Lastname).click();
        driver.findElement(Lastname).sendKeys(last);

        driver.findElement(Zipcodes).click();
        driver.findElement(Zipcodes).sendKeys(Zipcode);
        Thread.sleep(2000);
        driver.findElement(Continue).click();
    }

    public void TotalPrice(String ACPrice) throws InterruptedException {
        Thread.sleep(2000);
        WebElement TPrice = driver.findElement(TotalPrice);
        String price = TPrice.getText();
        System.out.println("/////////////////////////////" + price);
        softAssert.assertEquals(price, ACPrice, "Product price does not match");

        driver.findElement(Finish).click();

        Thread.sleep(2000);
        driver.quit();
    }

    public void assertAll() {
        softAssert.assertAll();  // This method will aggregate all soft assertion failures and report them
    }
}
