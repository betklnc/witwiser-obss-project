package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Exam_PO extends Base_PO {
    private @FindBy(xpath = "(//a[@class=\"item src-common-components-Navbar-NavbarItem-NavbarItem__item  \"])[1]")
    WebElement home_menuLink;

    private @FindBy(xpath = "//a[@class='ui button src-scenes-dashboard-components-WarningInfo-WarningInfo__buttonElement'][1]")
    WebElement home_start_test_button;

    private @FindBy(xpath = "//*[@class='ui primary button src-scenes-session-components-SessionInfoCard-SessionInfoCard__startButton src-common-components-AssesmentButton-AssesmentButton__button']")
    WebElement exam_start_test_button;

    private @FindBy(xpath = "(//*[@class='ui checkbox src-common-components-Questions-Questions__listItem'])[1]")
    WebElement question_checkboxes;

   /* private @FindBy(xpath = "//img[@class='ui right floated image src-scenes-session-pages-test-SessionTest__icon']")
    WebElement next_question;
*/

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


    public Exam_PO() {
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
        for (int i = 1; i <= question_buttons.size() + 1; i++) {
            if (isQuestionTypeDisplayed(answer_text_area)) {
                sendKeys(answer_text_area, "Yazılım Testi");
                System.out.println("answer_text_area");
                clickOn_Next_Question();
            } else if (isQuestionTypeDisplayed(question_radiobutton)) {
                waitForElementAndClick(question_radiobutton);
                System.out.println("radio button");
                clickOn_Next_Question();
            } else if (isQuestionTypeDisplayed(question_checkboxes)) {
                waitForElementAndClick(question_checkboxes);
                System.out.println("checkbox"); // TODO tüm checkboxlar nasıl seçtirilir bak.
                clickOn_Next_Question();
            } else {
                System.out.println("draggable yapılacak");
            }
        }
    }

    private boolean isQuestionTypeDisplayed(WebElement element) {
        try { // TODO isDisplayed neden false dönemiyor?
            waitUntilElementVisible(element, 50);
            return element.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    /*
        public void clickOn_Checkbox() {
            waitForElementAndClick(question_checkboxes);

        }

        public void set_Answer() {
            sendKeys(answer_text_area, "Yazılım Testi");

        }

        public void clickOn_Radio_Button() {
            waitForElementAndClick(question_radiobutton);

        }

    */
    public void clickOn_FinishTest_Button() {
        waitForElementAndClick(finish_test_button);

    }

    public void clickOn_Next_Question() {
        waitForElementAndClick(next_question);
    }

    public void clickOn_Complete_Test_Button() {
        waitForElementAndClick(complete_test_button);
    }



  /*  public void selectAllCheckboxes() {
         int size = question_checkboxes.size();

        for(int i = 0; i<size; i++) {

            waitForElementAndClick(question_checkboxes.get(i));

        }


    }
    */


}
