package pageObject;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_Vars;

import java.time.Duration;

import static drivers.DriverFactory.getDriver;

public class Base_PO {
    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
    }

    public void navigateTo_URL(String url) { //TODO tüm method ve variable isimleri Camel case olacak
        getDriver().get(url);
    }

    public void sendKeys(WebElement by, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT)); // TODO bu obje tek oluşturulacak. singleton pattern araştır.
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }

    public void waitForElementAndClick(WebElement element) {
        waitElement(element).click();
    }

    public WebElement waitElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT)); // TODO her seferinde obje oluşturuyor manyak
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForAlert_And_ValidateText(WebElement element, String text) {
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
            return Global_Vars.DEFAULT_EXPLICIT_TIMEOUT * 1000; // turn into seconds
        }
        return timeoutOfMillis;
    }
}
