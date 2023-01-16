package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static drivers.DriverFactory.cleanupDriver;
import static drivers.DriverFactory.clearCookieBeforeStart;

public class Hooks {

    @Before
    public void clearCookies() {
        clearCookieBeforeStart();
    }

    @Before(value = "@assignsession", order = 2)

    public void scenario1() {
        System.out.println("assignsession ok");
    }

    @Before(value = "@completeexam", order = 1)
    public void scenario2() {
        System.out.println("completeexam ok");
    }

        @After
    public void closeDriver() {
        cleanupDriver();
    }
}
