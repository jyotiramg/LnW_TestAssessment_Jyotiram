package com.page;

import com.base.BaseClass;
import com.pageObjectRepo.searchaddCartRepo;
import com.utility.CustomizedMethod;
import com.utility.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import static com.base.BaseClass.driver;

public class amazonCartPage extends searchaddCartRepo {


    public amazonCartPage() {
        PageFactory.initElements(BaseClass.webDriver.get(), this);
    }

    CustomizedMethod method= new CustomizedMethod(BaseClass.webDriver.get());

    public void searchproducts(String products) {
        try{
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            method.sendKeys(search_bar,products);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private String productPriceValue;
    private String productNamevalue;


    public void selectproductPositionfromList(String Position) {
        try{

            String productPositionXPath = "//div[contains(@data-cel-widget, 'search_result')][" + Position + "]";
            WebElement productPositionElement = driver.findElement(By.xpath(productPositionXPath));
            Util.scrollToElement(driver,productPositionElement);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String productprice = "//div[contains(@data-cel-widget, 'search_result')][" + Position + "]//span[contains(@class,'a-price-whole')]";
            WebElement productpricetext = driver.findElement(By.xpath(productprice));
            productPriceValue= productpricetext.getText().trim();
            System.out.println("product price :" +productPriceValue);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String productName = "//div[contains(@data-cel-widget, 'search_result')][" + Position + "]//span[contains(@class,'a-size-medium a-color-base a-text-normal')]";
            WebElement productNametext = driver.findElement(By.xpath(productName));
            productNamevalue= productNametext.getText();
            System.out.println("product Name :" +productNamevalue);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            addItemIntoCart(Position);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void addItemIntoCart(String position) {
        try {
            String productPositionXPath = "//div[contains(@data-cel-widget, 'search_result')][" + position + "]";
            WebElement productPositionElement = driver.findElement(By.xpath(productPositionXPath));
            Util.scrollToElement(driver, productPositionElement);
            WebDriverWait wait = new WebDriverWait(driver, 20);
            String addToCartXPath = "//div[contains(@data-cel-widget, 'search_result')][" + position + "]//button[contains(@class,'a-button-text')]";
            WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addToCartXPath)));
            addToCartBtn.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("User is able to add product to the cart");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void openCarttopLeft() {
        try{
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            method.click(cart);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public void verifyPriceofProduct() {
        try {
            String cartProductPrice = method.getText(cartproductprice).trim();
            String cartProductPriceValue=cartProductPrice.replaceAll("[^\\d.]", "").replaceAll("\\.00$", "");
            System.out.println("Raw Cart Product Price: " + cartProductPriceValue);

            if (cartProductPrice.isEmpty()) {
                fail("Unable to retrieve the price from the cart.");
            }
            String expectedProductPrice = productPriceValue.replaceAll("[^\\d.]", "").replaceAll("\\.00$", "");
            System.out.println("Cleaned Cart Product Price: " + cartProductPriceValue);
            System.out.println("Expected Product Page Price: " + expectedProductPrice);
            assertEquals("Price verification failed. Expected: " + expectedProductPrice + ", but found: " + cartProductPriceValue, expectedProductPrice, cartProductPriceValue);
            System.out.println("Price verification passed: " + cartProductPriceValue);
        } catch (Exception e) {
            e.printStackTrace();
            fail("An exception occurred during price verification: " + e.getMessage());
        }
    }



    public void verifysubTotalofProduct() {
        try {
            String subtotalValueText = method.getText(subtotalValue).trim();
            subtotalValueText = subtotalValueText.replaceAll("[^\\d.]", ""); // Remove non-numeric characters

            // Log the values for debugging
            System.out.println("Product Page Price: " + productPriceValue);
            System.out.println("Cart Subtotal Value: " + subtotalValueText);

            // Assert that the subtotal matches the product price
            assertEquals("Subtotal verification failed. Expected: " + productPriceValue + ", but found: " + subtotalValueText, productPriceValue, subtotalValueText);

            System.out.println("Subtotal verification passed: " + subtotalValueText);
        } catch (Exception e) {
            e.printStackTrace();
            fail("An exception occurred during subtotal verification: " + e.getMessage());
        }
    }


    public void clickEnter() {
        try{
            method.click(searchBtn);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
