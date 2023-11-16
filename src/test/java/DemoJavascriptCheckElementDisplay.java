import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DemoJavascriptCheckElementDisplay {
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/droppable");
        // Find the source and target elements
        WebElement sourceElement = driver.findElement(By.id("draggable"));
        //Check element display or not
        boolean isDisplayed = (boolean) ((JavascriptExecutor) driver).executeScript("return document.getElementById('draggable').style.display !== 'none';");
        System.out.println("Is displayed: " + isDisplayed);


        // Close the browser
    //driver.quit();
}

}
