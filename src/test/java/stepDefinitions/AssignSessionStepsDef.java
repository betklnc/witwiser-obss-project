package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.BasePageObject;
import pageObject.Login_PageObject;
import pageObject.Session_PageObject;

public class AssignSessionStepsDef extends BasePageObject {

    private Login_PageObject login_po;
    private Session_PageObject session_po;

    public AssignSessionStepsDef(Login_PageObject login_po, Session_PageObject session_po) {
        this.login_po = login_po;
        this.session_po = session_po;
    }

    @Given("User logins to Witwiser system with {} and {}")
    public void user_logins_to_witwiser_system(String username, String password) {
        login_po.navigateToWitwiserUrl();
        login_po.setUsername(username);
        login_po.setPassword(password);
        login_po.clickOn_Login_Button();
    }

    @When("User assigns session to user")
    public void user_assigns_session_to_user() {
        session_po.clickOn_Session_link();
        session_po.clickOn_Assign_Session_Button();
        session_po.clickOn_Template();
        session_po.clickOn_Template_Option();
        session_po.clickOn_StartDatePicker_Input_And_Select_Current_Date();
        session_po.clickOn_EndDatePicker_Input_And_Select_Current_Date();
        session_po.clickOn_Assignment_Type_Selection();
        session_po.clickOn_Assignment_Type_Option();
        session_po.clickOn_TestTaker_And_Set_User();
        session_po.clickOn_Assign_Session_Form_Button();
    }

    @Then("It's seen that user complete assigning session")
    public void it_s_seen_that_user_complete_assigning_session() {
        session_po.validate_Complete_Assign_Session();
    }

}
