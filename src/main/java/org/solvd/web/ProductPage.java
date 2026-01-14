package org.solvd.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.solvd.web.components.TopHeader;

import java.time.Duration;

public class ProductPage extends AbstractPage {

    @FindBy(css = "body")
    private ExtendedWebElement productBody;
    @FindBy(xpath = "//input[@id='add']")
    private ExtendedWebElement addToCart;
    @FindBy(xpath = "//span[@id='cart-target-desktop']")
    private ExtendedWebElement addedProductNumber;
    private WebDriverWait webDriverWait;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public TopHeader topHeader() {
        return new TopHeader(driver, productBody.getElement());
    }

    public ProductPage chooseProduct(String productName) {
        productBody.assertElementPresent();
        ExtendedWebElement productLink = productBody.findExtendedWebElement(By.xpath("//a[.//h3[text()='" + productName + "']]"));
        productLink.scrollTo();
        productLink.click();
        return new ProductPage(getDriver());
    }

    public CartPage addProductCart() {
        addToCart.scrollTo();
        addToCart.click();
        webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        webDriverWait.until(driver -> {
            String text = addedProductNumber.getText();
            int count = Integer.parseInt(text.replaceAll("[^0-9]", ""));
            return count > 0;
        });
        return new CartPage(driver);
    }

    public ExtendedWebElement getProductBody() {
        return productBody;
    }

}
