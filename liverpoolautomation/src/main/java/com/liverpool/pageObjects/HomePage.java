package com.liverpool.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath="//span[@class='a-header__topLink' and text()='Iniciar sesión']")
    private WebElement loginButton;

    @FindBy(id="mainSearchbar")
    private WebElement searchBar;
    
    @FindBy(xpath="//button[@class='input-group-text']")
    private WebElement searchButton;

    @FindBy(css="img[title='Liverpool Logo']")
    private WebElement homeLogoBanner;


    public WebElement loginButton() {
        return this.loginButton;
    }

    public WebElement searchBar() {
        return this.searchBar;
    }

    public WebElement searchButton() {
        return this.searchButton;
    }
     public WebElement homeLogoBanner(){
        return this.homeLogoBanner;
     }

    
}
