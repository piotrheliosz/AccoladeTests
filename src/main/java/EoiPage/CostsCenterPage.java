package EoiPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Piotr Heliosz TFS on 2017-07-21.
 */

public class CostsCenterPage extends EoiPage {

    public CostsCenterPage(WebDriver driver) throws FileNotFoundException {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class, 'icon') and contains(@onclick, 'moveNext')]")
    private WebElement nextPageIcon;

    public PrintWriter printWriter = new PrintWriter(new File("test.csv"));

    public void clickNextPageIcon() {
        nextPageIcon.click();
    }

    public boolean nextPageIconIsDisplayed() {
        return nextPageIcon.isDisplayed();
    }

    private List<WebElement> getRowValues() {
        return driver.findElements(By.xpath("//*[contains(@id, 'row')and not (contains(@id, 'locking'))]"));
    }

    public void getGridValues() {
        int rowNumber = 0;
        for (WebElement row : getRowValues()) {

            ++rowNumber;
            String costsCenterId = driver.findElement(By.xpath("//*[contains(@id, 'row')][" + rowNumber + "]/td[1]")).getText().replaceAll("[^\\d.]", "");
            String description = driver.findElement(By.xpath("//*[contains(@id, 'row')][" + rowNumber + "]/td[2]")).getText();
            String currentEngagements = driver.findElement(By.xpath("//*[contains(@id, 'row')][" + rowNumber + "]/td[3]")).getText();

            System.out.println("costsCenterId: " + costsCenterId);
            System.out.println("description: " + description);
            System.out.println("currentEngagements: " + currentEngagements + "\n");
        }
    }

    public void writeCsvFile() throws FileNotFoundException {
        int rowNumber = 0;
        for (WebElement row : getRowValues()) {

            ++rowNumber;
            String costsCenterId = driver.findElement(By.xpath("//*[contains(@id, 'row')][" + rowNumber + "]/td[1]")).getText().replaceAll("[^\\d.]", "");
            String description = driver.findElement(By.xpath("//*[contains(@id, 'row')][" + rowNumber + "]/td[2]")).getText();
            String currentEngagements = driver.findElement(By.xpath("//*[contains(@id, 'row')][" + rowNumber + "]/td[3]")).getText();

            String stringBuilder = costsCenterId + "," + description + "," + currentEngagements + "\n";
            printWriter.write(stringBuilder);
        }
    }
}
