package talentsage.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login {

    WebDriver driver;

    // ✅ Initialize Logger
    Logger log = LoggerFactory.getLogger(Login.class);

    @BeforeClass
    public void setUp() {
        Reporter.log("**Launching Chrome browser**", true);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // ❌ INVALID LOGIN TEST
    @Test(priority = 1)
    public void invalidLoginTest() {

        Reporter.log("*** Test Case No. 1- Starting INVALID login test ***", true);
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("wrongUser");
        Reporter.log("Step NO.1 entered invalid username", true);

        driver.findElement(By.id("password")).sendKeys("wrongPassword");
        Reporter.log("Step NO.2 Entered invalid password", true);

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Reporter.log("Step NO.3  Clicked login button", true);

        String errorMessage = driver.findElement(By.id("flash")).getText();
        Reporter.log("Error message displayed: " + errorMessage, true);
        Assert.assertTrue(
                errorMessage.contains("Your username is invalid!"),
                "Invalid login message not displayed"
        );
        Reporter.log("✅ INVALID login test PASSED", true);
    }

    // ✅ VALID LOGIN TEST
    @Test(priority = 2)
    public void validLoginTest() {

        Reporter.log("***  Test Case No. 2- Starting VALID login test ***", true);
        Reporter.log("Starting VALID login test");

        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        Reporter.log("Step NO.1 Entered valid username", true);

        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        Reporter.log("Step NO.2 Entered valid password", true);

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Reporter.log("Step NO.3 Clicked login button", true);

        String successMessage = driver.findElement(By.id("flash")).getText();
        Reporter.log("Success message displayed: " + successMessage, true);

        Assert.assertTrue(
                successMessage.contains("You logged into a secure area!"),
                "Success message not displayed"
        );
        Assert.assertTrue(
                driver.getCurrentUrl().contains("/secure"),
                "User not navigated to secure page"
        );
        log.info("VALID login test PASSED");
    }
    @AfterClass
    public void tearDown() {
        Reporter.log("Closing browser", true);
        log.info("Closing browser");

        if (driver != null) {
            driver.quit();
        }
    }
}
