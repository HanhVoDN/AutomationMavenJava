import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class DemoIdTooltip {
    public static void main(String[] args) {

        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang https://demoqa.com/tool-tips
        driver.get("https://demoqa.com/tool-tips");


        driver.findElement(By.xpath("//button[text()='Hover me to see']")).click();
        //github.click();
        //String actualTooltip=github.getAttribute("title");

        Boolean isDisplay=driver.findElement(By.xpath("//div[text()='You hovered over the Button']")).isDisplayed();
        //In tooltip of the element
        System.out.println("Is tooltip display? " +isDisplay);

        String title=driver.findElement(By.xpath("//div[text()='You hovered over the Button']")).getText();
        System.out.println("Actual Title of Tooltip is " +title);
        Assert.assertEquals(title,"You hovered over the Button1");


        //Tắt browser
        driver.quit();


    }
}
