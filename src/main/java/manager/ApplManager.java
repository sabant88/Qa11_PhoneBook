package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class ApplManager {
    //  WebDriver wd;
    EventFiringWebDriver wd;
    UserHelper userHelper;
    ContactHelper contactHelper;
    String browser;
    Logger loger = LoggerFactory.getLogger(ApplManager.class);

    public ApplManager(String browser) {
        this.browser = browser;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }



    @BeforeSuite
    public void preCon(){
        //wd = new EventFiringWebDriver(new ChromeDriver());
        // wd = if(browser.equals(BrowserType.CHROME)){
        if(browser.equals(BrowserType.CHROME)){
            wd =  new EventFiringWebDriver(new ChromeDriver());
            loger.info("All tests starts in 'Chrome' browser");
        } else if(browser.equals(BrowserType.EDGE)){
            wd =  new EventFiringWebDriver(new EdgeDriver());
            loger.info("All tests starts in 'Edge' browser");
        }else if (browser.equals(BrowserType.FIREFOX)){
            wd =  new EventFiringWebDriver(new FirefoxDriver());
            loger.info("All tests starts in 'Firefox' browser");
        }

        //  loger.info("all tests starts at Chrome Browser");
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        loger.info("Link ------->" +wd.getCurrentUrl());
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        userHelper = new UserHelper(wd);
        contactHelper = new ContactHelper(wd);
        wd.register(new MyListener());

    }


    @AfterSuite
    public void postCon(){

        wd.quit();
    }
}
