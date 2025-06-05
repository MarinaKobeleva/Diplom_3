import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    public static WebDriver getWebDriver(String browserName) {

        switch (browserName.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:/Users/79171/Documents/chromedriver-win64-137/chromedriver.exe");
                return new ChromeDriver();
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "C:/Users/79171/Documents/chromedriver-win64-134/chromedriver.exe");

                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:/Users/79171/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
                return new ChromeDriver(options);
            default:
                throw new IllegalArgumentException("Браузер " + browserName + " не поддерживается");
        }
    }
}
