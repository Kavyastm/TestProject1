package test;

import basePackage.DriverConfig;
import com.relevantcodes.extentreports.LogStatus;
import objectPackage.AlertsPage;
import objectPackage.DragAndDropPage;
import objectPackage.RegisterUserPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utility.ExcelFileUtility;
import utility.ExtentReporterConfig;

import java.lang.reflect.Method;

public class TestCases {
    RegisterUserPage registerUserPage;
    AlertsPage alertsPage;
    DragAndDropPage dragAndDropPage;
    ExcelFileUtility excelFileUtility;

    @BeforeSuite
    public void openBrowser() {
        DriverConfig.openbrowser("chrome");
        excelFileUtility = new ExcelFileUtility();
    }

    @BeforeMethod
    public void navigateToLaunchAutomationSite(Method method) {
        ExtentReporterConfig.logger = ExtentReporterConfig.report.startTest(method.getName());
        DriverConfig.driver.get("http://demo.automationtesting.in/Register.html");
        registerUserPage = new RegisterUserPage();
        alertsPage = new AlertsPage();
        dragAndDropPage = new DragAndDropPage();
    }

    @Test
    public void enterDetailsToRegisterUser(){
        String firstName = excelFileUtility.getData("Data",1,0);
        String lastName = excelFileUtility.getData("Data",1,1);
        String address = excelFileUtility.getData("Data",1,2);
        String emailID = excelFileUtility.getData("Data",1,3);
        String phoneNumber = excelFileUtility.getData("Data",1,4);
        String Gender = excelFileUtility.getData("Data",1,5);
        registerUserPage.enterDetailsToRegisterUser(firstName,lastName,address,emailID, phoneNumber, Gender);
        registerUserPage.clickSubmitButton();
    }

    @Test
    public void alertsPageTest(){
        alertsPage.switchTOAlerts();
        alertsPage.clickButtonAndAccept();
    }

    @Test
    public void dragAndDropPageTest() throws Exception {
        dragAndDropPage.dragAndDropTOStaticElement();
    }

    @AfterSuite
    public void generateReport() {
        ExtentReporterConfig.logger.log(LogStatus.INFO, "Test End");
        ExtentReporterConfig.report.endTest(ExtentReporterConfig.logger);
        ExtentReporterConfig.report.flush();
        DriverConfig.driver.get(ExtentReporterConfig.ReportLocation);
    }
}
