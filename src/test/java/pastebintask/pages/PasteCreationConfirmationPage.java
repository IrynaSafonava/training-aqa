package pastebintask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasteCreationConfirmationPage extends AbstractPage {

    @FindBy (xpath = "//div[@class='notice -success -post-view']")
    private WebElement noteSuccess;

    @FindBy(xpath = "//a[text()='Bash']")
    private WebElement syntax;

    @FindBy(tagName = "textarea")
    private WebElement textArea;

    @FindBy(xpath = "//title[text()='how to gain dominance among developers - Pastebin.com']")
    private WebElement pageTitle;

    public PasteCreationConfirmationPage(WebDriver driver){
        super(driver);
    }

    public boolean isSuccessful(){
        new WebDriverWait(driver, 10);
        return noteSuccess.isDisplayed();
    }

    public String getSyntaxElementText(){
        return syntax.getText();
    }

    public String getPasteText(){
        return textArea.getText();
    }

    public String getPageTitle(){
       return driver.getTitle();
    }


}
