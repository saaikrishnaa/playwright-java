package com.handson.locators.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatingStrategies {

    public static void main(String[] args) {

        Playwright playwrightSession = Playwright.create();
        Browser browser = playwrightSession.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page gmailLoginPage = browser.newPage();


        gmailLoginPage.navigate("https://mail.google.com");
//        css selector - one way
//        gmailLoginPage.locator("#identifierId").fill("trainer@way2automation.com");
//
//        css selector - another way
//        gmailLoginPage.locator("[id='identifierId']").fill("trainer@way2automation.com");

//        another way of working with locators
//        gmailLoginPage.fill("[id='identifierId']","trainer@way2automation.com");
//        gmailLoginPage.fill("[id='identifierId']","trainer@way2automation.com");
//        gmailLoginPage.type("[id='identifierId']","trainer@way2automation.com",new Page.TypeOptions().setDelay(150));
        gmailLoginPage.type("id=identifierId","java@way2automation.com",new Page.TypeOptions().setDelay(0));
//        gmailLoginPage.locator("[jsname=YPqjbf]").type("trainer@way2automation.com"); //solve the error TODO
//        gmailLoginPage.click("text=Next"); //way1
//        gmailLoginPage.click("a:has-text('Learn more about using Guest mode')");
        gmailLoginPage.click("button:has-text('Next')");
        gmailLoginPage.locator("[type=password]").fill("test");
        gmailLoginPage.click("button:has-text('Next')");
        System.out.println(gmailLoginPage.getByText("Wrong password. Try again or click \"Forgot password?\" for more options."));
        gmailLoginPage.close();
        playwrightSession.close();

    }
}
