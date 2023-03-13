package com.example.testautomationtask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public class SauceDemoPageElements {

    @FindBy(id = "user-name")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(className = "inventory_item_price")
    public List<WebElement> itemPrices;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement backPackAddToCart;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    public WebElement bikeLightAddToCart;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement boltTShirtAddToCart;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    public WebElement fleeceJacketAddToCart;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    public WebElement onesieAddToCart;

    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    public WebElement testAllTheThingsTShirtAddToCart;
    public SauceDemoPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
