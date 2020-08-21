package ru.technoserv.atmaven.tests.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Sample1Test {
    @Test
    public static void sam1Test() {
        System.setProperty("webdriver.chrome.driver","C:/Users/User/Desktop/Test/chromedriver.exe");

        WebDriver chromeDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/newtours/";
            chromeDriver.get(baseUrl);
            System.out.println("Chrome title = " + chromeDriver.getTitle());
        } finally {
            chromeDriver.quit();
        }
    }
}