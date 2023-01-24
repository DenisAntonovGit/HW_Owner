package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface WebDriverConfig extends Config {

        @Key("baseUrl")
        @DefaultValue("https://astondevs.com")
        String getBaseUrl();

        @Key("browser")
        @DefaultValue("chrome")
        String getBrowser();

        @Key("browser_version")
        @DefaultValue("100.0")
        String getBrowserVersion();

        @Key("browser_size")
        @DefaultValue("1024x768")
        String getBrowserSize();

        @Key("remoteUrl")
        @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
        String getRemoteUrl();

        @Key("remote")
        @DefaultValue("false")
        Boolean remote();
    }

