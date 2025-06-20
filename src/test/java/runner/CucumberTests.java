package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(features = "src/test/resources/features",
glue = {"stepDefs","hooks"},
plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "pretty"},
monochrome = true
)
public class CucumberTests extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    public Object[][] parallelRunProvider()
    {
        return super.scenarios();
    }

    @Test(

            description = "Runs Cucumber Scenarios in parallel",
            dataProvider = "parallelRunProvider"
            //retryAnalyzer = RetryAnalyzer.class
    )
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        super.runScenario(pickleWrapper, featureWrapper);
    }

    //If I comment the entire block of code then the tests will run sequentially
    //If there are many TestNG class having multiple methods i.e. more than 30-40 methods than it will be code rewrite
    //So in this scenario: adding the listener in testng.xml file

}
