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

        Configuration.remote = System.getProperty("Wdhost","https://user1:1234@selenoid.autotests.cloud/wd/hub");
        browser = System.getProperty("Browser","chrome");
        Configuration.browserVersion = System.getProperty("BrowserVersion","120.0");
        Configuration.browserSize = System.getProperty("BrowserSize","1920x1080");

    }
}
