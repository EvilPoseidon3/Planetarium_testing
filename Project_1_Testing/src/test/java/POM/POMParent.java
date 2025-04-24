package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class POMParent {
    protected WebDriver driver;
    protected String title;

    public POMParent(WebDriver driver, String title){
        this.driver = driver;
        this.title = title;
        PageFactory.initElements(driver,this);
    }

}
