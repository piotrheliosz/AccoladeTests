package PageObjectPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Piotr Heliosz TFS on 2017-05-29.
 */

public class LeftMenuPage extends Page {

    public LeftMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='navPole']//div[@data-title='Stages']")
    public WebElement stagesSectionLink;

    @FindBy(xpath = "//*[@id='navPole']//div[@data-title='Partners']")
    public WebElement partnersSectionLink;

    public void enterPartnersSection(){
        waitForVisibilityOfElement(partnersSectionLink, 60);
        partnersSectionLink.click();
        loadingSopheonElement();
    }

}
