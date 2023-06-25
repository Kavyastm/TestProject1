package utility;

import basePackage.DriverConfig;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ExtentReporterConfig {

    public static ExtentReports report;
    public static ExtentTest logger;
    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");
    static Date date = new Date();

    static Calendar cal = Calendar.getInstance();
    static SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");

    public static String ReportLocation=System.getProperty("user.dir")+"\\Reports\\ExecutionReport"+ sdf.format(cal.getTime())+".html";

    public static void intialiseconfig()
    {
        report = new ExtentReports(ReportLocation,true);
//        logger = report.startTest("Assignment TestCases");

    }


    public static String captureScreenShot(WebDriver driver, String screenshotname)
    {
        try{
            TakesScreenshot ts=(TakesScreenshot) driver;
            File src=ts.getScreenshotAs(OutputType.FILE);
            String des=System.getProperty("user.dir")+"\\Reports\\Screenshots\\"+screenshotname+".png";
            File destination =new File(des);
            FileUtils.copyFile(src, destination);
            return des;
        }
        catch(Exception e)
        {
            System.out.println("Exception while taking screen shot"+e.getMessage());
            return e.getMessage();
        }

    }

    public static void passCase(String ImgDesc,String imagename )
    {
        String screenshot_path= ExtentReporterConfig.captureScreenShot(DriverConfig.driver, imagename);
        String image = logger.addScreenCapture(screenshot_path);
        ExtentReporterConfig.logger.log(LogStatus.PASS,ImgDesc,image);
    }

    public static void failCase(String failedDetail,String imagename )
    {
        String screenshot_path= ExtentReporterConfig.captureScreenShot(DriverConfig.driver, imagename);
        String image = logger.addScreenCapture(screenshot_path);
        ExtentReporterConfig.logger.log(LogStatus.FAIL,failedDetail,image);
    }



}
