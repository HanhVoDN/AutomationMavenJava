import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DemoNavigateForward {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Maximize chrome
        //driver.manage().window().maximize();

        //Set x,y of browser
        Point point=new Point(300,100);
        driver.manage().window().setPosition(point);


        driver.navigate().to("https://demoqa.com");
        driver.navigate().to("https://demoqa.com/elements");
        //press back on browser
        driver.navigate().back();
        //press forward on browser
        driver.navigate().forward();
        // Close the browser
        //driver.quit();
    }

}
