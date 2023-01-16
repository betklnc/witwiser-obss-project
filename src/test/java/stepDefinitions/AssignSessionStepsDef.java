package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.BasePageObject;
import pageObject.LoginPageObject;
import pageObject.SessionPageObject;

public class AssignSessionStepsDef extends BasePageObject {

    private LoginPageObject login_po;
    private SessionPageObject session_po;

    public AssignSessionStepsDef(LoginPageObject login_po, SessionPageObject session_po) {
        this.login_po = login_po;
        this.session_po = session_po;
    }

    @Given("User logins to Witwiser system with {} and {}")
    public void user_logins_to_witwiser_system(String username, String password) {
        login_po.navigateToWitwiserUrl();
        login_po.setUsername(username);
        login_po.setPassword(password);
        login_po.clickOnLoginButton();
    }

    @When("User assigns session to user")
    public void user_assigns_session_to_user() {
        session_po.clickOnSessionLink();
        session_po.clickOnAssignSessionButton();
        session_po.clickOnTemplate();
        session_po.clickOnTemplateOption();
        session_po.clickOnStartDatePickerInputAndSelectCurrentDate();
        session_po.clickOnEndDatePickerInputAndSelectCurrentDate();
        session_po.clickOnAssignmentTypeSelection();
        session_po.clickOnAssignmentTypeOption();
        session_po.clickOnTestTakerAndSetUser();
        session_po.clickOnAssignSessionFormButton();
    }

    @Then("It's seen that user complete assigning session")
    public void it_s_seen_that_user_complete_assigning_session() {
        session_po.validateCompleteAssignSession();
    }

}
