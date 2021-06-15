package pastebintask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPasteCreationPage extends AbstractPage {

    private static final String NEW_PASTE_CREATION_PAGE_URL = "https://pastebin.com/";

    @FindBy(xpath = "//*[@class='textarea -form js-paste-code']")
    private WebElement textArea;

    @FindBy(id = "postform-name")
    private WebElement titleField;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement submitButton;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlightingDropDown;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpirationDropDown;

    public NewPasteCreationPage(WebDriver driver) {
        super(driver);
    }

    public NewPasteCreationPage openHomePage(){
        driver.get(NEW_PASTE_CREATION_PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        System.out.println("Page opened: " + NEW_PASTE_CREATION_PAGE_URL);
        return this;
    }

    public NewPasteCreationPage fillInTextArea(String someText) {
        textArea.sendKeys(someText);
        return this;
    }

    public NewPasteCreationPage choosePasteExpiration(String option) {
        pasteExpirationDropDown.click();
        selectRequiredOptionFromDropDown(option);
        return this;
    }

    public NewPasteCreationPage fillInTitle(String someTitle) {
        titleField.sendKeys(someTitle);
        return this;
    }

    public NewPasteCreationPage selectSyntaxHighlighting(String option) {
        syntaxHighlightingDropDown.click();
        selectRequiredOptionFromDropDown(option);
        return this;
    }

    public PasteCreationConfirmationPage clickSubmit() {
        submitButton.submit();
        return new PasteCreationConfirmationPage(driver);
    }

    private void selectRequiredOptionFromDropDown(String option){
        driver.findElement(By.xpath(String.format("//li[text()='%s']", option))).click();
    }
}
