package stEpDefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome=true,
		plugin={"pretty","html:target/html-cucumbers", "json:target/cucumbers.json"},
		features="src/test/java/features",
		tags={"@Sanity or @Regression"},                              
		glue={"stEpDefs"}
		
		)
						
public class TestRunner2 {
	
	

}
