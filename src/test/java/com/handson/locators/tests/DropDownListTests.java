package com.handson.locators.tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

public class DropDownListTests {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");

        //select by value
        page.selectOption("[id='searchLanguage']", "te");

        //select by text
        page.selectOption("[id='searchLanguage']",new SelectOption().setLabel("日本語"));

        //select by index
        page.selectOption("[id='searchLanguage']", new SelectOption().setIndex(1));


        //get the count of values in the dropdown list - what if, if there are >1 dropdown list's in a page?, use below
        System.out.println(page.locator("select > option").count());


        //list the values of a dropdown - way - 1
        Locator listOfDropdownValues = page.locator("select > option");
        for(int i=0; i<page.locator("select > option").count();i++) {
            System.out.println(listOfDropdownValues.nth(i).innerText()+"<>"+listOfDropdownValues.nth(i).getAttribute("value"));
        }

        //list the values of a dropdown - way - 2 - optimal
        List<ElementHandle> dropdownValuesEfficient = page.querySelectorAll("select > option");
        for(ElementHandle value: dropdownValuesEfficient){
            System.out.println(value.innerText()+"  "+value.getAttribute("lang"));
        }

        page.close();
        playwright.close();


    }
}
