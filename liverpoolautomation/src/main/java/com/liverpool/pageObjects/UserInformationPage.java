package com.liverpool.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInformationPage {
    public WebDriver driver;

    public UserInformationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@class='m-title']")
    public WebElement userInformationTitle;

    public WebElement userInformationTitle() {
        return this.userInformationTitle;

    }
    
}
