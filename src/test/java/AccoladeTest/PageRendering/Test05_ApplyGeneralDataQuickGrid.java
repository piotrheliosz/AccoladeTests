package AccoladeTest.PageRendering;

import AccoladePage.*;
import AccoladeTest.AccoladeScenario;
import org.testng.annotations.Test;

import java.util.UUID;

public class Test05_ApplyGeneralDataQuickGrid extends AccoladeScenario {

    @Test
    public void applyGeneralDataQuickGrid() {

        SearchAccoladePage searchAccoladePage = new SearchAccoladePage(driver);
        searchAccoladePage.waitForVisibilityOfElement(searchAccoladePage.searchField, 30);
        searchAccoladePage.findAndOpenProject(projectName);

        LeftMenuAccoladePage leftMenuAccoladePage = new LeftMenuAccoladePage(driver);
        leftMenuAccoladePage.waitForVisibilityOfElement(leftMenuAccoladePage.stagesSectionLink, 30);
        leftMenuAccoladePage.stagesSectionLink.click();

        StagesAccoladePage stagesAccoladePage = new StagesAccoladePage(driver);
        stagesAccoladePage.waitForVisibilityOfElement(stagesAccoladePage.generalDataLink, 30);
        stagesAccoladePage.generalDataLink.click();

        String uuid = UUID.randomUUID().toString();
        GeneralDataAccoladePage generalDataAccoladePage = new GeneralDataAccoladePage(driver);
        generalDataAccoladePage.setProjectTitle(uuid);
        generalDataAccoladePage.waitForVisibilityOfElement(generalDataAccoladePage.applyGeneralData, 30);

        System.out.println("Click apply button\n<<Start counting>>");
        double time1 = System.nanoTime();

        generalDataAccoladePage.applyGeneralData.click();
        generalDataAccoladePage.waitUntilElementIsClickable(generalDataAccoladePage.applyGeneralData);

        double time2 = System.nanoTime();
        System.out.println("<<Finish counting>>\nApply function is done in: " + (time2 - time1) / 1000000000 + " sec.");

        generalDataAccoladePage.closePopupButton.click();
        driver.switchTo().alert().accept();

        AccoladePage.totalTime(time1, time2);

    }
}
