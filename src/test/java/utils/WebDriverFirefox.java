package utils;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFirefox {

    private static WebDriver driver;

    public static void startDriver() {
        if (driver == null){
            try {
                driver = new FirefoxDriver();

            }catch (IllegalStateException e) {
                System.out.println("ChromeDriver not found or system property not set: " + e.getMessage());
            } catch (SessionNotCreatedException e) {
                System.out.println("Version mismatch or failed to create a session: " + e.getMessage());
            } catch (WebDriverException e) {
                System.out.println("WebDriver error occurred: " + e.getMessage());
            }
        }
    }

    public static void startDriver(String url) {
        if (driver == null){
            try {
                driver = new FirefoxDriver();
                driver.get(url);

            }catch (IllegalStateException e) {
                System.out.println("ChromeDriver not found or system property not set: " + e.getMessage());
            } catch (SessionNotCreatedException e) {
                System.out.println("Version mismatch or failed to create a session: " + e.getMessage());
            } catch (WebDriverException e) {
                System.out.println("WebDriver error occurred: " + e.getMessage());
            }
        }
    }

    public static void startDriverHeadless() {

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless=new");

        if (driver == null){
            try {
                driver = new FirefoxDriver(options);


            }catch (IllegalStateException e) {
                System.out.println("ChromeDriver not found or system property not set: " + e.getMessage());
            } catch (SessionNotCreatedException e) {
                System.out.println("Version mismatch or failed to create a session: " + e.getMessage());
            } catch (WebDriverException e) {
                System.out.println("WebDriver error occurred: " + e.getMessage());
            }
        }
    }

    public static void startDriverHeadless(String url) {

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless=new");

        if (driver == null){
            try {
                driver = new FirefoxDriver(options);
                driver.get(url);


            }catch (IllegalStateException e) {
                System.out.println("ChromeDriver not found or system property not set: " + e.getMessage());
            } catch (SessionNotCreatedException e) {
                System.out.println("Version mismatch or failed to create a session: " + e.getMessage());
            } catch (WebDriverException e) {
                System.out.println("WebDriver error occurred: " + e.getMessage());
            }
        }
    }

    public static void stopDriver(){
        if (driver != null) {
            try {
                driver.quit();
            } finally {
                driver = null;
            }
        }
    }
}
