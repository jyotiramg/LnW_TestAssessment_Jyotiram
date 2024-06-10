package com.utility;

import java.io.FileInputStream;



import java.util.Properties;

import org.openqa.selenium.*;


import com.base.BaseClass;


public class Util extends BaseClass {
    static FileInputStream fis = null;


    public static byte[] takeScreenShot()
    {
        return ((TakesScreenshot) webDriver.get()).getScreenshotAs(OutputType.BYTES);
    }


    public static String readProperties(String key)
    {
        String path = System.getProperty("user.dir")+"/src/main/resources/config.properties";
        Properties prop= new Properties();
        try {
            fis=new FileInputStream(path);
            prop.load(fis);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }



}
