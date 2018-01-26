package PageRendering;

import PageObjectPattern.LeftMenuPage;
import PageObjectPattern.Page;
import PageObjectPattern.PartnersPage;
import PageObjectPattern.SearchPage;
import SetUp.Scenario;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class Test02_EnterPartnersSection extends Scenario {

    @Test
    public void enterPartnersSection() {

        System.out.println(getClass());
        SearchPage searchAccoladePage = new SearchPage(driver);
        searchAccoladePage.waitForVisibilityOfElement(searchAccoladePage.searchField, 30);
        searchAccoladePage.findAndOpenProject(projectName);

        LeftMenuPage leftMenuAccoladePage = new LeftMenuPage(driver);
        leftMenuAccoladePage.waitForVisibilityOfElement(leftMenuAccoladePage.partnersSectionLink, 30);

        System.out.println("Click on partners section\n<<Start counting>>");
        double time1 = System.nanoTime();

        leftMenuAccoladePage.partnersSectionLink.click();

        PartnersPage partnersAccoladePage = new PartnersPage(driver);

        assertTrue(partnersAccoladePage.engagementPartnersTableIsDisplayed());
        assertTrue(partnersAccoladePage.proposedPartnersIsDisplayed());
        assertTrue(partnersAccoladePage.descriptionOfTheProjectTableIsDisplayed());

        double time2 = System.nanoTime();
        System.out.println("<<Finish counting>>\nPartner section is loaded in: " + (time2 - time1) / 1000000000 + " sec.");

        Page.totalTime(time1, time2);

    }
}
