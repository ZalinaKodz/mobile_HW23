package config;

import org.aeonbits.owner.Config;
@Config.Sources("classpath:config/emulator.properties")
public interface EmulatorConfig extends Config {
    @Key("appPackage")
    @DefaultValue("org.wikipedia.alpha")
    String appPackage();

    @Key("appActivity")
    @DefaultValue("org.wikipedia.main.MainActivity")
    String appActivity();

    @Key("serverUrl")
    @DefaultValue("http://localhost:4723/wd/hub")
    String serverUrl();

    @Key("appUrl")
    @DefaultValue("https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk?raw=true")
    String appUrl();

    @Key("appPath")
    @DefaultValue("src/test/resources/apk/app-alpha-universal-release.apk")
    String appPath();

    @Key("deviceName")
    @DefaultValue("Pixel 4 API 30")
    String deviceName();

    @Key("platformVersion")
    @DefaultValue("11.0")
    String platformVersion();
}
