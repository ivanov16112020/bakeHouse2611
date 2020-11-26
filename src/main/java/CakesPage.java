import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CakesPage {
    private WebDriver driver;

    public CakesPage(WebDriver driver) {
        this.driver = driver;
    }

    public By InBasketButton = By.xpath("//li[contains(@class, 'post-8747')]//a[@class=\"button product_type_simple add_to_cart_button ajax_add_to_cart\"]");
    //find button 'in basket' for strawberry-banana-cake
    public By textAboutBasket = By.xpath("//div[@role=\"alert\"]/text()[2]");
    //find text about adding goods in basket

    public CakesPage clickInBasketButton() {
        driver.findElement(InBasketButton).click();
        //add cake to basket
        return new CakesPage(driver);
        //add strawberry-banana-cake to basket and get text about basket
    }


    public String getTextAboutBasket() {

        driver.findElement(InBasketButton).click();
        //add cake to basket
        WebElement fieldWithText = driver.findElement(textAboutBasket);
        String text = ((JavascriptExecutor)driver).executeScript("return arguments[0].lastChild.textContent;", fieldWithText).toString();
        //String text = driver.findElement(textAboutBasket).getText();
        return text;
        //find text about adding goods in basket
    }


}
