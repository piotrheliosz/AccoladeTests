package PageRendering;

import PageObjectPattern.Page;
import PageObjectPattern.SearchPage;
import SetUp.Scenario;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class Test01_EnterProject extends Scenario {

    @Test
    public void enterProject() {

        System.out.println(getClass());
        SearchPage searchAccoladePage = new SearchPage(driver);
        searchAccoladePage.waitForVisibilityOfElement(searchAccoladePage.searchField, 30);

        System.out.println("Searching for " + projectName + " project\n<<Start counting>>");
        double time1 = System.nanoTime();
        searchAccoladePage.findAndOpenProject(projectName);

        assertEquals(projectName, searchAccoladePage.getProjectNameTitle());

        double time2 = System.nanoTime();
        System.out.println("<<Finish counting>>\nProject is found open in: " + (time2 - time1) / 1000000000 + " sec.");

        Page.totalTime(time1, time2);
    }
}
