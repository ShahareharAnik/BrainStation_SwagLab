package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(features = {"src/test/resources/Feature"},
        glue = {"StepDefinetion"},   monochrome = true,
        dryRun = false,
        plugin ={ "pretty","html:build/reports/BrainStation.html"
        })
@Test
class CucumberRunner extends AbstractTestNGCucumberTests{
}