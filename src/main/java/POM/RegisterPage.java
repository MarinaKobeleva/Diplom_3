package POM;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // список локаторов для страницы регистрации:
    // локатор для поля "Имя"
    @FindBy(xpath = ".//fieldset[contains(@class,'Auth_fieldset__1QzWN mb-6')]//input[(@name='name')]")
    private WebElement fieldName;

    // локатор для поля "Email"
    @FindBy(xpath = ".//fieldset[contains(@class,'Auth_fieldset__1QzWN mb-6')]/following::input[(@name='name')]")
    private WebElement fieldEmail;

    // локатор для поля "Пароль"
    @FindBy(xpath = ".//fieldset[contains(@class,'Auth_fieldset__1QzWN mb-6')]//input[(@name='Пароль')]")
    private WebElement fieldPassword;

    // локатор для кнопки "Зарегистрироваться"
    @FindBy(xpath = ".//button[contains(@class, 'button_button__33qZ0') and text()='Зарегистрироваться']")
    private WebElement buttonRegister;

    // локатор для кнопки "Войти"
    @FindBy(xpath = ".//a[(text()='Войти')]")
    private WebElement buttonInlet;

    // локатор текста ошибки "Некорректный пароль"
    @FindBy(xpath = ".//*[contains(@class, 'input__error') and text()='Некорректный пароль']")
    private WebElement errorTextIncorrectPassword;

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


    @Step("Загрузка страницы")
    public void waitForLoadRegisterPage() {
        wait.until(ExpectedConditions.elementToBeClickable(fieldName));
    }

    @Step("Ввести значение в поле \"Name\"")
    public void inputName(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(fieldName)).sendKeys(name);
    }

    @Step("Ввести значение в поле \"Email\"")
    public void inputEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(fieldEmail)).sendKeys(email);
    }

    @Step("Ввести значение в поле \"Password\"")
    public void inputPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(fieldPassword)).sendKeys(password);
    }

    @Step("Нажать кнопку \"Зарегистрироваться\"")
    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonRegister)).click();
    }

    @Step("Нажать кнопку \"Войти\"")
    public void clickInletButton() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonInlet)).click();
    }

    @Step("Получить текст ошибки")
    public String getErrorText() {
        WebElement errorText = wait.until(ExpectedConditions.elementToBeClickable(errorTextIncorrectPassword));
        return errorText.getText();
    }
}
