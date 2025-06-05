import POJO.User;
import POJO.UserAuthResponse;
import POJO.UserRegisterResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenerateTestData {

    private WebDriver driver;
    private WebDriverWait wait;
    private String accessToken;

    public GenerateTestData(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @Step("Авторизация и запись токена")
    public void authUserAndGetToken() {
        User user = new User("new89Email@yandex.ru", "password");
        AuthUser loginUser = new AuthUser(user);
        Response response = loginUser.authUser();
        accessToken = response.as(UserAuthResponse.class).getAccessToken();
    }

    @Step("Регистрация и запись токена")
    public void registerUserAndGetToken() {
        User user = new User("new89Email@yandex.ru", "password","Test");
        RegisterUser registerUser = new RegisterUser(user);
        Response response = registerUser.registerUser();
        accessToken = response.as(UserRegisterResponse.class).getAccessToken();
    }

    @Step("Удаление учетной записи")
    public void deleteUser() {
        if (accessToken != null) {
            DeleteUser deleteUser = new DeleteUser();
            deleteUser.deleteUser(accessToken);
        }
    }
}
