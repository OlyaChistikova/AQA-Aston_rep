import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckNameBlockTest extends BaseTest{

    @Test(description = "Check name block")
    public void testCheckNameBlock() {
        WebElement blockTitle = driver.findElement(By.xpath("//h2[contains(normalize-space(), 'Онлайн пополнение без комиссии')]"));
        Assert.assertNotNull(blockTitle,  "Blog 'Онлайн пополнение без комиссии' not found.");
    }

}
