package EnterData;


import PageObjectPattern.GeneralDataPage;
import PageObjectPattern.LeftMenuPage;
import PageObjectPattern.SearchPage;
import PageObjectPattern.StagesPage;
import SetUp.Scenario;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test04_AddDeliverable extends Scenario {

    @Test
    public static void deliverablesShouldBeAdded() {

        SearchPage searchAccoladePage = new SearchPage(driver);
        searchAccoladePage.findAndOpenProject(projectName);

        LeftMenuPage leftMenuAccoladePage = new LeftMenuPage(driver);
        leftMenuAccoladePage.waitForVisibilityOfElement(leftMenuAccoladePage.stagesSectionLink, 10);
        System.out.println("projectNameTitle: " + leftMenuAccoladePage.getProjectNameTitle());
        leftMenuAccoladePage.stagesSectionLink.click();

        StagesPage stagesAccoladePage = new StagesPage(driver);
        stagesAccoladePage.waitForVisibilityOfElement(stagesAccoladePage.generalDataLink, 30);
        stagesAccoladePage.generalDataLink.click();

        GeneralDataPage generalDataAccoladePage = new GeneralDataPage(driver);
        generalDataAccoladePage.loadingSopheonElement();
        generalDataAccoladePage.waitForVisibilityOfElement(generalDataAccoladePage.deliverablesTable, 20);
        generalDataAccoladePage.setProjectTitle("project title test");
        generalDataAccoladePage.quickGridExpander(9).click();

        do {
            System.out.println("Number of Deliverables on a grid: " + generalDataAccoladePage.numberOfTableRows(9));
            generalDataAccoladePage.addDeliverableProposalSubmitionStage(9);
        } while (Integer.parseInt(generalDataAccoladePage.numberOfTableRows(9)) < 10);

        generalDataAccoladePage.applyGeneralData.click();
        generalDataAccoladePage.waitForVisibilityOfElement(generalDataAccoladePage.deliverablesTable, 20);

        assertEquals("10", generalDataAccoladePage.numberOfTableRows(9));

        generalDataAccoladePage.closePopupButton.click();

    }

}
