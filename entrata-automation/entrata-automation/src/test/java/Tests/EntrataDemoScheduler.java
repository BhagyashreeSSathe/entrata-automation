package Tests;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import utilities.ExcelReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import base.BaseTest;
import utilities.Listeners;
import java.util.concurrent.TimeUnit;

public class EntrataDemoScheduler  extends BaseTest {

    public static void main(String[] args) {
     //   Setup WebDriverManager and ChromeDriver;
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Set implicit wait
            //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

           // Read data from Excel
          ExcelReader excelReader = new ExcelReader("C:\\entrata-automation\\entrata-automation\\Data.xlsx");
            String firstNameData = excelReader.getCellData("Sheet1", 1, 0); // Assuming data starts from row 1
            String lastNameData = excelReader.getCellData("Sheet1", 1, 1);
            String emailData = excelReader.getCellData("Sheet1", 1, 2);

            
           // excelReader.close();

            // Navigate to entrata.com
           // driver.get("https://www.entrata.com/");

            // Click on "Schedule Your Demo"
            WebElement scheduleDemoButton = driver.findElement(By.linkText("Schedule Your Demo"));
            scheduleDemoButton.click();

            // Fill in the demo scheduling form
            WebElement firstName = driver.findElement(By.name("firstName"));
            WebElement lastName = driver.findElement(By.name("lastName"));
            WebElement email = driver.findElement(By.name("email"));
            WebElement phone = driver.findElement(By.name("phone"));
            WebElement submitButton = driver.findElement(By.id("submit-button-id")); // Update this

            // Fill out the form using data from Excel
            firstName.sendKeys(firstNameData);
            lastName.sendKeys(lastNameData);
            email.sendKeys(emailData);
            //phone.sendKeys(phoneData);

            // Submit the form
            submitButton.click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
