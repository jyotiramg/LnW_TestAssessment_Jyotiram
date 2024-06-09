package com.utility;

import com.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class MethodAbstract extends BaseClass {

    public WebDriver driver=webDriver.get();

    public MethodAbstract(WebDriver driver){
        this.driver=driver;
    }



    //I am creating abstract method for achieving abstraction with the help of customize method class

    //public abstract void sendKeys(WebElement element);
    public abstract void sendKeys(WebElement element, String value);

    public abstract void click (WebElement element);

    public abstract String getText(WebElement element);

    public abstract void clickProduct(WebElement element, String value);
}
