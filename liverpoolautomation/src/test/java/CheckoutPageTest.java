import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.TestResource;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPageTest {
    private String[] testProducts = {"Videojuego", "Pelota", "Paleta"};
    private TestResource testResource;

    @BeforeMethod
    public void setUp(){
        testResource = new TestResource();
        testResource.driver.get(testResource.urlHomePage);

    }

    @Test
    public void testBuyingArticles() throws InterruptedException{
        testResource.validLogin();
        for(int i=0; i<testProducts.length; i++) {
            buyArticle(i);
        } 
    }
    
    @AfterMethod
    public void tearDown(){
        testResource.driver.quit();
    }
    //buying article with account ready, address added, card added
    private void buyArticle(int i) throws InterruptedException{
        System.out.println(testProducts[i]);
        testResource.wait.until(ExpectedConditions.visibilityOf(testResource.homePage.searchBar())).sendKeys(testProducts[i]);
        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.homePage.searchBar())).sendKeys(Keys.ENTER);
        testResource.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='o-listing__products']//li[@class='m-product__card card-masonry a'][1]//img"))).click();
        Thread.sleep(2000);
        testResource.wait.until(ExpectedConditions.elementToBeClickable(By.id("opc_pdp_buyNowButton"))).click();
        Thread.sleep(2000);

        Assert.assertTrue(testResource
        .wait
        .until(ExpectedConditions
        .elementToBeClickable(testResource.checkOutPage.buyButton()))
        .isEnabled(), "Cannot complete purchase");

        testResource.wait.until(ExpectedConditions.elementToBeClickable(testResource.checkOutPage.homeBanner())).click();
        
    }

}
