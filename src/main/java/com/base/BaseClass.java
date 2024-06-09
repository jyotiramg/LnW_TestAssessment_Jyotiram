package com.base;



import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.utility.Util;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;





public class BaseClass {

    public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public static WebDriver driver=null;

    private static Properties properties;

    public final static int TIMEOUT = 40;

    public static Logger log=Logger.getLogger(BaseClass.class);

    public static void launchDriver()
    {
        if(Util.readProperties("browser").equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
            driver = new ChromeDriver();

            log.info("::::Maximizing Window::::");
            driver.manage().window().maximize();


            log.info(":::::Applying Waits::::");
            driver.manage().timeouts().implicitlyWait(TIMEOUT,TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);

            webDriver.set(driver);

        }

    }

    public static void openPage(String url) {

        webDriver.get().get(url);

    }

    public static void tearDown()
    {
        log.info("::::Active Browser is close::::");

        webDriver.get().close();

        log.info("::::All Browser is quit::::");

        webDriver.get().quit();
    }


}
