package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BaseHelper {

    WebDriver wd;

    public BaseHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text) {
        if (text != null && !text.isEmpty()) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }

    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }


    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(wd,10).until(ExpectedConditions.alertIsPresent());
        if(alert==null){
            return false;
        }
        else{
            wd.switchTo().alert();
            alert.accept();//ok
//            alert.dismiss();  //cancel
//            alert.sendKeys("Mother Fucker");   // type in input alert
//            alert.getText();   // get text
        }
        return true;
    }

    public void takeScreenShots(String pathToFile){
        File temp = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(pathToFile);

        try {
            Files.copy(temp,screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
