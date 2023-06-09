package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;


@Tag("remote")
public class WikiBrowserstackTests extends TestBase {
        @Test
        void italianoLanguageTest() {
            step("Click menu", () -> {
                    $(AppiumBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
            });
            step("Click 'Settings'", () -> {
                    $(AppiumBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click();
            });
            step("Choose Wikipedia language", () -> {
                    $(AppiumBy.id("android:id/summary")).click();
            });
            step("Set 'Italiano' as language", () -> {
                    $(AppiumBy.id("org.wikipedia.alpha:id/preference_languages_filter")).sendKeys("Italiano");
                    $(AppiumBy.id("org.wikipedia.alpha:id/language_subtitle")).click();
            });
            step("Check that we got selected language in settings", () -> {
                    $(AppiumBy.id("android:id/summary")).shouldHave(exactText("Italiano"));
            });
    }
}
