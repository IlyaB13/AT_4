package MyTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;


public class OpenSelenide {
    @Test
    public void testDollarBuyMoreThanSale() {
        OpenBank obp = open("https://www.open.ru", OpenBank.class);
        Assert.assertFalse(obp.getDollarBuy() > obp.getDollarSale());
    }

    @Test
    public void testEuroBuyMoreThanSale() {
        OpenBank obp = open("https://www.open.ru", OpenBank.class);
        Assert.assertFalse(obp.getEuroBuy() > obp.getEuroSale());

    }

}


