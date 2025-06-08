package POM;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecoverPasswordPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // список локаторов для страницы восстановления пароля:

    // локатор для кнопки "Войти"
    @FindBy(xpath = ".//a[(text()='Войти')]")
    private WebElement buttonInlet;

    public RecoverPasswordPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @Step("Нажать кнопку \"Войти\"")
    public void clickInletButton() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonInlet)).click();
    }
}
