import model.MainPageOnly;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class FooterMainPageTest {

    private WebDriver driver;
    private MainPageOnly mainPageOnly;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        mainPageOnly = new MainPageOnly(driver);
        mainPageOnly.openOnlyURL();
    }

    @Test
    public void findFooterStartProjectButton() {

        mainPageOnly.closeCookie();
        mainPageOnly.scrollToStartProjectFooterButton();
        mainPageOnly.clickStartProjectFooterButton();

        assertTrue("Анкета не открылась", mainPageOnly.isNameInputDisplayed());

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
