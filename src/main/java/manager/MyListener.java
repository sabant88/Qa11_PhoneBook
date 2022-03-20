package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

//import java.util.logging.Logger;

public class MyListener extends AbstractWebDriverEventListener {
    Logger loger = LoggerFactory.getLogger(MyListener.class);


    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
       // Logger.getLogger("Start search element by locator" +by);
        loger.info("Start search element by locator" +by);

    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
     //   Logger.getLogger("element by locator" + by +"was found");
        loger.info("element by locator" + by +" was found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
//        Logger.getLogger("Something went wrong");
//        Logger.getLogger(throwable.getMessage());
//        Logger.getLogger(String.valueOf(throwable.fillInStackTrace()));

        loger.info("Something went wrong");
        loger.info(throwable.getMessage());
        loger.info(String.valueOf(throwable.fillInStackTrace()));

        //screenshots
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String link = "src/test/screenshots"+i+".png";
        BaseHelper baseHelper = new BaseHelper(driver);
        baseHelper.takeScreenShots(link);
        loger.info("this link to screenshots with error ---------->"+link);
    }

    public MyListener() {
        super();
    }
}
