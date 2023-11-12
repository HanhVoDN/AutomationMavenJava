import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//Click on "Click me" button to open alert
//Click Ok button to close alert
public class DemoAlertConfirmation {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Mở trang https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/alerts");
        // Click the "Click me" button to trigger an alert
        WebElement clickMeButton = driver.findElement(By.xpath("//button[@id=\"confirmButton\"]"));
        clickMeButton.click();

        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Get the text of the alert and print it
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
        Thread.sleep(3000);
        // Perform actions on the alert, e.g., accept or dismiss
        alert.dismiss(); // Click Cancel button on the alert
        // Close the browser
        //driver.quit();
    }

}
