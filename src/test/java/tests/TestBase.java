package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.Host;
import config.HostConfig;
import drivers.AndroidStudioDriver;
import drivers.BrowserstackDriver;
import drivers.RealDeviceDriver;
import drivers.SelenoidDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Host host = ConfigFactory.create(HostConfig.class).host();
        switch (host) {
            case BROWSERSTACK:
                Configuration.browser = BrowserstackDriver.class.getName();
                Configuration.browserSize = null;
                break;
            case EMULATION:
                Configuration.browser = AndroidStudioDriver.class.getName();
                Configuration.browserSize = "360x640";
                break;
            case REAL:
                Configuration.browser = RealDeviceDriver.class.getName();
                Configuration.browserSize = null;
                break;
            case SELENOID:
                Configuration.browser = SelenoidDriver.class.getName();
                Configuration.browserSize = "1920x1080";
                break;
            default:
                throw new IllegalArgumentException("Invalid host value: " + host);
        }
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void afterEach() {
 //       String sessionId = sessionId().toString();
//        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        closeWebDriver();

//        Attach.addVideo(sessionId);
    }

}