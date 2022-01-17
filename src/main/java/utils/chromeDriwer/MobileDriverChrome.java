package utils.chromeDriwer;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MobileDriverChrome {

    public static WebDriver driver;

    private static void initializeChromeDriver() {
        WebDriverManager.chromedriver().setup();
        Map<String, Object> deviceMetrics = new HashMap<>();

        deviceMetrics.put("width", 360);

        deviceMetrics.put("height", 640);

        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceMetrics", deviceMetrics);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver getChromeDriver() {
        initializeChromeDriver();
        return driver;
    }
}
