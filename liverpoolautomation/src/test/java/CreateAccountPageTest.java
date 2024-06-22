import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import resources.TestResource;

public class CreateAccountPageTest {
    private int ACCOUNT_NUMBER = 100;
    private TestResource testResource;

    @BeforeClass
    public void setUp(){
        testResource = new TestResource();
        testResource.driver.get(testResource.urlHomePage);

    }
    @Test
    public void testAccountCreation(){
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.homePage.loginButton())).click();
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.loginPage.createAccountLink())).click();
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.createAccountPage.emailTextBox())).sendKeys("marcoalfredo.gg+" +ACCOUNT_NUMBER+ "@gmail.com");
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.createAccountPage.passwordTextBox())).sendKeys("Automation1");
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.createAccountPage.createAccountButton())).click();
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.userInformationPage.userInformationTitle()));

        Assert.assertEquals(testResource.userInformationPage.userInformationTitle().getText(), "Ingresa los siguientes datos");
    }
    
    @AfterClass
    public void tearDown(){
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.checkOutPage.homeBanner())).click();
        testResource.driver.quit();
    
    }
}
