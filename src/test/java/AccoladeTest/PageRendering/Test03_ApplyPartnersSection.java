package AccoladeTest.PageRendering;

import AccoladePage.AccoladePage;
import AccoladePage.LeftMenuAccoladePage;
import AccoladePage.PartnersAccoladePage;
import AccoladePage.SearchAccoladePage;
import AccoladeTest.AccoladeScenario;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;

public class Test03_ApplyPartnersSection extends AccoladeScenario {

    @Test
    public void applyPartnersSectionChanges() {

        SearchAccoladePage searchAccoladePage = new SearchAccoladePage(driver);
        searchAccoladePage.waitForVisibilityOfElement(searchAccoladePage.searchField, 30);
        searchAccoladePage.findAndOpenProject(projectName);

        LeftMenuAccoladePage leftMenuAccoladePage = new LeftMenuAccoladePage(driver);
        leftMenuAccoladePage.enterPartnersSection();

        PartnersAccoladePage partnersAccoladePage = new PartnersAccoladePage(driver);
        //partnersAccoladePage.addPartnerAndFillAllFields();
        partnersAccoladePage.waitUntilElementIsClickable(partnersAccoladePage.applyButton);

        System.out.println("Click apply button\n<<Start counting>>");
        double time1 = System.nanoTime();

        //TODO <<BUG>>> - trzeba 2 razy kliknąć apply, żeby zapisało zmiany na SBX2
        if (driver.getCurrentUrl().contains("kicsbx2")) {
            try {
                partnersAccoladePage.applyButton.click();
            } catch (StaleElementReferenceException e) {
                partnersAccoladePage.waitUntilElementIsClickable(partnersAccoladePage.applyButton);
                partnersAccoladePage.applyButton.click();
            } finally {
                partnersAccoladePage.loadingSopheonElement();
                partnersAccoladePage.applyButton.click();
                partnersAccoladePage.loadingSopheonElement();
                partnersAccoladePage.waitUntilElementIsClickable(partnersAccoladePage.applyButton);
            }
        } else {
            try {
                partnersAccoladePage.applyButton.click();
                partnersAccoladePage.waitUntilElementIsClickable(partnersAccoladePage.applyButton);
            } catch (WebDriverException e) {
                Actions actions = new Actions(driver);
                actions.moveToElement(partnersAccoladePage.applyButton).perform();
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].scrollIntoView(true);", partnersAccoladePage.applyButton);
                partnersAccoladePage.applyButton.click();
                partnersAccoladePage.loadingSopheonElement();
                partnersAccoladePage.waitUntilElementIsClickable(partnersAccoladePage.applyButton);
            }
        }

        double time2 = System.nanoTime();
        System.out.println("<<Finish counting>>\nApply function is done in: " + (time2 - time1) / 1000000000 + " sec.");

        AccoladePage.totalTime(time1, time2);

    }
}
