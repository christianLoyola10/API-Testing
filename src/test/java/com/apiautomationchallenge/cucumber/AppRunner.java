package com.apiautomationchallenge.cucumber;

import org.junit.runner.RunWith;

import com.apiautomationchallenge.testbase.TestBase;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

// This class serves as the entry point for Cucumber tests.
// It configures Cucumber to run with Serenity BDD by using the CucumberWithSerenity test runner.

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/feature")
// The @CucumberOptions annotation is used to specify the configuration for Cucumber test execution.

public class AppRunner extends TestBase {
    // The AppRunner class extends the TestBase class to inherit common test setup and configuration.
}
