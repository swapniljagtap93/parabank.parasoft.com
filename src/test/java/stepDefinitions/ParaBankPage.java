package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.TestContextSetup;

import java.time.Duration;


public class ParaBankPage {

    TestContextSetup testContextSetup;

    public ParaBankPage(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("User is on ParaBank Login page")
    public void userIsOnParaBankLoginPage() {
        System.setProperty("webdriver.chrome.driver", "D:\\BrowserDrivers\\chromedriver.exe");
        testContextSetup.driver = new ChromeDriver();
        testContextSetup.driver.get("""
                https://parabank.parasoft.com/parabank/index.html""");
        testContextSetup.driver.manage().window().maximize();
    }


    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String string, String string2) {
        testContextSetup.driver.findElement(By.xpath("//input[@name='username']")).sendKeys(string);
        testContextSetup.driver.findElement(By.xpath("//input[@name='password']")).sendKeys(string2);
    }

    @When("User clicks the Login button")
    public void user_clicks_the_login_button() {
        testContextSetup.driver.findElement(By.cssSelector("input[value='Log In']")).click();
        WebDriverWait wait = new WebDriverWait(testContextSetup.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Accounts Overview"));
    }

    @Then("User should be logged in and see the Accounts Overview page")
    public void user_should_be_logged_in_and_see_the_accounts_overview_page() {
        String expectedTitle = "ParaBank | Accounts Overview";
        String actualTitle = testContextSetup.driver.getTitle();
        if (!actualTitle.equals(expectedTitle)) {
            throw new AssertionError("Expected title: " + expectedTitle + ", but got: " + actualTitle);
        }
    }

    @Given("User is on the Accounts Overview page")
    public void user_is_on_the_accounts_overview_page() {
        String expectedTitle = "ParaBank | Accounts Overview";
        String actualTitle = testContextSetup.driver.getTitle();
        if (!actualTitle.equals(expectedTitle)) {
            throw new AssertionError("Expected title: " + expectedTitle + ", but got: " + actualTitle);
        }
    }

    @When("User clicks on {string} link")
    public void userClicksOnLink(String linkText) {
        switch (linkText) {
            case "Open New Account":
                testContextSetup.driver.findElement(By.linkText("Open New Account")).click();
                break;
            case "Transfer Funds":
                testContextSetup.driver.findElement(By.linkText("Transfer Funds")).click();
                break;
            case "Bill Pay":
                testContextSetup.driver.findElement(By.linkText("Bill Pay")).click();
                break;
            case "Find Transactions":
                testContextSetup.driver.findElement(By.linkText("Find Transactions")).click();
                break;
            case "Update Contact Info":
                testContextSetup.driver.findElement(By.linkText("Update Contact Info")).click();
                break;
            case "Request Loan":
                testContextSetup.driver.findElement(By.linkText("Request Loan")).click();
                break;
            case "Log Out":
                testContextSetup.driver.findElement(By.linkText("Log Out")).click();
                break;
        }
    }

    @Then("User should be navigated to the {string} page")
    public void userShouldBeNavigatedToPage(String pageName) {
        switch (pageName) {
            case "Open New Account":
                Assert.assertTrue(testContextSetup.driver.getTitle().contains("ParaBank | Open Account"));
                break;
            case "Transfer Funds":
                Assert.assertTrue(testContextSetup.driver.getTitle().contains("ParaBank | Transfer Funds"));
                break;
            case "Bill Pay":
                Assert.assertTrue(testContextSetup.driver.getTitle().contains("ParaBank | Bill Pay"));
                break;
            case "Find Transactions":
                Assert.assertTrue(testContextSetup.driver.getTitle().contains("ParaBank | Find Transactions"));
                break;
            case "Update Contact Info":
                Assert.assertTrue(testContextSetup.driver.getTitle().contains("ParaBank | Update Profile"));
                break;
            case "Request Loan":
                Assert.assertTrue(testContextSetup.driver.getTitle().contains("ParaBank | Loan Request"));
                break;
            case "Welcome":
                Assert.assertTrue(testContextSetup.driver.getTitle().contains("ParaBank | Welcome | Online Banking"));
                break;
        }
    }

    @After
    public void tearDown() {
        if (testContextSetup.driver != null) {
            testContextSetup.driver.quit();
        }
    }

}