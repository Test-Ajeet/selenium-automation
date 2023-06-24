package shopkeytests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinkTest {
    public static void main(String[] args) {
        // Set the path to chromedriver.exe
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\deltastar1\\Desktop\\chrome\\chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Launch the website
        driver.get("https://test0606store1a.goshopkey.com/");

        // Get all the links on the webpage
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Iterate through each link and check if it's a broken link
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                try {
                    // Create a URL object
                    URL linkURL = new URL(url);

                    // Open a connection to the URL
                    HttpURLConnection connection = (HttpURLConnection) linkURL.openConnection();

                    // Get the response code
                    connection.connect();
                    int responseCode = connection.getResponseCode();

                    // Print the URL and response code
                    System.out.println("URL: " + url + " - Response Code: " + responseCode);

                    // Close the connection
                    connection.disconnect();
                } catch (Exception e) {
                    // Print the URL and the error message
                    System.out.println("URL: " + url + " - Error Message: " + e.getMessage());
                }
            }
        }

        // Close the browser
        driver.quit();
    }
}
