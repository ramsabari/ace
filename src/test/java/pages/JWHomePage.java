package pages;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class JWHomePage {

    @FindBy(xpath="//*[@href='/jw/web/ulogin/appcenter/v/_/home' and @class='btn waves-effect btn waves-button waves-float'] ")
    WebElement btn_login;


    @FindBy(id="j_username")
    WebElement txt_username;

    @FindBy(id="adminControl")
    WebElement btn_adminCredentials;

    @FindBy(xpath="//*[@id=\"adminBarButtons\"]//span[text()='All Apps']")
    WebElement btn_allApps;


    @FindBy(id="j_password")
    WebElement txt_password;

    @FindBy(xpath="//input[@name='submit']")
    WebElement btn_login_arrow;

    @FindBy(linkText="Admin Admin")
    WebElement lbl_usernameDisplay;

    @FindBy(linkText="Design New App")
    WebElement btn_designNewApp;

    WebDriver driver;

    public JWHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void clickLoginBtn(){
        btn_login.click();
    }

    public void enterUserCredentials(String uname, String pwd){
        txt_username.clear();
        txt_username.sendKeys(uname);
        txt_password.clear();
        txt_password.sendKeys(pwd);
    }

    public void clickOnLoginArrow(){
        btn_login_arrow.click();
    }

    public void validateLogin(){
        lbl_usernameDisplay.isDisplayed();
    }

    public void clickDesignNewApp(){
        btn_designNewApp.click();
    }

    public void clickAdminControls(){
        btn_adminCredentials.click();
    }

    public void clickAdminControlsAllApps(){
        btn_allApps.click();
    }

}
