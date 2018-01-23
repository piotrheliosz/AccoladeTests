package AccoladeTest.EnterData;

import AccoladePage.GateAccoladePage;
import AccoladePage.LeftMenuAccoladePage;
import AccoladePage.SearchAccoladePage;
import AccoladeTest.AccoladeScenario;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;


public class Test09_PassWp0Gate extends AccoladeScenario {

    @Test
    public void wp0GateShouldBePassed() {

        SearchAccoladePage searchAccoladePage = new SearchAccoladePage(driver);
        searchAccoladePage.findAndOpenProject(projectName);

        LeftMenuAccoladePage leftMenuAccoladePage = new LeftMenuAccoladePage(driver);
        leftMenuAccoladePage.waitForVisibilityOfElement(leftMenuAccoladePage.stagesSectionLink, 10);
        leftMenuAccoladePage.loadingSopheonElement();
        System.out.println("projectName: " + leftMenuAccoladePage.getProjectName());


        //WP0 gate
        GateAccoladePage gateAccoladePage = new GateAccoladePage(driver);
        gateAccoladePage.waitForVisibilityOfElement(gateAccoladePage.wp0GateButton, 10);
        gateAccoladePage.wp0GateButton.click();
        gateAccoladePage.waitForVisibilityOfElement(gateAccoladePage.insideFrame, 10);

        driver.switchTo().parentFrame();

        try {
            driver.switchTo().frame("LegacyIframe");
            gateAccoladePage.selectGateDecision("Go");
            gateAccoladePage.setMeetingDateField();
            gateAccoladePage.applyGateButton.click();
            gateAccoladePage.loadingSopheonElement();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            driver.switchTo().frame("LegacyIframe");
            gateAccoladePage.waitForVisibilityOfElement(gateAccoladePage.gateDecisionSelect, 10);
            gateAccoladePage.setMeetingDateField();
            gateAccoladePage.selectGateDecision("Go");
            gateAccoladePage.applyGateButton.click();
            gateAccoladePage.loadingSopheonElement();
        }
    }
}
