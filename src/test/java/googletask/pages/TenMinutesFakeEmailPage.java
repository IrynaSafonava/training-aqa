package googletask.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinutesFakeEmailPage extends AbstractPage {

    private static final String FAKE_EMAIL_URL = "https://10minemail.com/";

    @FindBy(xpath = "//input[@id='mail']")
    private WebElement fakeEmail;

    @FindBy(xpath = "//span[@title='Google Cloud Sales ']")
    private WebElement letterFromGoogle;

    @FindBy(xpath = "//tbody//h2")
    private WebElement estimatedCost;

    public TenMinutesFakeEmailPage(WebDriver driver) {
        super(driver);
    }

    public TenMinutesFakeEmailPage openFakeEmailPage() {
        driver.get(FAKE_EMAIL_URL);
        new WebDriverWait(driver, 5);
        return this;
    }

    public String copyFakeEmail() {
        return fakeEmail.getAttribute("value");
    }

    public String estimatedCostsInEmail() {
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(letterFromGoogle));
        ((JavascriptExecutor)driver).executeScript("scroll(0,100)");
        letterFromGoogle.click();
        String result = estimatedCost.getText();
        return result.substring(result.indexOf(':') + 6);
    }
}
