package hooks;

import POM.Loginpage;
import POM.Registerpage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;





import java.io.IOException;

public class HooksUS1 {

    public static WebDriver driver;
    public static Process process;
    public static Loginpage loginpage;
    public static Registerpage registerpage;


//    @BeforeAll
    public void setUp() throws InterruptedException {
        System.out.println("\n----------before Script ran-------------\n");
        Thread.sleep(2000);
        ProcessBuilder processBuilder = new ProcessBuilder(
                "java",
                "-jar",
                "C:\\Users\\Preston\\OneDrive\\Desktop\\Code\\Planetarium_testing\\Planetarium.jar");
        try {
            // Start the process
            process = processBuilder.start();

            // Wait for the process to finish
//            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = new ChromeDriver();
        driver.get("http://localhost:8080/");
        loginpage = new Loginpage(driver,"Planetarium Login");
    }

//    @AfterAll
    public void tearDown(){
        System.out.println("\n----------after Script ran-------------\n");

        if (driver != null)driver.quit();
        if (process.isAlive())process.destroy();
    }

//    @Before
//    public void setDriver(){
//        if(Feature1Test.driver == null){
//            Feature1Test.driver = new ChromeDriver();
//        }
//    }
}
