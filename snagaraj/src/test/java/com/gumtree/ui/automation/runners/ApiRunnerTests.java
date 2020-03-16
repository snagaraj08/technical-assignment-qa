package com.gumtree.ui.automation.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"src/test/resources/"},
        tags = {"@apitest"},
        glue = {
                "com.gumtree.ui.automation.apistepdefinitions"
        })
public class ApiRunnerTests{

}