package utilities;


import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.observer.ExtentObserver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class DriverManager extends Listeners {

    private static WebDriver driver;

//    public static WebDriver getDriver() {
//        if (driver == null) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//        }
//        return driver;
//    }

    public static WebDriver getDriver() {
//        WebDriverManager.chromedriver().setup();  // WebDriverManager automatically downloads and sets up the correct driver version
//        return new ChromeDriver();
    	 EdgeOptions options = new EdgeOptions();
         options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
         options.setExperimentalOption("useAutomationExtension", false);
         WebDriver driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      //  WebDriverManager.edgedriver().setup(); // WebDriverManager automatically downloads and sets up the correct driver version
      //  return new EdgeDriver();
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
