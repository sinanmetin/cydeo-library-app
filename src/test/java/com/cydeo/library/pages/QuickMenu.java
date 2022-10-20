package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickMenu {


   public QuickMenu(){
       PageFactory.initElements(Driver.getDriver(), this);
   }


   @FindBy (xpath = "//span[.='Dashboard']")
    public WebElement dashboardLink;

    @FindBy (xpath = "//span[.='Users']")
    public WebElement usersLink;

    @FindBy (xpath = "//span[.='Books']")
    public WebElement booksLink;

    @FindBy (css = "a.navbar-brand")
    public WebElement homePageLink;

    @FindBy(xpath = "//a[@id='navbarDropdown']/span")
    public WebElement userMenu;

    @FindBy (xpath = "//a[.='Log Out']")
    public WebElement logOutBtn;





}
