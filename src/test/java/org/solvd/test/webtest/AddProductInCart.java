package org.solvd.test.webtest;

import com.zebrunner.carina.core.AbstractTest;
import org.solvd.web.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductInCart extends AbstractTest {

    @Test
    public void addProductToCartTest() {
        getDriver().manage().window().maximize();
        HomePage homePage = new HomePage(getDriver());
        homePage.openHomePage();
        CatalogPage catalogPage = homePage.catalogPage();
        ProductPage productPage = catalogPage.chooseProduct("Black heels");
        CartPage cartPage = productPage.addProductCart();
        cartPage.openCartPage();
        SearchProductResultPage searchProductResultPage = new SearchProductResultPage(getDriver());
        Assert.assertTrue(searchProductResultPage.isProductPresent("Black heels"));
    }

}
