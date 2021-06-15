package googletask.tests;

import googletask.pages.GoogleCloudHomePage;
import googletask.pages.GoogleCloudPricingCalculatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class HurtMePlenty {

    private WebDriver driver;
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
    }

    @Test(description = "VM class")
    public void checkVMClass() {
        Assert.assertEquals(calculatorPage.resultOf("VM class"), "VM class: regular");
    }

    @Test(description = "Instance type")
    public void checkInstanceType() {
        Assert.assertEquals(calculatorPage.resultOf("Instance type"), "Instance type: n1-standard-8");
    }

    @Test(description = "Region")
    public void checkRegion() {
        Assert.assertEquals(calculatorPage.resultOf("Region"), "Region: Frankfurt");
    }

    @Test(description = "Total available local SSD space")
    public void checkLocalSsd() {
        Assert.assertEquals(calculatorPage
                .resultOf("Total available local SSD space"), "Total available local SSD space 2x375 GiB");
    }

    @Test(description = "Commitment term")
    public void checkCommitmentTerm() {
        Assert.assertEquals(calculatorPage.resultOf("Commitment term"), "Commitment term: 1 Year");
    }

    @Test(description = "Total Estimated Cost equals to the cost calculated manually")
    public void checkTotalEstimationCost() {
        Assert.assertEquals(calculatorPage.totalEstimatedCosts(), "1,082.77");
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
