package POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Registerpage extends POMParent {

    private WebDriverWait alertWait;

    @FindBy(xpath = "//div/form/input[1]")
    private WebElement usernameInput;
    @FindBy(xpath = "//div/form/input[2]")
    private WebElement passwordInput;
    @FindBy(xpath = "//div/form/input[3]")
    private WebElement submitInput;
    @FindBy(xpath = "a[starts-with(@href = 'http')]")
    private WebElement loginLink;
    @FindBy(tagName = "h1")
    private WebElement pageTitle;


    public Registerpage(WebDriver driver,String title){
        super(driver,title);
//        alertWait = new WebDriverWait(driver, Duration.ofMillis(200));
    }

    public String getTitle(){
        return pageTitle.getText();
    }

    public String getUrl(){
        return this.driver.getCurrentUrl();
    }

    public void inputSubmit(){
        submitInput.click();
    }

    public void enterUsername(String string){
        usernameInput.sendKeys(string);
    }

    public void enterPassword(String string){
        passwordInput.sendKeys(string);
    }

    public void clickLoginLink(){
        loginLink.click();
    }

//    public void waitForAlert(){
//        alertWait.until(ExpectedConditions.alertIsPresent());
//    }




}
