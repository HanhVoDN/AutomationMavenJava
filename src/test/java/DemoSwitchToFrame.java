import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class DemoSwitchToFrame {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Mở trang https://demoqa.com/frames
        driver.get("https://demoqa.com/frames");
        WebElement iFrame1=driver.findElement(By.xpath("//iframe[@id='frame1']"));
        //Focus to iFrame
        driver.switchTo().frame(iFrame1);

        //Interact with element on iFrame
        //Get Text "This is a sample page" on the iFrame
        String sampleHeadingID = "sampleHeading";
        WebElement sampleHeading = driver.findElement(By.id(sampleHeadingID));
        String actHeadingText = sampleHeading.getText();
        System.out.println("Current text: " + actHeadingText);

        //After iteract on iFrame, back to page contents
        driver.switchTo().defaultContent();
        // Close the browser
        //driver.quit();
    }

}
