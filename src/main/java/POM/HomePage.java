package POM;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // список локаторов для домашней страницы:
    // локатор для кнопки "Войти в аккаунт"
    @FindBy(xpath = ".//button[contains(@class, 'button_button__33qZ0') and text()='Войти в аккаунт']")
    private WebElement buttonLoginToAccount;

    // локатор для кнопки "Оформить заказ"
    @FindBy(xpath = ".//button[(text()='Оформить заказ')]")
    private WebElement buttonCreateOrder;

    // локатор для кнопки "Булки"
    @FindBy(xpath = ".//span[(text()='Булки')]")
    private WebElement buttonBuns;

    // локатор для нажатой кнопки "Булки"
    @FindBy(xpath = ".//div[contains(@class,'tab_tab_type_current__2BEPc')]/span[(text()='Булки')]")
    private WebElement buttonNameBuns;

    // локатор для кнопки "Соусы"
    @FindBy(xpath = ".//span[(text()='Соусы')]")
    private WebElement buttonSous;

    // локатор для нажатой кнопки "Соусы"
    @FindBy(xpath = ".//div[contains(@class,'tab_tab_type_current__2BEPc')]/span[(text()='Соусы')]")
    private WebElement buttonNameSous;

    // локатор для кнопки "Начинки"
    @FindBy(xpath = ".//span[(text()='Начинки')]")
    private WebElement buttonFillings;

    // локатор для нажатой кнопки "Начинки"
    @FindBy(xpath = ".//div[contains(@class,'tab_tab_type_current__2BEPc')]/span[(text()='Начинки')]")
    private WebElement buttonNameFillings;

    // локатор для кнопки "Личный кабинет"
    @FindBy(xpath = ".//p[(text()='Личный Кабинет')]")
    private WebElement buttonPersonalAccount;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @Step("Загрузка страницы")
    public void waitForLoadHomePage() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonBuns));
    }

    @Step("Нажать кнопку \"Войти в аккаунт\"")
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonLoginToAccount)).click();
    }

    @Step("Нажать кнопку \"Личный Кабинет\"")
    public void clickPersonalAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonPersonalAccount)).click();
    }

    @Step("Получить текст кнопки \"Оформить заказ\"")
    public String getTextCreateOrder() {
        WebElement textCreateOrder = wait.until(ExpectedConditions.elementToBeClickable(buttonCreateOrder));
        return textCreateOrder.getText();
    }

    @Step("Получить текст кнопки \"Булки\"")
    public String getTextBuns() {
        WebElement textBuns = wait.until(ExpectedConditions.elementToBeClickable(buttonBuns));
        return textBuns.getText();
    }

    @Step("Нажать кнопку \"Булки\"")
    public void clickBunsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonBuns)).click();
    }

    @Step("Получить текст - \"Булки\"")
    public String getNameBans() {
        wait.until(ExpectedConditions.visibilityOf(buttonNameBuns));
        return wait.until(ExpectedConditions.elementToBeClickable(buttonNameBuns)).getText();
    }

    @Step("Нажать кнопку \"Соусы\"")
    public void clickSousButton() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonSous)).click();
    }

    @Step("Получить текст - \"Соусы\"")
    public String getNameSous() {
        wait.until(ExpectedConditions.visibilityOf(buttonNameSous));
        return wait.until(ExpectedConditions.elementToBeClickable(buttonNameSous)).getText();
    }


    @Step("Нажать кнопку \"Начинки\"")
    public void clickFillingsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonFillings)).click();
    }

    @Step("Получить текст = \"Начинки\"")
    public String getNameFillings() {
        wait.until(ExpectedConditions.visibilityOf(buttonNameFillings));
        return wait.until(ExpectedConditions.elementToBeClickable(buttonNameFillings)).getText();
    }



}
