package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class MainPage {
    WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//button[@type='add']")
    public WebElement addUserButton;

    @FindBy(how = How.XPATH, using = "//td[@class='smart-table-data-cell']/following-sibling::td[contains(text()," +
            " 'novak')]//following-sibling::td//button[@ng-click='delUser()']")
    public WebElement deleteRecordButton;

    @FindBy(how = How.XPATH, using = "//tbody/tr/td[contains(text(), 'pablo')]")
    public WebElement userAdded;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'novak')]")
    public List<WebElement> userRemoved;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'OK')]")
    public WebElement confirmationDialogOkButton;

    public void clickAddUserButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addUserButton));
        addUserButton.click();
    }

    public void clickDeleteRecordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteRecordButton));
        deleteRecordButton.click();
    }

    public void clickOkToConfirmDeleteUser()  {
        wait.until(ExpectedConditions.visibilityOf(confirmationDialogOkButton));
        confirmationDialogOkButton.click();
    }

    public void verifyUserRemoved()  {
        String user = "novak";
        if ( userRemoved.size() > 0){
            System.out.println("Record: " +  user + " is present.");
            assertEquals(userRemoved.size(), 0,"record is not removed");
        } else {
            System.out.println("Record: " + user + " is  not present.");
            assertEquals(userRemoved.size(), 0, "record removed");
        }
    }

    public void verifyUserAdded() {
        wait.until(ExpectedConditions.elementToBeClickable(userAdded));
        assertTrue(userAdded.isDisplayed(), "THe user not created");
    }

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10, 20));
    }
}