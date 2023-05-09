package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.SelenoidConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidDriver implements WebDriverProvider {
    public static SelenoidConfig config = ConfigFactory.create(SelenoidConfig.class,
            System.getProperties());
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("deviceName", "android");
        mutableCapabilities.setCapability("version", config.selenoidAppVersion());


        mutableCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        mutableCapabilities.setCapability("appPackage", "org.wikipedia.alpha");

        mutableCapabilities.setCapability("app", config.appPath());


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(config.selenoidUrl()), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}