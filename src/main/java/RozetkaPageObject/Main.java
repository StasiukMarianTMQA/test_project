//package RozetkaPageObject;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.concurrent.TimeUnit;
//
//public class Main {
//    static WebDriver driver;
//    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lilma\\IdeaProjects\\test_project\\driver\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        RozetkaNavigationPage rozetkaNavigationPage = new RozetkaNavigationPage(driver);
//        driver.get("https://rozetka.com.ua/ua/");
//        rozetkaNavigationPage.navigationMethods();
//        FridgesListPage fridgesListPage = new FridgesListPage(driver);
//        fridgesListPage.getListOfFridges();
//        driver.get("https://bt.rozetka.com.ua/ua/indesit_li7_s1e_w/p320262790/");
//        FridgeDetails details = new FridgeDetails(driver);
//        details.getSingleFridge();
//
//
//    }
//}
