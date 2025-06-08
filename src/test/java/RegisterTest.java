import POM.AuthPage;
import POM.HomePage;
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
public class RegisterTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String browserName;
    private HomePage homePage;
    private AuthPage authPage;
    private RegisterPage registerPage;
    private GenerateTestData generateTestData;


    public RegisterTest(String browserName) {
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
    }

    @Test
    public void registerWithIncorrectPasswordAndCheckErrorText() {
        homePage.waitForLoadHomePage();
        homePage.clickLoginButton();
        authPage.waitForLoadAuthPage();
        authPage.clickRegisterButton();
        registerPage.waitForLoadRegisterPage();
        registerPage.inputName("Test");
        registerPage.inputEmail("new89Email@yandex.ru");
        registerPage.inputPassword("passw");
        registerPage.clickRegisterButton();
        String result = registerPage.getErrorText();
        Assert.assertEquals("Минимальный пароль — шесть символов", "Некорректный пароль", result);
    }

    @Test
    public void registerWithCorrectPasswordAndCheckSuccessInlet() {
        homePage.waitForLoadHomePage();
        homePage.clickLoginButton();
        authPage.waitForLoadAuthPage();
        authPage.clickRegisterButton();
        registerPage.waitForLoadRegisterPage();
        registerPage.inputName("Test");
        registerPage.inputEmail("new89Email@yandex.ru");
        registerPage.inputPassword("password");
        registerPage.clickRegisterButton();
        String result = authPage.waitForLoadPageAndGetText();
        Assert.assertEquals("Ошибка авторизации", "Вход", result);
        generateTestData.authUserAndGetToken();
        generateTestData.deleteUser();
    }

    @After
    public void tearDown() {
            driver.quit();
    }
}
