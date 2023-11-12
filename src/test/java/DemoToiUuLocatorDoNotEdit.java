import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.*;

import java.time.Duration;

public class DemoToiUuLocatorDoNotEdit {
    public static void main(String[] args) throws InterruptedException {
        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang https://demoqa.com/automation-practice-form
        driver.get("https://demoqa.com/automation-practice-form");


        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("abc");

        //1.Handle Gender radio button
        //driver.findElement(By.xpath("//input[@name='gender' and @value='Male']/following-sibling::label")).click();

        String DYNAMIC_INPUT_NAME_VALUE_FORM = "//input[@name='%s' and @value='%s']/following-sibling::label";
        String maleXPath = String.format(DYNAMIC_INPUT_NAME_VALUE_FORM, "gender","Male");
        Boolean isSelected = driver.findElement(By.xpath(maleXPath)).isSelected();
        if (isSelected == false) {
            driver.findElement(By.xpath(maleXPath)).click();
        }

        //2.Handle DatePicker
        WebElement datePicker=driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        //Press Ctrl-A
        String s = Keys.chord(Keys.CONTROL, "a");
        datePicker.sendKeys(s);
        //Fill Date
        datePicker.sendKeys("10 Oct 1984");
        //Press Enter to exit DatePicker
        datePicker.sendKeys(Keys.ENTER);

        //3.Handle Subjects dropdown editable
        //Scroll down to the field not override by ads
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        //Handle Subjects dropdown
        WebElement dropdown=driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']"));
        dropdown.click();
        Thread.sleep(20);
        WebElement dropdown1=driver.findElement(By.id("subjectsInput"));
        dropdown1.sendKeys("Chemistry");
        dropdown1.sendKeys(Keys.ENTER);

        //4.Handle Hobbies checkbox
//        driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();

        //5.Handle Upload file-Just use when can drag-drop file
        //driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys("D:\\Codegym\\Automation\\Course_Selenium_Java\\SeleniumMaven\\src\\test\\resource\\TestDataFile\\Timo.png");
        driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys(System.getProperty("user.dir") + "\\src\\test\\resource\\TestDataFile\\Timo.png");

        //6.Handle State and City dropdown
//       WebElement dropdownState= driver.findElement(By.xpath("//div[@id=\"state\"]"));
//       dropdownState.click();
//       dropdownState.sendKeys("Uttar Pradesh");
//       dropdownState.sendKeys(Keys.ENTER);


        //Tắt browser
        //driver.quit();

    }
}
