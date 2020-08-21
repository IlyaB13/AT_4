package Task2;
import java.util.Map;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssurdTest {
    static String LOCALES = "locales";
    static String CURRENCIES = "currencies";
    static String TIMEZONES = "timezones";
    static String CITIES = "cities";
    static String COUNTRIES = "countries";

    static String HOST = "wft-geo-db.p.rapidapi.com";
    static String KEY = "c6cac7bc7amshee2830eca70001bp1f2baejsn4ebfc34c5cff";
    static Map<String, String> baseUrl = Map.of(
            LOCALES,"https://wft-geo-db.p.rapidapi.com/v1/locale/locales",
            CURRENCIES, "https://wft-geo-db.p.rapidapi.com/v1/locale/currencies",
            TIMEZONES, "https://wft-geo-db.p.rapidapi.com/v1/locale/timezones",
            CITIES, "https://wft-geo-db.p.rapidapi.com/v1/geo/cities",
            COUNTRIES, "https://wft-geo-db.p.rapidapi.com/v1/geo/countries"
    );

    @Test
    public void Localestest() {
        given().
                header("x-rapidapi-host", HOST).
                header("x-rapidapi-key", KEY).
                queryParam("offset", "420").
                when().
                get(baseUrl.get(LOCALES)).
                then().
                assertThat().
                body("metadata.currentOffset", equalTo(420)).
                body("metadata.totalCount", equalTo(772));
    }

    @Test
    public void Currenciestest() {
        given().
                header("x-rapidapi-host", HOST).
                header("x-rapidapi-key", KEY).
                queryParam("offset", "42").
                queryParam("limit", "10").
                when().
                get(baseUrl.get(CURRENCIES)).
                then().
                assertThat().
                body("data", hasSize(10)).
                body("metadata.currentOffset", equalTo(42));
    }

    @Test
    public void TimeZonestest() {
        given().
                header("x-rapidapi-host", HOST).
                header("x-rapidapi-key", KEY).
                when().
                get(baseUrl.get(TIMEZONES)).
                then().
                assertThat().
                body("data[1].rawUtcOffsetHours", equalTo(-4));
    }

    @Test
    public void Citiestest() {
        given().
                header("x-rapidapi-host", HOST).
                header("x-rapidapi-key", KEY).
                when().
                get(baseUrl.get(CITIES)).
                then().
                assertThat().
                body("data[4].name", equalTo("Encamp"));
    }

    @Test
    public void Countriestest() {
        given().
                header("x-rapidapi-host", HOST).
                header("x-rapidapi-key", KEY).
                when().
                get(baseUrl.get(COUNTRIES)).
                then().
                assertThat().
                body("data", hasSize(5));
    }
}
