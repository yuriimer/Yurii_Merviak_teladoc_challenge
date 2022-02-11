package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddUserPage {
    WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//input[@name='FirstName']")
    public WebElement firstNameField;

    @FindBy(how = How.XPATH, using = "//input[@name='LastName']")
    public WebElement lastNameField;

    @FindBy(how = How.NAME, using = "UserName")
    public WebElement userNameField;

    @FindBy(how = How.XPATH, using = "//input[@type='password']")
    public WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//input[@value='15']")
    public WebElement customerRadioButton;

    @FindBy(how = How.XPATH, using = "//select[@name ='RoleId']")
    public WebElement roleDropDown;

    @FindBy(how = How.XPATH, using = "//input[@name = 'Email']")
    public WebElement emailField;

    @FindBy(how = How.NAME, using = "Mobilephone")
    public WebElement phoneField;

    @FindBy(how = How.XPATH, using = "//button[@ng-click = 'save(user)']")
    public WebElement saveButton;

    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOf(lastNameField));
        lastNameField.sendKeys(lastName);
    }

    public void enterUserName(String userName) {
        wait.until(ExpectedConditions.visibilityOf(userNameField));
        userNameField.sendKeys(userName);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }

    public void clickCustomerRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(customerRadioButton));
        customerRadioButton.click();
    }

    public void selectRoleDropDown(String role) {
        wait.until(ExpectedConditions.elementToBeClickable(roleDropDown));
        Select select = new Select(roleDropDown);
        select.selectByVisibleText(role);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
    }

    public void enterPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOf(phoneField));
        phoneField.sendKeys(phone);
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }

    public AddUserPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15, 10));
    }
}