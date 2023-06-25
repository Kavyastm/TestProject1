package objectPackage;

import basePackage.DriverConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ExtentReporterConfig;

public class DragAndDropPage extends RegisterUserPage{
    // This particular is extending RegisterUserPage class and the webelements defined in the parent class can be accessed directly in this class. Best example for Inheritance
    @FindBy(xpath = "//img[@id='node']")
    public WebElement seleniumImage;

    @FindBy(xpath = "//div[@id='droparea']")
    public WebElement dragDropElement;

    public DragAndDropPage(){
        PageFactory.initElements(DriverConfig.driver,this);
    }

    public void dragAndDropTOStaticElement() throws InterruptedException {
        try {
            moveToTheElementAndClick(interactions);
            moveToTheElementAndClick(dragAndDropArial);
            Thread.sleep(5000);
            moveToTheElementAndClick(eleStatic);
            eleStatic.click();
            Thread.sleep(5000);
            dragAndDropMethod(seleniumImage, dragDropElement);
            ExtentReporterConfig.passCase("User is able to drag and drop the image","DragAndDrop");
        }catch(Exception e){
            ExtentReporterConfig.failCase(e.getMessage(),"DragAndDropNotWorking");
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

    public void dragAndDropMethod(WebElement sourceElement, WebElement targetElement1) {
        try {
            Actions act = new Actions(DriverConfig.driver);
            act.dragAndDrop(sourceElement, targetElement1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

