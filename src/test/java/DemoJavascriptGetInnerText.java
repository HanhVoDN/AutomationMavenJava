import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DemoJavascriptGetInnerText {
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/droppable");

        // Refresh the page using JavaScript
        getInnerTextPage();

        // Close the browser
        // driver.quit();
}
    private static void getInnerTextPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String innerText = js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(innerText);

    }
}
