import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DemoSwitchToParentFrame {
    static WebDriver driver;
    public static <JavascriptExecutor> void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/nestedframes");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Switch to Parent frame
        driver.switchTo().frame("frame1");

        //Switch to Child frame
        WebElement iframeChild=driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        // Switch to the child frame with name 'frame1'
        driver.switchTo().frame(iframeChild);

        // To "html/body/p" and getText() in Child Frame
        WebElement frame1Content = driver.findElement(By.xpath("html/body/p"));
        System.out.println("Content inside frame1: " + frame1Content.getText());

        //Switch to parent frame
        driver.switchTo().parentFrame();

        //Or can use command
        //driver.switchTo().defaultContent();
        // Close the browser
        driver.quit();
    }

}
