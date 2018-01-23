package AccoladeTest.EnterData;

import AccoladePage.GeneralDataAccoladePage;
import AccoladePage.LeftMenuAccoladePage;
import AccoladePage.SearchAccoladePage;
import AccoladePage.StagesAccoladePage;
import AccoladeTest.AccoladeScenario;
import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Test11_AddTaskaInPeStage extends AccoladeScenario {


    @Test
    public void tasksShouldBeAdded() {

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
            generalDataAccoladePage.addTaskInPeStage(12);
            System.out.println("generalDataAccoladePage.numberOfTableRows(12): " + generalDataAccoladePage.numberOfTableRows(12));
        } while (Integer.parseInt(generalDataAccoladePage.numberOfTableRows(12)) < 30);

        generalDataAccoladePage.applyGeneralData.click();
        generalDataAccoladePage.waitForVisibilityOfElement(generalDataAccoladePage.newProductsTable, 20); //TODO wrong name of element

        assertEquals("30", generalDataAccoladePage.numberOfTableRows(12));

    }
}