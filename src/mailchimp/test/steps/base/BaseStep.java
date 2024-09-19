package steps.base;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Geolocation;
import io.cucumber.java.After;

import io.cucumber.java.Before;
import utility.PropertyReader;

import java.util.Arrays;

public class BaseStep {
    Playwright playwright;
    public static Page page;

    BrowserContext browserContext;
    Browser browser;



    @Before
    public void initializeBrowser(){
        String browserName = PropertyReader.getPropertyValue("browser");
        playwright = Playwright.create();
        switch (browserName) {

            case "chromium":
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            break;

            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            break;


            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
            break;

            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;

            default: System.out.println("Please enter the correct browser name");
            break;

        }
        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1200,1600));
        page = browserContext.newPage();
    }




    @After
    public void tearDown(){
        browserContext.close();
        playwright.close();
    }
}
