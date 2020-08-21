package MyTest;
import static com.codeborne.selenide.Selenide.$x;

public class OpenBank {
    public Double getDollarBuy() {
        return getCourse("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div/table/tbody/tr[2]/td[2]/div/span");
    }
    public Double getDollarSale() {
        return getCourse("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div/table/tbody/tr[2]/td[4]/div/span");
    }

    public Double getEuroBuy() {
        return getCourse("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div/table/tbody/tr[3]/td[2]/div/span");
    }
    public Double getEuroSale() {
        return getCourse("//*[@id=\"main\"]/div/div/div[7]/section/div/div/div[1]/div/div/div/div/div[2]/div[2]/div[1]/div/table/tbody/tr[3]/td[4]/div/span");
    }

    private Double getCourse(String xPath) {
        return Double.parseDouble($x(xPath).getText().replace(",","."));
    }
}
