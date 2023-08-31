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


public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        /*DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;*/

    }


    @AfterEach
    void afterEachTest() {
        SelenideLogger.addListener("Allure", new AllureSelenide());
        Selenide.closeWebDriver();

        /*ReportAttachments.addVideo();
        ReportAttachments.attachScreenshot();
        ReportAttachments.pageSource();
        ReportAttachments.browserConsoleLogs();*/
    }
}
