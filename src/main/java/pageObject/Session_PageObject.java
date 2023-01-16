package pageObject;

import drivers.DriverFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Session_PageObject extends BasePageObject {
    private @FindBy(xpath = "(//a[@class=\"item src-common-components-Navbar-NavbarItem-NavbarItem__item  \"])[4]")
    WebElement session_MenuLink;
    private @FindBy(xpath = "//button[@class='ui button src-scenes-session-components-SessionCreateButton-SessionCreateButton__button']")
    WebElement session_button;
    private @FindBy(xpath = "(//input[@class='prompt'])[2]")
    WebElement template_searchIcon;
    private @FindBy(xpath = "(//div[@class='src-common-components-SessionTemplateSearch-SessionTemplateSearch__templateItemContainer'])[1]")
    WebElement template_option;
    private @FindBy(xpath = "(//div[@class='react-datepicker-wrapper'])[1]")
    WebElement start_date_input;
    private @FindBy(xpath = "(//div[@class='react-datepicker-wrapper'])[2]")
    WebElement end_date_input;
    private @FindBy(className = "react-datepicker__day--today")
    WebElement current_date;
    private @FindBy(xpath = "//li[@class='react-datepicker__time-list-item '][1]")
    WebElement end_time;
    private @FindBy(xpath = "//div[@name='assignmentType']")
    WebElement assignment_type_select;

    private @FindBy(xpath = "//*[contains(@class, 'text') and text() = 'Single Assignment']")
    WebElement assignment_type_option;

    private @FindBy(xpath = "(//input[@class = 'prompt'])[2]")
    WebElement testTaker_input;

    private @FindBy(xpath = "//div[@class='results transition visible']")
    WebElement testTaker_input_result;

    private @FindBy(xpath = "//*[contains(@class, 'ui primary button') and text() = 'Assign Session']")
    WebElement assign_session_button;

    private @FindBy(xpath = "//div[@class = 'Toastify__toast-body']")
    WebElement success_message_toast;

    private @FindBy(xpath = "//span[@class='src-common-components-UserSearch-UserSearch__title']")
    WebElement session_search_result;

    public Session_PageObject() {
        super();
    }

    public void clickOn_Session_link() {
        waitForElementAndClick(session_MenuLink);
    }

    public void clickOn_Assign_Session_Button() {
        waitForElementAndClick(session_button);
    }

    public void clickOn_Template() {
        waitForElementAndClick(template_searchIcon);
    }

    public void clickOn_Template_Option() {
        waitForElementAndClick(template_option);
    }

    public void clickOn_StartDatePicker_Input_And_Select_Current_Date() {
        waitForElementAndClick(start_date_input);
        waitForElementAndClick(current_date);
    }

    public void clickOn_EndDatePicker_Input_And_Select_Current_Date() {
        waitForElementAndClick(end_date_input);
        waitForElementAndClick(current_date);
        waitForElementAndClick(end_time);
        // TODO 23:50ten sonra test çalışırsa listede eleman kalmayacak ve burası patlayabilir
        // TODO en son end date 1 gün sonrası seçilirse sıkıntı kalmaz
    }

    public void clickOn_Assignment_Type_Selection() {
        waitForElementAndClick(assignment_type_select);
    }

    public void clickOn_Assignment_Type_Option() {
        waitForElementAndClick(assignment_type_option);
    }

    public void clickOn_TestTaker_And_Set_User() {

        waitForElementAndClick(testTaker_input);
        WebDriver driver = DriverFactory.getDriver();
        Actions action = new Actions(driver);
        testTaker_input.sendKeys("Super Admin");
        waitElement(session_search_result);
        action.keyDown(Keys.DOWN);
        action.sendKeys(Keys.ENTER);
        action.build().perform();
    }

    public void clickOn_Assign_Session_Form_Button() {
        waitForElementAndClick(assign_session_button);
    }

    public void validate_Complete_Assign_Session() {
        waitForAlertAndValidateText(success_message_toast, "Session successfully created.");
    }
}
