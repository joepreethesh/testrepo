package automation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest extends LoadableComponent<BaseTest> {

    public static AppiumDriver driver;
    public static DesiredCapabilities capabilities;
    public static final String Default_Platform = "iOS";
    public static WebDriverWait driverWait;

    public static final String platform = System.getProperty("platform", Default_Platform);

    @BeforeClass
    public static void setUp() throws Exception {

        switch (platform) {

            case "Android":
                capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platformVersion", "6.0");
                capabilities.setCapability("browserName", "Chrome");
                capabilities.setCapability("deviceName", "Samsung");
                capabilities.setCapability("showChromedriverLog", true);
                //capabilities.setCapability("chromeInitialUrl", "https://web.agentdesks.com/#/login/choice");
                driver = new AndroidDriver(new URL("http://0.0.0.0:" + 4723 + "/wd/hub"), capabilities);
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                driver.get("https://web.agentdesks.com/#/login/choice");
                break;

            case "iOS":
                capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("platformVersion", "11.3");
                capabilities.setCapability("browserName", "Safari");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("deviceName", "iPhone 6s Plus");
                capabilities.setCapability("startIWDP", true);
                capabilities.setCapability("udid", "auto");
                capabilities.setCapability("safariInitialUrl", "https://web.agentdesks.com/#/login/choice");
                capabilities.setCapability("waitForAppScript", "true");
                driver = new IOSDriver(new URL("http://0.0.0.0:" + 4723 + "/wd/hub"), capabilities);
                driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
                driver.get("https://web.agentdesks.com/#/login/choice");
                break;


        }
    }

    @Override
    protected  void load() {

        driver.get("https://web.agentdesks.com/#/login/choice");

    }

    @Override
    protected void isLoaded() throws Error {
        load();
        String url = driver.getCurrentUrl();
       Assert.assertTrue(url.endsWith("/choice"), "Not on the issue entry page" + url);

    }
}
