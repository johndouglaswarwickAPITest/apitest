import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty",
                "html:build/report/html",
                "junit:build/report/junit/cucumber-report.xml",
                "json:build/report/json/cucumber-report.json"
        },
        features = {"src/test/resources/features/"},
        glue = {"stepdefs"},
        tags = {"~@ignore"}


)
public class Runner {

}
