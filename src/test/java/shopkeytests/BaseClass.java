package shopkeytests;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Shopkey";
    protected AndroidDriver driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();
    
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("Shopkey", testName);
        dc.setCapability(MobileCapabilityType.UDID, "084113125P054404");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.bitnudge.ime.shopkey.shopkey");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.bitnudge.ime.parent.view.activities.SplashActivity");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}