package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.WebDriverSingleton;

public class ScenarioHooks {
    @Before
    public void beforeScenario(){
    }

    @After
    public void afterScenario(){
        WebDriverSingleton.kill();
    }
}
