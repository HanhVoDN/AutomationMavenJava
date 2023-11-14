import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class DemoPressCtrlShiftR {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/droppable");

        // Identify the elements to perform clickAndHold operation
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        // Create Actions class instance
        Actions builder = new Actions(driver);

        // Click and hold the source element, then move to the target and release
        builder.dragAndDrop(source,target).build().perform();


        Robot robot = new Robot();
        // press key Ctrl+Shift+r to reload the page
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.delay(100);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.delay(100);
        robot.keyPress(KeyEvent.VK_R);
        // Refresh key Ctrl+Shift+r
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_R);
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Close the browser
        //driver.quit();
    }

}
