package AccoladeTest.EnterData;

import AccoladePage.GateAccoladePage;
import AccoladePage.LeftMenuAccoladePage;
import AccoladePage.SearchAccoladePage;
import AccoladeTest.AccoladeScenario;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class Test05_PassAllGatesTillWP0 extends AccoladeScenario {

    @Test
    public void callShouldBeClosed() throws InterruptedException {

        SearchAccoladePage searchAccoladePage = new SearchAccoladePage(driver);
        searchAccoladePage.findAndOpenProject(projectName);

        LeftMenuAccoladePage leftMenuAccoladePage = new LeftMenuAccoladePage(driver);
        leftMenuAccoladePage.waitForVisibilityOfElement(leftMenuAccoladePage.stagesSectionLink, 10);
        System.out.println("projectName: " + leftMenuAccoladePage.getProjectName());

        GateAccoladePage gateAccoladePage = new GateAccoladePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //Close call gate
        gateAccoladePage.waitForVisibilityOfElement(gateAccoladePage.closeCallButton, 20);
        gateAccoladePage.closeCallButton.click();

        gateAccoladePage.waitForVisibilityOfElement(gateAccoladePage.insideFrame, 10);
        driver.switchTo().parentFrame();
        wait.until(ExpectedConditions.not(stalenessOf(gateAccoladePage.insideFrame)));
        driver.switchTo().frame("LegacyIframe");

        gateAccoladePage.waitForVisibilityOfElement(gateAccoladePage.gateDecisionSelect, 10);
        gateAccoladePage.selectGateDecision("Go");
        gateAccoladePage.applyGateButton.click();
        gateAccoladePage.loadingSopheonElement();

        //Go to KLAC
        gateAccoladePage.waitForVisibilityOfElement(gateAccoladePage.goToKlacButton, 20);
        gateAccoladePage.goToKlacButton.click();

        driver.switchTo().parentFrame();

        try {
            driver.switchTo().frame("LegacyIframe");
            gateAccoladePage.selectGateDecision("Go");
            gateAccoladePage.applyGateButton.click();
            gateAccoladePage.loadingSopheonElement();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            driver.switchTo().frame("LegacyIframe");
            gateAccoladePage.waitForVisibilityOfElement(gateAccoladePage.gateDecisionSelect, 10);
            gateAccoladePage.selectGateDecision("Go");
            gateAccoladePage.applyGateButton.click();
            gateAccoladePage.loadingSopheonElement();
        }

        //Approval
        gateAccoladePage.waitForVisibilityOfElement(gateAccoladePage.approvalButton, 20);
        gateAccoladePage.approvalButton.click();

        driver.switchTo().parentFrame();

        try {
            driver.switchTo().frame("LegacyIframe");
            gateAccoladePage.selectGateDecision("Go");
            gateAccoladePage.applyGateButton.click();
            gateAccoladePage.loadingSopheonElement();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            driver.switchTo().frame("LegacyIframe");
            gateAccoladePage.waitForVisibilityOfElement(gateAccoladePage.gateDecisionSelect, 10);
            gateAccoladePage.selectGateDecision("Go");
            gateAccoladePage.applyGateButton.click();
            gateAccoladePage.loadingSopheonElement();
        }

        //Investment Decision
        gateAccoladePage.waitForVisibilityOfElement(gateAccoladePage.investmentDecisionButton, 10);
        gateAccoladePage.investmentDecisionButton.click();

        driver.switchTo().parentFrame();

        try {
            driver.switchTo().frame("LegacyIframe");
            gateAccoladePage.selectGateDecision("Go");
            gateAccoladePage.applyGateButton.click();
            gateAccoladePage.loadingSopheonElement();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            driver.switchTo().frame("LegacyIframe");
            gateAccoladePage.waitForVisibilityOfElement(gateAccoladePage.gateDecisionSelect, 10);
            gateAccoladePage.selectGateDecision("Go");
            gateAccoladePage.setMeetingDateField();
            gateAccoladePage.applyGateButton.click();
            gateAccoladePage.loadingSopheonElement();
        }

    }

}
