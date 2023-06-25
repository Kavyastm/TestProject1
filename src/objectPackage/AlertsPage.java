package objectPackage;

import basePackage.DriverConfig;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ExtentReporterConfig;

public class AlertsPage extends RegisterUserPage{
    // This particular is extending RegisterUserPage class and the webelements defined in the parent class can be accessed directly in this class. Best example for Inheritance

    @FindBy(xpath = "//div[@id='OKTab']/button")
    public WebElement buttonToDisplayAlertBox;

    public AlertsPage(){
        PageFactory.initElements(DriverConfig.driver,this);
    }

    public void clickButtonAndAccept(){
        try {
            Alert alert = DriverConfig.driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchTOAlerts(){
        try {
            moveToTheElementAndClick(switchTOLink);
            moveToTheElementAndClick(alertsLink);
            keyBoardActions(alertsLink, Keys.ENTER);
            ExtentReporterConfig.passCase("User navigated to Alerts page","AlertsPage");
        }catch(Exception e){
            ExtentReporterConfig.failCase(e.getMessage(),"UserNotNavigatedToAlertsPage");
        }
    }

    public  void moveToTheElementAndClick(WebElement element) {
        try {
            Actions act = new Actions(DriverConfig.driver);
            act.moveToElement(element).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void keyBoardActions(WebElement element, Keys keys) {
        try {
            Actions act = new Actions(DriverConfig.driver);
             act.keyUp(element,keys);
            act.keyDown(element,keys);
//            element.sendKeys(Keys.chord(keys));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
