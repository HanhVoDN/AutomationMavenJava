import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoDriverManageWindowSetSize {
    public static void main(String[] args) throws InterruptedException {
        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();
        // Navigate to a website
        driver.get("https://demoqa.com/");
        // Set Size for the window
        Dimension dimension=new Dimension(300,300);
        driver.manage().window().setSize(dimension);

        // Close the browser
        //driver.quit();
    }

}
