package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinition {
    WebDriver driver = null;
    @Given("User is on NetBanking landing page")
    public void userIsOnNetBankingLandingPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
    }

    @When("User login into application with username and password")
    public void userLoginIntoApplicationWithUsernameAndPassword() {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("test.user");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("abcd");
        WebElement login = driver.findElement(By.xpath("//div[@class='login']//input[@type='submit']"));
        login.click();
    }

    @Then("Home page is populated")
    public void homePageIsPopulated() {
        String homepage = driver.getTitle();
        if(homepage.contains("ParaBank | Accounts Overview")) {
            System.out.println("Homepage verified");
        }
        else {
            System.out.println("Homepage not verified");
        }
    }

    @And("Cards are displayed")
    public void cardsAreDisplayed() {
        WebElement card = driver.findElement(By.id("rightPanel"));
        if(card.isDisplayed()) {
            System.out.println("cards are displayed");
        }
        else {
            System.out.println("card not displayed");
        }
    }

    @When("User login into application with {string} and password {string}")
    public void userLoginIntoApplicationWithAndPassword(String arg0, String arg1) {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys(arg0);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(arg1);
        WebElement login = driver.findElement(By.xpath("//div[@class='login']//input[@type='submit']"));
        login.click();
    }

    @And("Cards displayed are {string}")
    public void cardsDisplayedAre(String arg0) {
        System.out.println(arg0);
    }

    @When("User login in to application with {string} and password {string}")
    public void userLoginInToApplicationWithAndPassword(String arg0, String arg1) {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys(arg0);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(arg1);
        WebElement login = driver.findElement(By.xpath("//div[@class='login']//input[@type='submit']"));
        login.click();
    }
}
