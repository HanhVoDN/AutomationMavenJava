import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DemoDoubleClick {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/buttons");
        WebElement doubleClickButton=driver.findElement(By.id("doubleClickBtn"));
        Actions actions=new Actions(driver);
        actions.doubleClick(doubleClickButton).build().perform();

        // Close the browser
        //driver.quit();
    }

}
