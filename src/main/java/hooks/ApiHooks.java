package hooks;

import io.cucumber.java.*;

public class ApiHooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("[BEFORE] Scenario: " + scenario.getName());
        System.out.println(scenario.getSourceTagNames());
    }

    /*
    *This will run before any scenario. We can also access scenario inside a hook
    * @param scenario
     */


    /*
     *This will run after any scenario. We can also access scenario inside a hook
     * @param scenario
     */

    @Before("@create-booking")
    public void beforeGetApi(Scenario scenario) {
        System.out.println("Before GET api run: " + scenario.getName());
        System.out.println(scenario.getSourceTagNames());
    }

    @Before("@get-all-booking")
    public void beforeCreateBookingApi(Scenario scenario) {
        System.out.println("Create Booking api run: " + scenario.getName());
        System.out.println(scenario.getSourceTagNames());
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("After Scenario in run: " + scenario.getName());
    }

    @AfterStep
    public void afterEachStep(Scenario scenario) {
        System.out.println("After each scenario in run: " + scenario.getName());
    }

    //This is use to the global setup and this will run before all the scenarios
    //They are always static method
    @BeforeAll
    public static void before_all() {
        System.out.println("Before executing all the scenarios: " );
    }

    @AfterAll
    public static void after_all() {
        System.out.println("After executing all the scenarios: " );
    }
}
