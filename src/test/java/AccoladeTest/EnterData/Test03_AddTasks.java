package AccoladeTest.EnterData;

import AccoladePage.GeneralDataAccoladePage;
import AccoladePage.LeftMenuAccoladePage;
import AccoladePage.SearchAccoladePage;
import AccoladePage.StagesAccoladePage;
import AccoladeTest.AccoladeScenario;
import org.junit.Test;

import static org.testng.Assert.assertEquals;

public class Test03_AddTasks extends AccoladeScenario {

    @Test
    public void tasksShouldBeAdded() {

        SearchAccoladePage searchAccoladePage = new SearchAccoladePage(driver);
        searchAccoladePage.findAndOpenProject(projectName);

        LeftMenuAccoladePage leftMenuAccoladePage = new LeftMenuAccoladePage(driver);
        leftMenuAccoladePage.waitForVisibilityOfElement(leftMenuAccoladePage.stagesSectionLink, 10);
        System.out.println("projectName: " + leftMenuAccoladePage.getProjectName());
        leftMenuAccoladePage.stagesSectionLink.click();

        StagesAccoladePage stagesAccoladePage = new StagesAccoladePage(driver);
        stagesAccoladePage.waitForVisibilityOfElement(stagesAccoladePage.generalDataLink, 30);
        stagesAccoladePage.generalDataLink.click();

        GeneralDataAccoladePage generalDataAccoladePage = new GeneralDataAccoladePage(driver);
        generalDataAccoladePage.loadingSopheonElement();
        generalDataAccoladePage.waitForVisibilityOfElement(generalDataAccoladePage.tasksTable, 20);
        generalDataAccoladePage.setProjectTitle("project title test");
        generalDataAccoladePage.quickGridExpander(8).click();

        do {
            generalDataAccoladePage.addTaskInProposalSubmitionStage(8);
        } while (Integer.parseInt(generalDataAccoladePage.numberOfTableRows(8)) < 10);

        generalDataAccoladePage.applyGeneralData.click();
        generalDataAccoladePage.waitForVisibilityOfElement(generalDataAccoladePage.tasksTable, 20);

        assertEquals("10", generalDataAccoladePage.numberOfTableRows(8));

    }

}
