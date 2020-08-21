package ru.technoserv.atmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

public class Sample3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/User/Desktop/Test/chromedriver.exe");
        String baseUrl = "http://demo.guru99.com/test/upload/";
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.get(baseUrl);
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("/Users/igor/Downloads/chromedriver_mac64.zip");

        // check the "I accept the terms of service" check box
        driver.findElement(By.id("terms")).click();

        WebElement resultElement = driver.findElement(By.cssSelector("#res"));
        WebElement resultText = driver.findElement(By.cssSelector("#res > center"));
        System.out.println(resultText.getText().contains(" successfully"));
        long start = (new Date()).getTime();
        System.out.println((new Date()).getTime() - start);

        // click the "UploadFile" button
        driver.findElement(By.name("send")).click();
        System.out.println(resultText.getText().contains(" successfully"));

        System.out.println((new Date()).getTime() - start);

        wait.until(ExpectedConditions.attributeContains(resultElement, "style", "display: block"));

        System.out.println(resultText.getText().contains(" successfully"));

        System.out.println((new Date()).getTime() - start);

        driver.quit();

    }
}