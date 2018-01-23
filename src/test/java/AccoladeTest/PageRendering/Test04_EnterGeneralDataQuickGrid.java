package AccoladeTest.PageRendering;

import AccoladePage.*;
import AccoladeTest.AccoladeScenario;
import org.testng.annotations.Test;
import org.openqa.selenium.UnhandledAlertException;

import static org.junit.Assert.assertTrue;


public class Test04_EnterGeneralDataQuickGrid extends AccoladeScenario {

    @Test
    public void enterGeneralDataQuickGrid() {

        SearchAccoladePage searchAccoladePage = new SearchAccoladePage(driver);
        searchAccoladePage.waitForVisibilityOfElement(searchAccoladePage.searchField, 30);
        searchAccoladePage.findAndOpenProject(projectName);

        LeftMenuAccoladePage leftMenuAccoladePage = new LeftMenuAccoladePage(driver);
        leftMenuAccoladePage.waitForVisibilityOfElement(leftMenuAccoladePage.stagesSectionLink, 10);
        leftMenuAccoladePage.stagesSectionLink.click();

        StagesAccoladePage stagesAccoladePage = new StagesAccoladePage(driver);
        stagesAccoladePage.waitForVisibilityOfElement(stagesAccoladePage.generalDataLink, 30);

        System.out.println("Click General data link\n<<Start counting>>");
        double time1 = System.nanoTime();

        stagesAccoladePage.generalDataLink.click();

        GeneralDataAccoladePage generalDataAccoladePage = new GeneralDataAccoladePage(driver);

        assertTrue(generalDataAccoladePage.projectDetailsTableIsDisplayed());
        assertTrue(generalDataAccoladePage.engagementPartnersTableIsDisplayed());

        double time2 = System.nanoTime();
        System.out.println("<<Finish counting>>\nGeneral data is open in: " + (time2 - time1) / 1000000000 + " sec.");

        try {
            generalDataAccoladePage.closePopupButton.click();
        } catch (UnhandledAlertException ignore) {
            driver.switchTo().alert().accept();
            generalDataAccoladePage.closePopupButton.click();
        }

        AccoladePage.totalTime(time1, time2);
    }
}
