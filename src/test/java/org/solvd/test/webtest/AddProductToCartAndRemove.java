package org.solvd.test.webtest;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.common.CommonUtils;
import org.solvd.web.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToCartAndRemove extends AbstractTest {

    @Test
    public void addProductToCartAndRemove() {
        getDriver().manage().window().maximize();
        HomePage homePage = new HomePage(getDriver());
        homePage.openHomePage();
        CatalogPage catalogPage = homePage.catalogPage();
        ProductPage productPage = catalogPage.chooseProduct("Black heels");
        CartPage cartPage = productPage.addProductCart();
        cartPage.openCartPage();
        cartPage.removeProduct();
        SearchProductResultPage searchProductResultPage = new SearchProductResultPage(getDriver());
        CommonUtils.pause(2);
        Assert.assertTrue(cartPage.isCartEmpty());
    }
}
