package config;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/android.properties")

public interface BrowserstackConfig extends Config {

        @Key("browserstack.user")
        @DefaultValue("zalinakodzova_4HPOF2")
        String getUser();

        @Key("browserstack.key")
        @DefaultValue("qJHfFPiqQFywDYgqzbBK")
        String getKey();

        @Key("remoteUrl")
        @DefaultValue("https://hub.browserstack.com/wd/hub")
        String getRemoteUrl();

        @Key("app")
        @DefaultValue("bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c")
        String getApp();

        @Key("device")
        @DefaultValue("Google Pixel 3")
        String getDevice();

        @Key("os_version")
        @DefaultValue("9.0")
        String getOsVersion();

        @Key("project")
        @DefaultValue("First Java Project")
        String getProjectName();

        @Key("build")
        @DefaultValue("browserstack-build-1")
        String getBuildName();

        @Key("name")
        @DefaultValue("first_test")
        String getTestName();

}
