package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CustomizedMethod extends MethodAbstract{

    public WebDriverWait wait=new WebDriverWait(driver,30);

    public CustomizedMethod(WebDriver driver){
        super(driver);
    }


    //overriding concept are use beasue of i am giving hear body definition to the abstract method hear for achieving polymorphism


    @Override
    public void sendKeys(WebElement element,String value){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    @Override
    public void click(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Override
    public void clickProduct(WebElement element,String value){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Override
    public String getText(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
        String text=element.getText();
        return text;
    }



}
