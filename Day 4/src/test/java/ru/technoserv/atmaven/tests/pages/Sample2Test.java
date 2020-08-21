package ru.technoserv.atmaven.tests.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.openqa.selenium.WebElement;

public class Sample2Test {
    public     String baseUrl = "http://demo.guru99.com/test/login.html";

    public WebDriver driver;

    @BeforeClass
    public void openSite() {
        System.setProperty("webdriver.chrome.driver", "/Users/User/Desktop/Test/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
    @Test
    public void sample2() {
        try {

            WebElement email = driver.findElement(By.id("email"));
            WebElement password = driver.findElement(By.name("passwd"));

            email.sendKeys("abcd@gmail.com");
            password.sendKeys("abcdefghlkjl");
            System.out.println("Text Field Set");


            email.clear();
            password.clear();
            System.out.println("Text Field Cleared");


            WebElement login = driver.findElement(By.id("SubmitLogin"));


            email.sendKeys("abcd@gmail.com");
            password.sendKeys("abcdefghlkjl");
            login.click();
            System.out.println("Login Done with Click");


            driver.get(baseUrl);
            driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
            driver.findElement(By.name("passwd")).sendKeys("abcdefghlkjl");
            driver.findElement(By.id("SubmitLogin")).submit();
            System.out.println("Login Done with Submit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void closeSite() {
        driver.quit();
    }
}
