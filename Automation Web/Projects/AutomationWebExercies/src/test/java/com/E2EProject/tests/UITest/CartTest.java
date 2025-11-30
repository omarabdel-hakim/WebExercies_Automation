package com.E2EProject.tests.UITest;

import com.E2EProject.Drivers.GUIDriver;
import com.E2EProject.Drivers.UITest;
import com.E2EProject.Pages.ProductsPage;
import com.E2EProject.Pages.components.NavigationBarComponent;
import com.E2EProject.tests.BaseTest;
import com.E2EProject.Utils.dataReader.JsonReader;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Cart Management")
@Feature("UI Cart Details")
@Story("Cart Details")
@Severity(SeverityLevel.CRITICAL)
@Owner("Ashraf")
@UITest
public class CartTest extends BaseTest {


    @Test
    public void verifyProductDetailsOnCartWithoutLogin() {
        new ProductsPage(driver)
                .navigate()
                .clickOnAddToCart(testData.getJsonData("product.name"))
                .validateItemAddedLabel(testData.getJsonData("messages.cartAdded"))
                .clickOnViewCart()
                .verifyProductDetailsOnCart(
                        testData.getJsonData("product.name"),
                        testData.getJsonData("product.price"),
                        testData.getJsonData("product.quantity"),
                        testData.getJsonData("product.total")
                );
    }

    //Configurations
    @BeforeClass
    protected void preCondition() {
        testData = new JsonReader("cart-data");
    }
    @BeforeMethod
    public void setUp() {
        driver = new GUIDriver();
        new NavigationBarComponent(driver).navigate();
        driver.browser().closeExtensionTab();
    }

    @AfterMethod
    public void tearDown() {
        driver.quitDriver();
    }
}
