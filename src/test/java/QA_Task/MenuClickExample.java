
package QA_Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MenuClickExample {
    public static void main(String[] args) throws InterruptedException {
    	ChromeOptions options = new ChromeOptions();

        // Set the desired language (English in this case)
        options.addArguments("--lang=en");

        // Initialize the WebDriver with the modified Chrome options
        WebDriver driver = new ChromeDriver(options);

        // Initialize the WebDriver
       // WebDriver driver = new ChromeDriver();

        // Open the website
        driver.get("https://jobins:g4vrh5vo5hqogd0dprfj@recruit.release.jobins.net/");
        
        Thread.sleep(5000);


        // Menu links in Japanese
        String[] menuLinks = {
            "ホーム", "JoBinsについて", "メンバー紹介", "働き方"
        };

        // Create an explicit wait instance
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Loop through each menu link
        for (String linkText : menuLinks) {
            try {
                // Wait for the element to be visible and then find it by link text
                WebElement menuItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));

                // Click on the menu item
                menuItem.click();
                
                

                // Print the current URL
                System.out.println("Current URL after clicking '" + linkText + "': " + driver.getCurrentUrl());

                // Go back to the previous page to click the next menu item
              //  driver.navigate().back();

            } catch (Exception e) {
                System.out.println("Error clicking menu item: " + linkText);
                e.printStackTrace();
            }
        }

        // Close the browser
        driver.quit();
    }
}
