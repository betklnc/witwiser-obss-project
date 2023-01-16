package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.BasePageObject;
import pageObject.LoginPageObject;
import pageObject.SessionPageObject;

public class AssignSessionStepsDef extends BasePageObject {

    private LoginPageObject loginPo;
    private SessionPageObject sessionPo;

    public AssignSessionStepsDef(LoginPageObject loginPo, SessionPageObject sessionPo) {
        this.loginPo = loginPo;
        this.sessionPo = sessionPo;
    }

    @Given("User logins to Witwiser system with {} and {}")
    public void user_logins_to_witwiser_system(String username, String password) {
        loginPo.navigateToWitwiserUrl();
        loginPo.setUsername(username);
        loginPo.setPassword(password);
        loginPo.clickOnLoginButton();
    }

    @When("User assigns session to user")
    public void user_assigns_session_to_user() {
        sessionPo.clickOnSessionLink();
        sessionPo.clickOnAssignSessionButton();
        sessionPo.clickOnTemplate();
        sessionPo.clickOnTemplateOption();
        sessionPo.clickOnStartDatePickerInputAndSelectCurrentDate();
        sessionPo.clickOnEndDatePickerInputAndSelectCurrentDate();
        sessionPo.clickOnAssignmentTypeSelection();
        sessionPo.clickOnAssignmentTypeOption();
        sessionPo.clickOnTestTakerAndSetUser();
        sessionPo.clickOnAssignSessionFormButton();
    }

    @Then("It's seen that user complete assigning session")
    public void it_s_seen_that_user_complete_assigning_session() {
        sessionPo.validateCompleteAssignSession();
    }

}
