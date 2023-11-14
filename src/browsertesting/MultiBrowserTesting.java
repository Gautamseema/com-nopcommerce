package browsertesting;
/**
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.
 * “https://demo.nopcommerce.com/login?returnUrl=
 * %2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button.
 * 15. Close the browser
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MultiBrowserTesting {
    public static void main(String[] args) {
        String baseUrl = "https://demo.nopcommerce.com/";
        // launch the Chrome browser
        WebDriver driver = new ChromeDriver();

       // Open the url into browser
        driver .get(baseUrl ) ;
       // maximise the browser
        driver.manage().window().maximize();
       // Get the title
        String title = driver.getTitle();
        System.out.println(title);
        // get current Url
        System.out.println("The current Url : " + driver.getCurrentUrl());
        // we give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Get page source
        System.out.println(driver.getPageSource() );
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=\n" +
                "%2F";
        driver .navigate() .to(loginUrl ) ;
        System.out.println("get current Url " + driver.getCurrentUrl() );

        // navigate back to homepage
        driver .navigate() .back() ;
        System.out.println("Get current Url " + driver.getCurrentUrl() );
        //Refresh the page.
        driver .navigate() .refresh() ;
        driver .navigate() .forward() ;
        System.out.println("Get current Url " + driver.getCurrentUrl() );

        //Find email field element and type the email
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField .sendKeys("prime123@gmail.com");

        // Find password Field element and type the email
        WebElement passwordField = driver.findElement(By.name("Password") );
        passwordField .sendKeys("Prime123") ;

        WebElement loginButton = driver.findElement(By.linkText("Log in") );
        loginButton .click() ;

        // close the browser
        driver .quit() ;

    }
}