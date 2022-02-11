package StepDefinitions;

import dataProviders.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Hooks {
    WebDriver driver;
    ConfigFileReader configFileReader;

//    @Before
//    public void setUp() {
//        configFileReader= new ConfigFileReader();
//        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(configFileReader.getApplicationUrl());
//    }
//
//    @After
//    public void teardown() {
//        driver.quit();
//    }
}
