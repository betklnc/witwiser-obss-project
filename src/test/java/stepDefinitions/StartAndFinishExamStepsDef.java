package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObject.BasePageObject;
import pageObject.ExamPageObject;

public class StartAndFinishExamStepsDef extends BasePageObject {

    private ExamPageObject examPo;

    public StartAndFinishExamStepsDef(ExamPageObject examPo) {
        this.examPo = examPo;
    }

    @And("User navigate to Home page")
    public void user_navigate_to_home_page() {
        examPo.clickOnHomepageLink();
    }

    @And("User starts and finish the exam answering the all questions")
    public void user_starts_and_finish_the_exam_answering_the_all_questions() {
        examPo.clickOnStartTestButton();
        examPo.clickOnExamStartTestButton();
        examPo.detectAndAnswerQuestions();
        examPo.clickOnCompleteTestButton();
    }

    @Then("It's seen that user complete exam assigned")
    public void it_s_seen_that_user_complete_exam_assigned() {
        examPo.validateIfExamIsCompleted();
    }
}
