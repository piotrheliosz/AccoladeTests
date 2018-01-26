package EnterData;

import PageObjectPattern.GatePage;
import PageObjectPattern.LeftMenuPage;
import PageObjectPattern.SearchPage;
import SetUp.Scenario;
import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;


public class Test09_PassWp0Gate extends Scenario {

    @Test
    public static void wp0GateShouldBePassed() {

        SearchPage searchAccoladePage = new SearchPage(driver);
        searchAccoladePage.findAndOpenProject(projectName);

        LeftMenuPage leftMenuAccoladePage = new LeftMenuPage(driver);
        leftMenuAccoladePage.waitForVisibilityOfElement(leftMenuAccoladePage.stagesSectionLink, 10);
        leftMenuAccoladePage.loadingSopheonElement();
        System.out.println("projectNameTitle: " + leftMenuAccoladePage.getProjectNameTitle());


        //WP0 gate
        GatePage gateAccoladePage = new GatePage(driver);
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
