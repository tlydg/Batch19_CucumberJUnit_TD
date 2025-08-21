package com.euroTech.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {

    private Driver() {
    }

    // InheritableThreadLocal  --> this is like a container, bag, pool.
    // in this pool we can have separate objects for each thread
    // for each thread, in InheritableThreadLocal we can have separate object for that thread
    // driver class will provide separate WebDriver object for each thread

    private static InheritableThreadLocal<WebDriver> driverPool= new InheritableThreadLocal<>();

    //  private static WebDriver driver;

    public static WebDriver get() {
        if (driverPool.get() == null) {
            //if we pass the driver from terminal then use that one
            //if we do not pass the driver from terminal then use the one properties file

            String browser = System.getProperty("browser") !=null ? browser = System.getProperty("browser"): ConfigurationReader.get("browser");

            switch (browser.toLowerCase()) {
                case "chrome":
                   driverPool.set(new ChromeDriver());
                    break;
                case "chrome-headless":
                    driverPool.set(new ChromeDriver(new ChromeOptions().addArguments("--headless")));
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    break;
                case "firefox-headless":
                    driverPool.set(new FirefoxDriver(new FirefoxOptions().addArguments("--headless")));
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS does not support Edge");
                    }
                    driverPool.set(new EdgeDriver());
                    break;
            }
        }
        return driverPool.get();
    }

    public static void closeDriver(){
        if(driverPool != null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }

}
