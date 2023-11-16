import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DemoJavascriptGetTextContent {
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/droppable");
        // Find the source and target elements
        WebElement sourceElement = driver.findElement(By.id("draggable"));
        //Get Text of an element
        String text = (String) ((JavascriptExecutor) driver).executeScript("return document.getElementById('draggable').textContent;");
        System.out.println("Text of element: "+text);

        // Close the browser
    //driver.quit();
}

}
