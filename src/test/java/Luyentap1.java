import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Luyentap1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rise.fairsketch.com/dashboard/index/1");
        login(driver);
        //updateMypreferences(driver);

    }

    private static void login(WebDriver driver) throws InterruptedException {
        String email = "admin@demo.com";
        String password = "riseDemo";

        driver.findElement(By.name("email")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, email);
        driver.findElement(By.name("password")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE, password);
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        driver.findElement(By.xpath("//span[@class='user-name ml10']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),' My preferences')]")).click();

        //Handle Enable web notification dropdown
        //Click on the Enable web notification dropdown
        driver.findElement(By.xpath("//label[text()='Enable web notification']/following::span")).click();
        driver.findElement(By.xpath("")).sendKeys("No" ,Keys.ENTER);

    }
}