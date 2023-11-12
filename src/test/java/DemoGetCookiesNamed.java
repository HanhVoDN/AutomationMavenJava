import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class DemoGetCookiesNamed {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Get all cookies
        Set <Cookie> cookieList =driver.manage().getCookies();
        for (Cookie cookie : cookieList) {
            System.out.println("Cookie Name: " + cookie.getName());
            System.out.println("Cookie Value: " + cookie.getValue());
            System.out.println("Cookie Domain: " + cookie.getDomain());
            System.out.println("Cookie Path: " + cookie.getPath());
            System.out.println("Cookie Expiry: " + cookie.getExpiry());
            System.out.println("Is Cookie Secure: " + cookie.isSecure());
            System.out.println("Is Cookie HttpOnly: " + cookie.isHttpOnly());
            System.out.println("------------------------------------------------");
        }
        //get details of a Cookie with name
        Cookie cookieName=driver.manage().getCookieNamed("_gid");
        System.out.println("Cookie details of _gid " +cookieName);


        // Close the browser
        driver.quit();
    }

}
