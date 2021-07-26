package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    @FindBy(xpath = "//input[@class='search-form__input ng-untouched ng-pristine ng-valid']")
    private WebElement searchInput;

    @FindBy(xpath = "//li[@class='header-actions__item header-actions__item--cart']")
    private WebElement productCart;

    @FindBy(xpath = "//div[@class='modal__holder modal__holder_show_animation modal__holder--large']")
    private WebElement cartDiv;

    @FindBy(xpath = "//div[@class='cart-receipt ng-star-inserted']//div[@class='cart-receipt__sum-price']//span[1]")
    private WebElement spanWithSumInCart;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(String keyword) {
        searchInput.clear();
        searchInput.sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnCart() {
        productCart.click();
    }

    public WebElement getCartDiv() {
        return cartDiv;
    }

    public int getSumOfProductsInCart() {
        return Integer.parseInt(spanWithSumInCart.getText());
    }
}
