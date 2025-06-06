package cucumber.functions.steps;


import POM.Loginpage;
import POM.Registerpage;
import POM.Homepage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"cucumber.functions.steps"},
        plugin = {"pretty","html:src/test/resources/reports/Cucumber-Report.html"}
)


public class RunnerTest {


    protected static Loginpage loginpage;
    protected static Registerpage registerpage;
    protected static WebDriver driver;
    protected static Homepage homepage;

    @BeforeClass
    public static void startUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginpage = new Loginpage(driver,"Login Page");
        registerpage = new Registerpage(driver,"Register Page");
        homepage = new Homepage(driver, "Home");
    }

    @AfterClass
    public static void tearDown(){
        if(driver != null) driver.quit();
    }



}
