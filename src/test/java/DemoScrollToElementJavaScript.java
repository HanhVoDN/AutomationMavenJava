import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DemoScrollToElementJavaScript {
    static WebDriver driver;
    public static <JavascriptExecutor> void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/scroll");

        // Identify the element to which you want to scroll
        WebElement elementToScroll = driver.findElement(By.id("to-element"));

        // Scroll to the element using JavaScriptExecutor
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);

        // Other actions with the scrolled-to element (e.g., click, interact, etc.)
        elementToScroll.click();


        // Close the browser
        //driver.quit();
    }

}
