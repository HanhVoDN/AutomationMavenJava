import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DemoJavascriptGetHeightWightOfWeb {
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/droppable");

        // Refresh the page using JavaScript
        getHeightWidthPage();

        // Close the browser
        // driver.quit();
}
    private static void getHeightWidthPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String height=js.executeScript("return window.innerHeight;").toString();
        String width=js.executeScript("return window.innerWidth;").toString();

        System.out.println("Height: "+height);
        System.out.println("Height: "+width);
    }
}
