package com.KaanCaseForAPPSmart.pages;

import com.KaanCaseForAPPSmart.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class BurgerPage extends BasePage{

    /**
     * Locators
     */

    @FindBy(xpath = "(//div[@data-testid='basket-button'])[1]")
    public WebElement hamburgerAddBtn;

    @FindBy(xpath = "(//div[@data-testid='basket-button'])[2]")
    public WebElement cheeseburgerAddBtn;

    @FindBy(xpath = "(//div[@data-testid='basket-button'])[3]")
    public WebElement rostiBurgerAddBtn;

    @FindBy(xpath = "(//div[@data-testid='basket-button'])[4]")
    public WebElement hotTortillaBurgerAddBtn;

    /**
     * Methods
     */

    /**
     *  We are using the following method to make the food selection dynamic
     * Author:Kaan Uzun
     */
    public void selectFood(String foodName){
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        switch (foodName.toLowerCase()) {
            case "hamburger":
                hamburgerAddBtn.click();
                break;
            case "cheeseburger":
                cheeseburgerAddBtn.click();
                break;
            case "rosti burger":
                rostiBurgerAddBtn.click();
                break;
            case "hot tortilla burger":
                hotTortillaBurgerAddBtn.click();
                break;
        }
    }
}

