package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.attachments.ReportAttachments;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;


public class TestBase {
    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("Allure", new AllureSelenide());
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = String.format("https://%s:%s@%s", System.getProperty("remote"));


        DesiredCapabilities capabilities = new DesiredCapabilities();
        Map<String, Object> value = new HashMap<>();
        value.put("enableVNC", true);
        value.put("enableVideo", true);
        capabilities.setCapability("selenoid:options", value);

        Configuration.browserCapabilities = capabilities;

    }


    @AfterEach
    void afterEachTest() {
        ReportAttachments.addVideo();
        ReportAttachments.attachScreenshot();
        ReportAttachments.pageSource();
        ReportAttachments.browserConsoleLogs();

        Selenide.closeWebDriver();


    }
}
