package tests;

import manager.ApplManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {

        protected static ApplManager app = new ApplManager(System.getProperty("browser", BrowserType.CHROME));
    Logger loger = LoggerFactory.getLogger(TestBase.class);

//    @BeforeMethod
//    public void logerStart(Method m){
//        loger.info("Test name---->" + m.getName());
//
//    }

//    @AfterMethod(alwaysRun = true)
//    public void endLoger(Method m){
//        loger.info("End of test" + m.getName());
//    }


    @BeforeSuite(alwaysRun = true)
    public void preCon(){
        app.preCon();

    }

    @AfterSuite(alwaysRun = true)
    public void postCon(){

        app.postCon();
    }

}
