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

    @After
    public void closeDriver() {
        cleanupDriver();
    }
}
