package com.KaanCaseForAPPSmart.step_definitions;

import com.KaanCaseForAPPSmart.pages.AngebotePage;
import com.KaanCaseForAPPSmart.pages.BurgerPage;
import com.KaanCaseForAPPSmart.pages.HomePage;
import com.KaanCaseForAPPSmart.utilities.BrowserUtils;
import com.KaanCaseForAPPSmart.utilities.ConfigurationReader;
import com.KaanCaseForAPPSmart.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class UIStepDefinitions {

    HomePage homePage = new HomePage();
    BurgerPage burgerPage = new BurgerPage();
    AngebotePage angebotePage = new AngebotePage();
    static String categoryName;

    @Given("User navigates to the {string} website")
    public void user_navigates_to_the_website(String URL) {
        Driver.get().get(ConfigurationReader.get(URL));
    }

    @When("User clicks {string} category")
    public void user_clicks_category(String categoryName) {
        this.categoryName = categoryName;
        homePage.selectCategory(categoryName);
    }

    @When("User adds {string}")
    public void user_add(String foodType) {
        if (categoryName.toLowerCase().equals("burger")){
            burgerPage.selectFood(foodType);
        }else if (categoryName.toLowerCase().equals("angebote")){
            angebotePage.selectFood(foodType);
        }

    }

    @When("User select {string}")
    public void user_select(String address) {
        burgerPage.selectAddress(address);
    }

    @When("User clicks {string} in extra order popup")
    public void user_clicks_in_extra_order_popup(String buttonSelection) {
        burgerPage.extraOrderPopupButtonSelection(buttonSelection);
    }

    @When("User clicks {int} times {string} in {string}")
    public void user_clicks_times_in(Integer times, String minusOrPlusBtn, String addedItem) {
        burgerPage.decOrIncCartItem(times,minusOrPlusBtn,addedItem);
    }

    @Then("User added item total and shopping cart subtotal should match")
    public void user_added_item_total_and_shopping_cart_subtotal_should_match() {
        BrowserUtils.waitFor(3);
        burgerPage.addedItemTotalCalculator();
    }
    @When("User selects {string} and clicks {string} button")
    public void user_selects_and_clicks_button(String selectedItem, String button) {
        angebotePage.selectBurger(selectedItem);
        angebotePage.extraOrderPopupButtonSelection(button);
    }

    @When("User adds {string} and clicks {string}")
    public void user_adds_and_clicks(String extraOption, String button) {
        angebotePage.selectExtraOption(extraOption);
        angebotePage.extraOrderPopupButtonSelection(button);
    }

    @When("User selects {string} and clicks  {string}")
    public void user_selects_and_clicks(String bier, String button) {
        angebotePage.selectBier(bier);
        angebotePage.extraOrderPopupButtonSelection(button);
    }

    @When("User deletes {string} on shopping cart")
    public void user_delete_on_shopping_cart(String item) {
        angebotePage.decOrIncCartItem(1,"minus",item);
        Driver.get().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("User should see {string} message on shopping cart")
    public void user_should_see_message_on_shopping_cart(String string) {
        BrowserUtils.waitFor(3);
        Assert.assertTrue(angebotePage.emptyShoppingCartMessage.isDisplayed());
    }

}
