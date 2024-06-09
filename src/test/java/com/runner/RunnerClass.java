package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features="src/test/resources/features",
       // tags = ("@Test11"),
        glue={"com.stepDef","com.hook"},
        dryRun=false,
        monochrome=true,
        plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)


//implementation of cucumber and testng

public class RunnerClass extends AbstractTestNGCucumberTests {



}