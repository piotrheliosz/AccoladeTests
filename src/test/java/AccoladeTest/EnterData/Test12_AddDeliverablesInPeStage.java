package AccoladeTest.EnterData;

import AccoladePage.GeneralDataAccoladePage;
import AccoladePage.LeftMenuAccoladePage;
import AccoladePage.SearchAccoladePage;
import AccoladePage.StagesAccoladePage;
import AccoladeTest.AccoladeScenario;
import org.junit.Test;

import static org.testng.Assert.assertEquals;

public class Test12_AddDeliverablesInPeStage extends AccoladeScenario {

    @Test
    public void deliverablesShouldBeAdded() {

        SearchAccoladePage searchAccoladePage = new SearchAccoladePage(driver);
        searchAccoladePage.findAndOpenProject(projectName);

        LeftMenuAccoladePage leftMenuAccoladePage = new LeftMenuAccoladePage(driver);
        leftMenuAccoladePage.waitForVisibilityOfElement(leftMenuAccoladePage.stagesSectionLink, 10);
        leftMenuAccoladePage.loadingSopheonElement();
        System.out.println("projectName: " + leftMenuAccoladePage.getProjectName());
        leftMenuAccoladePage.stagesSectionLink.click();

        StagesAccoladePage stagesAccoladePage = new StagesAccoladePage(driver);
        stagesAccoladePage.waitForVisibilityOfElement(stagesAccoladePage.generalDataLink, 30);
        stagesAccoladePage.loadingSopheonElement();
        stagesAccoladePage.generalDataLink.click();

        GeneralDataAccoladePage generalDataAccoladePage = new GeneralDataAccoladePage(driver);
        generalDataAccoladePage.loadingSopheonElement();
        generalDataAccoladePage.waitForVisibilityOfElement(generalDataAccoladePage.newProductsTable, 20); //TODO wrong name of element
        generalDataAccoladePage.setProjectTitle("project title test");

        do {
            generalDataAccoladePage.addDeliverableInPeStage(13);
            System.out.println(generalDataAccoladePage.numberOfTableRows(13));
        } while (Integer.parseInt(generalDataAccoladePage.numberOfTableRows(13)) < 30);

        generalDataAccoladePage.applyGeneralData.click();
        generalDataAccoladePage.loadingSopheonElement();
        generalDataAccoladePage.waitForVisibilityOfElement(generalDataAccoladePage.deliverablesTable, 20);

        assertEquals("30", generalDataAccoladePage.numberOfTableRows(13));

    }

}
