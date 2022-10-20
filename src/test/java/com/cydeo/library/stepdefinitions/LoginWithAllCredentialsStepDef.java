package com.cydeo.library.stepdefinitions;

import com.cydeo.library.pages.LibrarianDashboardPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.pages.QuickMenu;
import com.cydeo.library.pages.StudentDashboardPage;
import com.cydeo.library.utilities.Driver;
import com.cydeo.library.utilities.ExcelUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class LoginWithAllCredentialsStepDef {

    LoginPage loginPage=new LoginPage();
    StudentDashboardPage stdDash=new StudentDashboardPage();
    LibrarianDashboardPage libDash=new LibrarianDashboardPage();
    QuickMenu quickMenu=new QuickMenu();

    XSSFSheet sheet =ExcelUtil.openAndGetSheet("Credentials");


    @When("login with all valid credentials")
    public void student_login_with_valid_credentials() {



        for (int i = 0; i <= sheet.getLastRowNum(); i++) {

            String username=sheet.getRow(i).getCell(1).toString();
            String password=sheet.getRow(i).getCell(2).toString();

            loginPage.login(username,password);

            WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
            wait.until(ExpectedConditions.visibilityOf(stdDash.userMenu));

            String accountUsername=sheet.getRow(i).getCell(0).toString();
            if(accountUsername.equals(libDash.userMenu.getText())){

                sheet.getRow(i).getCell(4).setCellValue("PASS");
            }else{
                sheet.getRow(i).getCell(5).setCellValue(libDash.userMenu.getText());
            }



            quickMenu.userMenu.click();
            quickMenu.logOutBtn.click();
        }

        for (int i = 0; i <= sheet.getLastRowNum(); i++) {

            String username=sheet.getRow(i).getCell(7).toString();
            String password=sheet.getRow(i).getCell(8).toString();

            loginPage.login(username,password);

            WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
            wait.until(ExpectedConditions.visibilityOf(stdDash.userMenu));

            String accountUsername=sheet.getRow(i).getCell(6).toString();

            if(accountUsername.equals(libDash.userMenu.getText())){
                sheet.getRow(i).getCell(10).setCellValue("PASS");
            }else{
                sheet.getRow(i).getCell(11).setCellValue(libDash.userMenu.getText());
            }



            quickMenu.userMenu.click();
            quickMenu.logOutBtn.click();
        }
        ExcelUtil.fileSave();
    }


    @Then("verify excel table")
    public void verifyExcelTable() {

        List<String> expectedResult=new ArrayList<>();
        List<String> actualResult=new ArrayList<>();


        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            actualResult.add(sheet.getRow(i).getCell(4).toString());
            actualResult.add(sheet.getRow(i).getCell(10).toString());
            expectedResult.add("PASS");
            expectedResult.add("PASS");
        }

        ExcelUtil.fileSaveAndCloseAll();

        Assert.assertEquals(expectedResult,actualResult);

    }
}
