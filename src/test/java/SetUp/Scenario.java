package SetUp;

import org.openqa.selenium.Point;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.awt.*;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Piotr Heliosz TFS on 2017-05-24.
 */

public class Scenario {

    public static WebDriver driver;
    //public static String projectName = "HARMONY";
    public static String projectName = UUID.randomUUID().toString();

    enum Browser {
        FIREFOX,
        CHROME,
        EDGE;
    }

    @BeforeClass
    public static void setUp() throws IOException, AWTException {

        Browser browserName = Browser.CHROME;

        switch (browserName) {
            case FIREFOX:
                System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
                driver = new FirefoxDriver();
                Runtime.getRuntime().exec("./handleAuthenticationWindowFirefox.exe");
                driver.get("https://" + Configuration.getBaseUrl());
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.get("https://" + Configuration.getLogin() + ":" + Configuration.getPassword()
                        + "@" + Configuration.getBaseUrl());
                driver.navigate().to("https://" + Configuration.getBaseUrl());
                break;
            case EDGE:
                System.setProperty("webdriver.edge.driver", "C:\\MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
                Runtime.getRuntime().exec("./handleAuthenticationWindowEdge.exe");
                driver.get("https://" + Configuration.getBaseUrl());
                break;
        }

        driver.manage().window().setPosition(new Point(1920, 1));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() throws UnhandledAlertException {
        driver.quit();
    }
}
