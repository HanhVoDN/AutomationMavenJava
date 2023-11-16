import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DemoJavascriptClickElementCach2 {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.navigate().to("https://demoqa.com/text-box");
        // sendKeys text on input
        js.executeScript("document.getElementById('userName').setAttribute('value','HanhVo');");
        js.executeScript("document.getElementById('userEmail').setAttribute('value','admin02@mailinator.com');");

        js.executeScript("document.getElementById('submit').click()");
        Thread.sleep(2000);
    // Close the browser
    driver.quit();
}


}
