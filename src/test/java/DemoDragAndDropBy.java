import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DemoDragAndDropBy {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/dragabble");


        // Identify the elements to perform DragAndDrop operation
        WebElement draggableElement = driver.findElement(By.id("dragBox"));


        // Create Actions class instance
        Actions builder = new Actions(driver);

        // Perform drag and drop by a specified x and y offset
        builder.dragAndDropBy(draggableElement,200,200).build().perform();

        // Close the browser
        //driver.quit();
    }

}
