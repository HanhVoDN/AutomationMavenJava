import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DemoJavascriptHandleCheckbox {
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/automation-practice-form");
        WebElement checkBoxLocator=driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']"));
        checkCheckboxWithJavaScript(driver,checkBoxLocator);

    // Close the browser
    //driver.quit();
}
    private static void checkCheckboxWithJavaScript(WebDriver driver, WebElement checkbox) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].checked = true;", checkbox);
    }
    private static void uncheckCheckboxWithJavaScript(WebDriver driver, WebElement checkbox) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].checked = false;", checkbox);
    }

}
