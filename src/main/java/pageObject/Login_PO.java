package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Global_Vars;

public class Login_PO extends Base_PO{


    public Login_PO() {
        super();
    }
    private  @FindBy(xpath= "//*[@name=\"username\"]")
    WebElement username_TextField;
    private  @FindBy(xpath= "//*[@name=\"password\"]")
    WebElement password_TextField;

    private  @FindBy(xpath= "//button[@class='ui large fluid primary button src-scenes-dashboard-components-LoginCard-LoginCard__loginButton']")
    WebElement login_Button;






    public void navigateToWitwiserUrl() {
        navigateTo_URL(Global_Vars.HOMEPAGE_URL);
    }
    public  void setUsername(String username){
        sendKeys(username_TextField, "witwises-admin");
    }
    public void setPassword(String password){
        sendKeys(password_TextField,"lLYVRayAHimpt9bJ");
    }
    public void clickOn_Login_Button(){
        waitForElementAndClick(login_Button);
    }

}
