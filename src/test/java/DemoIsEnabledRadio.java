import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoIsEnabledRadio {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Find an element on the page using its CSS selector (or any other locator)
        WebElement element = driver.findElement(By.xpath("//input[@id='noRadio']"));

        // Use the isEnabled() method to check if the element is enabled
        boolean isElementEnabled = element.isEnabled();

        // Print the result
        if (isElementEnabled) {
            System.out.println("Element is enabled.");
        } else {
            System.out.println("Element is disabled.");
        }

        // Close the browser
        driver.quit();
    }

}
