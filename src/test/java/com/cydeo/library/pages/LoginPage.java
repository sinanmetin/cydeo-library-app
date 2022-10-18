package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (css = "input#inputEmail")
    public WebElement usernameFld;

    @FindBy (xpath = "//button[.='Sign in']")
    public WebElement signinBtn;

    @FindBy(css = "input#inputPassword")
    public WebElement inputPassword;



















}
