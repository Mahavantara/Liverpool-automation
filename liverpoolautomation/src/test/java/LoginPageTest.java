import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import resources.PasswordGenerator;
import resources.TestResource;

public class LoginPageTest {
    private TestResource testResource;

    @BeforeClass
    public void setUp() {
        testResource = new TestResource();
        testResource.driver.get(testResource.urlHomePage);
    }

    @Test
    public void testLoginValidCredentials() {
        WebElement waitHomeBanner;

        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.homePage.loginButton())).click();
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.loginPage.emailTextBox())).sendKeys("marcoalfredo.gg+1@gmail.com");
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.loginPage.passwordTextBox())).sendKeys("Automation1");
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.loginPage.loginButton())).click();
        
        // Wait for the home logo banner to be visible and assert it's enabled
        waitHomeBanner = testResource.waitLonger.until(ExpectedConditions.visibilityOf(testResource.homePage.homeLogoBanner()));
        Assert.assertTrue(waitHomeBanner.isEnabled(), "The home logo banner is not enabled.");
    }

    @Test
    public void testLoginInvalidCredentials() {
        String invalidPass = PasswordGenerator.generateRandomPassword(10);
        WebElement waitErrorPass;

        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.homePage.loginButton())).click();
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.loginPage.emailTextBox())).sendKeys("marcoalfredo.gg+1@gmail.com");
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.loginPage.passwordTextBox())).sendKeys(invalidPass);
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.loginPage.loginButton())).click();
        
        // Wait for the home logo banner to be visible and assert it's enabled
        waitErrorPass = testResource.waitLonger.until(ExpectedConditions.visibilityOf(testResource.loginPage.errorPassMess()));
        Assert.assertTrue(waitErrorPass.isDisplayed(), "The home logo banner is not enabled.");
    }
}