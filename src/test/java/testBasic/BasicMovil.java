package testBasic;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasicMovil {
private AppiumDriver driver;

@Before
    public void before() throws MalformedURLException {
    System.out.println("Iniciando Conexion");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("deviceName", "TEST");
    capabilities.setCapability("platformVersion", "9");
    capabilities.setCapability("appPackage", "com.vrproductiveapps.whendo");
    capabilities.setCapability("appActivity", ".ui.HomeActivity");
    capabilities.setCapability("platformName", "Android");

    this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    this.driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
   }
 @Test
    public void myfirstTest() {
        // press Add button
        this.driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        // Enter Title
        this.driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys("T001");
        // Enter Note Description
        this.driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys("N001");
        // Press Save button
        this.driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();

        // verificacion T001
        String actualResult = this.driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.TextView[@text='T001']")).getText();
        String expectedResult = "T001";

        Assert.assertEquals("ERROR! La nota no existe", expectedResult, actualResult);
    }

    @Test
    public void mySecondTest(){

        // press Add button
        this.driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        // Enter Title
        this.driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys("T001");
        // Enter Note Description
        this.driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys("N001");
        // Press Save button
        this.driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();


        // Select Note
        this.driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.TextView[@text='T001']")).click();
        // Select Delete icon
        this.driver.findElement(By.id("com.vrproductiveapps.whendo:id/deleteItem")).click();
        // Confirm Delete action
        this.driver.findElement(By.id("android:id/button1")).click();

        // Verification if T001 exist
        Boolean actualResult;
            try{
                actualResult=this.driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.TextView[@text='T001']")).isDisplayed();
            } catch (Exception e){
                actualResult=false;
            }
        Assert.assertFalse("ERROR! La nota no fue eliminada", actualResult);
}

 @After
 public void after(){
    System.out.println("AFTER...");
    this.driver.quit();
 }


}
