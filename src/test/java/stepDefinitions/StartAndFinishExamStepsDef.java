package stepDefinitions;

import io.cucumber.java.en.*;
import pageObject.Base_PO;
import pageObject.Exam_PO;

public class StartAndFinishExamStepsDef extends Base_PO {

    private Exam_PO exam_po;

    public StartAndFinishExamStepsDef(Exam_PO exam_po) {
        this.exam_po = exam_po;
    }

    @Given("User navigate to Home page")
    public void user_navigate_to_home_page() {
        exam_po.clickOn_Homepage_link();

    }

    @When("User starts and finish the exam answering the all questions")
    public void user_starts_and_finish_the_exam_answering_the_all_questions() {
        exam_po.clickOn_Start_Test_Button();
        exam_po.clickOn_Exam_Start_Test_Button();
        exam_po.answer_Questions();
        exam_po.clickOn_Complete_Test_Button();
    }

    @Then("It's seen that user complete exam assigned")
    public void it_s_seen_that_user_complete_exam_assigned() {

    }
}
