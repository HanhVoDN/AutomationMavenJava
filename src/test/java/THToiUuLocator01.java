import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
//Link bai tap https://james.codegym.vn/mod/page/view.php?id=18281
public class THToiUuLocator01 {
    public static void main(String[] args) {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Mở trang https://demoqa.com/tool-tips
        driver.get("https://demoqa.com/text-box");

        String DYNAMIC_INPUTTextBox="//input[@placeholder='%s']";
        String DYNAMIC_INPUT = "//textarea[@id='%s']";

        //Handle for Full Name
        String fullName = String.format(DYNAMIC_INPUTTextBox,"Full Name");
        driver.findElement(By.xpath(fullName)).sendKeys("Hanh Vo");

        //Handle for Email
        String email = String.format(DYNAMIC_INPUTTextBox,"name@example.com");
        driver.findElement(By.xpath(email)).sendKeys("hanh.vo123@gmail.com");

        //Handle for "Current Address field
        String currentAddressXpath = String.format(DYNAMIC_INPUT,"currentAddress");
        driver.findElement(By.xpath(currentAddressXpath)).sendKeys("abc");

        //Handle for Permanent Address field
        String permanentAddressXpath = String.format(DYNAMIC_INPUT,"permanentAddress");
        System.out.println("Xpath of Permanent Address is " + permanentAddressXpath);
        driver.findElement(By.xpath(permanentAddressXpath)).sendKeys("abcde");

        //Handle button Submit
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        WebElement formElement = driver.findElement(By.id("userForm"));
    }
}
