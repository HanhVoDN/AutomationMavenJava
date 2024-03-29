import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoGetElementHashCode {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Find an element on the page using its CSS selector (or any other locator)
        WebElement element = driver.findElement(By.xpath("//h5[text()='Forms']"));

        // Use the hashCode() method to get the unique identifier of the element
        int elementHashCode = element.hashCode();

        // Print the retrieved hash code
        System.out.println("Element's Hash Code: " + elementHashCode);

        // Close the browser
        driver.quit();
    }

}
