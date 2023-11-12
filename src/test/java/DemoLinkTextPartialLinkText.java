import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoLinkTextPartialLinkText {
    public static void main(String[] args) {

        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang https://demoqa.com/links
        driver.get("https://demoqa.com/links/");


//        //Click Home link
//        driver.findElement(By.linkText ("Home")).click();

        //Click Home link use partialLinkText
        driver.findElement(By.partialLinkText ("me")).click();


        //Tắt browser
        //driver.quit();


    }
}
