package shopkeytests;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
//package <set your test package>;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


/*This is test case for Placing order 
Written by Ajeet k Singh on 18 December 2022*/

public class PlacingOrder {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Placing the Order";
    protected AndroidDriver driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();
    
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "084113125P054404");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Infinix");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.bitnudge.ime.shopkey.shopkey");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.bitnudge.ime.parent.view.activities.SplashActivity");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

	/* Loging into Shopkey app */
    @SuppressWarnings("deprecation")
	@Test
    public void PlacingOrders() throws HeadlessException, UnsupportedFlavorException, IOException {
    	driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/getStartedBtnLogin")).click();
        driver.findElement(By.className("android.widget.LinearLayout")).click();
       // driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/countryCodeTV")).click();
        ///handling drop-downs
       // List items = (List) driver.findElements(By.id("com.bitnudge.ime.shopkey.shopkey:id/countryCodeDropDownIV"));
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
        driver.findElement(By.className("android.widget.TextView")).click();
        driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/phoneNumberTfEditText")).sendKeys("8145678901");
        driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/btnNext")).click();
        driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/etPasswordEditText")).sendKeys("Test@12345");
        driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/btnNext")).click();
        driver.findElement(By.className("android.view.ViewGroup")).click();
        WebElement result= (WebElement) driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/gc_gctextview"));
        Assert.assertEquals(result.getText(), "English");
        System.out.println("Welcome to Shopkey");
        driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/gc_gctextview")).click();
        driver.findElement(By.className("android.widget.Button")).click();
        //Dashboard screen
        System.out.println("This is Shopkey Dashboard");
        
        
    	//Going to product page
        driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/btnProduct")).click();
        System.out.println("Welcome to Products Page");
        //Srolling the screen
       // driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));
        //Adding Product to cart
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.Button[@index='2']")).click();
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/btnContinue")).click();
    	driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/tvLeadName")).click();
    	//Sharing Payment Link
    	driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/btnSharePayment")).click();
    	//Copying the store url
       // driver.findElement(By.id("android:id/chooser_copy_button")).click(); //text copied to clipboard
        driver.findElement(By.xpath("//android.widget.LinearLayout[@index='9']")).click();
        //Sending payment url to a contact
        driver.findElement(By.id("com.whatsapp:id/contactpicker_row_phone_type")).click();
        //Sending url
        driver.findElement(By.id("com.whatsapp:id/send")).click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.id("com.whatsapp:id/send")).click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.view.View[@index='0']")).click();
        System.out.println("This Payment Page");
        //Scrolling the screen
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));
        //Selecting the radio button
        WebElement radio1 = driver.findElement(By.xpath("//android.widget.RadioButton[@index='0']"));
        radio1.click();
        System.out.println("Delivery option selected...");
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));
        driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@index='1']")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(150000)"));
        //Placing Order
        driver.findElement(By.xpath("//android.widget.Button[@index='6']")).click();
        System.out.println("Order Placed button clicked...");
        //Validating order placed or not
      //  WebElement result1= (WebElement) driver.findElement(By.xpath("//android.widget.TextView[@index='2']"));
       // Assert.assertEquals(result1.getText(), "Please transfer your payment to this payment code / VA number: Bank Transfer Payment");
        System.out.println("Order Placed successfully...");
   

		/*
		 * driver.activateApp("com.android.chrome"); //Chrome launch
		 * driver.get("https://www.browserling.com/tools/extract-urls");
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(6000,50)"); //test
		 * driver.activateApp("com.android.chrome"); String myText = (String)
		 * Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.
		 * stringFlavor); // extracting the text that was copied to the clipboard
		 * driver.findElement(By.id("com.android.chrome:id/search_box_text")).sendKeys(
		 * myText);//passing the extracted text to the text field
		 * driver.findElement(By.id("com.android.chrome:id/line_2")).click();
		 */
        
    }
    
	

    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }
}