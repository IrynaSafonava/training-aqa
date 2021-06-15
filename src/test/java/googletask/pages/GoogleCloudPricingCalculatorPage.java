package googletask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {

    private static final String CALCULATOR_PAGE_URL = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement calculatorFrame;

    @FindBy(xpath = "//iframe[contains(@src, '/products/calculator/index_ad8ca20a6d1799e286a0c0839aeb86ca523afe927b04501d8ba77dc59e5b8523.frame')]")
    private WebElement commonFrame;

//    @FindBy(xpath = "//div[@title='Compute Engine']/following-sibling::div[@class='md-ripple-container']")
//    private WebElement computerEngineButton;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstancesField;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    private WebElement operationSystemSoftwareDropDown;

    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement vmClassDropDown;

    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement seriesDropDown;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement machineTypeDropDown;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']/div[2]")
    private WebElement addGPUsCheckbox;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUsList;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuTypeList;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSsdList;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement dataCenterLocationList;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement committedUsageList;

    @FindBy(xpath = "(//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'])[1]")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//h2[@class='md-title']/b")
    private WebElement totalEstimatedCost;

    @FindBy(xpath = "//button[@id='email_quote']")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorPage openCalculatorPage() {
        driver.get(CALCULATOR_PAGE_URL);
        new WebDriverWait(driver, 10);
        return this;
    }

    public GoogleCloudPricingCalculatorPage switchToCalculatorFrame() {
        driver.switchTo().frame(commonFrame).switchTo().frame(calculatorFrame);
        return this;
    }

//    public GoogleCloudPricingCalculatorPage activateComputerEngineSection(){
//        new WebDriverWait(driver, 10);
//        computerEngineButton.click();
//        return this;
//    }

    public GoogleCloudPricingCalculatorPage fillInNumberOfInstances(String number) {
        numberOfInstancesField.sendKeys(number);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectOperatingSystemSoftwareOption(String option) {
        operationSystemSoftwareDropDown.click();
        selectOptionForMenuContainer(option);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectMachineClassOption(String option) {
        vmClassDropDown.click();
        selectOptionForMenuContainer(option);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectSeriesOption(String option) {
        seriesDropDown.click();
        selectOptionForMenuContainer(option);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectMachineTypeOption(String option) {
        machineTypeDropDown.click();
        selectOptionForMenuContainer(option);
        return this;
    }

    public GoogleCloudPricingCalculatorPage checkAddGPUsCheckbox() {
        addGPUsCheckbox.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectNumberOfGPUs(String number) {
        numberOfGPUsList.click();
        selectOptionForMenuContainer(number);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectGPUType(String option) {
        gpuTypeList.click();
        selectOptionForMenuContainer(option);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectLocalSSD(String option) {
        localSsdList.click();
        selectOptionForMenuContainer(option);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectDataCenterLocation(String option) {
        dataCenterLocationList.click();
        selectOptionForMenuContainer(option);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectCommittedUsage(String option) {
        committedUsageList.click();
        selectOptionForMenuContainer(option);
        return this;
    }

    public void selectOptionForMenuContainer(String option) {
        WebElement searchResult = driver
                .findElement(By.xpath(String
                        .format("//div[@class='md-select-menu-container md-active md-clickable']//md-option/div[contains(text(), '%s')]", option)));
        searchResult.click();
    }

    public GoogleCloudPricingCalculatorPage clickAddToEstimateButton() {
        addToEstimateButton.click();
        return this;
    }

    public String totalEstimatedCosts() {
        String result = totalEstimatedCost.getText();
        return result.substring(result.indexOf(':') + 6, result.indexOf('p') - 1);
    }

    public String resultOf(String option) {
        WebElement element = driver
                .findElement(By.xpath(String
                        .format("//div[@class='md-list-item-text ng-binding'][contains(text(), '%s')]", option)));
        return element.getText();
    }

    public GoogleCloudPricingCalculatorPage clickEmailEstimateButton() {
        emailEstimateButton.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage fillInFieldWithParams(String field, String value) {
        driver.findElement(By.xpath(String.format("//label[contains(text(), '%s')]/following-sibling::input", field)))
                .sendKeys(value);
        return this;
    }

    public GoogleCloudPricingCalculatorPage clickSendEmailButton() {
        sendEmailButton.click();
        return this;
    }
}


