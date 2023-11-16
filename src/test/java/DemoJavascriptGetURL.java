import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DemoJavascriptGetURL {
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/text-box");
        getPageURL();

    // Close the browser
    driver.quit();
}
    private static void getPageURL() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String url= jsExecutor.executeScript("return document.URL;").toString();
        System.out.println("URL of page is "+url);
    }

}
