import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DemoDeselectByVisibleText {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("cars"));

        // Create a Select object
        Select select = new Select(dropdownElement);

        // Select an option by its index (e.g., index 2, which is the third option)
        select.selectByIndex(0);
        Thread.sleep(3000);
        select.deselectByVisibleText("Volvo");
        // Close the browser
        //driver.quit();
    }

}
