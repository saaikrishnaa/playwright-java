package com.handson.initial.tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ScreenSize;

import java.awt.*;

public class InvokeBrowser {

    public static void main(String[] args) {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(
                new Browser.NewContextOptions().setViewportSize((int) screenSize.getWidth(),(int) screenSize.getHeight()));
        Page page = browserContext.newPage();
        page.navigate("https://www.google.co.in");

        System.out.println(page.title());

        page.close();
        playwright.close();
    }
}