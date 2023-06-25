package objectPackage;

import basePackage.DriverConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ExtentReporterConfig;

public class RegisterUserPage {

    //@FindBy annotation is best example for Abstraction, because the implementation is hidden from the user and only the purpose is understood to the user
    @FindBy(xpath = "//input[@ng-model='FirstName']")
    public WebElement firstNameInputBox;

    @FindBy(xpath = "//input[@ng-model='LastName']")
    public WebElement lastNameInputBox;

    @FindBy(xpath = "//textarea[@ng-model='Adress']")
    public WebElement addressInputBox;

    @FindBy(xpath = "//input[@ng-model='EmailAdress']")
    public WebElement emailAddressInputBox;

    @FindBy(xpath = "//input[@ng-model='Phone']")
    public WebElement phoneNumberInputBox;

    @FindBy(xpath = "//input[@value='Male']")
    public WebElement maleRadioButton;

    @FindBy(xpath = "//input[@value='FeMale']")
    public WebElement femaleRadioButton;

    @FindBy(id = "submitbtn")
    public WebElement submitButton;

    @FindBy(linkText = "SwitchTo")
    public WebElement switchTOLink;

    @FindBy(linkText = "Alerts")
    public WebElement alertsLink;

    @FindBy(xpath = "//a[contains(text(),'Interactions ')]")
    public WebElement interactions;

    @FindBy(xpath = "//a[contains(text(),'Drag and Drop ')]")
    public WebElement dragAndDropArial;

    @FindBy(xpath = "//a[contains(text(),'Static ')]")
    public WebElement eleStatic;

    public RegisterUserPage(){
        //This constructor defined here is best example for Encapsulation, because here the code written is wrapping the webelements and Driver object together
        PageFactory.initElements(DriverConfig.driver,this);
    }

    public void enterDetailsToRegisterUser(String firstName, String lastName, String address, String emailAddress, String phoneNumber, String gender){
        try{
            firstNameInputBox.sendKeys(firstName);
            lastNameInputBox.sendKeys(lastName);
            addressInputBox.sendKeys(address);
            emailAddressInputBox.sendKeys(emailAddress);
            phoneNumberInputBox.sendKeys(phoneNumber);
            if(gender.equalsIgnoreCase("male")){
                maleRadioButton.click();
            }else{
                femaleRadioButton.click();
            }
            ExtentReporterConfig.passCase("User is able to enter all required details","RegisterUser");
        }catch (Exception e){
            e.printStackTrace();
            ExtentReporterConfig.failCase(e.getMessage(),"UserNotRegistered");
        }
    }

    public void clickSubmitButton(){
        try {
            submitButton.click();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
