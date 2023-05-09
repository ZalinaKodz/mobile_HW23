package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/selenoid.properties"
})
public interface SelenoidConfig extends Config {
    @Key("selenoidUrl")
    @DefaultValue("http://user1:1234@selenoid.autotests.cloud:4444/wd/hub")
    String selenoidUrl();

    @Key("selenoidAppversion")
    @DefaultValue("8.1")
    String selenoidAppVersion();

    @Key("appPath")
    @DefaultValue("https://github.com/qa-guru/wikipedia-mobile-tests/raw/local/src/test/resources/apk/app-alpha-universal-release.apk")
    String appPath();
}
