package PageObjectPattern;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Piotr Heliosz TFS on 2017-05-24.
 */

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "BtnCreateProject")
    public WebElement createNewProjectButton;

    @FindBy(id = "projectCodeLabel")
    public WebElement projetId;

    @FindBy(id = "AccessNodeID")
    private WebElement accessGroupDropdown;

    @FindBy(xpath = "//a[text()='Project']")
    private WebElement projectDropdown;

    @FindBy(xpath = "//*[@id='createProjectForm']//*[text()='Click to Edit...']")
    private WebElement callPeriodField;

    @FindBy(xpath = "//*[@id='createProjectForm']//select[@class='cte_editor']")
    private WebElement callPeriodDropdown;

    public WebElement openProjectDropdownAndPassTextOfChoosenElement(String choosenElementText) {
        waitForVisibilityOfElement(projectDropdown, 30);
        loadingSopheonElement();
        projectDropdown.click();
        loadingSopheonElement();
        return driver.findElement(By.xpath("//a[text()='" + choosenElementText + "']"));
    }

    public void createNewProject(String projectName) {
        loadingSopheonElement();
        try {
            selectNewPojectClass("WP0");
            setNewPojectName(projectName);
            setNewPojectDescription(Page.uuidProjectDesc);
            setNewPojectAccessGroup("    Clean coal and gas technologies");
            setNewPojectCallPeriod("CIP2017-2");
            createNewProjectButton.click();
            loadingSopheonElement();
        } catch (UnhandledAlertException | NoSuchElementException e) {
            if (e.toString().contains("UnhandledAlertException")) {
                driver.switchTo().alert().accept();
            }
            waitForVisibilityOfElement(accessGroupDropdown, 30);
            driver.findElement(By.xpath("//select[@id='AccessNodeID']")).click();
            driver.findElement(By.xpath("//select[@id='AccessNodeID']//option[@value='3']")).click();
            driver.findElement(By.xpath("//*[@title='Call period']/div")).click();
            driver.findElement(By.xpath("//select[@class='cte_editor']/option[@value='CIP2017-2']")).click();
            createNewProjectButton.click();
            loadingSopheonElement();
        }
    }

    public void setNewPojectCallPeriod(String visibleText) {
        waitForVisibilityOfElement(callPeriodField, 10);
        callPeriodField.click();
        waitForVisibilityOfElement(callPeriodDropdown, 5);
        Select select = new Select(callPeriodDropdown);
        select.selectByVisibleText(visibleText);
    }

    public void setNewPojectAccessGroup(String visibleText) {
        waitForVisibilityOfElement(accessGroupDropdown, 30);
        waitUntilElementIsClickable(accessGroupDropdown);
        Select select = new Select(accessGroupDropdown);
        select.selectByVisibleText(visibleText);
    }

    public void setNewPojectDescription(String newProjectDescriptionText) {
        driver.findElement(By.id("ProjectDescription")).sendKeys(newProjectDescriptionText);
    }

    public void setNewPojectName(String newProjectName) {
        driver.findElement(By.id("ProjectName")).sendKeys(newProjectName);
    }

    public void selectNewPojectModel(String visibleText) {
        WebElement modelsDropdown = driver.findElement(By.id("ProcessModels"));
        Select select = new Select(modelsDropdown);
        select.selectByVisibleText(visibleText);
    }

    public void selectNewPojectClass(String visibleText) {
        WebElement classesDropdown = driver.findElement(By.id("Classes"));
        Select select = new Select(classesDropdown);
        select.selectByVisibleText(visibleText);
    }

}
