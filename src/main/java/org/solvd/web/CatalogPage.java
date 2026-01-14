package org.solvd.web;


import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.solvd.web.components.Products;

import java.time.Duration;

public class CatalogPage extends AbstractPage {
    @FindBy(css = "section.product-grid")
    private ExtendedWebElement productGrid;

    @FindBy(css = "body")
    private Products products;
    private WebDriverWait webDriverWait;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage chooseProduct(String productName) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> !products.getProductCartList().isEmpty());
        products.chooseProduct(productName);
        return new ProductPage(driver);
    }

}
