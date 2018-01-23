package AccoladePage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by Piotr Heliosz TFS on 2017-05-24.
 */

public class AccoladePage {

    public AccoladePage(WebDriver driver) {
        AccoladePage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    static WebDriver driver;
    public static String uuidProjectName = UUID.randomUUID().toString();
    public static String uuidProjectDesc = UUID.randomUUID().toString();
    static int partnerDropDownIndex = 0;
    static int id = 0;
    private static double totalTime;

    @FindBy(id = "MainHeader")
    public WebElement mainHeader;

    @FindBy(id = "projectTitleHeader")
    public WebElement projectName;


    public void loadingSopheonElement() {
        WebDriverWait wait = new WebDriverWait(driver, 360);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[contains(@class, 'loading') or contains(@class, 'sopheon_loading')]"), 0));
    }

    public void waitForVisibilityOfElement(WebElement element, int timeout) {
        loadingSopheonElement();
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.pollingEvery(200, TimeUnit.MICROSECONDS).ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.visibilityOf(element));
        } catch (StaleElementReferenceException ignore) {
        }
        loadingSopheonElement();
    }

    public void waitUntilElementIsClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 360);
        try {
            loadingSopheonElement();
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
    }

    public String getProjectName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(projectName)).getText();
    }

    public String numberOfTableRows(int tableNumber) {
        List<WebElement> numberOfRows = driver.findElements
                (By.xpath("//table[" + tableNumber + "]//tr[(@data-row and not(@data-row='0'))]"));
        return numberOfRows.get(numberOfRows.size() - 1).getAttribute("data-row");
    }

    public static void totalTime(double time1, double time2) {
        totalTime = totalTime + (time2 - time1) / 1000000000;
        System.out.println("Total time: " + totalTime);
    }
}
