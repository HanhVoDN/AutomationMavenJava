import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class DemoJavascriptGetTitlePage {
    static WebDriver driver;
    public static <JavascriptExecutor> void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/text-box");
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        Object result =js.executeScript("return document.title;");
        System.out.println("Title of page is " +result);


        // Close the browser
        driver.quit();
    }

}
