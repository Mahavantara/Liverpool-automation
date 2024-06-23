import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.PasswordGenerator;
import resources.TestResource;

public class CreateAccountPageTest {
    private TestResource testResource;

    int randomNumber = (int) (Math.random() * 1000);
    

    @BeforeMethod
    public void setUp(){
        testResource = new TestResource();
        testResource.driver.get(testResource.urlHomePage);

    }
    @Test
    public void testAccountCreation(){
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.homePage.loginButton())).click();
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.loginPage.createAccountLink())).click();
        
        do{
            testResource.wait.until(ExpectedConditions.visibilityOf(testResource.createAccountPage.emailTextBox())).sendKeys("marcoalfredo.gg+" +randomNumber+ "@gmail.com");
            testResource.wait.until(ExpectedConditions.visibilityOf(testResource.createAccountPage.passwordTextBox())).sendKeys(TestResource.passwordCorrect);
            testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.createAccountPage.createAccountButton())).click();
        } while(errorEmailPresent());

        System.out.println("fuera");
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.userInformationPage.userInformationTitle));

        Assert.assertEquals(testResource.userInformationPage.userInformationTitle().getText(), "Ingresa los siguientes datos");
    }

    //Invalid account creation due to an existing email 
    @Test
    public void testExistingEmail(){
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.homePage.loginButton())).click();
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.loginPage.createAccountLink())).click();
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.createAccountPage.emailTextBox())).sendKeys(TestResource.emailCorrect);
        //testResource.wait.until(ExpectedConditions.visibilityOf(testResource.createAccountPage.emailTextBox())).sendKeys("marcoalfredo.gg+" +randomNumber+ "@gmail.com");
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.createAccountPage.passwordTextBox())).sendKeys(testResource.randomPass);
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.createAccountPage.createAccountButton())).click();

        Assert.assertTrue(errorEmailPresent());
    }

        //Invalid account creation due to invalid password
        @Test
        public void testInvalidPassword(){
            testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.homePage.loginButton())).click();
            testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.loginPage.createAccountLink())).click();
            testResource.wait.until(ExpectedConditions.visibilityOf(testResource.createAccountPage.emailTextBox())).sendKeys(testResource.invalidEmail);
            testResource.wait.until(ExpectedConditions.visibilityOf(testResource.createAccountPage.passwordTextBox())).sendKeys(PasswordGenerator.generateRandomPassword(5));
            testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.createAccountPage.createAccountButton())).click();
    
            Assert.assertTrue(messagePassNotcomplete());
            
        }

    @AfterMethod
    public void tearDown(){
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.checkOutPage.homeBanner())).click();
        testResource.driver.quit();
    
    }

    public boolean errorEmailPresent(){
        try {
            testResource.driver.findElement(By.id("error-element-email"));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean messagePassNotcomplete(){
        try {
            testResource.driver.findElement(By.xpath("//span[contains(text(), 'Su contraseña debe contener:')]"));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
