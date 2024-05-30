package tests;

import attachments.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Configuration.browser;


public class BaseTest {

    @BeforeEach
    void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = System.getProperty("Wdhost","https://user1:1234@selenoid.autotests.cloud/wd/hub");
        browser = System.getProperty("Browser","chrome");
        Configuration.browserVersion = System.getProperty("BrowserVersion","120.0");
        Configuration.browserSize = System.getProperty("BrowserSize","1920x1080");
        SelenideLogger.addListener("allure",new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;




    }

    @AfterEach
    void attachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
