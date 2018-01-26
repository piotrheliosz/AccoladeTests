package EnterData;


import PageObjectPattern.MainPage;
import SetUp.Scenario;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test01_AddNewProject extends Scenario {

    @Test
    public static void newProjectShouldBeAdded() {

        MainPage mainAccoladePage = new MainPage(driver);
        mainAccoladePage.openProjectDropdownAndPassTextOfChoosenElement("Add New").click();
        mainAccoladePage.createNewProject(projectName);

        System.out.println("Project name: " + projectName);

        mainAccoladePage.loadingSopheonElement();

        assertEquals(projectName, mainAccoladePage.getProjectNameTitle());

    }

}
