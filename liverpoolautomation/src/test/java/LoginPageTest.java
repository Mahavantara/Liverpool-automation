import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.TestResource;

public class LoginPageTest {
    //String testResource.invalidPass = PasswordGenerator.generateRandomPassword(10);
    //String invalidEmail = PasswordGenerator.generateUserRandom();
    WebElement waitErrorPass;
    private TestResource testResource;
    String validEmail = "marcoalfredo.gg+1@gmail.com";
    String validPass = "Automation1";

    @BeforeMethod
    public void setUp() {
        testResource = new TestResource();
        testResource.driver.get(testResource.urlHomePage);
    }

    @Test
    public void testLoginValidCredentials() {
        WebElement waitHomeBanner;

        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.homePage.loginButton())).click();
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.loginPage.emailTextBox())).sendKeys(validEmail);
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.loginPage.passwordTextBox())).sendKeys(validPass);
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.loginPage.loginButton())).click();
        
        // Wait for the home logo banner to be visible and assert it's enabled
        waitHomeBanner = testResource.waitLonger.until(ExpectedConditions.visibilityOf(testResource.homePage.homeLogoBanner()));
        Assert.assertTrue(waitHomeBanner.isEnabled(), "The home logo banner is not enabled.");
    }

    @Test
    public void testLoginInvalidCredentials() {
        //Invalid password 
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.homePage.loginButton())).click();
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.loginPage.emailTextBox())).sendKeys(validEmail);
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.loginPage.passwordTextBox())).sendKeys(testResource.randomPass);
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.loginPage.loginButton())).click();
        
        waitErrorPass = testResource.waitLonger.until(ExpectedConditions.visibilityOf(testResource.loginPage.errorPassMess()));
        Assert.assertTrue(waitErrorPass.isDisplayed(), "The home logo banner is not enabled.");
        //Invalid email 
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.loginPage.emailTextBox())).sendKeys(testResource.invalidEmail);
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.loginPage.passwordTextBox())).sendKeys(validPass);
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.loginPage.loginButton())).click();
        
        waitErrorPass = testResource.waitLonger.until(ExpectedConditions.visibilityOf(testResource.loginPage.errorPassMess()));
        Assert.assertTrue(waitErrorPass.isDisplayed(), "The home logo banner is not enabled.");

        //Invalid credentials
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.loginPage.emailTextBox())).sendKeys(testResource.invalidEmail);
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.loginPage.passwordTextBox())).sendKeys(testResource.randomPass);
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.loginPage.loginButton())).click();
        
        waitErrorPass = testResource.waitLonger.until(ExpectedConditions.visibilityOf(testResource.loginPage.errorPassMess()));
        Assert.assertTrue(waitErrorPass.isDisplayed(), "The home logo banner is not enabled.");
    }

    @AfterMethod
    public void tearDown(){
        testResource.driver.quit();
    
    }
}