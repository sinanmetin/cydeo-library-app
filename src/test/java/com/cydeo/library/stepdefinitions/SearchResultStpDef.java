package com.cydeo.library.stepdefinitions;

import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.pages.QuickMenu;
import com.cydeo.library.pages.UserManagementPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class SearchResultStpDef {

    LoginPage login=new LoginPage();
    QuickMenu quickMenu=new QuickMenu();
    UserManagementPage userManPage=new UserManagementPage();

    @Given("User logged in as a librarian")
    public void user_logged_in_as_a_librarian() {

        login.loginAsALibrarian();
    }
    @When("Librarian click on Users link")
    public void librarian_click_on_users_link() {
        quickMenu.usersLink.click();
    }
    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedList) {

        List<String> actualList=BrowserUtils.getElementsText(userManPage.tableHeader);

        Assert.assertEquals(expectedList,actualList);

    }




}
