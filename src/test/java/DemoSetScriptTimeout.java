import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

//1. The setScriptTimeout method is used to set the script timeout for the WebDriver instance.
//2. The executeAsyncScriptDemo method demonstrates the execution of an asynchronous script using executeAsyncScript.
//3. The script waits for 5 seconds before clicking on an element with the ID "elementId."
public class DemoSetScriptTimeout {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Set the script timeout to 10 seconds
        setScriptTimeout(driver, 10);
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com");

        // Perform some asynchronous JavaScript operation
        executeAsyncScriptDemo(driver);

        // Close the browser
        //driver.quit();
    }
    private static void setScriptTimeout(WebDriver driver, int timeoutInSeconds) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.setTimeout(arguments[arguments.length - 1], " + timeoutInSeconds * 1000 + ");");
        driver.manage().timeouts().setScriptTimeout(timeoutInSeconds, TimeUnit.SECONDS);
    }

    private static void executeAsyncScriptDemo(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // Example of an asynchronous script
        jsExecutor.executeAsyncScript(
                "var callback = arguments[arguments.length - 1];" +
                        "setTimeout(function() {" +
                        "   document.getElementById('elementId').click();" +
                        "   callback();" +
                        "}, 5000);");
    }



}
