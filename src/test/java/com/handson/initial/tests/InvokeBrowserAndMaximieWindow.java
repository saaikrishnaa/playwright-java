package com.handson.initial.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.List;

public class InvokeBrowserAndMaximieWindow {

    public static void main(String[] args) {

        Playwright playwrightSession = Playwright.create();


        List<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");

        Browser browser = playwrightSession.chromium().launch(new BrowserType
                                                    .LaunchOptions()
                                                    .setChannel("chrome")
                                                    .setHeadless(false)
                                                    .setArgs(arguments)
                                           );

        BrowserContext context = browser.newContext(new Browser
                                .NewContextOptions()
                                .setViewportSize(null)
                                );

        Page page = context.newPage();

        page.navigate("https://www.google.co.in");

        System.out.println(page.title());

        browser.close();
        playwrightSession.close();
    }



}
