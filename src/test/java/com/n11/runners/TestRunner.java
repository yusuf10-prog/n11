package com.n11.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.n11.stepdefinitions",
    plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {
}
