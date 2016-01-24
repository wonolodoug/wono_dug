package com.wonolo.app.Wonolo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Doug on 1/23/2016.
 */

public class WonoloDriver {

    public WebDriver driver;

    public WebDriver driver() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
