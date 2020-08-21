package ru.technoserv.atmaven.tests.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.Assert;



public class AlertDemoTest {
    public String baseUrl = "http://demo.guru99.com/test/delete_customer.php";
    public WebDriver driver ;


    @BeforeClass
    public void openSite() {
        System.setProperty("webdriver.chrome.driver","/Users/User/Desktop/Test/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);

    }

    @Test
    public void delCastTest() {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String alertMessage = alert.getText();
        System.out.println(alertMessage);

        alert.accept();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert2 = driver.switchTo().alert();

        String alertMessage2 = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage2, "Customer Successfully Delete!");
        System.out.println(alertMessage2);

        alert2.accept();
    }

    @AfterClass
    public void closeSite() { driver.quit(); }
}

