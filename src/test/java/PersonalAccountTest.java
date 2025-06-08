import POM.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


@RunWith(Parameterized.class)
public class PersonalAccountTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String browserName;
    private HomePage homePage;
    private AuthPage authPage;
    private GenerateTestData generateTestData;
    private PersonalAccountPage personalAccountPage;


    public PersonalAccountTest(String browserName) {
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
        generateTestData = new GenerateTestData(driver, wait);
        authPage = new AuthPage(driver, wait);
        personalAccountPage = new PersonalAccountPage(driver, wait);
        generateTestData.registerUserAndGetToken();
        generateTestData.authUserAndGetToken();
        homePage.waitForLoadHomePage();
        homePage.clickLoginButton();
        authPage.waitForLoadAuthPage();
        authPage.inputEmail("new89Email@yandex.ru");
        authPage.inputPassword("password");
        authPage.clickInletButton();
        homePage.waitForLoadHomePage();
        homePage.clickPersonalAccountButton();
    }

    @Test
    public void moveInPersonalAccountAndCheckTextProfile() {
        personalAccountPage.waitForLoadPersonalAccountPage();
        String result = personalAccountPage.getProfileText();
        Assert.assertEquals("Ошибка перехода в личный кабинет", "Профиль", result);
    }

    @Test
    public void clickConstructorAndMoveToConstructorAndCheckTextCreateOrder() {
        personalAccountPage.waitForLoadPersonalAccountPage();
        personalAccountPage.clickConstructorButton();
        homePage.waitForLoadHomePage();
        String result = homePage.getTextBuns();
        Assert.assertEquals("Ошибка перехода к конструктору по кнопке конструктор", "Булки", result);
    }

    @Test
    public void clickStellarBurgersAndMoveToConstructorAndCheckTextCreateOrder() {
        personalAccountPage.waitForLoadPersonalAccountPage();
        personalAccountPage.clickStellarBurgersButton();
        homePage.waitForLoadHomePage();
        String result = homePage.getTextBuns();
        Assert.assertEquals("Ошибка перехода к конструктору по логотипу Stellar Burgers", "Булки", result);
    }

    @Test
    public void clickExitButtonAndCheckText() {
        personalAccountPage.waitForLoadPersonalAccountPage();
        personalAccountPage.clickExitButton();
        authPage.waitForLoadAuthPage();
        String result = authPage.waitForLoadPageAndGetText();
        Assert.assertEquals("Ошибка выхода из аккаунта", "Вход", result);
    }


    @After
    public void tearDown() {
        generateTestData.deleteUser();
        driver.quit();
    }
}
