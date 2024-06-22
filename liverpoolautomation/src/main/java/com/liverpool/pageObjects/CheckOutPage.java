package com.liverpool.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
    public WebDriver driver;
    
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//h4[contains(text(), 'Confirma tu compra')]")
    private WebElement checkOutTitle;

    @FindBy(id="promotions__banner")
    private WebElement homeBanner;

    @FindBy(id="opc_addressButton")
    private WebElement deliveryHomeButton;

    @FindBy(id="opc_addresses-container")
    private WebElement optionHomeButton;

    @FindBy(xpath="//button[text()='Continuar']")
    private WebElement addAddressButton;

    @FindBy(id="submitForOther")
    private WebElement buyButton;

    public WebElement checkOutTitle() {
        return this.checkOutTitle;

    }

    public WebElement homeBanner(){
        return this.homeBanner;
    }
    
    public WebElement deliveryHomeButton(){
        return this.deliveryHomeButton;
    }
    
    public WebElement optionHomeButton(){
        return this.optionHomeButton();
    }

    public WebElement addAddressButton(){
        return this.addAddressButton;
    }

    public WebElement buyButton() {
        return this.buyButton;
    }

}
