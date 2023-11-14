import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DemoKeyDown {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/text-box");

        // Identify the text box element
        WebElement textBox = driver.findElement(By.id("userName"));

        // Create Actions class instance
        Actions builder = new Actions(driver);

        // Simulate pressing the Shift key and entering text into the text box. Uppercase
        builder.keyDown(Keys.SHIFT)
                .sendKeys(textBox, "demoqa")
                .keyUp(Keys.SHIFT)
                .build()
                .perform();


        // Close the browser
        //driver.quit();
    }

}
