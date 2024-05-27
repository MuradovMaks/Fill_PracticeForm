package properties.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.browser;

public class PropertiesSystem
{
    @Test
    @Tag("PracticeForm")
    void BrowserPropertie()
    {
        browser = System.getProperty("browser","chrome");
        Configuration.remote = System.getProperty("Wdhost","https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.browserSize = System.getProperty("browserSize","1920x1080");
        Configuration.browserVersion = System.getProperty("browserVersion","120.0");
    }
}
