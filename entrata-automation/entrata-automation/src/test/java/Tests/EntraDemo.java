package Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import base.BaseTest;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class EntraDemo extends BaseTest {
    @Test
    public void testHomePageTitle() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // Verify the homepage title
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);
        Assert.assertTrue(pageTitle.contains("Entrata"), "Title does not contain 'Entrata'");
        System.out.println("test case 1 passed.");
        screenshot();
    }

    @Test
    public void cookieaccept(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        try {
            WebElement acceptButton = driver.findElement(By.xpath("//*[@id=\"cookie-accept\"]"));
            acceptButton.click();
            System.out.println("test case 2 passed.");
        } catch (NoSuchElementException e) {
            System.out.println("Cookie consent pop-up not found or already accepted.");
        }
    }
    @Test
    public void Demo() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        try {
            WebElement demoButton = driver.findElement(By.xpath("//div[text()='Schedule Your Demo']"));
            if (demoButton.isDisplayed()) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", demoButton);
                System.out.println("Test case: Demo button is visible and clicked using JavaScript.");
                System.out.println("Test case 3 passed.");
                screenshot();

                // Get the current window handle
                String originalWindow = driver.getWindowHandle();
                System.out.println("Original window handle: " + originalWindow);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

                // Get all window handles
                Set<String> allWindows = driver.getWindowHandles();
                System.out.println("Total window handles: " + allWindows.size());

                // Loop through all window handles and switch to the new tab
                for (String windowHandle : allWindows) {
                    if (!windowHandle.equals(originalWindow)) {
                        driver.switchTo().window(windowHandle);
                        System.out.println("Switched to the new tab: " + windowHandle);
                        break;
                    }
                }
                // Perform actions in the new tab
                fillOutForm();

                // Close the new tab
                driver.close();

                // Switch back to the original window
                driver.switchTo().window(originalWindow);
                System.out.println("Switched back to the original window.");

            } else {
                System.out.println("Test case: Demo button is not visible.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Schedule Your Demo button not found.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    private void fillOutForm() {
        // Example method to fill out the form fields
        screenshot();
        WebElement firstName = driver.findElement(By.cssSelector("#FirstName"));
        Assert.assertTrue(firstName.isDisplayed() && firstName.isEnabled(), "First Name field is not available");
        firstName.sendKeys("FirstNameTest");

        WebElement lastName = driver.findElement(By.cssSelector("#LastName"));
        Assert.assertTrue(lastName.isDisplayed() && lastName.isEnabled(), "Last Name field is not available");
        lastName.sendKeys("LastName");

        WebElement email = driver.findElement(By.cssSelector("#Email"));
        Assert.assertTrue(email.isDisplayed() && email.isEnabled(), "Email field is not available");
        email.sendKeys("Test@att.com");

        WebElement company = driver.findElement(By.cssSelector("#Company"));
        Assert.assertTrue(company.isDisplayed() && company.isEnabled(), "Company field is not available");
        company.sendKeys("TestCompany");

        WebElement phone = driver.findElement(By.cssSelector("#Phone"));
        Assert.assertTrue(phone.isDisplayed() && phone.isEnabled(), "Phone field is not available");
        phone.sendKeys("1234567890");

        // Select an option from Unit Count dropdown
        WebElement dropdownElement = driver.findElement(By.cssSelector("#Unit_Count__c"));
        Assert.assertTrue(dropdownElement.isDisplayed() && dropdownElement.isEnabled(), "Dropdown is not available");
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(1);

        WebElement role = driver.findElement(By.xpath("//input[@placeholder='Job Title']"));
        role.sendKeys("QA");
        System.out.println("Test case 4 passed.");
        screenshot();
    }
}
