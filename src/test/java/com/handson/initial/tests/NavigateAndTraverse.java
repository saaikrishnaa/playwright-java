package com.handson.initial.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType;
import java.nio.file.Paths;

public class NavigateAndTraverse {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("T0 - JVM main started: " + System.currentTimeMillis());

        System.out.println("T1 - Before Playwright.create(): " + System.currentTimeMillis());

        Playwright playwrightSession = Playwright.create();

        System.out.println("T2 - After Playwright.create(): " + System.currentTimeMillis());

        System.out.println("T3 - Before Chrome launch: " + System.currentTimeMillis());

        Browser browser = playwrightSession.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setChannel("chrome")
                        .setHeadless(false)
        );

        System.out.println("T4 - After Chrome launch: " + System.currentTimeMillis());

        System.out.println("T5 - Before browser context creation: " + System.currentTimeMillis());

        BrowserContext browserContext = browser.newContext(
                new Browser.NewContextOptions().setViewportSize(null)
        );

        System.out.println("T6 - After browser context creation: " + System.currentTimeMillis());

        Page page = browserContext.newPage();

        System.out.println("T7 - Before Google navigation: " + System.currentTimeMillis());

        page.navigate("https://www.google.com");

        System.out.println("T8 - After Google navigation: " + System.currentTimeMillis());
        System.out.println(page.title());

        page.navigate("https://www.amazon.co.in");
        Thread.sleep(1000);
        System.out.println(page.title());
        Thread.sleep(1000);
        page.goBack();
        Thread.sleep(1000);

        page.goForward();
        Thread.sleep(1000);

        page.reload();

        page.close();
        playwrightSession.close();

        System.out.println("T9 - Program finished: " + System.currentTimeMillis());


    }
}
