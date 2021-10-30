package W7;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestLoginPOM {
    String driverPath = "E:\\HOCTAP\\KIỂM THỰ TỰ ĐỘNG\\geckodriver.exe"; 
    WebDriver driver;
    LoginPagePOM objLogin;
    HomePagePOM objHomePage;

    @BeforeTest
    public void setup(){
    	System.setProperty("webdriver.gecko.driver", driverPath);  
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
    }

    
    @Test(priority=0)
    public void test_Home_Page_Appear_Correct(){

    objLogin = new LoginPagePOM(driver);
    String loginPageTitle = objLogin.getLoginTitle();
    
    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
    
    objLogin.loginToGuru99("mngr362982", "mEnavab");
    objHomePage = new HomePagePOM(driver);
    
    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mngr362982"));
    }
}