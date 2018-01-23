package AccoladePage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PartnersAccoladePage extends AccoladePage {

    public PartnersAccoladePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()='Apply']")
    public WebElement applyButton;

    @FindBy(xpath = "//*[@id='projectPageMainContent']//table[4]//div[@data-name='Engagement Partners']")
    private WebElement engagementPartnersTableHeading;

    @FindBy(xpath = "//*[@id='projectPageMainContent']//table[5]//div[@data-name='Proposed Partners']")
    private WebElement proposedPartnersTableHeading;

    @FindBy(xpath = "//*[@id='projectPageMainContent']//table[6]//div[@data-name='Description of the project consortium']")
    private WebElement descriptionOfTheProjectConsortiumTableHeading;

    @FindBy(xpath = "//*[@id='projectPageMainContent']//table[4]//button[text()='Add New Row']")
    private WebElement addEngagementPartnersButton;

    public void addPartnerAndFillAllFields() {
        waitForVisibilityOfElement(addEngagementPartnersButton, 5);
        addEngagementPartnersButton.click();
        selectProposedPartnerLegalName(++partnerDropDownIndex);
        sendAccountablePerson("accountablePersonFieldTest");
        sendEmail("emailFieldTest");
        sendPhoneNumber("phoneNumberFieldTest");
        sendActiveDateFrom("1");
        sendActiveDateTo("2");
    }

    private void selectProposedPartnerLegalName(int index) {
        driver.findElement(By.xpath("//*[@id='projectPageMainContent']//table[4]/tbody/tr[@data-row=" + numberOfTableRows(4) + "]/td[1]/div[1]")).click();
        Select select = new Select(driver.findElement(By.xpath("//*[@id='projectPageMainContent']//table[4]//select")));
        select.selectByIndex(index);
    }

    private void sendAccountablePerson(String accountablePersonText) {
        driver.findElement
                (By.xpath("//*[@id='projectPageMainContent']//table[4]//tr[@data-row=" + numberOfTableRows(4) + "]/td[7]/div[1]/input"))
                .sendKeys(accountablePersonText);
    }

    private void sendEmail(String emailText) {
        driver.findElement
                (By.xpath("//*[@id='projectPageMainContent']//table[4]//tr[@data-row=" + numberOfTableRows(4) + "]/td[8]/div[1]/input"))
                .sendKeys(emailText);
    }

    private void sendPhoneNumber(String phoneNumberText) {
        driver.findElement(By.xpath("//*[@id='projectPageMainContent']//table[4]//tr[@data-row=" + numberOfTableRows(4) + "]/td[9]/div[1]/input"))
                .sendKeys(phoneNumberText);
    }

    private void sendActiveDateFrom(String day) {
        WebElement activeFromDateField = driver.findElement
                (By.xpath("//*[@id='projectPageMainContent']//table[4]//tr[@data-row=" + numberOfTableRows(4) + "]/td[10]/div[1]/input"));
        activeFromDateField.click();
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='" + day + "']")).click();
    }

    private void sendActiveDateTo(String day) {
        WebElement activeFromDateField = driver.findElement
                (By.xpath("//*[@id='projectPageMainContent']//table[4]//tr[@data-row=" + numberOfTableRows(4) + "]/td[11]/div[1]/input"));
        activeFromDateField.click();
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='" + day + "']")).click();
    }


    public boolean engagementPartnersTableIsDisplayed() {
        try {
            waitForVisibilityOfElement(engagementPartnersTableHeading, 180);
            return engagementPartnersTableHeading.isDisplayed();
        } catch (NoSuchElementException ignore) {
            return false;
        }
    }

    public boolean proposedPartnersIsDisplayed() {
        try {
            waitForVisibilityOfElement(proposedPartnersTableHeading, 180);
            return proposedPartnersTableHeading.isDisplayed();
        } catch (NoSuchElementException ignore) {
            return false;
        }
    }

    public boolean descriptionOfTheProjectTableIsDisplayed() {
        try {
            waitForVisibilityOfElement(descriptionOfTheProjectConsortiumTableHeading, 180);
            return descriptionOfTheProjectConsortiumTableHeading.isDisplayed();
        } catch (NoSuchElementException ignore) {
            return false;
        }
    }

    public void sendMainActivityAndRoleInProjectText(String descriptionText) {
        driver.findElement(By.xpath("//*[@id='projectPageMainContent']//table[6]//tr[2]/td[5]/div[1]/span/p")).click();
        driver.findElement(By.xpath("//textarea[contains(@id, 'ui-id')]")).clear();
        driver.findElement(By.xpath("//textarea[contains(@id, 'ui-id')]")).sendKeys(descriptionText);
        driver.findElement(By.xpath("//div[contains(@style, 'position: absolute;')]//div[@class='ui-dialog-buttonset']//button[1]")).click();
    }

    public String getMainActivityAndRoleInProjectText() {
        loadingSopheonElement();
        return driver.findElement(By.xpath("//*[@id='projectPageMainContent']//table[6]//tr[2]/td[5]/div[1]/span/p")).getText();
    }

}
