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
    private WebDriverWait webDriverWait;

    protected ProductPage(WebDriver driver) {
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
        ExtendedWebElement addProduct = productBody.findExtendedWebElement(By.xpath("//input[@id='add']"));
        addProduct.scrollTo();
        addProduct.click();
        webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        webDriverWait.until(driver -> {
            String text = findExtendedWebElement(By.xpath("//span[@id='cart-target-desktop']//span")).
                    getText();
            int count = Integer.parseInt(text.replaceAll("[^0-9]", ""));
            return count > 0;
        });
        return new CartPage(driver);
    }

    public ExtendedWebElement getProductBody() {
        return productBody;
    }

}
