package org.solvd.test.webtest;

import com.zebrunner.carina.core.AbstractTest;
import org.solvd.web.CartPage;
import org.solvd.web.CatalogPage;
import org.solvd.web.HomePage;
import org.solvd.web.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductInCart extends AbstractTest {

    @Test
    public void addProductToCartTest() {
        getDriver().manage().window().maximize();
        HomePage homePage = new HomePage(getDriver());
        homePage.openHomePage();
        CatalogPage catalogPage = homePage.catalogPage();
        ProductPage productPage = catalogPage.goToproductPage();
        productPage = productPage.chooseProduct("Black heels");
        CartPage cartPage = productPage.addProductCart();
        cartPage.openCartPage();
        Assert.assertTrue(cartPage.isProductInCart("Black heels"), "Product is not in the cart");
    }

}
