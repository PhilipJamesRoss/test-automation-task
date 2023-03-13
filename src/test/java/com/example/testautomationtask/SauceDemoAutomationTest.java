package com.example.testautomationtask;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SauceDemoAutomationTest {
    private WebDriver driver;
    private SauceDemoPageElements sauceDemoPageElements;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/utils/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        sauceDemoPageElements = new SauceDemoPageElements(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    //Automation task
    @Test
    public void addHighestSauceItemToCart() {
        //1. Navigate to the following URL https://www.saucedemo.com/
        driver.get(" https://www.saucedemo.com/");

        //2. Login using the following details(username: standard_user, Password: secret_sauce)
        sauceDemoPageElements.usernameField.sendKeys("standard_user");
        sauceDemoPageElements.passwordField.sendKeys("secret_sauce");
        sauceDemoPageElements.loginButton.click();
        assertTrue(sauceDemoPageElements.backPackAddToCart.isDisplayed());

        //3. Select the highest price item (Please do not use the “Sort By” option on the page).
        // Find the price for all items on the page and convert to type double
        double backPackPrice = Double.parseDouble(sauceDemoPageElements.itemPrices.get(0).getText().substring(1));
        double bikeLightPrice = Double.parseDouble(sauceDemoPageElements.itemPrices.get(1).getText().substring(1));
        double boltTShirt = Double.parseDouble(sauceDemoPageElements.itemPrices.get(2).getText().substring(1));
        double fleeceJacketPrice = Double.parseDouble(sauceDemoPageElements.itemPrices.get(3).getText().substring(1));
        double onsiePrice = Double.parseDouble(sauceDemoPageElements.itemPrices.get(4).getText().substring(1));
        double testAllTheThingsTShirt = Double.parseDouble(sauceDemoPageElements.itemPrices.get(5).getText().substring(1));
        // Create a list of the items prices
        List<Double> itemList = new ArrayList<>();
        itemList.add(backPackPrice);
        itemList.add(bikeLightPrice);
        itemList.add(boltTShirt);
        itemList.add(fleeceJacketPrice);
        itemList.add(onsiePrice);
        itemList.add(testAllTheThingsTShirt);
        // Find the highest priced item
        Double mostExpensiveItem = Collections.max(itemList);
        //4. Add the selected highest price item to the cart
        // Add the highest priced item to cart
        if (mostExpensiveItem == itemList.get(0).doubleValue()) {
            sauceDemoPageElements.backPackAddToCart.click();
        } else if (mostExpensiveItem == itemList.get(1).doubleValue()) {
            sauceDemoPageElements.bikeLightAddToCart.click();
        } else if (mostExpensiveItem == itemList.get(2).doubleValue()) {
            sauceDemoPageElements.boltTShirtAddToCart.click();
        } else if (mostExpensiveItem == itemList.get(3).doubleValue()) {
            sauceDemoPageElements.fleeceJacketAddToCart.click();
        } else if (mostExpensiveItem == itemList.get(4).doubleValue()) {
            sauceDemoPageElements.onesieAddToCart.click();
        } else
            sauceDemoPageElements.testAllTheThingsTShirtAddToCart.click();
    }
}
