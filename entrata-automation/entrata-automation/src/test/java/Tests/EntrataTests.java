package Tests;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
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
	public void cookieaccept() {
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
	public void testNavigationToPages() {
		// Array of page names and their corresponding XPath
		String[][] pages = {
				{"Products", "//div[contains(text(),'Products')]"},
				{"Solutions", "//div[contains(text(),'Solutions')]"},
				{"Resources", "//div[contains(text(),'Resources')]"}
		};

		for (String[] page : pages) {
			String pageName = page[0];
			String pageXPath = page[1];

			try {
				// Set implicit wait
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				// Find and click the link
				WebElement link = driver.findElement(By.xpath(pageXPath));
				link.click();

				// Get the title of the navigated page
				String pageTitle = driver.getTitle();
				System.out.println("Navigated to: " + pageTitle);

				// Assert the title contains the expected page name
				Assert.assertTrue(pageTitle.contains("Entrata"), "Failed to navigate to " + pageName + " page");
				System.out.println("Test case for " + pageName + " passed.");
				screenshot(); // Capture a screenshot after navigation

			} catch (NoSuchElementException e) {
				System.out.println("The '" + pageName + "' link was not found.");
			} catch (TimeoutException e) {
				System.out.println("The operation timed out while navigating to " + pageName + " page.");
			} catch (Exception e) {
				System.out.println("An unexpected error occurred while navigating to " + pageName + ": " + e.getMessage());
			}

			// Navigate back to the homepage to reset state for the next iteration
			driver.navigate().back();
		}
	}


	@Test
	public void testLoginButtonPresent() {
		// Check if the login button is present on the homepage
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
		Assert.assertTrue(loginButton.isDisplayed(), "Sign In button is not displayed on the homepage");
		System.out.println("test case 5 passed.");
		screenshot();

	}

	@Test
	public void checkAllBrokenLinks() {
		// Check for broken links on the homepage
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HttpURLConnection connection = null;
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links on the page: " + links.size());

		for (WebElement link : links) {
			String url = link.getAttribute("href");
			try {
				URL actualUrl = new URL(url);
				connection = (HttpURLConnection) actualUrl.openConnection();
				connection.setRequestMethod("HEAD");
				connection.connect();
				int responseCode = connection.getResponseCode();
				if (responseCode >= 400) {
					System.out.println("Broken link found: " + url);
				} else {
					System.out.println("Valid link: " + url);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}

