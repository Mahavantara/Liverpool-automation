package resources;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.liverpool.pageObjects.CheckOutPage;
import com.liverpool.pageObjects.CreateAccountPage;
import com.liverpool.pageObjects.HomePage;
import com.liverpool.pageObjects.LoginPage;
import com.liverpool.pageObjects.UserInformationPage;

public class TestResource {
    public String urlHomePage = "https://www.liverpool.com.mx/tienda/home";
    public WebDriver driver;
    public HomePage homePage;
    public LoginPage loginPage;
    public CheckOutPage checkOutPage;
    public CreateAccountPage createAccountPage;
    public WebDriverWait wait;
    public WebDriverWait waitLonger;
    public UserInformationPage userInformationPage;

    //setup login page
    public TestResource(){
        driver = new ChromeDriver();
        
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        checkOutPage = new CheckOutPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        userInformationPage = new UserInformationPage(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        waitLonger = new WebDriverWait(driver, Duration.ofSeconds(120));
    }

    public void validLogin() throws InterruptedException{
        
        wait.until(ExpectedConditions.elementToBeClickable(homePage.loginButton())).click();
        wait.until(ExpectedConditions.visibilityOf(loginPage.emailTextBox())).sendKeys("marcoalfredo.gg+1@gmail.com");
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordTextBox())).sendKeys("Automation1");
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginButton())).click();
        waitLonger.until(ExpectedConditions.visibilityOf(homePage.homeLogoBanner()));
        
    }
}
