package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features="src/test/resources/features",
        //tags = ("@Demo"),
        glue={"com.stepDef","com.hook"},
        dryRun=false,
        monochrome=true,
        plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)

public class RunnerClass extends AbstractTestNGCucumberTests {



}