import RozetkaPageObject.Fridge;
import RozetkaPageObject.FridgeDetails;
import RozetkaPageObject.FridgesListPage;
import RozetkaPageObject.RozetkaNavigationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RozetkaTest {
    private WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lilma\\IdeaProjects\\test_project\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        RozetkaNavigationPage rozetkaNavigationPage = new RozetkaNavigationPage(driver);
        driver.get("https://rozetka.com.ua/ua/");
        rozetkaNavigationPage.navigationMethods();
    }

    @Test
    public void checkList(){
        FridgesListPage fridgesListPage = new FridgesListPage(driver);
        List<Fridge> listOfFridges = fridgesListPage.getListOfFridges();
        driver.get("https://bt.rozetka.com.ua/ua/indesit_li7_s1e_w/p320262790/");
        FridgeDetails details = new FridgeDetails(driver);
        Fridge singleFridge = details.getSingleFridge();
        Assert.assertTrue(listOfFridges.contains(singleFridge));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
