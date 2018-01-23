package AccoladePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class GateAccoladePage extends AccoladePage {

    public GateAccoladePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='projectTimeline']//div[@title='Close call']//a")
    public WebElement closeCallButton;

    @FindBy(xpath = "//*[@id='projectTimeline']//div[@title='Go to KLAC']//a")
    public WebElement goToKlacButton;

    @FindBy(xpath = "//*[@id='projectTimeline']//div[@title='Approval']//a")
    public WebElement approvalButton;

    @FindBy(xpath = "//*[@id='projectTimeline']//div[@title='Investment Decision']//a")
    public WebElement investmentDecisionButton;

    @FindBy(xpath = "//*[@id='projectTimeline']//div[@title='WPO Gate']//a")
    public WebElement wp0GateButton;

    @FindBy(id = "ContentPlaceHolder_ProjectGatePanelView_GateDecisionDropDownList")
    public WebElement gateDecisionSelect;

    @FindBy(id = "ContentPlaceHolder_ProjectGatePanelView_ApplyButton")
    public WebElement applyGateButton;

    @FindBy(id = "LegacyIframe")
    public WebElement insideFrame;

    @FindBy(id = "ContentPlaceHolder_ProjectGatePanelView_GateMeetingDate_DatePicker")
    private WebElement meetingDateField;

    public void selectGateDecision(String value) {
        Select select = new Select(gateDecisionSelect);
        select.selectByVisibleText(value);
    }

    public void setMeetingDateField() {
        meetingDateField.click();
        driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//a[contains(@class, 'highlight')]")).click();
    }

    public void getCurrentStatus() {
        driver.findElement(By.xpath("//*[@id='projectTimeline']//div[@class='projectTimeline compact']")).getAttribute("data-currentphaseid");
    }

}
