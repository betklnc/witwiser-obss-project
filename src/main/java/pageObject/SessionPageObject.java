package pageObject;

import drivers.DriverFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SessionPageObject extends BasePageObject {
    private @FindBy(xpath = "(//a[@class=\"item src-common-components-Navbar-NavbarItem-NavbarItem__item  \"])[4]")
    WebElement sessionMenuLink;
    private @FindBy(xpath = "//button[@class='ui button src-scenes-session-components-SessionCreateButton-SessionCreateButton__button']")
    WebElement sessionButton;
    private @FindBy(xpath = "(//input[@class='prompt'])[2]")
    WebElement templateSearchIcon;
    private @FindBy(xpath = "(//div[@class='src-common-components-SessionTemplateSearch-SessionTemplateSearch__templateItemContainer'])[1]")
    WebElement templateOption;
    private @FindBy(xpath = "(//div[@class='react-datepicker-wrapper'])[1]")
    WebElement startDateInput;
    private @FindBy(xpath = "(//div[@class='react-datepicker-wrapper'])[2]")
    WebElement endDateInput;
    private @FindBy(className = "react-datepicker__day--today")
    WebElement currentDate;
    private @FindBy(xpath = "//li[@class='react-datepicker__time-list-item '][1]")
    WebElement endTime;
    private @FindBy(xpath = "//div[@name='assignmentType']")
    WebElement assignmentTypeSelect;
    private @FindBy(xpath = "//*[contains(@class, 'text') and text() = 'Single Assignment']")
    WebElement assignmentTypeOption;
    private @FindBy(xpath = "(//input[@class = 'prompt'])[2]")
    WebElement testTakerInput;
    private @FindBy(xpath = "//div[@class='results transition visible']")
    WebElement testTakerResult;
    private @FindBy(xpath = "//*[contains(@class, 'ui primary button') and text() = 'Assign Session']")
    WebElement assignSessionButton;
    private @FindBy(xpath = "//div[@class = 'Toastify__toast-body']")
    WebElement successMessageToast;
    private @FindBy(xpath = "//span[@class='src-common-components-UserSearch-UserSearch__title']")
    WebElement sessionSearchResult;

    public SessionPageObject() {
        super();
    }

    public void clickOnSessionLink() {
        waitForElementAndClick(sessionMenuLink);
    }

    public void clickOnAssignSessionButton() {
        waitForElementAndClick(sessionButton);
    }

    public void clickOnTemplate() {
        waitForElementAndClick(templateSearchIcon);
    }

    public void clickOnTemplateOption() {
        waitForElementAndClick(templateOption);
    }

    public void clickOnStartDatePickerInputAndSelectCurrentDate() {
        waitForElementAndClick(startDateInput);
        waitForElementAndClick(currentDate);
    }

    public void clickOnEndDatePickerInputAndSelectCurrentDate() {
        waitForElementAndClick(endDateInput);
        waitForElementAndClick(currentDate);
        waitForElementAndClick(endTime);
        // TODO 23:50ten sonra test çalışırsa listede eleman kalmayacak ve burası patlayabilir
        // TODO en son end date 1 gün sonrası seçilirse sıkıntı kalmaz
    }

    public void clickOnAssignmentTypeSelection() {
        waitForElementAndClick(assignmentTypeSelect);
    }

    public void clickOnAssignmentTypeOption() {
        waitForElementAndClick(assignmentTypeOption);
    }

    public void clickOnTestTakerAndSetUser() {

        waitForElementAndClick(testTakerInput);
        WebDriver driver = DriverFactory.getDriver();
        Actions action = new Actions(driver);
        testTakerInput.sendKeys("Super Admin");
        waitElement(sessionSearchResult);
        action.keyDown(Keys.DOWN);
        action.sendKeys(Keys.ENTER);
        action.build().perform();
    }

    public void clickOnAssignSessionFormButton() {
        waitForElementAndClick(assignSessionButton);
    }

    public void validateCompleteAssignSession() {
        waitForAlertAndValidateText(successMessageToast, "Session successfully created.");
    }
}
