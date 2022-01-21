import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver wd;

    @BeforeMethod
    public void init(){
        wd=new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void LoginPositiveTest(){
        ////*[text()='LOGIN']
        WebElement loginBtn = wd.findElement(By.linkText("LOGIN"));
        //CLICK
        loginBtn.click();

        //FIND E-MAIL
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        wd.findElement(By.xpath("//input[1]"));

        //CLICK E-MAIL
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("noa@gmail.com");

        //find password
        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("Nnoa12345$");

        //find Login Button
        WebElement clickLogin=wd.findElement(By.xpath("//button[1]"));
        clickLogin.click();

        //check sign out in present
        //  Assert.assertTrue(wd.findElement(By.xpath("//button[text()='Sign Out']")));



    }

    @AfterMethod
    public void postCondition(){

        wd.quit();
    }
}
