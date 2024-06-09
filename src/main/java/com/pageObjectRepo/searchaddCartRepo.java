package com.pageObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchaddCartRepo {

    @FindBy(xpath = "//input[contains(@id,'twotabsearchtextbox')]")
    public WebElement search_bar;

    @FindBy(xpath = "//input[contains(@id,'nav-search-submit-button')]")
    public WebElement searchBtn;

    @FindBy(xpath = "//div[contains(@data-cel-widget, 'search_result')][%d]")
    public WebElement productPosition;

    @FindBy(xpath = "//div[contains(@data-cel-widget, 'search_result')][\" + Position + \"]//button[contains(text(),'Add to cart')]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[contains(@id,'nav-cart-count')]")
    public WebElement cart;

    @FindBy(xpath = "//div[contains(@data-cel-widget, 'search_result')][\" + Position + \"]")
    public  WebElement productPositionXPath;

    @FindBy(xpath = "(//span[contains(@class,'a-price')])[\" + Position + \"]")
    public WebElement productprice;

    @FindBy(xpath = "(//span[contains(@class,'a-size-medium a-color-base a-text-normal')])[\" + Position + \"]")
    public WebElement productName;

    @FindBy(xpath = "//span[contains(@class,'a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold')]")
    public WebElement cartproductprice;

    @FindBy(xpath = "(//span[contains(@class,'a-size-medium a-color-base sc-price sc-white-space-nowrap')])[1]")
    public WebElement subtotalValue;


}
