package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CookiePage;


public class BaseTest {

    protected WebDriver driver;
    protected CookiePage cookiePage;
    protected BasePage basePage;

    protected static final String BASE_URL = "https://www.mts.by";

    @BeforeClass
    @Step("Initializing the driver")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);

        basePage = new BasePage(driver);
        cookiePage = new CookiePage(driver);
        cookiePage.dismissCookies();
        cookiePage.hoverToPayWrapper();
    }

    @AfterClass
    public final void tearDown() {
        if (driver != null){
            driver.quit();
        }
    }
}
