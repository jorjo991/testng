package org.solvd.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCart extends AbstractUIObject {

    @FindBy(css = "h3")
    private ExtendedWebElement productCart;

    public ProductCart(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitle() {
        return productCart.getText();
    }

    public ExtendedWebElement getProductCart() {
        return productCart;
    }

    public void click() {
        productCart.click();
    }
}
