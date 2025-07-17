import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckLinkTest extends BaseTest {

    @Test
    public void testCheckLink() {
        WebElement linkAboutService = driver.findElement(By.linkText("Подробнее о сервисе"));
        linkAboutService.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/");
        driver.navigate().back();
    }
}
