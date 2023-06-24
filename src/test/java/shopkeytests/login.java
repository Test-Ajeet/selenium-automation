package shopkeytests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

public class login extends BaseClass {
	
	ExtentReports extent = new ExtentReports();
	
	@Test
    public void testlogin() {
        driver.findElement(By.xpath("//*[@text='Login Now']")).click();
        driver.findElement(By.xpath("//*[@text='Login Now']")).click();
       // new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='etPhone']")));
        driver.findElement(By.xpath("//*[@id='etPhone']")).sendKeys("9855511198");
      //  new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='Login Now']")).click();
        driver.findElement(By.xpath("//*[@text='Login Now']")).click();
        driver.findElement(By.xpath("//*[@id='etPhone']")).sendKeys("830");
    //    new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='etPhone']")));
        driver.findElement(By.xpath("//*[@id='etPhone']")).sendKeys("9281550");
   //     new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
        driver.findElement(By.xpath("//*[@text='Next']")).click();
   //     new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='etPassword']")));
        driver.findElement(By.xpath("//*[@id='etPassword']")).sendKeys("Pass@1234");
  //      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='btnNext']")));
        driver.findElement(By.xpath("//*[@id='btnNext']")).click();
   //     new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@contentDescription='Dismiss update dialog']")));
        driver.findElement(By.xpath("//*[@contentDescription='Dismiss update dialog']")).click();
        driver.findElement(By.xpath("//*[@id='cancel']")).click();
        driver.findElement(By.xpath("//*[@text='ShopKey']")).click();
        driver.findElement(By.xpath("//*[@class='android.view.ViewGroup' and ./*[@id='iconBGIV' and @class='androidx.cardview.widget.CardView']]")).click();
        //new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='navigation_bar_item_icon_view' and ./parent::*[./parent::*[@id='btnMore']]]")));
        driver.findElement(By.xpath("//*[@id='navigation_bar_item_icon_view' and ./parent::*[./parent::*[@id='btnMore']]]")).click();
        driver.findElement(By.xpath("//*[@text='Settings']")).click();
        driver.findElement(By.xpath("//*[@text='Logout']")).click();
        driver.findElement(By.xpath("//*[@text='YES']")).click();
	
	
	}}
