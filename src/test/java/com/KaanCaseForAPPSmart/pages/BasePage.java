package com.KaanCaseForAPPSmart.pages;

import com.KaanCaseForAPPSmart.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePage {
    /**
     * Constructor to initialize Driver
     */
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    /**
     * Locators
     */

    @FindBy(xpath = "//button[@class='button-order positive-action']")
    public WebElement extraOrderConfirmBtn;

    @FindBy(xpath = "//div[@class='button-standard']")
    public WebElement extraOrderCancelBtn;

    @FindBy(className = "Select2_container__U8PBg")
    public WebElement postalCodeBtn;

    @FindBy(xpath = "//div[contains(text(),'Beilage auf Wunsch')]")
    public WebElement beilageAufWunschBtn;

    @FindBy(xpath = "//div[@class='icon-wrapper']/div[2]")
    public WebElement emptyShoppingCartMessage;



    /**
     * Methods
     */

    /**
     * We are using the following method to make the category selection dynamic
     * Author:Kaan Uzun
     */
    public void selectCategory(String category){

        switch (category.toLowerCase()) {
            case "angebote":
                HomePage.angebotePageButton.click();
                break;
            case "burger":
                HomePage.burgerPageButton.click();
                break;
        }
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * We are selecting postal code address in popup with below method dynamically
     * Author:Kaan Uzun
     */
    public void selectAddress(String selectedAddress){

        postalCodeBtn.click();
        String xpath = "//li[.='"+selectedAddress+"']";
        //Selecting postal code address element click
        Driver.get().findElement(By.xpath(xpath)).click();
        //Confirm button click
        Driver.get().findElement(By.xpath("//button[@type='submit']")).click();

    }

    /**
     * We are using the following method to make dynamic how many times
     * we click which item and which button(plus or minus) on shopping cart
     * Author:Kaan Uzun
     */
    public void decOrIncCartItem(int number, String buttonType,String itemType){

        // To make dynamic in shopping cart plus button xpath we are using following String
        String xpathPlusBtn = "//div[text()='"+itemType+"']/../following-sibling::div[1]/div[1]/div[2]";
        // To make dynamic in shopping cart minus button xpath we are using following String
        String xpathMinusBtn = "//div[text()='"+itemType+"']/../following-sibling::div[1]/div[1]/i";

        if (buttonType.equalsIgnoreCase("plus")){
            for (int i = 0; i<number ; i++){
                Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                Driver.get().findElement(By.xpath(xpathPlusBtn)).click();
            }
        }else if (buttonType.equalsIgnoreCase("minus")){
            for (int i = 0; i<number ; i++){
                Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                Driver.get().findElement(By.xpath(xpathMinusBtn)).click();
            }
        }
    }

    /**
     * We are using the following method to make dynamic extra order popup button selection
     * Author:Kaan Uzun
     */
    public void extraOrderPopupButtonSelection(String selectedButton){

        switch (selectedButton.toLowerCase()) {
            case "confirm":
                extraOrderConfirmBtn.click();
                break;
            case "cancel":
                extraOrderCancelBtn.click();
                break;
            case "next step":
                extraOrderConfirmBtn.click();
                break;
        }
    }
    /**
     * We are using the following method to calculate what we added
     * Author:Kaan Uzun
     */
    public int addedItemTotalCalculator(){
        int total = 0;
        if (Driver.get().findElement(By.xpath("//div[text()='Cheeseburger']")).isDisplayed()){
            String stringAmount = Driver.get().findElement(By.xpath("//div[text()='Cheeseburger']/../following-sibling::div/div/div[1]/div")).getText();
            int intAmounts = Integer.parseInt(stringAmount);
            String stringPrice = Driver.get().findElement(By.xpath("//div[text()='Cheeseburger']/../../../div[3]/div[2]")).getText();
            String[] divededPrice = stringPrice.split(" ");
        }
        return total;
    }

}
