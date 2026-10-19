package com.handson.initial.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType;
import java.nio.file.Paths;

public class NavigateAndTraverse {

    public static void main(String[] args) {

        Playwright playwrightSession = Playwright.create();
        Browser browser = playwrightSession.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setChannel("chrome")
                        .setHeadless(false)
        );

        BrowserContext browserContext = playwrightSession.chromium().launchPersistentContext(
          Paths.get("C:\\Users\\HP\\AppData\\Local\\Google\\Chrome\\User Data\\Default"),
          new BrowserType.LaunchPersistentContextOptions().setHeadless(false).setExecutablePath(
                  Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")
          )
        );

        Page page = browserContext.newPage();
        page.navigate("https://www.google.com");
        System.out.println(page.title());

        page.navigate("https://www.amazon.co.in");
        System.out.println(page.title());
        page.goBack(new Page.GoBackOptions().setTimeout(5000));

        page.goForward(new Page.GoForwardOptions().setTimeout(5000));


        page.reload();
        page.close();
        playwrightSession.close();
    }
}
