package com.KaanCaseForAPPSmart.pages;

import com.KaanCaseForAPPSmart.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class AngebotePage extends BasePage{

    /**
     * Locators
     */
    @FindBy(xpath = "//button[@class='button-order positive-action']")
    public WebElement popupNextStepBtn;

    @FindBy(xpath = "(//i[@class='hover-layer fas fa-shopping-cart'])[1]")
    public WebElement sparmenü1Btn;

    @FindBy(xpath = "(//i[@class='hover-layer fas fa-shopping-cart'])[2]")
    public WebElement sparmenü2Btn;

    @FindBy(xpath = "(//i[@class='hover-layer fas fa-shopping-cart'])[3]")
    public WebElement longRanchMasterMenüBtn;

    @FindBy(xpath = "(//i[@class='hover-layer fas fa-shopping-cart'])[4]")
    public WebElement pizzaFür2Sparmenü1Btn;

    @FindBy(xpath = "(//i[@class='hover-layer fas fa-shopping-cart'])[5]")
    public WebElement pizzaFür2Sparmenü2Btn;

    @FindBy(xpath = "(//i[@class='hover-layer fas fa-shopping-cart'])[6]")
    public WebElement kiddyBoxBurger;

    @FindBy(xpath = "//div[contains(text(),'Pommes + Coca Cola')]")
    public WebElement pommesAndCocaColaBtn;

    @FindBy(xpath = "//div[contains(text(),'Pommes + Cola light')]")
    public WebElement pommesAndColaLightBtn;

    @FindBy(xpath = "//div[@class='product-name']")
    public WebElement prodcutName;

    /**
     *  We are using the following method to make the food selection dynamic
     * Author:Kaan Uzun
     */
    public void selectFood(String foodName){
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        switch (foodName.toLowerCase()) {
            case "sparmenü 1":
                sparmenü1Btn.click();
                break;
            case "sparmenü 2":
                sparmenü2Btn.click();
                break;
            case "long ranch-master menu":
                longRanchMasterMenüBtn.click();
                break;
            case "long ranch master menu":
                longRanchMasterMenüBtn.click();
                break;
            case "pizza für 2 sparmenü 1":
                pizzaFür2Sparmenü1Btn.click();
                break;
            case "pizza für 2 sparmenü 2":
                pizzaFür2Sparmenü2Btn.click();
                break;
            case "kiddy-box burger":
                kiddyBoxBurger.click();
                break;
            case "kiddy box burger":
                kiddyBoxBurger.click();
                break;
        }
    }

    /**
     *  We are using the following method to make the Angebote page menus burger selection dynamic
     * Author:Kaan Uzun
     */
    public void selectBurger(String item) {
        String name;
        for (int i = 1; i < 13; i++){
            name = Driver.get().findElement(By.xpath("(//div[@class='product-name'])["+i+"]")).getText().toLowerCase();

            if (item.toLowerCase().equals(name)){
                Driver.get().findElement(By.xpath("(//button[@class='button-accent'])["+i+"]")).click();
            }
        }

    }

    /**
     *  We are using the following method to make the Angebote page menus extra order selection dynamic
     * Author:Kaan Uzun
     */
    public void selectExtraOption(String item) {
        beilageAufWunschBtn.click();
        WebElement extraOrder = Driver.get().findElement(By.xpath("//div[contains(text(),'"+item+"')]"));
        Driver.get().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        extraOrder.click();
    }

    /**
     *  We are using the following method to make the Angebote page menus bier selection dynamic
     * Author:Kaan Uzun
     */
    public void selectBier(String bier){
        WebElement bierName = Driver.get().findElement(By.xpath("//div[contains(text(),'"+bier+"')]"));
        String name;

        for (int i = 1; i < 4; i++){
            name = bierName.getText().toLowerCase();

            if (bier.toLowerCase().equals(name)){
                Driver.get().findElement(By.xpath("(//button[@class='button-accent'])["+i+"]")).click();
            }
        }
    }

}
