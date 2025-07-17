import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckPayLogosTest extends BaseTest{

    @Test(description = "Check the availability of payment logos")
    public void testCheckPayLogos() {
        List<WebElement> paymentLogos = driver.findElements(By.cssSelector(".pay__partners"));
        Assert.assertFalse(paymentLogos.isEmpty(),  "Payment system logos not found.");
    }
}
