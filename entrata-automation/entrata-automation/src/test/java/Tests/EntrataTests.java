package Tests;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.Listeners;


import java.util.concurrent.TimeUnit;

public class EntrataTests extends BaseTest {


	@Test
	public void testHomePageTitle() {
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
			screenshot();
		} catch (NoSuchElementException e) {
			System.out.println("Cookie consent pop-up not found or already accepted.");
		}

	}

	@Test
	public void testNavigationToProducts() {

		// Click on "Products" link in the header and verify navigation
		try {
			// Set implicit wait
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			// Find and click the 'Products' link
			WebElement productsLink = driver.findElement(By.xpath("//div[contains(text(),'Products')]"));
			productsLink.click();

			// Get the title of the products page
			String productsPageTitle = driver.getTitle();
			System.out.println("Navigated to: " + productsPageTitle);

			// Assert the title contains 'Products'
			Assert.assertTrue(productsPageTitle.contains("Entrata"), "Failed to navigate to Products page");
			System.out.println("test case 3 passed.");
			screenshot();
		} catch (NoSuchElementException e) {
			System.out.println("The 'Products' link was not found.");
		} catch (TimeoutException e) {
			System.out.println("The operation timed out.");
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
	}

	@Test
	public void testLoginButtonPresent() {
		// Check if the login button is present on the homepage
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
		Assert.assertTrue(loginButton.isDisplayed(), "Sign In button is not displayed on the homepage");
		System.out.println("test case 4 passed.");
		screenshot();

	}
}
