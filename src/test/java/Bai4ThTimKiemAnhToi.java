import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Bai4ThTimKiemAnhToi {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        //
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //Login the website
        String DYNAMIC_INPUT_VALUE_FORM = "//input[@placeholder='%s']";
        String userNameXpath = String.format(DYNAMIC_INPUT_VALUE_FORM,"Username");
        driver.findElement(By.xpath(userNameXpath)).sendKeys("Admin");
        String userPassword = String.format(DYNAMIC_INPUT_VALUE_FORM,"Password");
        driver.findElement(By.xpath(userPassword)).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='My Info']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Personal Details']")).click();

        //Employee Full Name
        String firstNameXpath = String.format(DYNAMIC_INPUT_VALUE_FORM,"First Name");
        WebElement inputFirstName = driver.findElement(By.xpath(firstNameXpath));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(inputFirstName));

        //Because loi Other element would receive the click: <div class="oxd-form-loader" data-v-d5bfe35b="">...</div>
        //https://stackoverflow.com/questions/25249000/selenium-other-element-would-receive-click-but-is-the-correct
        Actions action = new Actions(driver);
        action.moveToElement(inputFirstName).perform();
        action.click().perform();
        //inputFirstName.click();
        Thread.sleep(2000);
        inputFirstName.sendKeys(Keys.CONTROL, "a",Keys.DELETE);
        //inputFirstName.sendKeys(Keys.DELETE);
        inputFirstName.sendKeys("Hanh");

        //Nationality
        WebElement nationality=driver.findElement(By.xpath("//div[@class='oxd-select-wrapper']"));
        nationality.click();

        //Cach 1
        //Send character to search
        //nationality.sendKeys("a");
        //Press Enter to select
        //nationality.sendKeys(Keys.ENTER);

        //Cach 2 https://bichhanh-evizi.tinytake.com/msc/ODg4NDQyOF8yMjMzNzEwOQ
        //String OPTION = "//div[@role='option' and .='%s']";
        //or
        Thread.sleep(2000);
        String OPTION = "////span[text()='%s']]";
        String optionXPath = String.format(OPTION, "American");
        WebElement optionElement = driver.findElement(By.xpath(optionXPath));
        optionElement.click();

    }
}
