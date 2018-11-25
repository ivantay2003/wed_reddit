/*
 * Copyright Ivan Tay 2018
 */

package cucumber;


import org.junit.runner.RunWith;
import org.testng.annotations.Test;



import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class) 
@CucumberOptions(plugin ={"pretty" , "html:Folder_Name"},
				tags={"@Scenario1"},
				features="src/test/java/cucumber",
				glue={"stepDefinition"}
		) 


public class runTest  extends AbstractTestNGCucumberTests{




}
