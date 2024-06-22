package com.liverpool.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[contains(text(), 'Crear cuenta')]")
    private WebElement createAccountLink;

    @FindBy(id="username")
    private WebElement emailTextBox;

    @FindBy(id="password")
    private WebElement passwordTextBox;

    @FindBy(name="action")
    private WebElement loginButton;
    
    public WebElement createAccountLink() {
        return this.createAccountLink;
    }
    public WebElement emailTextBox(){
        return this.emailTextBox;
    }

    public WebElement passwordTextBox() {
        return this.passwordTextBox;
    }

    public WebElement loginButton() {
        return this.loginButton;
    }
}
