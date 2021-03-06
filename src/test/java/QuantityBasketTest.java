import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class QuantityBasketTest {

    WebDriver driver;
    BasketPage basketPage;
    CakesPage cakesPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User01\\IdeaProjects\\test-selenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        basketPage = new BasketPage(driver);
        cakesPage = new CakesPage(driver);
        driver.get("http://bakehouse.by/product-category/cakes/");
    }

    @Test
    public void getNameOfGoodsInBasket() {

        cakesPage.clickInBasketButton();
        //add cake to basket
        String text = basketPage.getNameInBasket();
        //get name of cake from basket
        Assert.assertEquals("Клубника-банан", text);
        //compare expected and actual results
    }
/*
    @Test
    public void getNameOfGoodsInBasket() {
        driver.get("http://bakehouse.by/product-category/cakes/");
        cakesPage.clickInBasketButton();
        //add cake to basket
        driver.get("https://bakehouse.by/cart/");
        String text = basketPage.getNameInBasket();
        //get name of cake from basket
        Assert.assertEquals("Клубника-банан", text);
        //compare expected and actual results
    }
*/
    @After
    public void tearDown() {
        driver.quit();
    }
}
