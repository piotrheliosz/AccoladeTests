package PageObjectPattern;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Piotr Heliosz TFS on 2017-05-29.
 */

public class SearchPage extends Page {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tbQuickSearch")
    public WebElement searchField;

    public void findAndOpenProject(String projectName) {
        loadingSopheonElement();
        if (!projectTitleIsDispalyed()) {
            try {
                System.out.println("Searching for project: " + projectName);
                findProject(projectName);
                waitForVisibilityOfElement(searchField, 30);
                loadingSopheonElement();
                openFindedProject(projectName);
            } catch (NoSuchElementException ignore) {
                waitForVisibilityOfElement(searchField, 30);
                searchField.clear();
                findProject("HARMONY");
                loadingSopheonElement();
                openFindedProject("HARMONY");
            }
        }
    }

    private void findProject(String searchingProject) {
        searchField.sendKeys(searchingProject + Keys.ENTER);
    }

    private void openFindedProject(String projectName) {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.pollingEvery(200, TimeUnit.MICROSECONDS)
                .ignoring(org.openqa.selenium.NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='projects-tree']")));
        driver.findElement(By.xpath("//div[@id='QuickSearchResultsContainer']//ul[@class='projects-tree']//*[text()='" + projectName + "']")).click();
    }

    public boolean projectIsFound(String projectName) {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.pollingEvery(200, TimeUnit.MICROSECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='projects-tree']")));
        return driver.findElement(By.xpath("//div[@id='QuickSearchResultsContainer']//ul[@class='projects-tree']//*[text()='" + projectName + "']")).isDisplayed();
    }
}
