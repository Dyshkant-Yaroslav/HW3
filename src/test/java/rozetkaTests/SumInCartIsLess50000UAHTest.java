package rozetkaTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBException;

public class SumInCartIsLess50000UAHTest extends BaseTest{

    private final int DEFAULT_WAIT_TIME = 5000;

    @Test
    public void checkIfSumInCartIsLessThan50000UAH() throws JAXBException {
        getHomePage().waitForPageLoadComplete(DEFAULT_WAIT_TIME);
        getHomePage().searchByKeyword(useFilterData().getProductType());
        getHomePage().waitForPageLoadComplete(DEFAULT_WAIT_TIME);
        getLaptopPage().useBrandFilterInput(useFilterData().getBrand());
        getHomePage().waitVisibilityOfElement(DEFAULT_WAIT_TIME,getLaptopPage().getAcerCheckbox());
        getHomePage().waitForPageLoadComplete(DEFAULT_WAIT_TIME);
        getLaptopPage().selectFilteredBrand();
        getHomePage().waitForPageLoadComplete(DEFAULT_WAIT_TIME);
        getLaptopPage().buyFirstProductFromList();
        getHomePage().waitForPageLoadComplete(DEFAULT_WAIT_TIME);
        getHomePage().clickOnCart();
        getHomePage().waitForPageLoadComplete(DEFAULT_WAIT_TIME);
        getHomePage().waitVisibilityOfElement(DEFAULT_WAIT_TIME,getHomePage().getCartDiv());
        boolean isSumInCartLowerThanOneHundredThousands = true;
        if (getHomePage().getSumOfProductsInCart() >= useFilterData().getPriceBounds() || getHomePage().getSumOfProductsInCart() == 0) {
            isSumInCartLowerThanOneHundredThousands = false;
        }
        Assert.assertTrue(isSumInCartLowerThanOneHundredThousands);
    }

}
