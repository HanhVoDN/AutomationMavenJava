import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DemoRelease {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/droppable");

        // Identify the element to perform a click
        WebElement element = driver.findElement(By.id("draggable"));

        // Create Actions class instance
        Actions builder = new Actions(driver);

        // Perform a click operation on the element
        builder.click(element).release().build().perform();


        // Close the browser
        //driver.quit();
    }

}
