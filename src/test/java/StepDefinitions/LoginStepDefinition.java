package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefinition {

    WebDriver driver;

    @Given("User Launch browser")
    public void openingUrl() throws Throwable{

        //Invoking Browswer
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lakshmi\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
//        //Method to Open Specified URL (website)
        driver.get("https://www.saucedemo.com/");


    }
    @When("User enter {string} and {string}")
    public void LoginSuccess(String username, String password) throws Throwable{

        //Getting the Web element
        WebElement logo = driver.findElement(By.xpath("//div[@class='login_logo']"));

        //Wait method - Explicit
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(logo));

        WebElement username_field = driver.findElement(By.id("user-name"));
        username_field.sendKeys(username);

        WebElement password_field = driver.findElement(By.id("password"));
        password_field.sendKeys(password);

        WebElement login_button = driver.findElement(By.id("login-button"));
        login_button.click();

        //Closing all browsers opened by selenium

    }

    @Then("User should able to login successfully")
    public void HomeScreen() throws Throwable{

        WebElement homepage_logo = driver.findElement(By.className("app_logo"));

        WebDriverWait wait = new WebDriverWait(driver, 30);


        driver.quit();

    }



}
