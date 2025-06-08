package POM;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // список локаторов для страницы личного кабинета:

    // локатор для кнопки "Профиль"
    @FindBy(xpath = ".//a[(text()='Профиль')]")
    private WebElement buttonProfile;

    // локатор для кнопки "Конструктор"
    @FindBy(xpath = ".//p[(text()='Конструктор')]")
    private WebElement buttonConstructor;

    // локатор для логотипа "Stellar Burgers"
    @FindBy(xpath = "(//*[(local-name()='svg' and namespace-uri()='http://www.w3.org/2000/svg')])[3]")
    private WebElement buttonStellarBurgers;

    // локатор для кнопки "Выход"
    @FindBy(xpath = ".//button[(text()='Выход')]")
    private WebElement buttonExit;

    public PersonalAccountPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @Step("Загрузка страницы")
    public void waitForLoadPersonalAccountPage() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonProfile));
    }

    @Step("Получить текст")
    public String getProfileText() {
        WebElement profileText = wait.until(ExpectedConditions.elementToBeClickable(buttonProfile));
        return profileText.getText();
    }

    @Step("Нажать кнопку \"Конструктор\"")
    public void clickConstructorButton() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonConstructor)).click();
    }

    @Step("Нажать кнопку \"Stellar Burgers\"")
    public void clickStellarBurgersButton() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonStellarBurgers)).click();
    }

    @Step("Нажать кнопку \"Выход\"")
    public void clickExitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonExit)).click();
    }
}
