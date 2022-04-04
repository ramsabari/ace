package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JWNewAppPage {

    @FindBy(id="main-body-header")
    WebElement lbl_designNewAppWindow;

    @FindBy(id="id")
    WebElement txt_appId;

    @FindBy(id="name")
    WebElement txt_appName;

    @FindBy(xpath="//*[@id=\"createApp\"]/div/i[1]/input")
    WebElement btn_save;

    @FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/p[2]/a[2]")
    WebElement btn_publish;

    @FindBy(xpath="//*[@id=\"nav-links\"]/a[2]")
    WebElement btn_published;

    @FindBy(xpath="//*[@id=\"appVersionList_radio_0\"]")
    WebElement btn_version;

    @FindBy(xpath="//*[@id=\"JsonDataTable_appVersionList-buttons\"]/button[2]")
    WebElement btn_publish_2;

    @FindBy(xpath="//*[@id=\"JsonDataTable_appVersionList-buttons\"]/button[5]")
    WebElement btn_delete;

    @FindBy(xpath="//*[@id=\"nav-apps-link\"]/a")
    WebElement btn_allApps;


    WebDriver driver;

    public JWNewAppPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void validateDesignNewAppWindowIsDisplayed(){
        lbl_designNewAppWindow.isDisplayed();
    }

    public void enterAppIDandAppName(String appid, String appname){
        txt_appId.clear();
        txt_appId.sendKeys(appid);
        txt_appName.clear();
        txt_appName.sendKeys(appname);
    }

    public void clickSaveButton(){
        btn_save.click();
    }

    public void clickPublishBtn(){
        btn_publish.click();
    }

    public void clickPublishedBtn(){
        btn_published.click();
    }

    public void clickVersionRadioBtn(){
        btn_version.click();
    }

    public void clickPublishBtnFinal(){
        btn_publish_2.click();
    }

    public void clickDeleteBtn(){
        btn_delete.click();
    }

    public void clickAllApps(){
        btn_allApps.click();
    }

    public void  checkIfAppIsPublished(String appName){
        driver.findElement(By.xpath("//*[@id='nv-published']//span[contains(text(),'" +appName+ "')]")).isDisplayed();
    }

    public void  clickOnPublishedApp(String appName){
        driver.findElement(By.xpath("//*[@id='nv-published']//span[contains(text(),'" +appName+ "')]")).click();
    }


}
