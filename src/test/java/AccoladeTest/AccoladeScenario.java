package AccoladeTest;

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

/**
 * Created by Piotr Heliosz TFS on 2017-05-24.
 */

public class AccoladeScenario {

    public static WebDriver driver;
    public String projectName = "HARMONY";

    enum Browser {
        FIREFOX,
        CHROME,
        EDGE;
    }

    @BeforeClass
    public static void setUp() throws IOException, AWTException {

        Browser browserName = Browser.EDGE;

        String baseUrl = "";

        switch (browserName) {
            case FIREFOX:
                System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
                driver = new FirefoxDriver();
                Runtime.getRuntime().exec("./handleAuthenticationWindowFirefox.exe");
                driver.get("https://" + baseUrl);
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.get("https://*@" + baseUrl);
                driver.navigate().to("https://" + baseUrl);
                break;
            case EDGE:
                System.setProperty("webdriver.edge.driver", "C:\\MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
                Runtime.getRuntime().exec("./handleAuthenticationWindowEdge.exe");
                driver.get("https://" + baseUrl);
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
