package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Global_Vars;

public class LoginPageObject extends BasePageObject {

    private @FindBy(xpath = "//*[@name=\"username\"]")
    WebElement usernameTextField;
    private @FindBy(xpath = "//*[@name=\"password\"]")
    WebElement passwordTextField;
    private @FindBy(xpath = "//button[@class='ui large fluid primary button src-scenes-dashboard-components-LoginCard-LoginCard__loginButton']")
    WebElement loginButton;

    public LoginPageObject() {
        super();
    }

    public void navigateToWitwiserUrl() {
        navigateToURL(Global_Vars.HOMEPAGE_URL);
    }

    public void setUsername(String username) {
        sendKeys(usernameTextField, "witwises-admin");
    }

    public void setPassword(String password) {
        sendKeys(passwordTextField, "lLYVRayAHimpt9bJ");
    }

    public void clickOnLoginButton() {
        waitForElementAndClick(loginButton);
    }

}
