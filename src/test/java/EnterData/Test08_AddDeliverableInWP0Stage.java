package EnterData;

import PageObjectPattern.GeneralDataPage;
import PageObjectPattern.LeftMenuPage;
import PageObjectPattern.SearchPage;
import PageObjectPattern.StagesPage;
import SetUp.Scenario;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test08_AddDeliverableInWP0Stage extends Scenario {

    @Test
    public static void deliverablesShouldBeAdded() {

        SearchPage searchAccoladePage = new SearchPage(driver);
        searchAccoladePage.findAndOpenProject(projectName);

        LeftMenuPage leftMenuAccoladePage = new LeftMenuPage(driver);
        leftMenuAccoladePage.waitForVisibilityOfElement(leftMenuAccoladePage.stagesSectionLink, 10);
        leftMenuAccoladePage.loadingSopheonElement();
        System.out.println("projectNameTitle: " + leftMenuAccoladePage.getProjectNameTitle());
        leftMenuAccoladePage.stagesSectionLink.click();

        StagesPage stagesAccoladePage = new StagesPage(driver);
        stagesAccoladePage.waitForVisibilityOfElement(stagesAccoladePage.generalDataLink, 30);
        stagesAccoladePage.loadingSopheonElement();
        stagesAccoladePage.generalDataLink.click();

        GeneralDataPage generalDataAccoladePage = new GeneralDataPage(driver);
        generalDataAccoladePage.loadingSopheonElement();
        generalDataAccoladePage.waitForVisibilityOfElement(generalDataAccoladePage.newProductsTable, 20); //TODO wrong name of element
        generalDataAccoladePage.setProjectTitle("project title test");

        do {
            System.out.println("Number of Deliverables on a grid: " + generalDataAccoladePage.numberOfTableRows(13));
            generalDataAccoladePage.addDeliverableInWp0Stage(13);
        } while (Integer.parseInt(generalDataAccoladePage.numberOfTableRows(13)) < 20);

        generalDataAccoladePage.applyGeneralData.click();
        generalDataAccoladePage.waitForVisibilityOfElement(generalDataAccoladePage.deliverablesTable, 20);

        assertEquals("20", generalDataAccoladePage.numberOfTableRows(13));

        generalDataAccoladePage.closePopupButton.click();

    }

}
