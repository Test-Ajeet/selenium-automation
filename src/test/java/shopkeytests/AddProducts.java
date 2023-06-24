package shopkeytests;
import java.awt.Dimension;
import java.awt.List;
//package <set your test package>;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


/*This is test case for login 
Written by Ajeet k Singh on 15 December 2022*/

public class AddProducts {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Add Simple product with name and price only";
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
    @Test
    public void AddSimpleProduct() {
    	driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/getStartedBtnLogin")).click();
        driver.findElement(By.className("android.widget.LinearLayout")).click();
       // driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/countryCodeTV")).click();
        ///handling drop-downs
       // List items = (List) driver.findElements(By.id("com.bitnudge.ime.shopkey.shopkey:id/countryCodeDropDownIV"));
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
        driver.findElement(By.className("android.widget.TextView")).click();
        driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey:id/phoneNumberTfEditText")).sendKeys("8182067816");
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
        
        /* Adding simple product without image with Name and Price of  product only */
    	//Going to product page
    	driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/btnProduct")).click();
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/fabAddProductSelector")).click();
    	driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/addProductZeroStateLl")).click();
    	//Adding image of product
    	driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/cardPhoto")).click();
    	driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
    	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
    	driver.findElement(By.id("com.gallery20:id/iv_picture")).click();
    	//Adding name of the product
    	driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/productNameEditText")).sendKeys("Men’s Jacket Korean-style Versatile Bomber Denim Jacket");
    	//Adding price of the product
    	driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/productPriceEditText")).sendKeys("2600");
    	//Publishing the products
    	driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/bottomPublishLl")).click();
    	driver.findElement(By.id("android:id/button1")).click();
        WebElement result1= (WebElement) driver.findElement(By.id("com.bitnudge.ime.shopkey.shopkey.shopkey:id/successFailureTitleTv"));
        Assert.assertEquals(result1.getText(), "Congratulations !");
    	System.out.println("Congratulations ! Product Added!!!");
    }
    
	

    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }
}