import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.homePage.loginButton())).click();
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.loginPage.emailTextBox())).sendKeys("marcoalfredo.gg+1@gmail.com");
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.loginPage.passwordTextBox())).sendKeys("Automation1");
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.loginPage.loginButton())).click();
        
        // Wait for the home logo banner to be visible and assert it's enabled
        testResource.waitLonger.until(ExpectedConditions.visibilityOf(testResource.homePage.homeLogoBanner()));
        Assert.assertTrue(testResource.homePage.homeLogoBanner().isEnabled(), "The home logo banner is not enabled.");
    }
}
