package StepDefinetion;

import POM.WebElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static StepDefinetion.ProductSelection.driver;

public class Checkout {
    WebElements elements;

    @Given("User click on the checkout")
    public void userClickOnTheCheckout() {
        System.out.println("User is in the cart list");
        elements = new WebElements(driver);

    }

    @And("user input {string} and {string} and {string}")
    public void userInputFirstnameAndLastNameAndZipCode(String name, String last,String zip) throws InterruptedException {
    elements.Checkout();
    elements.InputCredential(name, last, zip);


    }

    @And("Continue to overview")
    public void continueToOverview() {
        System.out.println("user in the overview");
    }

    @And("Check the {string} with SoftAccertion")
    public void checkTheTotalPricesWithSoftAccertion(String Price) throws InterruptedException {
        elements.TotalPrice(Price);
    }


}
