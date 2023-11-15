import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class DemoBeforeAfterClass {
    public WebDriver driver;
    @BeforeClass
    public void createDrive() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/text-box");
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        Object result =js.executeScript("return document.title;");
        System.out.println("Title of page is " +result);

    }
@AfterClass
    public void closeDriver(){
    // Close the browser
    driver.quit();
}
}
