package googletask.tests;

import googletask.pages.GoogleCloudHomePage;
import googletask.pages.GoogleCloudPricingCalculatorPage;
import googletask.pages.TenMinutesFakeEmailPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Hardcore {

    private WebDriver driver;
    private String costsInEmail;
    private String resultOnSite;
    private GoogleCloudPricingCalculatorPage calculatorPage;

    @BeforeClass(alwaysRun = true)
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        calculatorPage = new GoogleCloudHomePage(driver)
                .openHomePage()
                .searchRequiredOption("Google Cloud Platform Pricing Calculator")
                .switchToCalculatorFrame()
                .fillInNumberOfInstances("4")
                .selectOperatingSystemSoftwareOption("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS")
                .selectMachineClassOption("Regular")
                .selectSeriesOption("N1")
                .selectMachineTypeOption("n1-standard-8 (vCPUs: 8, RAM: 30GB)")
                .checkAddGPUsCheckbox()
                .selectNumberOfGPUs("1")
                .selectGPUType("NVIDIA Tesla V100")
                .selectLocalSSD("2x375 GB")
                .selectDataCenterLocation("Frankfurt (europe-west3)")
                .selectCommittedUsage("1 Year")
                .clickAddToEstimateButton()
                .clickEmailEstimateButton();

        resultOnSite = calculatorPage.totalEstimatedCosts();

        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String email = new TenMinutesFakeEmailPage(driver).openFakeEmailPage().copyFakeEmail();
        driver.switchTo().window(tabs.get(0));

        calculatorPage.switchToCalculatorFrame()
                .fillInFieldWithParams("Email", email)
                .clickSendEmailButton();

        driver.switchTo().window(tabs.get(1));
        costsInEmail = new TenMinutesFakeEmailPage(driver).estimatedCostsInEmail();
    }

    @Test(description = "Compare costs sent in an email")
    public void checkCostsEqualCostsInEmail(){
        Assert.assertEquals(resultOnSite, costsInEmail);
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
