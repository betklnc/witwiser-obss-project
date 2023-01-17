package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() {
        WebDriver driver = null;

        switch (getBrowserType()) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static String getBrowserType() {
        String browserType = null;
        try {
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
            properties.load(file);
            browserType = properties.getProperty("browser").toLowerCase().trim();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return browserType;
    }

    public static void clearCookieBeforeStart() {
        getDriver().manage().deleteAllCookies();
        getDriver().get("chrome://settings/clearBrowserData");
        getDriver().findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
    }

    public static void cleanupDriver() {
        getDriver().quit();
        webDriver.remove();
    }
}

