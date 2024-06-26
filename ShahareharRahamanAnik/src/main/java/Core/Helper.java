package Core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.Map;

public class Helper {
    public WebDriver driver;

    public WebDriver chromeLaunch() {
        ChromeOptions options = new ChromeOptions(); //
        Map<java.lang.String, Object> prefs = new HashMap<>();
        Map<java.lang.String, Map<java.lang.String, Integer>> profile = new HashMap<>();
        Map<String, Integer> contentSettings;
        contentSettings = new HashMap<>();
        contentSettings.put("notifications", 2);
        contentSettings.put("geolocation", 2);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);


        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        return driver;

    }
    public WebDriver FireFoxLaunch() {
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(new FirefoxProfile());
        options.addPreference("dom.webnotifications.enabled", false);
        options.addPreference("geo.enabled", true);
        options.addPreference("geo.prompt.testing", true);
        options.addPreference("geo.prompt.testing.allow", true);
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(options);


        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        return driver;

    }

}