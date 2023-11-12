import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DemoDriverManageWindowFullscreen {
    public static void main(String[] args) throws InterruptedException {
        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();
        // Navigate to a website
        driver.get("https://demoqa.com/");
        // Maximize the browser window to full screen
        driver.manage().window().fullscreen();


        // Close the browser
        //driver.quit();
    }

}
