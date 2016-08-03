package com.antin.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by antin on 8/3/16.
 */
public class Driver {
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getFirefoxDriver() {
        if (null == driver) {
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
