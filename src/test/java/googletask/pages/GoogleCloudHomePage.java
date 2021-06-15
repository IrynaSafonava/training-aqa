package googletask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudHomePage extends AbstractPage {

    private static final String HOME_PAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//*[@name='q']")
    private WebElement searchField;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudHomePage openHomePage(){
        driver.get(HOME_PAGE_URL);
        new WebDriverWait(driver, 5);
        return this;
    }

    public GoogleCloudPricingCalculatorPage searchRequiredOption(String option) {
        searchField.click();
        searchField.sendKeys(option);
        WebElement searchResult = driver.findElement(By.xpath(String.format("//span[contains(.,'%s')]", option)));
        searchResult.click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}
