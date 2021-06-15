package pastebintask.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pastebintask.pages.NewPasteCreationPage;
import pastebintask.pages.PasteCreationConfirmationPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BringItOnTaskTest {

    private WebDriver driver;

    private PasteCreationConfirmationPage page;

    private static final String SYNTAX_HIGHLIGHTING_OPTION = "Bash";
    private static final String TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private static final String PASTE_EXPIRATION = "10 Minutes";
    private static final String PASTE_TITLE = "how to gain dominance among developers";
    private static final String PAGE_TITLE = String.format("%s - Pastebin.com", PASTE_TITLE);

    @BeforeClass(description = "Launching a browser and creating a new paste")
    public void createNewPast() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        page = new NewPasteCreationPage(driver)
                .openHomePage()
                .selectSyntaxHighlighting(SYNTAX_HIGHLIGHTING_OPTION)
                .choosePasteExpiration(PASTE_EXPIRATION)
                .fillInTextArea(TEXT)
                .fillInTitle(PASTE_TITLE)
                .clickSubmit();
    }

    @Test(description = "Check Syntax Highlighting")
    public void checkSyntaxHighlighting() {
        String syntax = page.getSyntaxElementText();
        Assert.assertEquals(syntax, SYNTAX_HIGHLIGHTING_OPTION);
    }

    @Test(description = "Check Paste Text")
    public void checkPasteText() {
        String text = page.getPasteText();
        Assert.assertEquals(text, TEXT);
    }

    @Test(description = "Check Page Title")
    public void checkPageTitle() throws InterruptedException {
        Thread.sleep(2000);
        String title = driver.getTitle();
        Assert.assertEquals(title, PAGE_TITLE);
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
