package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.ExtentReporterConfig;

import java.util.concurrent.TimeUnit;

public class DriverConfig {

    public static WebDriver driver;// WebDriver is an interface in Selenium library and its methods are implemented in Classes like ChromeDriver, EdgeDriver, InternetExplorerDriver etc.,
    public static void openbrowser(String browsername){
        switch(browsername)
        {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driverFiles/chromedriver.exe");
                ChromeOptions options=new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver=new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
                // implicitlyWait method is best example for Polymorphism because the same method can be used with different types of parameters like Timeunit.SECONDS or TimeUnit.MINUTES
                ExtentReporterConfig.intialiseconfig();
                break;
        }
    }
}
