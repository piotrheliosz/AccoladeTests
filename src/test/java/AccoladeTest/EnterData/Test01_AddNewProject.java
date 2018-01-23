package AccoladeTest.EnterData;

import AccoladePage.AccoladePage;
import AccoladePage.MainAccoladePage;
import AccoladeTest.AccoladeScenario;
import org.junit.Test;

import static org.testng.Assert.assertEquals;

public class Test01_AddNewProject extends AccoladeScenario {

    @Test
    public void newProjectShouldBeAdded() {

        MainAccoladePage mainAccoladePage = new MainAccoladePage(driver);
        mainAccoladePage.openProjectDropdownAndPassTextOfChoosenElement("Add New").click();
        mainAccoladePage.completePopUpFieldsToAddNewProject();

        System.out.println("projectName: " + AccoladePage.uuidProjectName);

        assertEquals(AccoladePage.uuidProjectName, mainAccoladePage.getProjectName());

    }

}
