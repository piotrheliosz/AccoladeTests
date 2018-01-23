package EoiPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Piotr Heliosz TFS on 2017-07-21.
 */

public class EoiPage {

    protected static WebDriver driver;

    EoiPage(WebDriver driver) {

        EoiPage.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
