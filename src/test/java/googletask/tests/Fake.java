package googletask.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Fake {
    WebDriver driver = new ChromeDriver();
    private String URL = "https://10minutemail.net/";

    @Test
    public void openPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
    }
}
