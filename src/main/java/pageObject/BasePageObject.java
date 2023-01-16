package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.GlobalVars;

import java.time.Duration;

import static drivers.DriverFactory.getDriver;

public class BasePageObject {
    public BasePageObject() {
        PageFactory.initElements(getDriver(), this);
    }

    public void navigateToURL(String url) {
        getDriver().get(url);
    }

    public void sendKeys(WebElement by, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT)); // TODO bu obje tek oluşturulacak. singleton pattern araştır.
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }

    public void waitForElementAndClick(WebElement element) {
        waitElement(element).click();
    }

    public WebElement waitElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(GlobalVars.DEFAULT_EXPLICIT_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForAlertAndValidateText(WebElement element, String text) {
        waitUntilElementVisible(element, 0);
        String success_message = element.getText();
        Assert.assertEquals(success_message, text);
    }

    public void waitUntilElementVisible(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofMillis(getTimeout(timeout)));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private long getTimeout(int timeoutOfMillis) {
        if (timeoutOfMillis == 0) {
            return GlobalVars.DEFAULT_EXPLICIT_TIMEOUT * 1000; // turn into seconds
        }
        return timeoutOfMillis;
    }
}
