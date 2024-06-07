package StepDefinetion;

import Core.Helper;
import POM.WebElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ProductSelection {

    WebElements elements;
    static WebDriver driver;
    @Given("user hit on the Swag lab url")
    public void userHitOnTheSwagLabUrl() {
        Helper hp = new Helper();
        driver = hp.FireFoxLaunch();
    }

    @When("Input {string} and {string}")
    public void inputUsernameAndPassword(String username, String pass) throws InterruptedException {
        elements = new WebElements(driver);
        elements.userInput(username, pass);

    }

    @And("Select Multiple Product")
    public void selectMultipleProduct() throws InterruptedException {
        elements.ProductSelect();
    }
}
