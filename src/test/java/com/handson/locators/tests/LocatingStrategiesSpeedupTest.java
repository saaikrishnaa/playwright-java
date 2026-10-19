package com.handson.locators.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitUntilState;

public class LocatingStrategiesSpeedupTest {

    public static void main(String[] args) {

        long start = System.nanoTime();
        Playwright playwright = Playwright.create();
        logTime("Playwright initialization", start);

        try {
            start = System.nanoTime();

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setChannel("chrome")
                            .setHeadless(false)
            );

            logTime("Chrome launch", start);

            Page page = browser.newPage();

            start = System.nanoTime();

            page.navigate(
                    "https://www.gmail.com",
                    new Page.NavigateOptions()
                            .setWaitUntil(WaitUntilState.DOMCONTENTLOADED)
                            .setTimeout(15000)
            );

            logTime("Gmail navigation", start);

            start = System.nanoTime();

            page.locator("#identifierId").fill("ska@gmail.com");

            logTime("Email field interaction", start);

            System.out.println("Email entered successfully.");

        } finally {
            playwright.close();
            System.out.println("Playwright closed.");
        }
    }

    private static void logTime(String operation, long start) {
        double seconds =
                (System.nanoTime() - start) / 1_000_000_000.0;

        System.out.printf("%s: %.3f seconds%n", operation, seconds);
    }
}