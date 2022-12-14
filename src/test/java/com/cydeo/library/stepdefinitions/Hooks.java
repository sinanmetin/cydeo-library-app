package com.cydeo.library.stepdefinitions;

import com.cydeo.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {





    @After  //*****import from io.cucumber.java not from junit
    public void teardownScenario(Scenario scenario){


        if (scenario.isFailed()){
            byte [] screenshot= ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName());
        }

        Driver.closeDriver();

    }


}
