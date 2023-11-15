import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class DemoScrollToElement {
    static WebDriver driver;
    public static <JavascriptExecutor> void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/text-box");

        // Identify the element to which you want to scroll
        WebElement elementToScroll = driver.findElement(By.xpath("//div[text()='Interactions']"));

        // Scroll to the element
        Actions actions=new Actions(driver);
        actions.scrollToElement(elementToScroll);

        // Other actions with the scrolled-to element (e.g., click, interact, etc.)
        elementToScroll.click();


        // Close the browser
        //driver.quit();
    }

}
