package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LaptopsPage extends BasePage {

    @FindBy(xpath = "//div[@class='sidebar-block__inner ng-star-inserted']//input[@class='sidebar-search__input ng-untouched ng-pristine ng-valid']")
    private WebElement brandFilterInput;

    @FindBy(xpath = "//ul[@class='checkbox-filter ng-star-inserted'][2]//li//a")
    private List<WebElement> brandCheckboxList;

    @FindBy(xpath = "//button[@aria-label='Купить']")
    private List<WebElement> buyButtonListOfProducts;

    @FindBy(xpath = "//ul[@class='checkbox-filter ng-star-inserted'][2]//li//a//input[@id='Acer']/..")
    private WebElement acerCheckbox;

    public LaptopsPage(WebDriver driver) {
        super(driver);
    }

    public void useBrandFilterInput(String keyword) {
        brandFilterInput.clear();
        brandFilterInput.sendKeys(keyword, Keys.ENTER);
    }

    public void selectFilteredBrand() {
        brandCheckboxList.get(0).click();
    }

    public void buyFirstProductFromList() {
        buyButtonListOfProducts.get(0).click();
    }

    public WebElement getAcerCheckbox() {
        return acerCheckbox;
    }
}
