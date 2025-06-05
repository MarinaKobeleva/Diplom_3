package POM;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // список локаторов для страницы авторизации:
    // локатор для поля ввода "Email"
    @FindBy(xpath = ".//input[(@name='name')]")
    private WebElement inputFieldEmail;

    // локатор для поля ввода "Password"
    @FindBy(xpath = ".//input[(@name='Пароль')]")
    private WebElement inputFieldPassword;

    // локатор для поля "Вход"
    @FindBy(xpath = ".//h2[(text()='Вход')]")
    private WebElement fieldInlet;

    // локатор для кнопки "Войти"
    @FindBy(xpath = ".//button[(text()='Войти')]")
    private WebElement buttonInlet;

    // локатор для кнопки "Восстановить пароль"
    @FindBy(xpath = ".//a[(text()='Восстановить пароль')]")
    private WebElement buttonRecoverPassword;

    // локатор для кнопки "Зарегистрироваться"
    @FindBy(xpath = ".//*[contains(@class, 'Auth_link__1fOlj') and text()='Зарегистрироваться']")
    private WebElement buttonRegister;


    public AuthPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @Step("Загрузка страницы")
    public void waitForLoadAuthPage() {
        wait.until(ExpectedConditions.elementToBeClickable(fieldInlet));
    }

    @Step("Ввести значение в поле \"Email\"")
    public void inputEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(inputFieldEmail)).sendKeys(email);
    }

    @Step("Ввести значение в поле \"Password\"")
    public void inputPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(inputFieldPassword)).sendKeys(password);
    }

    @Step("Нажать кнопку \"Войти\"")
    public void clickInletButton() {
        wait.until(ExpectedConditions.visibilityOf(buttonInlet)).click();
    }

    @Step("Загрузка страницы и вывод текста")
    public String waitForLoadPageAndGetText() {
        wait.until(ExpectedConditions.elementToBeClickable(fieldInlet));
        return fieldInlet.getText();
    }

    @Step("Нажать кнопку \"Зарегистрироваться\"")
    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonRegister)).click();
    }

    @Step("Нажать кнопку \"Восстановить пароль\"")
    public void clickRecoverPasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonRecoverPassword)).click();
    }


}
