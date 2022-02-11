package StepDefinitions;

import dataProviders.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import pageObjects.AddUserPage;
import pageObjects.MainPage;

import java.io.IOException;

public class StepDefs {
    WebDriver driver;
    ConfigFileReader configFileReader;
    MainPage mainPage;
    AddUserPage addUserPage;
    WebDriverWait wait;

    @Before
    public void OpenBrowser() {
        Reporter.log("=====Browser Session Started=====", true);
        configFileReader = new ConfigFileReader();
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(configFileReader.getApplicationUrl());
        Reporter.log("=====Application Started=====", true);
    }

        @Given("the user clicks Add User button")
    public void theUserClicksAddUserButton() {
        mainPage = new MainPage(driver);
        mainPage.clickAddUserButton();
    }

    @And("fill out all information")
    public void fillOutAllInformation() {
        addUserPage = new AddUserPage(driver);
        addUserPage.enterFirstName("Pablo");
        addUserPage.enterLastName("Doe");
        addUserPage.enterUserName("pablo");
        addUserPage.enterPassword("abc123dd");
        addUserPage.clickCustomerRadioButton();
        addUserPage.selectRoleDropDown("Admin");
        addUserPage.enterEmail("email1289@grr.la");
        addUserPage.enterPhone("123567890");
    }

    @When("the user clicks Save button")
    public void theUserClicksSaveButton() {
        addUserPage.clickSaveButton();
    }

    @Then("the user has been added to the table")
    public void theUserHasBeenAddedToTheTable() {
        mainPage.verifyUserAdded();
    }

    @Given("the user clicks Delete User button")
    public void theUserClicksDeleteUserButton() {
        mainPage = new MainPage(driver);
        mainPage.clickDeleteRecordButton();
    }

    @When("user confirms delete")
    public void userConfirmsDelete() {
        mainPage = new MainPage(driver);
        mainPage.clickOkToConfirmDeleteUser();
    }

    @Then("user has been removed")
    public void userHasBeenRemoved() {
        mainPage.verifyUserRemoved();
    }

    @After
    public void teardown() {
       driver.quit();
   }
}
