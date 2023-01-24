package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import config.WebDriverConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import page.PageElements;


public class TestBase {

    private static WebDriverConfig config;
    private static ProjectConfig configuration;

    @BeforeAll
    static void beforeAll() {
        config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        configuration = new ProjectConfig();
        configuration.runConfig(config);
    }

    @BeforeEach
    void beforeEach() {
        new PageElements().openPage();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
