import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoIdXpathCssSelector {
    public static void main(String[] args) {

        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang https://demoqa.com/text-box
        driver.get("https://demoqa.com/automation-practice-form");

//        //1.Input information in Full Name by xpath
//        driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("Vincent");


//        //1.Input information in Full Name by cssSelector
//        driver.findElement(By.cssSelector("input[placeholder='Full Name']")).sendKeys("Vincent");

//        //1.Input information in Full Name by id
//        driver.findElement(By.id("userName")).sendKeys("Vincent");

        //1.use contains
        driver.findElement(By.xpath("//div[@class=\"subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3\"]']")).sendKeys("Chemistry");



//        //2.Input information in Email by name
//        driver.findElement(By.id("userEmail")).sendKeys("email@qa.team");


//        //3.Input information in Current Address  by class name
//        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("144 Ong Ich Khiem");
        //Click Home link
        //driver.findElement(By.linkText("Home")).click();

        driver.findElement(By.partialLinkText("me")).click();

        //Tắt browser
        //driver.quit();


    }
}
