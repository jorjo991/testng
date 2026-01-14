package org.solvd.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Products extends AbstractUIObject {

    @FindBy(css = "section.product-grid > div.four.columns")
    private List<ExtendedWebElement> productCartList;

    public Products(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void chooseProduct(String productName) {
        productCartList.stream().
                map(product -> new ProductCart(getDriver(), product.getElement())).
                filter(card -> card.getTitle().contains(productName)).
                findFirst().
                orElseThrow(() -> new AssertionError("Product was not found")).
                click();
    }

    public List<ExtendedWebElement> getProductCartList() {
        return productCartList;
    }
}
