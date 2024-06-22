package com.liverpool.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    /*
     * open url
     * iniciar sesión
     * crear cuenta
     * correo y password
     * confirmar password requirements
     * 
     * mostrar contraseña????
     * crear cuenta
     * nombre apellido paterno y materno
     * comprobar que apellido y nombre sean obligatorios???
     * fecha de nacimiento 
     * sexo
     * terminos y condiciones?
     * crear cuenta
     */

public class CreateAccountPage {
    public WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="email")
    private WebElement emailTextBox;

    @FindBy(id="password")
    private WebElement passwordTextBox;

    @FindBy(name="action")
    private WebElement createAccountButton;

    @FindBy(xpath="//button[@class='cd8576e16 ulp-button-icon c859954ba _button-icon']")
    private WebElement showPasswordButton;

    @FindBy(css="li[data-error-code='password-policy-length-at-least']")
    private WebElement errorMessageLenght;

    @FindBy(css="li[data-error-code='password-policy-lower-case']")
    private WebElement errorMessageLowerCase;

    @FindBy(css="li[data-error-code='password-policy-upper-case']")
    private WebElement errorMessageUpperCase;

    @FindBy(css="li[data-error-code='password-policy-numbers']")
    private WebElement errorMessageNumber;

    public WebElement emailTextBox(){
        return this.emailTextBox;
    }

    public WebElement passwordTextBox() {
        return this.passwordTextBox;
    }
    
    public WebElement createAccountButton() {
        return this.createAccountButton;
    }

    public WebElement showPasswordButton() {
        return this.showPasswordButton;
    }

    public WebElement errorMessageLenght() {
        return this.errorMessageLenght;
    }

    public WebElement errorMessageLowerCase() {
        return this.errorMessageLowerCase;
    }

    public WebElement errorMessageUpperCase() {
        return this.errorMessageUpperCase;
    }

    public WebElement errorMessageNumber() {
        return this.errorMessageNumber;
    }


}


