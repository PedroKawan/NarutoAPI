package me.pedrokaua.narutoapi.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/me/pedrokaua/narutoapi/cucumber",
        glue = "me.pedrokaua.narutoapi.cucumber"
    )
public class CucumberTests {
}
