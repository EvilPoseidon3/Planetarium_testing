package POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends POMParent{

    private String url = String.format("http://%s/", System.getenv("PLANETARIUM_URL"));

    @FindBy(id = "usernameInput")
    private WebElement usernameInput;
    @FindBy(id = "passwordInput")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@type = 'submit']")
    private WebElement input;
    @FindBy(xpath = "//a[starts-with(@href,'http')]")
    private WebElement registrationLink;
    @FindBy(tagName = "h1")
    private WebElement pageTitle;

    public Loginpage(WebDriver driver, String title){
        super(driver,title);
    }

    public void goToLoginPage(){
        driver.get(url);
    }

//    public String getUrl(){
//        return this.driver.getCurrentUrl();
//    }

    public void clickRegisterLink(){
        registrationLink.click();
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public void enterUsername(String string){
        usernameInput.sendKeys(string);
    }

    public void enterPassword(String string){
        passwordInput.sendKeys(string);
    }

    public void inputSubmit(){
        input.click();
    }



}
