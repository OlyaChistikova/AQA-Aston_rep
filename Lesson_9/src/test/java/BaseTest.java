import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;

    protected static final String BASE_URL = "https://www.mts.by";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        try{
            By cookieLocator = By.className("cookie__wrapper");
            wait.until(ExpectedConditions.visibilityOfElementLocated(cookieLocator));

            WebElement dismissButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Отклонить']" )));
            dismissButton.click();
        } catch (NoSuchElementException e) {
            System.out.println("Dismiss button not found: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Timed out waiting for the cookie consent dialog: " + e.getMessage());
        }

        WebElement pay__wrapper = driver.findElement(By.className("pay__wrapper"));
        Actions actions = new Actions(driver);
        actions.moveToElement(pay__wrapper).perform();
    }

    @AfterClass
    public final void tearDown() {
        if (driver != null){
            driver.quit();
        }
    }
}
