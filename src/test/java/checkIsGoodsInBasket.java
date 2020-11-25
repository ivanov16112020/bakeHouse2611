import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class checkIsGoodsInBasket {

    private WebDriver driver;
    private CakesPage cakesPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User01\\IdeaProjects\\test-selenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        cakesPage = new CakesPage(driver);
        driver.get("http://bakehouse.by/product-category/cakes");
    }

    @Test
    public void checkGoods() {

        String newCakesPage = cakesPage.getTextAboutBasket();
        Assert.assertEquals("Вы отложили “Клубника-банан” в свою корзину.", newCakesPage);
    }
/*
    @Test
    public void getHeadingTest() {
        String sp = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub", sp);
    }
*/
    @After
        public void tearDown() {
            driver.quit();
    }
}
