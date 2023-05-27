package config;

import org.aeonbits.owner.Config;
@Config.Sources("classpath:config/real.properties")
public interface RealConfig extends Config {
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
    @DefaultValue("R9KBB17722154216")
    String deviceName();

    @Key("platformVersion")
    @DefaultValue("6.0")
    String platformVersion();
}
