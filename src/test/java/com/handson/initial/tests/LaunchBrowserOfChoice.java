package com.handson.initial.tests;

import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LaunchBrowserOfChoice {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter chrome(c) or firefox(f)");
        String userInput = scanner.next();

        Playwright playwright = Playwright.create();
        Browser browser = null;
        Page page = null;
        List<String> browserArgs = new ArrayList<>();
        browserArgs.add("--start-maximized");

        try {
            if (userInput.equalsIgnoreCase("c")) {
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setArgs(browserArgs));

            } else if (userInput.equalsIgnoreCase("f")) {
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("firefox").setArgs(browserArgs));
            } else {
                System.out.println("try with given browser options");
            }

            BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
            page = browserContext.newPage();
            page.navigate("https://www.stackoverflow.com");

        }catch (Exception e){
            System.out.println("some issue happened");
        }finally{
            page.close();
            playwright.close();
        }

    }
}
