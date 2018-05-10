package automation.test;

import automation.BaseTest;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.sun.deploy.trace.Trace.automation;

public class EnterDataInGmailScreen  extends BaseTest{

    @Test
    public static void test() throws InterruptedException {

      //  Thread.sleep(2000);
      //  WebElement name  = driver.findElement(By.id("identifierId"));
      //  name.click();
      //  Thread.sleep(2000);
      //  driver.findElement(By.id("identifierId")).sendKeys("joe.preethesh29");
      //  driver.findElement(By.id("identifierNext")).click();
      //  Thread.sleep(2000);
        //.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
      //  driver.get("https://web.agentdesks.com/#/login/choice");

        TouchAction action = new TouchAction(driver);
        action.tap(208, 371).perform();


    }
}
