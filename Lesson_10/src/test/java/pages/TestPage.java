package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class TestPage extends BasePage{

    private By linkAboutServiceLocator = By.linkText("Подробнее о сервисе");
    private By blockTitleLocator = By.xpath("//h2[contains(normalize-space(), 'Онлайн пополнение без комиссии')]");
    private By payPartnersLocator = By.cssSelector(".pay__partners");
    private By selectHolderLocator = By.className("select__header");
    private By payConnectionLocator = By.xpath("//p[contains(text(),'Услуги связи')]");
    private By connectionPhoneLocator = By.id("connection-phone");
    private By connectionSumLocator = By.id("connection-sum");
    private By connectionEmailLocator = By.id("connection-email");
    private By connectionButtonLocator = By.xpath("//button[text()='Продолжить']");
    private By connectionFrameLocator = By.className("bepaid-iframe");
    private By payDescriptionTextLocator = By.xpath("//div[@class='pay-description__text']/span");
    private By payDescriptionCostLocator = By.xpath("//div[@class='pay-description__cost']/span");
    private By payDescriptionCostButtonLocator = By.xpath("//div[@class='card-page__card']/button");
    private By creditCardLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input");
    private By expirationDateLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label");
    private By cvcLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label");
    private By ccNameLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label");
    private By cardsBrandsLocator = By.xpath("//div[contains(@class, 'cards-brands__container')]");


    public TestPage(WebDriver driver) {
        super(driver);
    }

    public void clickAboutServiceLink() {
        WebElement link = driver.findElement(linkAboutServiceLocator);
        link.click();
    }

    public WebElement сheckNameBlock() {
        WebElement link = driver.findElement(blockTitleLocator);
        return link;
    }

    public List<WebElement> сheckPayLogos() {
        List<WebElement> listLink = driver.findElements(payPartnersLocator);
        return listLink;
    }

    public WebElement fillSelectHolder(){
        WebElement selectHolder = driver.findElement(selectHolderLocator);
        selectHolder.click();
        WebElement payConnection = driver.findElement(payConnectionLocator);
        payConnection.click();
        return payConnection;
    }

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

    public List<WebElement> getPayIcons(){
        WebElement container = driver.findElement(cardsBrandsLocator);
        return container.findElements(By.tagName("img"));
    }

    public WebElement checkPayConnection(String option){
        WebElement selectHolder = driver.findElement(selectHolderLocator);
        selectHolder.click();
        driver.findElement(By.xpath("//p[contains(text(),'" + option +"')]")).click();
        return driver.findElement(By.xpath("//option[@value='" + option + "']"));
    }

    public String checkNumberPayConnection(WebElement webElement){
        String locatorForm = webElement.getAttribute("data-open");
        WebElement numberHolder = driver.findElement(By.xpath("//*[@id='" + locatorForm + "']//input[@type='text']"));
        return numberHolder.getAttribute("placeholder");
    }

}
