package AccoladeTest.EnterData;

import AccoladePage.LeftMenuAccoladePage;
import AccoladePage.PartnersAccoladePage;
import AccoladePage.SearchAccoladePage;
import AccoladeTest.AccoladeScenario;
import org.junit.Test;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;

import static org.junit.Assert.assertTrue;

public class Test02_AddPartner extends AccoladeScenario {

    @Test
    public void partnerShouldBeAdded() {

        SearchAccoladePage searchAccoladePage = new SearchAccoladePage(driver);
        searchAccoladePage.waitForVisibilityOfElement(searchAccoladePage.mainHeader, 30);
        searchAccoladePage.findAndOpenProject(projectName);

        LeftMenuAccoladePage leftMenuAccoladePage = new LeftMenuAccoladePage(driver);
        leftMenuAccoladePage.loadingSopheonElement();
        System.out.println("projectName: " + leftMenuAccoladePage.getProjectName());
        leftMenuAccoladePage.enterPartnersSection();
        leftMenuAccoladePage.loadingSopheonElement();

        PartnersAccoladePage partnersAccoladePage = new PartnersAccoladePage(driver);

        try {
            do {
                partnersAccoladePage.addPartnerAndFillAllFields();
            } while (!partnersAccoladePage.numberOfTableRows(4).equals("7"));
        } catch (UnhandledAlertException | ElementNotVisibleException | TimeoutException e) {
            if (e.toString().contains("UnhandledAlertException")) {
                driver.switchTo().alert().accept();
                partnersAccoladePage.addPartnerAndFillAllFields();
                System.out.println("NUMBER OF PARTNERS ROWS: " + partnersAccoladePage.numberOfTableRows(4));
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
        assertTrue(numberOfPartnersRow == 7);

    }
}
