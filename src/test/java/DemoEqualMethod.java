import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoEqualMethod {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Locate two elements you want to compare
        WebElement element1 = driver.findElement(By.xpath("//h5[text()='Forms']"));
        WebElement element2 = driver.findElement(By.xpath("//h5[text()='Book Store Application']"));

        // Check if the elements are equal
        boolean areEqual = element1.equals(element2);
        System.out.println("The elements ofelement1 is "+element1);
        System.out.println("The elements ofelement2 is "+element2);
        if (areEqual) {
            System.out.println("The elements are equal.");
        } else {
            System.out.println("The elements are not equal.");
        }

        driver.quit();
    }
}
