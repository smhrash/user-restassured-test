package com.perficient.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/perficient/features"},
        glue = {"com/perficient/step_definitions"},
        plugin = {"pretty", "json:target/cucumber-report.json"}
       // tags = "@get-user"
)

public class RunnerTest {

}
