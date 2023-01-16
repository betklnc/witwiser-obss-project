package pageObject;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Exam_PageObject extends BasePageObject {
    int totalQuestionCount = 4; //(question_buttons.size() + 1); // TODO burası question buttonsın yüklenmesini bekleyecek.
    private @FindBy(xpath = "(//a[@class=\"item src-common-components-Navbar-NavbarItem-NavbarItem__item  \"])[1]")
    WebElement home_menuLink;
    private @FindBy(xpath = "//a[@class='ui button src-scenes-dashboard-components-WarningInfo-WarningInfo__buttonElement'][1]")
    WebElement home_start_test_button;
    private @FindBy(xpath = "//*[@class='ui primary button src-scenes-session-components-SessionInfoCard-SessionInfoCard__startButton src-common-components-AssesmentButton-AssesmentButton__button']")
    WebElement exam_start_test_button;
    private @FindBy(xpath = "(//*[@class='ui checkbox src-common-components-Questions-Questions__listItem'])[1]")
    WebElement question_checkboxes;
    private @FindBy(xpath = "(//*[@class='ui checkbox src-common-components-Questions-Questions__listItem'])")
    List<WebElement> checkboxes;
    private @FindBy(xpath = "//div[@class='ql-editor ql-blank']")
    WebElement answer_text_area;
    private @FindBy(xpath = "(//div[@class='ui radio checkbox src-common-components-Questions-Questions__listItem'])[2]")
    WebElement question_radiobutton;
    private @FindBy(xpath = "//img[@src ='/static/media/arrow_next.00f4e471.svg']")
    WebElement next_question;
    private @FindBy(xpath = "//div[@class ='src-scenes-session-pages-test-SessionTest__testHeaderActions']")
    WebElement finish_test_button;
    private @FindBy(xpath = "//button[@class ='ui primary right floated button src-common-components-AssesmentButton-AssesmentButton__button']")
    WebElement complete_test_button;
    private @FindBy(xpath = "//button[@class ='src-scenes-session-pages-test-SessionTest__questionBox ']")
    List<WebElement> question_buttons;
    private @FindBy(xpath = "//div[@class ='ui medium label src-common-components-Questions-DragAndDrop-BlankItem__blankLabel']")
    WebElement dragTest;
    private @FindBy(xpath = "//div[@class ='ui medium label src-common-components-Questions-DragAndDrop-BlankItem__blankLabel']")
    WebElement home_last_start_date;

    public Exam_PageObject() {
        super();
    }

    public void clickOn_Homepage_link() {
        waitForElementAndClick(home_menuLink);
    }

    public void clickOn_Start_Test_Button() {
        waitForElementAndClick(home_start_test_button);
    }

    public void clickOn_Exam_Start_Test_Button() {
        waitForElementAndClick(exam_start_test_button);
    }

    public void answer_Questions() {
        for (int i = 1; i <= totalQuestionCount; i++) {
            if (isQuestionTypeDisplayed(answer_text_area)) {
                sendKeys(answer_text_area, "Yazılım Testi");
                System.out.println("answer_text_area");
                clickOn_Next_Question(i, totalQuestionCount);
            } else if (isQuestionTypeDisplayed(question_radiobutton)) {
                waitForElementAndClick(question_radiobutton);
                System.out.println("radio button");
                clickOn_Next_Question(i, totalQuestionCount);
            } else if (isQuestionTypeDisplayed(question_checkboxes)) {
                selectAllCheckboxes();
                System.out.println("checkbox");
                clickOn_Next_Question(i, totalQuestionCount);
            } else if (isQuestionTypeDisplayed(dragTest)) { // TODO 83. satırda waitForElementClick yapılacak.
                dragAndDrop();
                System.out.println("drag and drop");
                clickOn_Next_Question(i, totalQuestionCount);
            } else {
                System.out.println("Undefined question type");
            }
        }
    }

    private void dragAndDrop() {
        WebDriver driver = DriverFactory.getDriver();
        Actions builder = new Actions(driver);
        for (int j = 1; j <= 4; j++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Action dragAndDrop = builder.clickAndHold(driver.findElement(By.xpath("//div[@class ='ui medium label src-common-components-Questions-DragAndDrop-BlankItem__blankLabel']")))
                    .moveToElement(driver.findElement(By.xpath("//span[@class ='src-common-components-Questions-DragAndDrop-QuestionPreview__placeholder']")))
                    .release(driver.findElement(By.xpath("//span[@class ='src-common-components-Questions-DragAndDrop-QuestionPreview__placeholder']")))
                    .build();
            dragAndDrop.perform();
        }
    }

    private boolean isQuestionTypeDisplayed(WebElement element) {
        try { // TODO isDisplayed neden false dönemiyor?
            waitUntilElementVisible(element, 300);
            return element.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }


    public void clickOn_FinishTest_Button() {
        waitForElementAndClick(finish_test_button);
    }

    public void clickOn_Next_Question(int questionIndex, int questionSize) {
        System.out.println(questionIndex);
        System.out.println(questionSize);
        if (questionIndex != questionSize) {
            waitForElementAndClick(next_question);
        } else {
            clickOn_FinishTest_Button();
        }
    }

    public void clickOn_Complete_Test_Button() {
        waitForElementAndClick(complete_test_button);
    }

    private void selectAllCheckboxes() {
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                waitForElementAndClick(checkbox);
            }
        }
    }
}
