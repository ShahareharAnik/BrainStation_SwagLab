package StepDefinetion;

import POM.WebElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static StepDefinetion.ProductSelection.driver;

public class CartNavigation {
WebElements elements;

    @Given("User in the All Product Page")
    public void userInTheAllProductPage() {
        System.out.println("User is in the Product list");
        elements = new WebElements(driver);
    }

    @When("Go to the Cart page")
    public void goToTheCartPage() throws InterruptedException {

        elements.Cart();
    }

    @And("Verify the FirstProduct {string} and {string}")
    public void verifyTheFirstProductFirstnameAndFirstprice(String name, String Price) {
        elements.FirstItemCheck(name, Price);
    }

    @And("Verify the SecondProduct {string} and {string}")
    public void verifyTheSecondProductSecondnameAndFirstprice(String name, String price) {
        elements.SecondItemCheck(name, price);
    }

    @Then("The  Navigation is done")
    public void theNavigationIsDone() {

        System.out.println("Product is Checked");
    }
}
