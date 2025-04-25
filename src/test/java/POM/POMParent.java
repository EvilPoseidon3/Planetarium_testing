package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class POMParent {
    protected WebDriver driver;
    protected String title;
    protected WebDriverWait alertWait;
    protected WebDriverWait pageLoadWait;

    public POMParent(WebDriver driver, String title){

        this.driver = driver;
        this.title = title;
        PageFactory.initElements(driver,this);
        alertWait = new WebDriverWait(driver, Duration.ofMillis(1000));
        pageLoadWait = new WebDriverWait(driver, Duration.ofMillis(100));

    }

    public String getUrl(){
        return this.driver.getCurrentUrl();
    }

    public String getTitle(){
        return title;
    }

    public void waitForAlert(){
        alertWait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitPageLoad(){
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr")));
    }

    public void pageFactoryRefresh(){
        PageFactory.initElements(driver, this);
    }

}
