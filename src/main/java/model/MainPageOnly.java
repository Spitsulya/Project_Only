package model;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static model.constants.Url.PAGE_URL;

public class MainPageOnly {
    private WebDriver driver;

    // локатор для кнопки закрытия Куки
    private static final By COOKIES_OKEY_BUTTON = By.xpath(".//button[contains(@class, 'Cookie_rootButton__38Z2N')]");
    // локатор для кнопки "Начать проект" (на футере)
    private static final By START_PROJECT_BUTTON = By.xpath(".//div[1]/button[contains(@class, 'StartProjectButton_root__jB_Lv')]");
    // локатор для плейсхолдера Имя
    private static final By INPUT_NAME = By.xpath(".//input[@placeholder='Имя*']");


    // конструктор класса Page Object
    public MainPageOnly(WebDriver driver) {
        this.driver = driver;
    }

    // Открывает сайт Only
    public void openOnlyURL() {
        driver.get(PAGE_URL);
    }
    // Закрывает куки
    public void closeCookie() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(COOKIES_OKEY_BUTTON));
            cookieButton.click();
        } catch (TimeoutException e) {
            System.out.println("Кнопка закрытия куки не была найдена или не стала кликабельной за отведенное время.");
        } catch (NoSuchElementException e) {
            System.out.println("Кнопка закрытия куки не найдена на странице.");
        } catch (Exception e) {
            System.out.println("Произошла ошибка при попытке закрыть куки: " + e.getMessage());
        }
    }
    // Находит кнопку "Начать проект" на футере
    public WebElement getStartProjectFooterButton() {
        return driver.findElement(START_PROJECT_BUTTON);
    }
    // Скроллит до кнопки "Начать проект" на футере
    public void scrollToStartProjectFooterButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", getStartProjectFooterButton());
    }
    // Кликает по кнопке "Начать проект" на футере
    public void clickStartProjectFooterButton() {
        getStartProjectFooterButton().click();
    }
    // Дожидается появления формы (инпут Имя)
    public boolean isNameInputDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_NAME));
            return button.isDisplayed();
        } catch (Exception e) {
            return false; // Если инпут не появился, возвращаем false
        }
    }
}
