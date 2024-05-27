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
        System.setProperty("Wdhost","https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.remote = System.getProperty("Wdhost");
        browser = System.getProperty("Browser");
        Configuration.browserVersion = System.getProperty("BrowserVersion");
        Configuration.browserSize = System.getProperty("BrowserSize");
    }
}
