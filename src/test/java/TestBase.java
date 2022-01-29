import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeSuite
    public void preCon(){
        wd = new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();

    }

    @BeforeMethod
    public void preCondition() {
        if (isLogged()) {
            logOut();
        }
    }


//===================================================================================================

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }


    public void fillLoginRegForm(String eMail, String password) {
    }


    public void submitRegForm() {
        click(By.xpath("//button[2]"));
    }


    public void fillRegForm(String eMail, String password) {
        type(By.xpath("//input[1]"), eMail);

        type(By.xpath("//input[2]"), password);
      //  type(By locator, eMail);
    }


    public void type(By locator, String text){
        if(text!=null && !text.isEmpty()){
            WebElement element =  wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }

    }

    public void openLoginRegForm() {
        click(By.linkText("LOGIN"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void submitLoginForm() {
        click(By.xpath("//button[1]"));
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public boolean isLogged(){

        return isElementPresent(By.xpath("//*[text()='Sign Out']"));
    }

    public void logOut(){

        click(By.xpath("//button"));
    }


//=================================================================
    @AfterSuite
    public void postCon(){

        wd.quit();
    }
}
