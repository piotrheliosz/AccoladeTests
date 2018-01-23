package AccoladeTest.PageRendering;

import AccoladePage.AccoladePage;
import AccoladePage.SearchAccoladePage;
import AccoladeTest.AccoladeScenario;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class Test01_EnterProject extends AccoladeScenario {

    @Test
    public void enterProject() {

        SearchAccoladePage searchAccoladePage = new SearchAccoladePage(driver);
        searchAccoladePage.waitForVisibilityOfElement(searchAccoladePage.searchField, 30);

        System.out.println("Searching for " + projectName + " project\n<<Start counting>>");
        double time1 = System.nanoTime();
        searchAccoladePage.findAndOpenProject(projectName);

        assertEquals(projectName, searchAccoladePage.getProjectName());

        double time2 = System.nanoTime();
        System.out.println("<<Finish counting>>\nProject is found open in: " + (time2 - time1) / 1000000000 + " sec.");

        AccoladePage.totalTime(time1, time2);
    }
}
