import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {

    private WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameOfGoodsInBasket = By.xpath("//a[text()='Клубника-банан']");
    //find field with quantity of goods at basket page

    public String getNameInBasket () {
        driver.get("https://bakehouse.by/cart/");
        return driver.findElement(nameOfGoodsInBasket).getText();
    }


}
