package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class Homepage extends POMParent{

    protected String workingName;

    @FindBy(xpath = "//div/input[@type='text']")
    private WebElement celestialBodyDelete;
    @FindBy(xpath = "//div/button[@id = 'deleteButton']")
    private WebElement deleteButton;
    @FindBy(xpath = "//div/input[@id='moonNameInput']")
    private List<WebElement> moonInput;
    @FindBy(xpath = "//div/input[@id='orbitPlanetInput]")
    private List<WebElement> orbitPlanetIdInput;
    @FindBy(xpath = "//div/input[@type='file']")
    private List<WebElement> pictureUpload;
    @FindBy(xpath = "//div/input[@id='planetNameInput']")
    private List<WebElement> planetNameInput;
    @FindBy(xpath = "//table[@id]tbody/tr")
    private List<WebElement> celestialList;
    @FindBy(xpath = "//button[@class = 'submit-button']")
    private WebElement submitButton;
    @FindBy(xpath = "//select[@id = 'locationSelect']")
    private WebElement selectMenu;

    public Homepage(WebDriver driver, String title){
        super(driver,title);
    }

    public void celestialBodyDeleteInput(String name){
        celestialBodyDelete.sendKeys(name);

    }

    public void clickDelete(){
        deleteButton.click();
    }

    public void moonInput(String name){
        moonInput.get(0).sendKeys();
    }

    public void planetIdInput(String name){
        orbitPlanetIdInput.get(0).sendKeys();
    }

    public void uploadPicture(String absoluteFilePath){
        pictureUpload.get(0).sendKeys(absoluteFilePath);
    }

    public void planetNameInput(String name){
        planetNameInput.get(0).sendKeys(name);
    }

    public boolean getCelestialBodyInformation(String name){
        for(WebElement webElement: celestialList){
            if (webElement
                    .findElements(By.tagName("td"))
                    .get(3)
                    .getText()
                    .equals(name)){
                return true;
            }
        }
        return false;

    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public void selectPlanetOrMoon(String planetOrMoon){
        Select select = new Select(selectMenu);
        select.selectByValue(planetOrMoon);
        workingName = planetOrMoon;
    }

    public String getWorkingName(){
        return workingName;
    }







}
