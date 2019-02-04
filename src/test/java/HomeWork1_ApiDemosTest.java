import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class HomeWork1_ApiDemosTest {

    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "Android");
        desiredCapabilities.setCapability("platformVersion", "8.1");
        desiredCapabilities.setCapability("newCommandTimeout", 300000);
        desiredCapabilities.setCapability("app", new File("/Users/MacPro/IdeaProjects/ContactTest/app/ApiDemos-debug.apk"));
        AppiumDriver driver = null;
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println(driver.getPageSource());
            driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']")).click();
            WebDriverWait wait = new WebDriverWait(driver, 10);

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.TextView[@content-desc='Notification']")));
            driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Notification']")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.TextView[@content-desc='IncomingMessage']")));
            driver.findElement(By.xpath("//android.widget.TextView[@content-desc='IncomingMessage']")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.Button[@content-desc='Show App Notification']")));
            driver.findElement(By.xpath("//android.widget.Button[@content-desc='Show App Notification']")).click();

            ((AndroidDriver) driver).openNotifications();

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.TextView[@text='API Demos']")));
            driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']"));
            System.out.println("PASSED");
    }

}
