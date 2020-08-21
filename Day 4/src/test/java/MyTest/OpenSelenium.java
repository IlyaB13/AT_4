package MyTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenSelenium {
        public String baseUrl = "https://www.open.ru/";
        public WebDriver driver ;

        @BeforeClass
        public void openSite() {
            System.setProperty("webdriver.chrome.driver","/Users/User/Desktop/Test/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(baseUrl);
        }

        @Test
        public void dollarBuyMoreThanSale() {

            double dollarBuy = Double.parseDouble(driver.findElement(By.cssSelector("tr:nth-child(2)>td:nth-child(2) span")).getText().replace(",","."));
            double dollarSale = Double.parseDouble(driver.findElement(By.cssSelector("tr:nth-child(2)>td:nth-child(4) span")).getText().replace(",","."));

            Assert.assertFalse(dollarBuy  > dollarSale );
        }

        @Test
        public void euroBuyMoreThanSale() {

            double euroBuy = Double.parseDouble(driver.findElement(By.cssSelector("tr:nth-child(3)>td:nth-child(2) span")).getText().replace(",","."));
            double euroSale = Double.parseDouble(driver.findElement(By.cssSelector("tr:nth-child(3)>td:nth-child(4) span")).getText().replace(",","."));

            Assert.assertFalse(euroBuy > euroSale );
        }

        @AfterClass
        public void closeSite() {
            driver.close();
        }
}
