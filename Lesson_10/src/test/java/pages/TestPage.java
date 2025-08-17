package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class TestPage extends BasePage{

    @FindBy(linkText = "Подробнее о сервисе")
    private WebElement linkAboutService;

    @FindBy(xpath = "//h2[contains(normalize-space(), 'Онлайн пополнение без комиссии')]")
    private WebElement blockTitle;

    @FindBy(xpath = "//*[@class = 'pay__partners']/ul/li")
    private List<WebElement> payPartners;

    private By selectHolderLocator = By.xpath("//button[@class = 'select__header']");
    private By payConnectionLocator = By.xpath("//p[contains(text(),'Услуги связи')]");
    private By connectionPhoneLocator = By.id("connection-phone");
    private By connectionSumLocator = By.id("connection-sum");
    private By connectionEmailLocator = By.id("connection-email");
    private By connectionButtonLocator = By.xpath("//button[text()='Продолжить']");
    private By connectionFrameLocator = By.className("bepaid-iframe");
    private By payDescriptionTextLocator = By.xpath("//div[@class='pay-description__text']/span");
    private By payDescriptionCostLocator = By.xpath("//div[@class='pay-description__cost']/span");
    private By payDescriptionCostButtonLocator = By.xpath("//div[@class='card-page__card']/button");
    private By creditCardLocator = By.xpath("//app-input[contains(@class, 'full-width') and .//input[@id='cc-number']]//label");
    private By expirationDateLocator = By.xpath("//div[contains(@class, 'expires-input')]//label");
    private By cvcLocator = By.xpath("//div[contains(@class, 'cvc')]//label");
    private By ccNameLocator = By.xpath("//app-input[contains(@class, 'full-width') and .//input[@autocomplete='cc-name']]//label");
    private By cardsBrandsLocator = By.xpath("//div[contains(@class, 'cards-brands__container')]");


    public TestPage(WebDriver driver) {
        super(driver);
    }

    public void clickAboutServiceLink() {
        wait.until(ExpectedConditions.elementToBeClickable(linkAboutService));
        linkAboutService.click();
    }

    public String checkNameBlock() {
        wait.until(ExpectedConditions.visibilityOf(blockTitle));
        return blockTitle.getText();
    }

    public void checkPayLogos() {
        for (WebElement element: payPartners) {
            System.out.println(element.getText());//.img/alt
        }
    }

    @Step("Choosing the 'Communication Services' service")
    public WebElement fillSelectHolder(){
        WebElement selectHolder = driver.findElement(selectHolderLocator);
        selectHolder.click();
        WebElement payConnection = driver.findElement(payConnectionLocator);
        payConnection.click();
        return payConnection;
    }

    @Step("Entering a number 297777777")
    public WebElement fillNumberHolder(){
        WebElement numberHolder = driver.findElement(connectionPhoneLocator);
        numberHolder.click();
        numberHolder.sendKeys("297777777");
        return numberHolder;
    }

    public WebElement fillSumHolder (String value,  boolean shouldPass){
        WebElement sumHolder = driver.findElement(connectionSumLocator);
        sumHolder.click();
        sumHolder.clear();
        sumHolder.sendKeys(value);

        checkShouldPass(getEnteredValue(sumHolder), shouldPass);
        return sumHolder;
    }

    public String getEnteredValue(WebElement element){
        return element.getAttribute("value");
    }

    @Step("Checking for compliance")
    public void checkShouldPass (String enteredValue, boolean shouldPass){
        if (shouldPass){
            try {
                int number = Integer.parseInt(enteredValue);
                Assert.assertTrue(number > 0, "The field should contain a value greater than 0");
            } catch (NumberFormatException e) {
                Assert.fail("The entered value is not a valid number: " + enteredValue);
            }
        } else {
            try {
                int number = Integer.parseInt(enteredValue);
                Assert.assertFalse(number > 0, "The field should not contain a value greater than 0");
            } catch (NumberFormatException e) {
                Assert.assertFalse(false);
            }
        }
    }

    @Step("Filling in the email field")
    public WebElement fillEmailHolder(String emailAddress){
        WebElement emailHolder = driver.findElement(connectionEmailLocator);
        emailHolder.click();
        emailHolder.clear();
        emailHolder.sendKeys(emailAddress);
        return emailHolder;
    }

    public boolean patternMatches(String emailAddress) {
        if (emailAddress.isEmpty()) return true;
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public WebElement clickContinueButton(){
        WebElement button = driver.findElement(connectionButtonLocator);
        button.click();
        return button;
    }

    @Step("Waiting for the frame to appear")
    public void waitAndSwitchToFrame() {
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(connectionFrameLocator));
    }

    public WebElement getPayDescriptionText(){
        WebElement payDescription = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(payDescriptionTextLocator));
        return payDescription;
    }

    public WebElement getPayDescriptionCost(){
        WebElement payDescriptionCost = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(payDescriptionCostLocator));
        return payDescriptionCost;
    }

    public WebElement getPayDescriptionCostButton(){
        WebElement payDescriptionCostButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(payDescriptionCostButtonLocator));
        return payDescriptionCostButton;
    }

    public WebElement checkCreditCard(){
        return driver.findElement(creditCardLocator);
    }

    public WebElement checkExpirationDate(){
        return driver.findElement(expirationDateLocator);
    }

    public WebElement checkCvc(){
        return driver.findElement(cvcLocator);
    }

    public WebElement checkCcName(){
        return driver.findElement(ccNameLocator);
    }

    @Step("Getting a list of PayIcons")
    public List<WebElement> getPayIcons(){
        WebElement container = driver.findElement(cardsBrandsLocator);
        return container.findElements(By.tagName("img"));
    }

    @Step("Choosing a service")
    public WebElement checkPayConnection(String option){
        WebElement selectHolder = driver.findElement(selectHolderLocator);
        selectHolder.click();
        driver.findElement(By.xpath("//p[contains(text(),'" + option +"')]")).click();
        return driver.findElement(By.xpath("//option[@value='" + option + "']"));
    }

    @Step("Getting the id of the number field by data-open service field")
    public String checkNumberPayConnection(WebElement webElement){
        String locatorForm = webElement.getAttribute("data-open");
        WebElement numberHolder = driver.findElement(By.xpath("//*[@id='" + locatorForm + "']//input[@type='text']"));
        return numberHolder.getAttribute("placeholder");
    }
}
