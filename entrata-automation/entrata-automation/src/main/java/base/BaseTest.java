package base;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.DriverManager;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * BaseTest class that provides setup and teardown methods for WebDriver.
 * It also includes a method to take screenshots.
 */
public class BaseTest {
    protected static WebDriver driver;
    public ExtentReports extent;

    /**
     * Sets up the WebDriver before any test class is executed.
     * Initializes the WebDriver and navigates to the Entrata homepage.
     */
    @BeforeClass
    public void setUp() {

        try {

            // Set the path to the ChromeDriver executable
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            driver = DriverManager.getDriver();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver.get("https://www.entrata.com/");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    /**
     * Tears down the WebDriver after all test methods in the class have been executed.
     * Quits the WebDriver and flushes the ExtentReports instance.
     */
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (extent != null) {
            extent.flush();
        }

    }

    /**
     * Takes a screenshot of the current browser window.
     * The screenshot is saved with a unique filename based on the current timestamp.
     */
    public void screenshot(){
        // Take a screenshot
        try {
            // Navigate to a webpage

            // Take a screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Create a unique filename using the current timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filePath = "C:\\entrata-automation\\entrata-automation\\entrata-automation\\src\\screenshots\\screenshot_" + timestamp + ".png";

            // Save the screenshot
            FileHandler.copy(screenshot, new File(filePath));

            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
