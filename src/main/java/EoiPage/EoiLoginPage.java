package EoiPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Piotr Heliosz TFS on 2017-07-21.
 */

public class EoiLoginPage extends EoiPage {

    public EoiLoginPage(WebDriver driver) {
        super(driver);
    }

    public void setLogin(String login) {
        driver.findElement(By.id("usernameInput")).sendKeys(login);
    }

    public void setPassword(String password) {
        driver.findElement(By.id("passwordInput")).sendKeys(password);
    }

    public void submit() {
        driver.findElement(By.id("loginButton")).click();
    }

}
