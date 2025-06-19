package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.TestContextSetup;

import java.util.List;

public class ParaBankRegistration {
  //  public WebDriver driver;
    TestContextSetup testContextSetup;

    public ParaBankRegistration(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @When("User click on the Register link")
    public void userClickOnTheRegisterLink() {
        testContextSetup.driver.findElement(By.linkText("Register")).click();
    }

    @Then("User should navigate to the Registration page")
    public void userShouldNavigateToTheRegistrationPage() throws InterruptedException {
        String expectedTitle = "ParaBank | Register for Free Online Account Access";
        String actualTitle = testContextSetup.driver.getTitle();
        if (!actualTitle.equals(expectedTitle)) {
            throw new AssertionError("Expected URL: " + expectedTitle + ", but got: " + actualTitle);
        }
        Thread.sleep(2000);
    }


    @And("User enters enter all the fields on the registration page")
    public void userEntersEnterAllTheFieldsOnTheRegistrationPage(List<List<String>> data) {
        List<String> fields = data.get(0);
        testContextSetup.driver.findElement(By.id("customer.firstName")).sendKeys(fields.get(0));
        testContextSetup.driver.findElement(By.id("customer.lastName")).sendKeys(fields.get(1));
        testContextSetup.driver.findElement(By.id("customer.address.street")).sendKeys(fields.get(2));
        testContextSetup.driver.findElement(By.id("customer.address.city")).sendKeys(fields.get(3));
        testContextSetup.driver.findElement(By.id("customer.address.state")).sendKeys(fields.get(4));
        testContextSetup.driver.findElement(By.id("customer.address.zipCode")).sendKeys(fields.get(5));
        testContextSetup.driver.findElement(By.id("customer.phoneNumber")).sendKeys(fields.get(6));
        testContextSetup.driver.findElement(By.id("customer.ssn")).sendKeys(fields.get(7));
        testContextSetup.driver.findElement(By.id("customer.username")).sendKeys(fields.get(8));
        testContextSetup.driver.findElement(By.id("customer.password")).sendKeys(fields.get(9));
        testContextSetup.driver.findElement(By.id("repeatedPassword")).sendKeys(fields.get(10));
    }

    @Then("User submits the registration form")
    public void user_submits_the_registration_form() {
        testContextSetup.driver.findElement(By.xpath("//input[@value='Register']")).click();
        // Optionally, you can add a wait here to ensure the page loads before proceeding
        try {
            Thread.sleep(2000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("User should see a confirmation message")
    public void user_should_see_a_confirmation_message() {
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        String actualMessage = testContextSetup.driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']")).getText();
        if (!actualMessage.contains(expectedMessage)) {
            throw new AssertionError("Expected message: " + expectedMessage + ", but got: " + actualMessage);
        }
    }
}
