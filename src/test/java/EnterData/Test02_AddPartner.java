package EnterData;

import PageObjectPattern.LeftMenuPage;
import PageObjectPattern.PartnersPage;
import PageObjectPattern.SearchPage;
import SetUp.Scenario;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test02_AddPartner extends Scenario {

    @Test
    public static void partnerShouldBeAdded() {

        SearchPage searchAccoladePage = new SearchPage(driver);
        searchAccoladePage.waitForVisibilityOfElement(searchAccoladePage.mainHeader, 30);
        searchAccoladePage.findAndOpenProject(projectName);

        LeftMenuPage leftMenuAccoladePage = new LeftMenuPage(driver);
        leftMenuAccoladePage.loadingSopheonElement();
        System.out.println("projectNameTitle: " + leftMenuAccoladePage.getProjectNameTitle());
        leftMenuAccoladePage.enterPartnersSection();
        leftMenuAccoladePage.loadingSopheonElement();

        PartnersPage partnersAccoladePage = new PartnersPage(driver);

        try {
            do {
                System.out.println("Numbers of Partners on a grid: " + partnersAccoladePage.numberOfTableRows(4));
                partnersAccoladePage.addPartnerAndFillAllFields();
            } while (!partnersAccoladePage.numberOfTableRows(4).equals("7"));
        } catch (UnhandledAlertException | ElementNotVisibleException | TimeoutException e) {
            if (e.toString().contains("UnhandledAlertException")) {
                driver.switchTo().alert().accept();
                partnersAccoladePage.addPartnerAndFillAllFields();
                System.out.println("Numbers of Partners on a grid: " + partnersAccoladePage.numberOfTableRows(4));
            } else {
                e.printStackTrace();
            }
        }


        try {
            partnersAccoladePage.waitUntilElementIsClickable(partnersAccoladePage.applyButton);
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
        assertEquals(numberOfPartnersRow, 7);

    }
}
