import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

// Open web https://demoqa.com/text-box
//Sendkey in "Full Name" field=> active field
//GetTagName and Attribute of active element
public class DemoSwitchToActiveElement {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Mở trang https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/text-box");
        // Find an input field and type something into it
        WebElement nameField = driver.findElement(By.id("userName"));
        nameField.sendKeys("Hanh Vo");

        // Switch to the currently active element (in this case, the input field)
        WebElement activeElement = driver.switchTo().activeElement();

        // Perform actions on the active element, if needed
        System.out.println("Tag name of the active element: " + activeElement.getTagName());
        System.out.println("Value of the active element: " + activeElement.getAttribute("value"));

        // Close the browser
        driver.quit();
    }

}
