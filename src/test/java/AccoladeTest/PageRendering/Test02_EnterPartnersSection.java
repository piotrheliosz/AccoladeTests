package AccoladeTest.PageRendering;

import AccoladePage.AccoladePage;
import AccoladePage.LeftMenuAccoladePage;
import AccoladePage.PartnersAccoladePage;
import AccoladePage.SearchAccoladePage;
import AccoladeTest.AccoladeScenario;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class Test02_EnterPartnersSection extends AccoladeScenario {

    @Test
    public void enterPartnersSection() {

        SearchAccoladePage searchAccoladePage = new SearchAccoladePage(driver);
        searchAccoladePage.waitForVisibilityOfElement(searchAccoladePage.searchField, 30);
        searchAccoladePage.findAndOpenProject(projectName);

        LeftMenuAccoladePage leftMenuAccoladePage = new LeftMenuAccoladePage(driver);
        leftMenuAccoladePage.waitForVisibilityOfElement(leftMenuAccoladePage.partnersSectionLink, 30);

        System.out.println("Click on partners section\n<<Start counting>>");
        double time1 = System.nanoTime();

        leftMenuAccoladePage.partnersSectionLink.click();

        PartnersAccoladePage partnersAccoladePage = new PartnersAccoladePage(driver);

        assertTrue(partnersAccoladePage.engagementPartnersTableIsDisplayed());
        assertTrue(partnersAccoladePage.proposedPartnersIsDisplayed());
        assertTrue(partnersAccoladePage.descriptionOfTheProjectTableIsDisplayed());

        double time2 = System.nanoTime();
        System.out.println("<<Finish counting>>\nPartner section is loaded in: " + (time2 - time1) / 1000000000 + " sec.");

        AccoladePage.totalTime(time1, time2);

    }
}
