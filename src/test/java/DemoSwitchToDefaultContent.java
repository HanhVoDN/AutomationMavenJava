import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class DemoSwitchToDefaultContent {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        // Navigate to demoqa.com
        driver.get("https://demoqa.com/nestedframes");

        // Switch to the frame with id="frame1"
        driver.switchTo().frame("frame1");

        // Find and interact with elements inside the frame
        WebElement frame1Text = driver.findElement(By.tagName("p"));
        System.out.println("Text inside frame1: " + frame1Text.getText());

        // Switch back to the default content
        driver.switchTo().defaultContent();

        // Find and interact with elements outside the frame
        WebElement mainPageText = driver.findElement(By.tagName("h1"));
        System.out.println("Text on the main page: " + mainPageText.getText());
        // Close the browser
        //driver.quit();
    }

}
