package PageRendering;

import PageObjectPattern.*;
import SetUp.Scenario;
import org.testng.annotations.Test;

import java.util.UUID;

public class Test05_ApplyGeneralDataQuickGrid extends Scenario {

    @Test
    public void applyGeneralDataQuickGrid() {

        System.out.println(getClass());
        SearchPage searchAccoladePage = new SearchPage(driver);
        searchAccoladePage.waitForVisibilityOfElement(searchAccoladePage.searchField, 30);
        searchAccoladePage.findAndOpenProject(projectName);

        LeftMenuPage leftMenuAccoladePage = new LeftMenuPage(driver);
        leftMenuAccoladePage.waitForVisibilityOfElement(leftMenuAccoladePage.stagesSectionLink, 30);
        leftMenuAccoladePage.stagesSectionLink.click();

        StagesPage stagesAccoladePage = new StagesPage(driver);
        stagesAccoladePage.waitForVisibilityOfElement(stagesAccoladePage.generalDataLink, 30);
        stagesAccoladePage.generalDataLink.click();

        String uuid = UUID.randomUUID().toString();
        GeneralDataPage generalDataAccoladePage = new GeneralDataPage(driver);
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

        Page.totalTime(time1, time2);

    }
}
