package PageObjectPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StagesPage extends Page {

    public StagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//table//div[contains(text(), 'General Data') or contains(text(),'General data')]")
    public WebElement generalDataLink;

    public int getActualGate() {
        return Integer.parseInt(driver.findElement(By.xpath("//*[@id='projectTimeline']//*[@data-timelinetype]")).getAttribute("data-currentphaseid"));
    }
}
