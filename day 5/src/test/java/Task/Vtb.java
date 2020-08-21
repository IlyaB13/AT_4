package Task;
import static com.codeborne.selenide.Selenide.*;
public class Vtb {
    private static String  url = "https://www.vtb.ru/personal/platezhi-i-perevody/obmen-valjuty/";
    static String USD = "USD";
    static String RUR = "RUR";
    private void method1change(String val) {
        $x("//input[@id=\"method1\"]/../../div[3]").click();
        $x("//input[@id=\"method1\"]/../..//li[contains(.,\"" + val + "\")]").click();
    }
    private void method2change(String val) {
        $x("//input[@id=\"method2\"]/../../div[3]").click();
        $x("//input[@id=\"method2\"]/../..//li[contains(.,\"" + val + "\")]").click();
    }
    private void exchangeMethod (String have, String want) {
        method1change(have);
        method2change(want);
    }

    public static Vtb getExchangePage() {
        return open(url, Vtb.class);
    }
    public Double RurToUsd (Double rub) {
        return Course(rub, RUR, USD);
    }
    public Double UsdToRur (Double usd) {
        return Course(usd, USD, RUR);
    }

    private Double Course (Double val, String m1, String m2) {
        exchangeMethod(m1, m2);

        $x("//input[@id=\"method1\"]").clear();
        String oldM2value = $x("//input[@id=\"method2\"]").val();
        $x("//input[@id=\"method1\"]").sendKeys(val.toString().replace(".",","));
        //клик на название, чтобы метод вернул курс
        $x("//input[@id=\"method1\"]/../../../label").click();

        // проверка, и ожидание, что курс рассчитался
        String result  = oldM2value;
        for (int i = 0; i < 10; i++) {
            result = $x("//input[@id=\"method2\"]").val();
            if (oldM2value.equals(result) || result.equals("0")) {
                try {
                    Thread.sleep(500);
                } catch (Exception ignored) {}
            } else {
                break;
            }
        }

        //удалить неразрывный пробел, замена запятой
        result = result.replaceAll("\u00a0", "").replace(",",".");
        //System.out.println(result);
        return Double.parseDouble(result);
    }
}
