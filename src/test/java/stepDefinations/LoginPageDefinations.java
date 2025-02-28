package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.DashboarPage;
import pages.LoginPage;

import java.time.Duration;

public class LoginPageDefinations {
    private static final Logger log = LoggerFactory.getLogger(LoginPageDefinations.class);
    public WebDriver driver;
    public WebDriverWait wait;
    public LoginPage loginPage;
    public DashboarPage dashboarPage;

    @Given("User Launch Chrome Browser")
    public void user_launch_chrome_browser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        loginPage = new LoginPage(driver, wait);
        dashboarPage = new DashboarPage(driver, wait);
    }
    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }
    @When("User enters email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
    }
    @When("Click on Login")
    public void click_on_login() {
        loginPage.clickLogin();
    }
    @Then("Page title should be {string}")
    public void page_title_should_be(String title) throws InterruptedException {
        Thread.sleep(10000);
        if (driver.getPageSource().contains("Login was unsuccessful.")) {
            driver.close();
            Assert.fail();
        } else {
           Assert.assertEquals(title, driver.getTitle());
       }
    }
    @When("User click on Logout link")
    public void user_click_on_logout_link() {
        dashboarPage.clickLogout();
    }
    @Then("Close browser")
    public void close_browser() {
        driver.quit();
    }

}
