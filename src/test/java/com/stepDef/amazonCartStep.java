package com.stepDef;

import com.base.BaseClass;
import com.page.amazonCartPage;
import com.utility.Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class amazonCartStep extends BaseClass {

    amazonCartPage amazoncartpage= new amazonCartPage();


    @When("^user launch application$")
    public void launchApp(){
        openPage(Util.readProperties("url"));
    }

    @When("^user Search the \"([^\"]*)\" and press enter$")
    public void userSearchTheAndPressEnter(String products) {
        this.amazoncartpage.searchproducts(products);
        this.amazoncartpage.clickEnter();
    }

    @And("^user select the item in the list as per \"([^\"]*)\" and clicking on Add to Cart$")
    public void userSelectTheItemInTheListAsPer(String Position) {
        String actualPosition = mapPosition(Position);
        this.amazoncartpage.selectproductPositionfromList(actualPosition);

    }

    @And("^user Open Cart from the top-left$")
    public void userOpenCartFromTheTopLeft() {
        this.amazoncartpage.openCarttopLeft();
    }

    @Then("^Verify that the price is identical to the product page$")
    public void verifyThatThePriceIsIdenticalToTheProductPage() {
        this.amazoncartpage.verifyPriceofProduct();
    }

    @And("^Verify that the sub total is identical to the product page$")
    public void verifyThatTheSubTotalIsIdenticalToTheProductPage() {
        this.amazoncartpage.verifysubTotalofProduct();
    }

    private String mapPosition(String position) {
        // Mapping logic: e.g., "1" -> "3", "2" -> "4"
        switch (position) {
            case "1":
                return "3";
            case "2":
                return "4";

            default:
                return position;
        }
    }
}
