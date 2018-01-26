package PageRendering;

import PageObjectPattern.*;
import SetUp.Scenario;
import org.testng.annotations.Test;
import org.openqa.selenium.UnhandledAlertException;

import static org.junit.Assert.assertTrue;


public class Test04_EnterGeneralDataQuickGrid extends Scenario {

    @Test
    public void enterGeneralDataQuickGrid() {

        System.out.println(getClass());
        SearchPage searchAccoladePage = new SearchPage(driver);
        searchAccoladePage.waitForVisibilityOfElement(searchAccoladePage.searchField, 30);
        searchAccoladePage.findAndOpenProject(projectName);

        LeftMenuPage leftMenuAccoladePage = new LeftMenuPage(driver);
        leftMenuAccoladePage.waitForVisibilityOfElement(leftMenuAccoladePage.stagesSectionLink, 10);
        leftMenuAccoladePage.stagesSectionLink.click();

        StagesPage stagesAccoladePage = new StagesPage(driver);
        stagesAccoladePage.waitForVisibilityOfElement(stagesAccoladePage.generalDataLink, 30);

        System.out.println("Click General data link\n<<Start counting>>");
        double time1 = System.nanoTime();

        stagesAccoladePage.generalDataLink.click();

        GeneralDataPage generalDataAccoladePage = new GeneralDataPage(driver);

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

        Page.totalTime(time1, time2);
    }
}
