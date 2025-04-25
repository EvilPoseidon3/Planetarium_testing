package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.print.DocFlavor;
import java.io.File;
import java.time.Duration;
import java.util.List;

import static cucumber.functions.steps.RunnerTest.*;

public class Homepage extends POMParent{

    public String workingName;
    public int listcount;

    @FindBy(xpath = "//div/input[@id = 'deleteInput']")
    private WebElement celestialBodyDelete;
    @FindBy(xpath = "//div/button[@id = 'deleteButton']")
    private WebElement deleteButton;
    @FindBy(xpath = "//div/input[@id='moonNameInput']")
    private List<WebElement> moonInput;
    @FindBy(xpath = "//div/input[@id='orbitedPlanetInput']")
    private List<WebElement> orbitPlanetIdInput;
    @FindBy(xpath = "//div/input[@type='file']")
    private List<WebElement> pictureUpload;
    @FindBy(xpath = "//div/input[@id='planetNameInput']")
    private List<WebElement> planetNameInput;
    @FindBy(xpath = "//table[@id = 'celestialTable']/tbody/tr")
    private List<WebElement> celestialList;
    @FindBy(xpath = "//button[@class = 'submit-button']")
    private WebElement submitButton;
    @FindBy(xpath = "//select[@id ='locationSelect']")
    private List<WebElement> selectMenu;

    public Homepage(WebDriver driver, String title){
        super(driver,title);
    }

    public void celestialBodyDeleteInput(String name){
        celestialBodyDelete.sendKeys(name);
    }

    public void clickDelete(){
        deleteButton.click();
    }

    public void setMoonInput(String name){
        moonInput.get(0).sendKeys(name);
    }

    public void planetIdInput(String name){
        orbitPlanetIdInput.get(0).sendKeys(name);
    }

    public void uploadPicture(String absoluteFilePath){
        pictureUpload.get(0).sendKeys(absoluteFilePath);
    }

    public void planetNameInput(String name){
        planetNameInput.get(0).sendKeys(name);
    }

    public boolean getCelestialBodyInformation(String name){
        this.waitPageLoad();
        boolean isPresent = false;
        List<WebElement> celestialList1 = driver.findElements(By.xpath("//table[@id = 'celestialTable']/tbody/tr"));
        String POMname = "";
        for(WebElement webElement: celestialList1){
            List<WebElement> elements = webElement.findElements(By.tagName("td"));
            if(!elements.isEmpty()) {
                WebElement nameInTag = elements.get(2);
                POMname = nameInTag.getText();
                System.out.println(POMname);
                System.out.println(name);
            }
            if (POMname.equals(name)) {
                isPresent = true;
            }
        }
        return isPresent;

    }

    public String getCelestialOwnerId(String name){
        this.waitPageLoad();
        for (WebElement webElement: celestialList) {
            List<WebElement> elements = webElement.findElements(By.tagName("td"));

            if (!elements.isEmpty()) {
                String targetId = elements.get(3).getText();
                String targetName = elements.get(2).getText();
                if (targetName.equals(name)){
                    return targetId;
                }
            }
        }
        return null;
    }

    public void clickSubmitButton(){
        submitButton = driver.findElement(By.xpath("//button[@class = 'submit-button']"));
        submitButton.click();
    }

    public void selectPlanetOrMoon(String planetOrMoon){
        Select select = new Select(selectMenu.get(0));
        select.selectByValue(planetOrMoon);
        this.waitPageLoad();
        PageFactory.initElements(driver,this);

    }
    public void setWorkingName(String name){
        workingName = name;
    }

    public String getWorkingName(){
        return workingName;
    }


    public int getListcount() {
        return listcount;
    }

    public void setListcount() {
        this.waitPageLoad();
        pageFactoryRefresh();
        this.listcount =  celestialList.size();

    }

    public void waitForPicture(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@type = 'file']")));

    }



}
