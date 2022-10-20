package com.cydeo.library.stepdefinitions;

import com.cydeo.library.pages.LibrarianDashboardPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.pages.StudentDashboardPage;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
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


    @When("user enters librarian username {string}")
    public void userEntersLibrarianUsername(String username) {
        login.usernameFld.sendKeys(username);
    }

    @And("user enters librarian password {string}")
    public void userEntersLibrarianPassword(String password) {
        login.inputPassword.sendKeys(password+ Keys.ENTER);
    }

    @When("user enters student username {string}")
    public void userEntersStudentUsername(String username) {
        login.usernameFld.sendKeys(username);
    }

    @And("user enters student password {string}")
    public void userEntersStudentPassword(String password) {
        login.inputPassword.sendKeys(password+Keys.ENTER);
    }

    @When("I login using {string} and {string}")
    public void iLoginUsingAnd(String username, String password) {
        login.login(username,password);
    }

    @And("there should be Users module")
    public void thereShouldBeUsersModule() {
        Assert.assertTrue(libDash.usersNumber.isDisplayed());
    }

    @And("there should be Books module")
    public void thereShouldBeBooksModule() {
        Assert.assertTrue(libDash.booksNumber.isDisplayed());
    }

    @And("there should be Borrowed Books module")
    public void thereShouldBeBorrowedBooksModule() {
        Assert.assertTrue(libDash.borrowedBooksNumber.isDisplayed());
    }

    @Then("account holder name should be {string}")
    public void accountHolderNameShouldBe(String name) {
        Assert.assertEquals(name,libDash.userMenu.getText());

    }
}
