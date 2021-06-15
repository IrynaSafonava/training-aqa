package pastebintask.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pastebintask.pages.NewPasteCreationPage;

public class TestICanWin {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSutUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "ICanWin Task")
    public void createNewPaste(){
        boolean isSuccessful = new NewPasteCreationPage(driver)
                .openHomePage()
                .selectSyntaxHighlighting("Bash")
                .fillInTextArea("Some text")
                .choosePasteExpiration("10 Minutes")
                .fillInTitle("Any Title")
                .clickSubmit()
                .isSuccessful();

        Assert.assertTrue(isSuccessful, "Paste Creation Is Not Successful");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}
