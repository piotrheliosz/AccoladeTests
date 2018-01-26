package EnterData;

import PageObjectPattern.LeftMenuPage;
import PageObjectPattern.PartnersPage;
import PageObjectPattern.SearchPage;
import SetUp.Scenario;
import org.testng.annotations.Test;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;

import static org.junit.Assert.assertTrue;

public class Test06_AddPartnersInWP0Stage extends Scenario {

    @Test
    public static void partnersShouldBeAdded() {

        SearchPage searchAccoladePage = new SearchPage(driver);
        searchAccoladePage.findAndOpenProject(projectName);

        LeftMenuPage leftMenuAccoladePage = new LeftMenuPage(driver);
        leftMenuAccoladePage.loadingSopheonElement();
        System.out.println("projectNameTitle: " + leftMenuAccoladePage.getProjectNameTitle());

        leftMenuAccoladePage.enterPartnersSection();

        PartnersPage partnersAccoladePage = new PartnersPage(driver);

        try {
            do {
                partnersAccoladePage.addPartnerAndFillAllFields();
                System.out.println("Number of Partners on a grid: " + partnersAccoladePage.numberOfTableRows(4));
            } while (!partnersAccoladePage.numberOfTableRows(4).equals("10"));
        } catch (UnhandledAlertException | ElementNotVisibleException | TimeoutException e) {
            if (e.toString().contains("UnhandledAlertException")) {
                driver.switchTo().alert().accept();
                partnersAccoladePage.addPartnerAndFillAllFields();
                System.out.println("Number of Partners on a grid: " + partnersAccoladePage.numberOfTableRows(4));
            }
        }


        try {
            partnersAccoladePage.applyButton.click();
        } catch (StaleElementReferenceException e) {
            partnersAccoladePage.waitUntilElementIsClickable(partnersAccoladePage.applyButton);
            partnersAccoladePage.applyButton.click();
        } finally {
            partnersAccoladePage.loadingSopheonElement();
            partnersAccoladePage.applyButton.click();
        }

        partnersAccoladePage.loadingSopheonElement();
        int numberOfPartnersRow = Integer.parseInt(partnersAccoladePage.numberOfTableRows(4));
        assertTrue(numberOfPartnersRow == 10);

    }

}


