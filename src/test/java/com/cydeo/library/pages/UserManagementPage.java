package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserManagementPage {

    public UserManagementPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }



    @FindBy (xpath = "//table[@id='tbl_users']//tr/th")
    public List<WebElement> tableHeader;





}
