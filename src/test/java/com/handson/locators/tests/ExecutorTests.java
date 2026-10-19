package com.handson.locators.tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class ExecutorTests {

    public static void main(String[] args) {
        try (
                Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://demo.playwright.dev/todomvc/#/");
            page.locator("html").click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).fill("complete playwright course");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).press("Enter");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).fill("bring dhoopsticks");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).press("Enter");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).fill("sleep by 10 PM");
            page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("complete playwright course")).getByLabel("Toggle Todo").check();
        }
    }

}
