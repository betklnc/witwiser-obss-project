package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Exam_PO extends Base_PO {
    private @FindBy(xpath = "(//a[@class=\"item src-common-components-Navbar-NavbarItem-NavbarItem__item  \"])[1]")
    WebElement Home_MenuLink;

 private @FindBy(xpath = "//a[@class='ui button src-scenes-dashboard-components-WarningInfo-WarningInfo__buttonElement'][1]")
    WebElement start_test_button;


public Exam_PO() {
        super();
    }

    public void clickOn_Homepage_link() {
        waitForElementAndClick(Home_MenuLink);
    }

 public void clickOn_Start_Test_Button() {
        waitForElementAndClick(start_test_button);
    }


}
