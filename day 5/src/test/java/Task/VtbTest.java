package Task;
import org.testng.Assert;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.$x;

public class VtbTest {
    private Vtb page;
    @BeforeClass
    public void before() {
        page = Vtb.getExchangePage();
        $x("//*[@id=\"cookiemsgoffpls\"]/p[1]").click();
    }

    @Test
    public void test1() {
        double rur = 13.00;
        double result = page.RurToUsd(rur);
        Assert.assertNotEquals(result, 0.0);
        Assert.assertTrue(rur > result);
    }

    @Test
    public void test2() {
        double usd = 13000.00;
        double result = page.UsdToRur(usd);
        Assert.assertNotEquals(result, 0.0);
        Assert.assertTrue(usd < result );
    }
    @Test
    public void test3() {
        double rur = 130000000.00;
        double result = page.RurToUsd(rur);
        Assert.assertNotEquals(result, 0.0);
        Assert.assertTrue(rur > result);
    }

    @Test
    public void test4() {
        double usd = 33000.00;
        double result = page.UsdToRur(usd);
        Assert.assertNotEquals(result, 0.0);
        Assert.assertTrue(usd < result );
    }

}
