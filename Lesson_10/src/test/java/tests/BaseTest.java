package tests;

import helpers.ConfProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.BasePage;
import pages.CookiePage;
import java.time.Duration;

public class BaseTest {

    protected BasePage basePage;
    protected WebDriver driver;
    protected CookiePage cookiePage;

    @BeforeClass(description = "Initializing the driver")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfProperties.getProperty("baseUrl"));
    }

    @BeforeClass(description = "Check the url of base page", dependsOnMethods = "setUp")
    public void CheckBaseUrlTest(){
        basePage = new BasePage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), ConfProperties.getProperty("baseUrl"));
    }

    @BeforeClass(description = "Check the appearance and dismiss cookies", dependsOnMethods = "CheckBaseUrlTest")
    public void CheckCookiesTest(){
        cookiePage = new CookiePage(driver);
        cookiePage.dismissCookies();
        cookiePage.hoverToPayWrapper();
    }

    @AfterClass(description = "Close browser after tests")
    public final void tearDown() {
        if (driver != null){
            driver.quit();
        }
    }
}
