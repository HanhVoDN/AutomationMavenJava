import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DemoJavascriptDragAnDrop {
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/droppable");
        // Find the source and target elements
        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droppable"));

        // Perform drag-and-drop using JavaScript
        dragAndDropWithJavaScript(driver, sourceElement, targetElement);

    // Close the browser
    //driver.quit();
}
    private static void dragAndDropWithJavaScript(WebDriver driver, WebElement source, WebElement target) {
        //JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", source);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", target);
        ((JavascriptExecutor) driver).executeScript("arguments[0].simulateDragDrop(arguments[1]);", source, target);

    }
}
