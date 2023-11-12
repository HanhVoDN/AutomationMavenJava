import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoIsSelected {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Find an element on the page using its CSS selector (or any other locator)
        WebElement element = driver.findElement(By.xpath("//input[@id='yesRadio']"));

        // Use the isSelected() method to check if the element is enabled
        boolean isElementSelected = element.isSelected();

        // Print the result
        if (isElementSelected) {
            System.out.println("Element is selected.");
        } else {
            System.out.println("Element is unselected.");
        }

        // Close the browser
        driver.quit();
    }

}
