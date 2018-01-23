package AccoladePage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.UUID;

public class GeneralDataAccoladePage extends AccoladePage {

    public GeneralDataAccoladePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='CenterContentContainer']//button[text()='Apply']")
    public WebElement applyGeneralData;

    @FindBy(xpath = "(//button[@title='Close'])[2]")
    public WebElement closePopupButton;

    @FindBy(xpath = "//*[@id='StageTaskDetailsMainDiv']//table[12]")
    public WebElement tasksTable;

    @FindBy(xpath = "//*[@id='StageTaskDetailsMainDiv']//table[13]")
    public WebElement deliverablesTable;

    @FindBy(xpath = "//*[@id='StageTaskDetailsMainDiv']//table[8]")
    public WebElement newProductsTable;

    @FindBy(xpath = "//*[@id='StageTaskDetailsMainDiv']//table[9]")
    private WebElement workpackagesTable;

    @FindBy(xpath = "//*[@id='StageTaskDetailsMainDiv']//table[14]")
    public WebElement uploadedDocumentsTabel;

    @FindBy(xpath = "//*[@id='StageTaskDetailsMainDiv']//table[19]")
    public WebElement backgroundIpTable;

    @FindBy(xpath = "//*[@id='StageTaskDetailsMainDiv']//table[21]")
    public WebElement foregroundIpTable;

    @FindBy(xpath = "//*[@id='StageTaskDetailsMainDiv']//table[23]")
    public WebElement complianceWithAdditionalKicTable;

    @FindBy(xpath = "//*[@id='StageTaskDetailsMainDiv']//table[25]")
    public WebElement riskAssesmentTable;

    @FindBy(xpath = "//*[@id='StageTaskDetailsMainDiv']//table[27]")
    public WebElement kpiTable;

    @FindBy(xpath = "//*[@id='StageTaskDetailsMainDiv']//table[28]")
    public WebElement uploadedKpiDocumentsTable;

    @FindBy(xpath = "//*[@id='StageTaskDetailsMainDiv']//table[6]")
    public WebElement startUpsTable;

    @FindBy(xpath = "//*[@id='CenterContentContainer']//table[1]//tr[1]/td[2]//input")
    private WebElement projectTitleField;

    @FindBy(xpath = "//*[@id='StageTaskDetailsMainDiv']//table[1]")
    private WebElement projectDetailsTable;

    @FindBy(xpath = "//*[@id='StageTaskDetailsMainDiv']//table[3]")
    private WebElement engagementPartnersTable;

    @FindBy(xpath = "//*[@id='StageTaskDetailsMainDiv']//table[5]")
    private WebElement proposedPartnersTable;

    public void addDeliverableProposalSubmitionStage(int tableNo) {
        addNewRowButton(tableNo).click();
        clickAlreadyAddedRow(tableNo);
        inputTextToTableData(tableNo, 1, String.valueOf(++id));
        inputTextToTableData(tableNo, 2, String.valueOf(++id));
        inputTextToTableData(tableNo, 3, String.valueOf(++id));
        inputTextToTableData(tableNo, 4, UUID.randomUUID().toString());
        sendDescriptionText(UUID.randomUUID().toString(), 5, tableNo);
        selectTableDataDropdownValue(tableNo, 6, 1);
        selectTableDataDropdownValue(tableNo, 7, 2);
    }

    public void addDeliverableInWp0Stage(int tableNo) {
        addNewRowButton(tableNo).click();
        inputTextToTableData(tableNo, 1, String.valueOf(++id));
        inputTextToTableData(tableNo, 2, String.valueOf(++id));
        inputTextToTableData(tableNo, 3, String.valueOf(++id));
        inputTextToTableData(tableNo, 4, UUID.randomUUID().toString());
        sendDescriptionText(UUID.randomUUID().toString(), 5, tableNo);
        selectTableDataDropdownValue(tableNo, 8, 1);
        selectTableDataDropdownValue(tableNo, 9, 2);
        selectTableDataDropdownValue(tableNo, 10, 1);
        sendDescriptionText(UUID.randomUUID().toString(), 11, tableNo);
        selectTableDataDropdownValue(tableNo, 12, 1);

    }

    public void addDeliverableInPeStage(int tableNo) {
        addNewRowButton(tableNo).click();
        inputTextToTableData(tableNo, 1, String.valueOf(++id));
        inputTextToTableData(tableNo, 2, String.valueOf(++id));
        inputTextToTableData(tableNo, 3, String.valueOf(++id));
        inputTextToTableData(tableNo, 4, UUID.randomUUID().toString());
        sendDescriptionText(UUID.randomUUID().toString(), 5, tableNo);
        sendDate(tableNo, 11, 3);
        selectTableDataDropdownValue(tableNo, 12, 1);
        inputTextToTableData(tableNo, 13, "100");
        inputTextToTableData(tableNo, 15, "100");
        sendDate(tableNo, 16, 4);
        sendDescriptionText(UUID.randomUUID().toString(), 17, tableNo);
        selectTableDataDropdownValue(tableNo, 18, 1);

    }

    public void addTaskInPeStage(int tableNo) {
        addNewRowButton(tableNo).click();
        clickAlreadyAddedRow(tableNo);
        inputTextToTableData(tableNo, 1, String.valueOf(++id));
        inputTextToTableData(tableNo, 2, String.valueOf(++id));
        inputTextToTableData(tableNo, 3, UUID.randomUUID().toString());
        sendDescriptionText(UUID.randomUUID().toString(), 4, tableNo);
        selectTableDataDropdownValue(tableNo, 5, 1);
        selectTableDataDropdownValue(tableNo, 6, 1);
        sendDate(tableNo, 15, 1);
        sendDate(tableNo, 16, 2);
        selectTableDataDropdownValue(tableNo, 17, 1);
        sendDescriptionText(UUID.randomUUID().toString(), 18, tableNo);
        inputTextToTableData(tableNo, 19, "100");
        sendDate(tableNo, 20, 3);
        sendDate(tableNo, 21, 4);
        selectTableDataDropdownValue(tableNo, 22, 1);

    }

    public void addTaskInWP0Stage(int tableNo) {
        addNewRowButton(tableNo).click();
        clickAlreadyAddedRow(tableNo);
        inputTextToTableData(tableNo, 1, String.valueOf(++id));
        inputTextToTableData(tableNo, 2, String.valueOf(++id));
        inputTextToTableData(tableNo, 3, UUID.randomUUID().toString());
        sendDescriptionText(UUID.randomUUID().toString(), 4, tableNo);
        selectTableDataDropdownValue(tableNo, 5, 1);
        selectTableDataDropdownValue(tableNo, 6, 1);
        selectTableDataDropdownValue(tableNo, 10, 1);
        selectTableDataDropdownValue(tableNo, 11, 1);
        inputTextToTableData(tableNo, 12, String.valueOf(++id));
        selectTableDataDropdownValue(tableNo, 13, 1);
        sendDescriptionText(UUID.randomUUID().toString(), 14, tableNo);
        inputTextToTableData(tableNo, 15, String.valueOf(++id));
        selectTableDataDropdownValue(tableNo, 16, 1);

    }

    public void addTaskInProposalSubmitionStage(int tableNo) {
        addNewRowButton(tableNo).click();
        clickAlreadyAddedRow(tableNo);
        inputTextToTableData(tableNo, 1, String.valueOf(++id));
        inputTextToTableData(tableNo, 2, String.valueOf(++id));
        inputTextToTableData(tableNo, 3, UUID.randomUUID().toString());
        sendDescriptionText(UUID.randomUUID().toString(), 4, tableNo);
        selectTableDataDropdownValue(tableNo, 5, 1);
        selectTableDataDropdownValue(tableNo, 6, 1);
        selectTableDataDropdownValue(tableNo, 7, 1);
        selectTableDataDropdownValue(tableNo, 8, 1);
        inputTextToTableData(tableNo, 9, String.valueOf(++id));

    }

    public void setProjectTitle(String projectTitle) {
        waitForVisibilityOfElement(projectTitleField, 60);
        projectTitleField.clear();
        projectTitleField.click();
        projectTitleField.sendKeys(projectTitle);
    }

    private void inputTextToTableData(int tableNo, int tdNo, String text) {
        WebElement tableData = driver.findElement
                (By.xpath("//*[@id='CenterContentContainer']//table[" + tableNo + "]//tr[@data-row='" + numberOfTableRows(tableNo) + "']/td[" + tdNo + "]/div[1]/input"));
        tableData.clear();
        tableData.sendKeys(text);
    }

    private void selectTableDataDropdownValue(int tableNo, int tdNo, int value) {
        WebElement dropdown = driver.findElement
                (By.xpath("//*[@id='CenterContentContainer']//table[" + tableNo + "]//tr[@data-row='" + numberOfTableRows(tableNo) + "']/td[" + tdNo + "]/div[1]/select"));
        Select select = new Select(dropdown);
        select.selectByIndex(value);
    }

    private void clickAlreadyAddedRow(int tableNo) {
        driver.findElement(By.xpath("//*[@id='CenterContentContainer']//table[" + tableNo + "]//tr[@data-row='" + numberOfTableRows(tableNo) + "']")).click();
    }

    private void sendDescriptionText(String descritpionText, int tdNo, int tableNo) {
        driver.findElement(By.xpath("//*[@id='CenterContentContainer']//table[" + tableNo + "]//tr[@data-row='" + numberOfTableRows(tableNo) + "']/td[" + tdNo + "]/div[1]")).click();
        try {
            driver.findElement(By.xpath("//div[contains(@class, 'ui-dialog')]//textarea[contains(@class, 'quickgridControl')]")).clear();
        } catch (NoSuchElementException ignore) {
            driver.findElement(By.xpath("//*[@id='CenterContentContainer']//table[" + tableNo + "]//tr[@data-row='" + numberOfTableRows(tableNo) + "']/td[" + tdNo + "]/div[1]")).click();
            driver.findElement(By.xpath("//div[contains(@class, 'ui-dialog')]//textarea[contains(@class, 'quickgridControl')]")).clear();
        }
        driver.findElement(By.xpath("//div[contains(@class, 'ui-dialog')]//textarea[contains(@class, 'quickgridControl')]")).sendKeys(descritpionText);
        driver.findElement(By.xpath("//div[contains(@style, 'position: absolute;')]//div[@class='ui-dialog-buttonset']//button[1]")).click();
    }

    private void sendDate(int tableNo, int tdNo, int day) {
        WebElement dateField = driver.findElement
                (By.xpath("//*[@id='CenterContentContainer']//table[" + tableNo + "]//tr[@data-row='" + numberOfTableRows(tableNo) + "']/td[" + tdNo + "]/div[1]/input"));
        dateField.click();
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='" + day + "']")).click();
    }

    public WebElement quickGridExpander(int tableNo) {
        return driver.findElement(By.xpath("//*[@id='CenterContentContainer']//table[" + tableNo + "]//div[contains(@class, 'quickGridGridExpander')]"));
    }

    private WebElement addNewRowButton(int tableNo) {
        return driver.findElement(By.xpath("//*[@id='CenterContentContainer']//table[" + tableNo + "]//button[text()='Add New Row']"));
    }

    public void sendWorkpackagesObjectivesText(String workpackagesObhectivesText) {
        driver.findElement(By.xpath("//*[@id='CenterContentContainer']//table[9]//tr[3]/td[3]/div[1]")).click();
        try {
            driver.findElement(By.xpath("//div[contains(@id, 'ui-id')]/textarea")).clear();
        } catch (NoSuchElementException ignore) {
            driver.findElement(By.xpath("//*[@id='CenterContentContainer']//table[9]//tr[3]/td[3]/div[1]")).click();
            driver.findElement(By.xpath("//div[contains(@id, 'ui-id')]/textarea")).clear();
        }
        driver.findElement(By.xpath("//div[contains(@id, 'ui-id')]/textarea")).sendKeys(workpackagesObhectivesText);
        driver.findElement(By.xpath("//div[contains(@style, 'position: absolute;')]//div[@class='ui-dialog-buttonset']//button[1]")).click();
    }

    public String getWorkpackagesObjectivesText() {
        loadingSopheonElement();
        return driver.findElement(By.xpath("//*[@id='CenterContentContainer']//table[9]//tr[3]/td[3]/div[1]/span")).getText();
    }

    public boolean projectDetailsTableIsDisplayed() {
        try {
            waitForVisibilityOfElement(projectDetailsTable, 90);
            return projectDetailsTable.isDisplayed();
        } catch (NoSuchElementException ignore) {
            return false;
        }
    }

    public boolean engagementPartnersTableIsDisplayed() {
        try {
            waitForVisibilityOfElement(engagementPartnersTable, 90);
            return engagementPartnersTable.isDisplayed();
        } catch (NoSuchElementException ignore) {
            return false;
        }
    }

    public boolean workpackagesTableIsDisplayed() {
        try {
            waitForVisibilityOfElement(workpackagesTable, 90);
            return workpackagesTable.isDisplayed();
        } catch (NoSuchElementException ignore) {
            return false;
        }
    }


    public boolean proposedPartnersTableIsDisplayed() {
        try {
            waitForVisibilityOfElement(proposedPartnersTable, 90);
            return proposedPartnersTable.isDisplayed();
        } catch (NoSuchElementException ingore) {
            return false;
        }
    }
}
