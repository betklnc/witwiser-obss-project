package stepDefinitions;

import io.cucumber.java.en.*;
import pageObject.BasePageObject;
import pageObject.ExamPageObject;

public class StartAndFinishExamStepsDef extends BasePageObject {

    private ExamPageObject exam_po;

    public StartAndFinishExamStepsDef(ExamPageObject exam_po) {
        this.exam_po = exam_po;
    }

    @Given("User navigate to Home page")
    public void user_navigate_to_home_page() {
        exam_po.clickOnHomepageLink();

    }

    @When("User starts and finish the exam answering the all questions")
    public void user_starts_and_finish_the_exam_answering_the_all_questions() {
        exam_po.clickOnStartTestButton();
        exam_po.clickOnExamStartTestButton();
        exam_po.detectAndAnswerQuestions();
        exam_po.clickOnCompleteTestButton();
    }

    @Then("It's seen that user complete exam assigned")
    public void it_s_seen_that_user_complete_exam_assigned() {

    }
}
