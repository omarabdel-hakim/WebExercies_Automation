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

@Epic("Products Management")
@Feature("UI Product Details")
@Story("Product Details")
@Severity(SeverityLevel.CRITICAL)
@Owner("Ashraf")
@UITest
public class ProductDetailsTest extends BaseTest {

    @Test
    public void verifyProductDetailsTCWithoutLogin()
    {
        new ProductsPage(driver)
                .navigate()
                .clickOnViewProduct(testData.getJsonData("product.name"))
                .verifyProductDetails(testData.getJsonData("product.name"),testData.getJsonData("product.price"));
    }

    @Test
    public void verifyReviewMessageTCWithoutLogin()
    {
        new ProductsPage(driver)
                .navigate()
                .clickOnViewProduct(testData.getJsonData("product.name"))
                .addReview(testData.getJsonData("review.name"),testData.getJsonData("review.email"),testData.getJsonData("review.review"))
                .verifyReviewMsg(testData.getJsonData("messages.review"));
    }


    //Configurations
    @BeforeClass
    protected void preCondition() {
        testData = new JsonReader("product-details-data");
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
