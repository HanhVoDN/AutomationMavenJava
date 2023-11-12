import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

// Get the handle of the main window using getWindowHandle().
// Click a button or perform an action that opens a new browser window.
//Get all window handles using getWindowHandles().
// Switch to the new window using driver.switchTo().window(windowHandle).
//Perform actions on the new window if needed.
//Close the new window.
//Switch back to the main window using driver.switchTo().window(mainWindowHandle).
//Perform actions on the main window if needed.
//Close the main window.
public class DemoGetWindowHandles {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Mở trang https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");

        // Get the handle of the main window
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Main Window Handle: " + mainWindowHandle);

        // Perform actions that open new browser windows, e.g., clicking a link
        driver.findElement(By.xpath("//button[@id=\"windowButton\"]")).click();

        // Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("All active windows "+allWindowHandles);
        // Switch to the new window
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                driver.manage().window().maximize();
                break;
            }
        }

        // Perform actions on the new window, if needed
        System.out.println("Title of the new window: " + driver.getTitle());
        //Try check text exist on the new window
        Boolean isTextDisplay=driver.findElement(By.xpath("//h1[text()=\"This is a sample page\"]")).isDisplayed();
        System.out.println("This is a sample page text displays? "+isTextDisplay);

        // Close the new window
        //driver.close();

        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);

        // Perform actions on the main window, if needed
        System.out.println("Title of the main window: " + driver.getTitle());

        // Close the browser
        //driver.quit();
    }

}
