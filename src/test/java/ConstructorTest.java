import POM.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



@RunWith(Parameterized.class)
public class ConstructorTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String browserName;
    private HomePage homePage;


    public ConstructorTest(String browserName) {
        this.browserName = browserName;
    }

    @Parameterized.Parameters
    public static Object[][] browsers() {
        return new Object[][]{
                {"chrome"},
                {"yandex"}
        };
    }

    @Before
    public void setUp() {
        driver = Browser.getWebDriver(browserName);
        wait = new WebDriverWait(driver, 10);
        driver.get(UriConst.BASE_URI);
        homePage = new HomePage(driver, wait);
        homePage.waitForLoadHomePage();
    }

    @Test
    public void moveSousAndCheckTextNameSous() {
        homePage.clickSousButton();
        String result = homePage.getNameSous();
        Assert.assertEquals("Ошибка перехода к соусам", "Соусы", result);
    }

    @Test
    public void moveBunsAndCheckTextNameBuns() {
        homePage.clickSousButton();
        homePage.clickBunsButton();
        String result = homePage.getNameBans();
        Assert.assertEquals("Ошибка перехода к булкам", "Булки", result);
    }

    @Test
    public void moveFillingsAndCheckTextNameFillings() {
        homePage.clickFillingsButton();
        String result = homePage.getNameFillings();
        Assert.assertEquals("Ошибка перехода к начинкам", "Начинки", result);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
