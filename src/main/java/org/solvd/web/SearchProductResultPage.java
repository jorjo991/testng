package org.solvd.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.solvd.web.components.ProductCart;

import java.util.List;

public class SearchProductResultPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='page-content']")
    private List<ExtendedWebElement> products;

    public SearchProductResultPage(WebDriver driver) {
        super(driver);
    }

    public List<ProductCart> getProducts() {
        return products.stream().
                map(root -> new ProductCart(getDriver(), root.getElement())).
                toList();
    }

    public boolean isProductPresent(String productName) {
        return getProducts().stream().
                anyMatch(productCart -> productCart.getTitle().toLowerCase().contains(productName.toLowerCase()));
    }

}
