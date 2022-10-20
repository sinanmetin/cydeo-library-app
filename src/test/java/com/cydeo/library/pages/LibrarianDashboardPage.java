package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibrarianDashboardPage {

    public LibrarianDashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//a[@id='navbarDropdown']/span")
    public WebElement userMenu;

    @FindBy(css = "h2#user_count")
    public WebElement usersNumber;

    @FindBy(css = "h2#book_count")
    public WebElement booksNumber;

    @FindBy(css = "h2#borrowed_books")
    public WebElement borrowedBooksNumber;





}
