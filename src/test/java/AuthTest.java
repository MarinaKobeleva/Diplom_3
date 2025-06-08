import POM.AuthPage;
import POM.HomePage;
import POM.RecoverPasswordPage;
import POM.RegisterPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class AuthTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String browserName;
    private HomePage homePage;
    private AuthPage authPage;
    private RegisterPage registerPage;
    private GenerateTestData generateTestData;
    private RecoverPasswordPage recoverPasswordPage;


    public AuthTest(String browserName) {
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
        registerPage = new RegisterPage(driver, wait);
        generateTestData = new GenerateTestData(driver, wait);
        authPage = new AuthPage(driver, wait);
        recoverPasswordPage = new RecoverPasswordPage(driver, wait);
        generateTestData.registerUserAndGetToken();
    }

    @Test
    public void authByButtonLoginAccountAndCheckTextCreateOrder() {
        homePage.waitForLoadHomePage();
        homePage.clickLoginButton();
        authPage.waitForLoadAuthPage();
        authPage.inputEmail("new89Email@yandex.ru");
        authPage.inputPassword("password");
        authPage.clickInletButton();
        homePage.waitForLoadHomePage();
        String result = homePage.getTextCreateOrder();
        Assert.assertEquals("Ошибка авторизации", "Оформить заказ", result);
    }

    @Test
    public void authByButtonPersonalAccountAndCheckTextCreateOrder() {
        homePage.waitForLoadHomePage();
        homePage.clickPersonalAccountButton();
        authPage.waitForLoadAuthPage();
        authPage.inputEmail("new89Email@yandex.ru");
        authPage.inputPassword("password");
        authPage.clickInletButton();
        homePage.waitForLoadHomePage();
        String result = homePage.getTextCreateOrder();
        Assert.assertEquals("Ошибка авторизации", "Оформить заказ", result);
    }

    @Test
    public void authByButtonInRegisterFormAndCheckTextCreateOrder() {
        homePage.waitForLoadHomePage();
        homePage.clickLoginButton();
        authPage.waitForLoadAuthPage();
        authPage.clickRegisterButton();
        registerPage.clickInletButton();
        authPage.waitForLoadAuthPage();
        authPage.inputEmail("new89Email@yandex.ru");
        authPage.inputPassword("password");
        authPage.clickInletButton();
        homePage.waitForLoadHomePage();
        String result = homePage.getTextCreateOrder();
        Assert.assertEquals("Ошибка авторизации", "Оформить заказ", result);
    }

    @Test
    public void authByButtonInRecoverPasswordFormAndCheckTextCreateOrder() {
        homePage.waitForLoadHomePage();
        homePage.clickLoginButton();
        authPage.waitForLoadAuthPage();
        authPage.clickRecoverPasswordButton();
        recoverPasswordPage.clickInletButton();
        authPage.waitForLoadAuthPage();
        authPage.inputEmail("new89Email@yandex.ru");
        authPage.inputPassword("password");
        authPage.clickInletButton();
        homePage.waitForLoadHomePage();
        String result = homePage.getTextCreateOrder();
        Assert.assertEquals("Ошибка авторизации", "Оформить заказ", result);
    }

    @After
    public void tearDown() {
        generateTestData.deleteUser();
        driver.quit();
    }
}
