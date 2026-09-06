package com.handson.initial.tests;

import com.microsoft.playwright.*;

import java.util.Arrays;
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

        try {
            if (userInput.equalsIgnoreCase("c")) {
                browser = playwright.chromium().launch(
                                new BrowserType.LaunchOptions()
                                        .setHeadless(false)
                                        .setChannel("chrome")
                                        .setArgs(List.of("--start-maximized"))
                );

            } else if (userInput.equalsIgnoreCase("f")) {
                browser = playwright.firefox().launch(
                                new BrowserType.LaunchOptions()
                                        .setHeadless(false)
                );
            } else {
                browser = playwright.chromium().launch(
                                new BrowserType.LaunchOptions()
                                        .setHeadless(false)
                                        .setChannel("msedge")
                                        .setArgs(List.of("--start-maximized"))
                );


                System.out.println("using edge as the last option, without erroring out");
            }

            BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
            page = browserContext.newPage();
            page.navigate("https://www.stackoverflow.com");

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            page.close();
            playwright.close();
        }

    }
}
