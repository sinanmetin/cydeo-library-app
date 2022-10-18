package com.cydeo.library.stepdefinitions;

import com.cydeo.library.pages.LibrarianDashboardPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.pages.StudentDashboardPage;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefinitions {

    LoginPage login = new LoginPage();
    LibrarianDashboardPage libDash=new LibrarianDashboardPage();
    StudentDashboardPage stdDash=new StudentDashboardPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        login.usernameFld.sendKeys(ConfigurationReader.getProperty("librarian.username"));
    }

    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        login.inputPassword.sendKeys(ConfigurationReader.getProperty("librarian.password"));
        login.signinBtn.click();
    }

    @Then("student should see the dashboard")
    public void student_should_see_the_dashboard() {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(stdDash.userMenu));

        Assert.assertTrue(stdDash.userMenu.isDisplayed());

    }

    @Then("librarian should see the dashboard")
    public void librarian_should_see_the_dashboard() {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(libDash.userMenu));

        Assert.assertTrue(libDash.userMenu.isDisplayed());

    }

    @When("user enters student username")
    public void user_enters_student_username() {
        login.usernameFld.sendKeys(ConfigurationReader.getProperty("student.username"));
    }

    @When("user enters student password")
    public void user_enters_student_password() {
        login.inputPassword.sendKeys(ConfigurationReader.getProperty("student.password"));
        login.signinBtn.click();
    }


}
