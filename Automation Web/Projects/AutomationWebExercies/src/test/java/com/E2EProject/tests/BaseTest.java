package com.E2EProject.tests;

import com.E2EProject.Drivers.GUIDriver;
import com.E2EProject.Drivers.WebDriverProvider;
import com.E2EProject.Utils.dataReader.JsonReader;
import org.openqa.selenium.WebDriver;

public class BaseTest implements WebDriverProvider {
    protected GUIDriver driver;
    protected JsonReader testData;





    @Override
    public WebDriver getWebDriver() {
        return driver.get();
    }
}
