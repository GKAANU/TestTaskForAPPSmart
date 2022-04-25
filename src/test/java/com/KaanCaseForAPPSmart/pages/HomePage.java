package com.KaanCaseForAPPSmart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    /**
     * Locators
     */

    @FindBy(xpath = "//a[@class='category-wrapper pointer'][2]")
    public static WebElement burgerPageButton;

    @FindBy(xpath = "//a[@class='odd category-wrapper pointer active']")
    public static WebElement angebotePageButton;
}
