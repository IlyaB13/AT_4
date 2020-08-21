package ru.technoserv.atmaven.tests.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ToolTipTest {
    @Test
    public static void TTTest() {
        System.setProperty("webdriver.chrome.driver","/Users/User/Desktop/Test/chromedriver.exe");

        String baseUrl = "http://demo.guru99.com/test/social-icon.html";

        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        String expectedTooltip = "Github";

        WebElement github = driver.findElement(By.xpath(".//*[@class='soc-ico show-round']/a[4]"));

        String actualTooltip = github.getAttribute("title");
        System.out.println("Actual Title of Tool Tip = " + actualTooltip);

        if(actualTooltip.equals(expectedTooltip)) {
            System.out.println("Test Case Passed");
        }
        else {
            System.out.println("Test Case FAILED");
        }
        driver.quit();
    }
}
