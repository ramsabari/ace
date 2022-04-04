package stepDefinitions;

import base.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.JWHomePage;
import pages.JWNewAppPage;

import java.io.File;
import java.io.IOException;


public class JWHomeStepDefinitions {
    WebDriver driver = null;
    JWHomePage JWHomePage = null;
    JWNewAppPage JWNewAppPage = null;
    DriverManager drivermanager = new DriverManager();

    @Before(order=1)
    public void cucumberSetup(){
        System.out.println("This is my First Before tag");
    }

/*    @After
    public void tearDown(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            File sshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] sscontent = FileUtils.readFileToByteArray(sshot);
            scenario.attach(sscontent, "image/png", "Screenshot");
        }
        driver.close();
    }*/

    @Given("JW webpage is launched in {string}")
    public void JWWebpageIsLaunchedIn(String browsername) {
        driver = drivermanager.getBrowserDriver(browsername);
        driver.get("http://localhost:8080/jw/web/userview/appcenter/v/_/home");
        JWHomePage = new JWHomePage(driver);

        JWNewAppPage = new JWNewAppPage(driver);

    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() {

        JWHomePage.clickLoginBtn();
    }

    @And("user enters a {string} and {string}")
    public void userEntersAAnd(String arg0, String arg1) {
        JWHomePage.enterUserCredentials(arg0, arg1);
    }

    @And("clicks on login arrow button")
    public void clicksOnLoginArrowButton() {
        JWHomePage.clickOnLoginArrow();
    }

    @Then("login is successful")
    public void loginIsSuccessful() {
        JWHomePage.validateLogin();
    }


    @And("click on design new app button")
    public void clickOnDesignNewAppButton() {
        JWHomePage.clickDesignNewApp();

        driver.switchTo().frame("jqueryDialogFrame");
        JWNewAppPage.validateDesignNewAppWindowIsDisplayed();

    }

    @And("enter {string} and {string}")
    public void enterAnd(String arg0, String arg1) {
        JWNewAppPage.enterAppIDandAppName(arg0, arg1);
    }

    @And("click save button")
    public void clickSaveButton() {
        JWNewAppPage.clickSaveButton();
    }

    @And("publish the app")
    public void publishTheApp() throws InterruptedException {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("quickOverlayFrame");
        JWNewAppPage.clickPublishBtn();
        //driver.switchTo().defaultContent();
        driver.switchTo().frame("jqueryDialogFrame");
        JWNewAppPage.clickVersionRadioBtn();
        JWNewAppPage.clickPublishBtnFinal();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("quickOverlayFrame");
        Thread.sleep(2000);
        JWNewAppPage.clickAllApps();
    }

    @Then("validate if {string} app is published successfully")
    public void validateIfAppIsPublishedSuccessfully(String arg0) throws InterruptedException {
        Thread.sleep(1000);
        JWNewAppPage.checkIfAppIsPublished(arg0);
    }


    @And("click on admin arrow button")
    public void clickOnAdminArrowButton() {
        JWHomePage.clickAdminControls();
    }

    @And("click on all apps")
    public void clickOnAllApps() {
        JWHomePage.clickAdminControlsAllApps();
    }

    @And("click on {string}")
    public void clickOn(String arg0) throws InterruptedException {
        driver.switchTo().frame("quickOverlayFrame");
        JWNewAppPage.clickOnPublishedApp(arg0);
        Thread.sleep(2000);
        JWNewAppPage.clickPublishedBtn();
    }

    @Then("delete the app")
    public void deleteTheApp() {
        driver.switchTo().frame("jqueryDialogFrame");
        JWNewAppPage.clickVersionRadioBtn();
        JWNewAppPage.clickDeleteBtn();
        driver.switchTo().alert().accept();
    }
}
