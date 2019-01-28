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

// 1. Прописали capabilities
public class FirstTest {

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
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']")).click();
        //Thread.sleep(5000); - thread-sleep(msec)
        //driver.manage().timeouts().implicitlyWait(10000); - waitImplicit
        //WebDriverWait webDriverWait = new WebDriverWait(driver, 10); - waitExplicit
        //WebElement h1 = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
        //        By.xpath("//android.widget.TextView[@content-desc='Accessibility Node Querying']")));
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        WebElement h1 = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.TextView[@content-desc='Accessibility Node Querying']")));
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility Node Querying']")).click();
        List<MobileElement> list = driver.findElements(By.className("android.widget.CheckBox"));
        list.get(0).click();
        Boolean ifTrue = list.get(0).isSelected();
        driver.navigate().back();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility Node Querying']")).click();

        if (ifTrue = list.get(0).isSelected()) {
            System.out.println("Yes!");
        }
        else {
            System.out.println("Noooooo...");
        }
    }

}
