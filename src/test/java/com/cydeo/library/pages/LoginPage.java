package com.cydeo.library.pages;

import com.cydeo.library.utilities.ConfigurationReader;
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

    public void loginAsAStudent(){
        usernameFld.sendKeys(ConfigurationReader.getProperty("student.username"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("student.password"));
        signinBtn.click();
    }

    public void loginAsALibrarian(){
        usernameFld.sendKeys(ConfigurationReader.getProperty("librarian.username"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("librarian.password"));
        signinBtn.click();
    }

    public void login(String username, String password){
        usernameFld.sendKeys(username);
        inputPassword.sendKeys(password);
        signinBtn.click();
    }


























}
